#!/usr/bin/env bash
#
# Advanced Python PATH Fix Script
# This script uses brew --prefix to find the correct Python paths

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

echo "Advanced Python PATH Fix Script"
echo "================================="

# Check if brew is available
if ! command -v brew >/dev/null 2>&1; then
    log_error "Homebrew is not installed or not in PATH"
    exit 1
fi

# Find installed Python versions
log_info "Searching for installed Python versions..."
PYTHON_VERSIONS=("3.13" "3.12" "3.11" "3.10" "3.9")
INSTALLED_PYTHONS=()

for version in "${PYTHON_VERSIONS[@]}"; do
    if brew list "python@${version}" >/dev/null 2>&1; then
        INSTALLED_PYTHONS+=("${version}")
        log_info "Found Python ${version}"
    fi
done

if [[ ${#INSTALLED_PYTHONS[@]} -eq 0 ]]; then
    log_error "No Python versions found via Homebrew"
    log_info "Installing Python 3.11..."
    brew install python@3.11
    INSTALLED_PYTHONS=("3.11")
fi

# Get the latest version
PYTHON_VERSION="${INSTALLED_PYTHONS[0]}"
log_info "Using Python ${PYTHON_VERSION}"

# Get the actual prefix using brew
PYTHON_PREFIX=$(brew --prefix "python@${PYTHON_VERSION}")
if [[ -z "${PYTHON_PREFIX}" ]]; then
    log_error "Could not get prefix for python@${PYTHON_VERSION}"
    exit 1
fi

log_info "Python prefix: ${PYTHON_PREFIX}"

# Check if the Python binary exists
PYTHON_BIN="${PYTHON_PREFIX}/bin/python3"
if [[ ! -f "${PYTHON_BIN}" ]]; then
    log_error "Python binary not found at: ${PYTHON_BIN}"
    exit 1
fi

log_info "Python binary found: ${PYTHON_BIN}"

# Get Homebrew prefix
HOMEBREW_PREFIX=$(brew --prefix)
log_info "Homebrew prefix: ${HOMEBREW_PREFIX}"

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

# Add correct paths using actual prefixes
log_info "Adding correct Python paths..."
echo "" >> ~/.zshrc
echo "# Advanced Python PATH fix - $(date '+%Y-%m-%d %H:%M:%S')" >> ~/.zshrc
echo "# Python version: ${PYTHON_VERSION}" >> ~/.zshrc
echo "# Python prefix: ${PYTHON_PREFIX}" >> ~/.zshrc
echo "# Homebrew prefix: ${HOMEBREW_PREFIX}" >> ~/.zshrc
echo "export PATH=\"${PYTHON_PREFIX}/bin:${HOMEBREW_PREFIX}/bin:\$PATH\"" >> ~/.zshrc
echo "" >> ~/.zshrc

log_success "Python PATH fixed!"
log_info "Python version: ${PYTHON_VERSION}"
log_info "Python prefix: ${PYTHON_PREFIX}"
log_info "Homebrew prefix: ${HOMEBREW_PREFIX}"
echo "================================="
log_info "Next steps:"
echo "  1. Run: source ~/.zshrc"
echo "  2. Test: python3 --version"
echo "  3. Verify: which python3"
echo "  4. Expected: ${PYTHON_BIN}" 