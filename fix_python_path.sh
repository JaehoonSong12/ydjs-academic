#!/usr/bin/env bash
#
# Smart Python PATH Fix Script
# This script detects your system architecture and fixes the Python PATH accordingly
# Works for both Apple Silicon and Intel Macs

set -euo pipefail

# Colors for output
if [[ -t 1 ]]; then
    readonly RED='\033[0;31m'
    readonly GREEN='\033[0;32m'
    readonly YELLOW='\033[1;33m'
    readonly BLUE='\033[0;34m'
    readonly NC='\033[0m'
else
    readonly RED=''
    readonly GREEN=''
    readonly YELLOW=''
    readonly BLUE=''
    readonly NC=''
fi

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

# Source system detection if available
if [[ -f "./system_detect.sh" ]]; then
    source "./system_detect.sh"
    detect_system
    log_info "System detection loaded"
else
    log_warning "system_detect.sh not found, using fallback detection"
fi

echo "Smart Python PATH Fix Script"
echo "----------------------------------------------"

# Detect system architecture
if [[ -n "${SYSTEM_ARCH:-}" ]]; then
    log_info "Detected architecture: ${SYSTEM_ARCH}"
    log_info "Apple Silicon: ${IS_APPLE_SILICON}"
    log_info "Intel Mac: ${IS_INTEL_MAC}"
else
    # Fallback detection
    SYSTEM_ARCH=$(uname -m)
    if [[ "${SYSTEM_ARCH}" == "arm64" ]]; then
        IS_APPLE_SILICON="true"
        IS_INTEL_MAC="false"
    else
        IS_APPLE_SILICON="false"
        IS_INTEL_MAC="true"
    fi
    log_info "Fallback detection - Architecture: ${SYSTEM_ARCH}"
fi

# Determine Homebrew prefix
if [[ -n "${HOMEBREW_PREFIX:-}" ]]; then
    HOMEBREW_PATH="${HOMEBREW_PREFIX}"
else
    if [[ "${IS_APPLE_SILICON}" == "true" ]]; then
        HOMEBREW_PATH="/opt/homebrew"
    else
        HOMEBREW_PATH="/usr/local"
    fi
fi

log_info "Using Homebrew path: ${HOMEBREW_PATH}"

# Backup current .zshrc
BACKUP_FILE="~/.zshrc.backup.$(date +%Y%m%d_%H%M%S)"
cp ~/.zshrc "${BACKUP_FILE}"
log_info "Created backup: ${BACKUP_FILE}"

# Remove all existing Homebrew Python paths
log_info "Removing existing Homebrew Python paths..."
sed -i '' '/\/opt\/homebrew\/opt\/python@/d' ~/.zshrc
sed -i '' '/\/usr\/local\/opt\/python@/d' ~/.zshrc
sed -i '' '/\/opt\/homebrew\/bin/d' ~/.zshrc
sed -i '' '/\/usr\/local\/bin/d' ~/.zshrc

# Find the latest Python version installed
PYTHON_VERSIONS=("3.13" "3.12" "3.11" "3.10" "3.9")
PYTHON_VERSION=""

for version in "${PYTHON_VERSIONS[@]}"; do
    if [[ -d "${HOMEBREW_PATH}/opt/python@${version}" ]]; then
        PYTHON_VERSION="${version}"
        log_info "Found Python ${version} at ${HOMEBREW_PATH}/opt/python@${version}"
        break
    fi
done

if [[ -z "${PYTHON_VERSION}" ]]; then
    log_error "No Python versions found in ${HOMEBREW_PATH}/opt/"
    log_info "Available Python installations:"
    ls -la "${HOMEBREW_PATH}/opt/" | grep python || log_warning "No Python installations found"
    exit 1
fi

# Add correct paths
log_info "Adding Python ${PYTHON_VERSION} to PATH..."
echo "" >> ~/.zshrc
echo "# Smart Python PATH fix - $(date '+%Y-%m-%d %H:%M:%S')" >> ~/.zshrc
echo "# System: ${SYSTEM_ARCH} (Apple Silicon: ${IS_APPLE_SILICON})" >> ~/.zshrc
echo "export PATH=\"${HOMEBREW_PATH}/opt/python@${PYTHON_VERSION}/bin:${HOMEBREW_PATH}/bin:\$PATH\"" >> ~/.zshrc
echo "" >> ~/.zshrc

log_success "Python PATH fixed!"
log_info "Python version: ${PYTHON_VERSION}"
log_info "Homebrew path: ${HOMEBREW_PATH}"
echo "----------------------------------------------"
log_info "Next steps:"
echo "  1. Run: source ~/.zshrc"
echo "  2. Test: python3 --version"
echo "  3. Verify: which python3" 