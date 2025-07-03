#!/usr/bin/env bash
#
# Python Version Manager Setup Script
# 
# This script installs and configures Python versions via Homebrew, handling
# macOS version compatibility issues. It automatically detects the appropriate
# Python version based on your macOS version.
#
# Usage: ./on_pvm.sh [python_version]
#        ./on_pvm.sh 3.11    # Install specific version
#        ./on_pvm.sh         # Auto-detect compatible version
#
# Exit codes:
#   0 - Success
#   1 - Error (with descriptive message)
#
# Author: Generated script
# License: MIT

set -euo pipefail

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

# Check if Homebrew is available
check_homebrew() {
    if ! command -v brew >/dev/null 2>&1; then
        error_exit "Homebrew is not installed. Please run on_brew.sh first."
    fi
    log_info "Homebrew is available"
}

# Get macOS version information
get_macos_version() {
    local macos_version
    local macos_build
    
    # Get macOS version (e.g., "14.7.6")
    macos_version=$(sw_vers -productVersion)
    
    # Get macOS build number (e.g., "23G93")
    macos_build=$(sw_vers -buildVersion)
    
    echo "${macos_version}:${macos_build}"
}

# Determine compatible Python version based on macOS
get_compatible_python_version() {
    local macos_info
    local macos_version
    local major_version
    local minor_version
    local patch_version
    
    macos_info=$(get_macos_version)
    macos_version=$(echo "${macos_info}" | cut -d: -f1)
    
    # Parse version components
    major_version=$(echo "${macos_version}" | cut -d. -f1)
    minor_version=$(echo "${macos_version}" | cut -d. -f2)
    patch_version=$(echo "${macos_version}" | cut -d. -f3)
    
    log_info "Detected macOS version: ${macos_version}"
    
    # Python version compatibility matrix
    # Python 3.13+ requires macOS 14.7.6+ (build 23G93+)
    # Python 3.12+ requires macOS 14.7.6+ (build 23G93+)
    # Python 3.11+ requires macOS 10.15+
    # Python 3.10+ requires macOS 10.15+
    # Python 3.9+ requires macOS 10.15+
    
    if [[ "${major_version}" -eq 14 ]]; then
        if [[ "${minor_version}" -eq 7 ]] && [[ "${patch_version}" -ge 6 ]]; then
            # macOS 14.7.6+ can use Python 3.12+
            echo "3.12"
        else
            # macOS 14.x (but < 14.7.6) - use Python 3.11
            log_warning "macOS ${macos_version} detected. Python 3.12+ requires macOS 14.7.6+. Using Python 3.11."
            echo "3.11"
        fi
    elif [[ "${major_version}" -ge 10 ]] && [[ "${minor_version}" -ge 15 ]]; then
        # macOS 10.15+ can use Python 3.11
        echo "3.11"
    else
        error_exit "Unsupported macOS version: ${macos_version}. This script requires macOS 10.15 or later."
    fi
}

# Install Python version
install_python() {
    local python_version="$1"
    local formula_name="python@${python_version}"
    
    log_info "Installing Python ${python_version}..."
    
    # Check if formula exists
    if ! brew info "${formula_name}" >/dev/null 2>&1; then
        error_exit "Python ${python_version} formula not found. Available versions: $(brew search python@ | grep -E 'python@[0-9]+\.[0-9]+' | sort -V | tail -5 | tr '\n' ' ')"
    fi
    
    # Install Python
    if brew install "${formula_name}"; then
        log_success "Python ${python_version} installation completed"
    else
        error_exit "Python ${python_version} installation failed"
    fi
}

# Unlink all Python versions
unlink_all_pythons() {
    log_info "Unlinking all Python versions..."
    
    local python_versions=("3.9" "3.10" "3.11" "3.12" "3.13")
    
    for version in "${python_versions[@]}"; do
        if brew list "python@${version}" >/dev/null 2>&1; then
            log_info "Unlinking python@${version}"
            brew unlink "python@${version}" 2>/dev/null || true
        fi
    done
}

# Link specific Python version
link_python() {
    local python_version="$1"
    local formula_name="python@${python_version}"
    
    log_info "Linking Python ${python_version}..."
    
    if brew link --force --overwrite "${formula_name}"; then
        log_success "Python ${python_version} linked successfully"
    else
        error_exit "Failed to link Python ${python_version}"
    fi
}

