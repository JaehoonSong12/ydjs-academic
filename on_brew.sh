#!/usr/bin/env bash
#
# Homebrew Installation and Setup Script
# 
# This script installs Homebrew on macOS and configures the shell environment
# to include Homebrew in the PATH. It supports both Apple Silicon and Intel Macs.
#
# Usage: ./on_brew.sh
#
# Exit codes:
#   0 - Success
#   1 - Error (with descriptive message)
#
# Author: Generated script
# License: MIT

set -euo pipefail

# Source system detection if available
if [[ -f "./system_detect.sh" ]]; then
    source "./system_detect.sh"
    detect_system
fi

# Colors for output (only if terminal supports it)
if [[ -t 1 ]]; then
    readonly RED='\033[0;31m'
    readonly GREEN='\033[0;32m'
    readonly YELLOW='\033[1;33m'
    readonly BLUE='\033[0;34m'
    readonly NC='\033[0m' # No Color
else
    readonly RED=''
    readonly GREEN=''
    readonly YELLOW=''
    readonly BLUE=''
    readonly NC=''
fi

# Logging functions
log_info() {
    echo -e "${BLUE}[INFO]${NC} $*"
}

log_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $*"
}

log_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $*"
}

log_error() {
    echo -e "${RED}[ERROR]${NC} $*" >&2
}

# Error handling
error_exit() {
    log_error "$1"
    exit 1
}

# Check if running on macOS
check_os() {
    if [[ "$(uname)" != "Darwin" ]]; then
        error_exit "This script is designed for macOS only. Detected OS: $(uname)"
    fi
    log_info "Operating system check passed"
}

# Detect shell and determine RC file
detect_shell() {
    local current_shell
    local rc_file
    
    # Get the current shell name
    current_shell=$(basename "${SHELL:-$(ps -p $$ -o comm=)}")
    
    case "${current_shell}" in
        zsh)
            rc_file="${HOME}/.zshrc"
            ;;
        bash)
            # Check for .bash_profile first, then .bashrc
            if [[ -f "${HOME}/.bash_profile" ]]; then
                rc_file="${HOME}/.bash_profile"
            else
                rc_file="${HOME}/.bashrc"
            fi
            ;;
        *)
            log_warning "Unsupported shell detected: ${current_shell}. Defaulting to .bash_profile"
            rc_file="${HOME}/.bash_profile"
            ;;
    esac
    
    echo "${rc_file}"
}

# Install Homebrew if not present
install_homebrew() {
    if command -v brew >/dev/null 2>&1; then
        log_info "Homebrew is already installed"
        return 0
    fi
    
    log_info "Homebrew not found. Installing..."
    
    # Check if we can download the installer
    if ! command -v curl >/dev/null 2>&1; then
        error_exit "curl is required but not installed. Please install curl first."
    fi
    
    # Install Homebrew
    if /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"; then
        log_success "Homebrew installation completed"
    else
        error_exit "Homebrew installation failed"
    fi
}

# Configure shell RC file
configure_shell() {
    local rc_file="$1"
    local homebrew_prefix
    local export_line
    local backup_file="${rc_file}.backup.$(date +%Y%m%d_%H%M%S)"
    
    # Use system detection if available, otherwise fallback
    if [[ -n "${HOMEBREW_PREFIX:-}" ]]; then
        homebrew_prefix="${HOMEBREW_PREFIX}"
        log_info "Using detected Homebrew prefix: ${homebrew_prefix}"
    else
        # Fallback detection
        if [[ -d "/opt/homebrew" ]]; then
            homebrew_prefix="/opt/homebrew"
        elif [[ -d "/usr/local" ]]; then
            homebrew_prefix="/usr/local"
        else
            error_exit "Homebrew installation not found in expected locations"
        fi
        log_info "Using fallback Homebrew prefix: ${homebrew_prefix}"
    fi
    
    export_line="export PATH=\"${homebrew_prefix}/bin:\$PATH\""
    
    log_info "Configuring shell RC file: ${rc_file}"
    log_info "System architecture: ${SYSTEM_ARCH:-unknown}"
    log_info "Apple Silicon: ${IS_APPLE_SILICON:-unknown}"
    
    # Create RC file if it doesn't exist
    if [[ ! -f "${rc_file}" ]]; then
        log_info "Creating ${rc_file}"
        touch "${rc_file}"
    fi
    
    # Check if Homebrew PATH is already configured
    if grep -Fq "${homebrew_prefix}/bin" "${rc_file}" 2>/dev/null; then
        log_info "Homebrew PATH already configured in ${rc_file}"
        return 0
    fi
    
    # Create backup
    cp "${rc_file}" "${backup_file}"
    log_info "Created backup: ${backup_file}"
    
    # Add Homebrew configuration
    {
        echo ""
        echo "# Homebrew configuration - added by on_brew.sh on $(date '+%Y-%m-%d %H:%M:%S')"
        echo "# System: ${SYSTEM_ARCH:-unknown} (Apple Silicon: ${IS_APPLE_SILICON:-unknown})"
        echo "${export_line}"
        echo ""
    } >> "${rc_file}"
    
    log_success "Homebrew PATH added to ${rc_file}"
}

# Verify Homebrew installation
verify_installation() {
    log_info "Verifying Homebrew installation..."
    
    # Source the RC file to get updated PATH
    local rc_file="$1"
    if [[ -f "${rc_file}" ]]; then
        # shellcheck source=/dev/null
        source "${rc_file}"
    fi
    
    if command -v brew >/dev/null 2>&1; then
        log_success "Homebrew is installed and accessible"
        brew --version
        return 0
    else
        error_exit "Homebrew installation verification failed. Please restart your terminal or run: source ${rc_file}"
    fi
}

# Main function
main() {
    echo
    log_info "Homebrew Setup Script"
    log_info "Working directory: ${PWD}"
    echo "----------------------------------------------"
    
    # Run setup steps
    check_os
    install_homebrew
    
    local rc_file
    rc_file=$(detect_shell)
    log_info "Using RC file: ${rc_file}"
    
    configure_shell "${rc_file}"
    verify_installation "${rc_file}"
    
    echo "----------------------------------------------"
    log_success "Setup complete!"
    log_info "You may need to restart your terminal or run: source ${rc_file}"
}

# Run main function
main "$@"