# Configure shell environment
configure_shell() {
    local python_version="$1"
    local rc_file
    local export_line="export PATH=\"/opt/homebrew/opt/python@${python_version}/bin:/opt/homebrew/bin:\$PATH\""
    local backup_file
    
    # Detect shell and RC file
    local current_shell
    current_shell=$(basename "${SHELL:-$(ps -p $$ -o comm=)}")
    
    case "${current_shell}" in
        zsh)
            rc_file="${HOME}/.zshrc"
            ;;
        bash)
            if [[ -f "${HOME}/.bash_profile" ]]; then
                rc_file="${HOME}/.bash_profile"
            else
                rc_file="${HOME}/.bashrc"
            fi
            ;;
        *)
            log_warning "Unsupported shell detected: ${current_shell}. Defaulting to .zshrc"
            rc_file="${HOME}/.zshrc"
            ;;
    esac
    
    log_info "Configuring shell: ${rc_file}"
    
    # Create RC file if it doesn't exist
    if [[ ! -f "${rc_file}" ]]; then
        log_info "Creating ${rc_file}"
        touch "${rc_file}"
    fi
    
    # Check if Python PATH is already configured
    if grep -Fq "python@${python_version}/bin" "${rc_file}" 2>/dev/null; then
        log_info "Python ${python_version} PATH already configured in ${rc_file}"
        return 0
    fi
    
    # Create backup
    backup_file="${rc_file}.backup.$(date +%Y%m%d_%H%M%S)"
    cp "${rc_file}" "${backup_file}"
    log_info "Created backup: ${backup_file}"
    
    # Add Python configuration
    {
        echo ""
        echo "# Python ${python_version} configuration - added by on_pvm.sh on $(date '+%Y-%m-%d %H:%M:%S')"
        echo "${export_line}"
        echo ""
    } >> "${rc_file}"
    
    log_success "Python ${python_version} PATH added to ${rc_file}"
}

# Verify Python installation
verify_installation() {
    local python_version="$1"
    local rc_file
    
    log_info "Verifying Python ${python_version} installation..."
    
    # Detect RC file for sourcing
    local current_shell
    current_shell=$(basename "${SHELL:-$(ps -p $$ -o comm=)}")
    
    case "${current_shell}" in
        zsh)
            rc_file="${HOME}/.zshrc"
            ;;
        bash)
            if [[ -f "${HOME}/.bash_profile" ]]; then
                rc_file="${HOME}/.bash_profile"
            else
                rc_file="${HOME}/.bashrc"
            fi
            ;;
        *)
            rc_file="${HOME}/.zshrc"
            ;;
    esac
    
    # Source the RC file to get updated PATH
    if [[ -f "${rc_file}" ]]; then
        # shellcheck source=/dev/null
        source "${rc_file}"
    fi
    
    # Check if python3 is available
    if ! command -v python3 >/dev/null 2>&1; then
        error_exit "python3 command not found. Please restart your terminal or run: source ${rc_file}"
    fi
    
    # Check Python version
    local installed_version
    installed_version=$(python3 --version 2>&1 | cut -d' ' -f2 | cut -d. -f1,2)
    
    if [[ "${installed_version}" == "${python_version}" ]]; then
        log_success "Python ${python_version} is installed and accessible"
        python3 --version
        log_info "Python location: $(which python3)"
        return 0
    else
        log_warning "Expected Python ${python_version}, but found ${installed_version}"
        log_info "Python location: $(which python3)"
        python3 --version
    fi
}

# Show Python compatibility information
show_compatibility_info() {
    local macos_info
    local macos_version
    
    macos_info=$(get_macos_version)
    macos_version=$(echo "${macos_info}" | cut -d: -f1)
    
    echo
    log_info "Python Version Compatibility Information:"
    echo "  macOS Version: ${macos_version}"
    echo "  Python 3.13+: Requires macOS 14.7.6+ (build 23G93+)"
    echo "  Python 3.12+: Requires macOS 14.7.6+ (build 23G93+)"
    echo "  Python 3.11+: Requires macOS 10.15+"
    echo "  Python 3.10+: Requires macOS 10.15+"
    echo "  Python 3.9+:  Requires macOS 10.15+"
    echo
}

# Main function
main() {
    local target_version="${1:-}"
    
    echo
    log_info "Python Version Manager Setup Script"
    log_info "Working directory: ${PWD}"
    echo "----------------------------------------------"
    
    # Check prerequisites
    check_homebrew
    
    # Determine Python version
    if [[ -z "${target_version}" ]]; then
        target_version=$(get_compatible_python_version)
        log_info "Auto-detected compatible Python version: ${target_version}"
    else
        log_info "Using requested Python version: ${target_version}"
    fi
    
    # Show compatibility information
    show_compatibility_info
    
    # Install and configure Python
    install_python "${target_version}"
    unlink_all_pythons
    link_python "${target_version}"
    configure_shell "${target_version}"
    verify_installation "${target_version}"
    
    echo "----------------------------------------------"
    log_success "Python ${target_version} setup complete!"
    log_info "You may need to restart your terminal for changes to take effect."
    log_info "To create a virtual environment: python3 -m venv myenv"
    log_info "To activate virtual environment: source myenv/bin/activate"
}

# Run main function
main "$@"
