#!/usr/bin/env bash
#
# System Detection Utility for macOS
# This script detects system architecture and Homebrew paths
# Source this file in other scripts: source ./system_detect.sh
#
# Variables set:
#   SYSTEM_ARCH - "arm64" or "x86_64"
#   HOMEBREW_PREFIX - "/opt/homebrew" or "/usr/local"
#   IS_APPLE_SILICON - "true" or "false"
#   IS_INTEL_MAC - "true" or "false"

# Detect system architecture
detect_architecture() {
    local arch
    arch=$(uname -m)
    
    case "${arch}" in
        arm64)
            echo "arm64"
            ;;
        x86_64)
            echo "x86_64"
            ;;
        *)
            echo "unknown"
            ;;
    esac
}

# Detect Homebrew prefix based on architecture
detect_homebrew_prefix() {
    local arch="$1"
    
    case "${arch}" in
        arm64)
            if [[ -d "/opt/homebrew" ]]; then
                echo "/opt/homebrew"
            else
                echo "/usr/local"
            fi
            ;;
        x86_64)
            if [[ -d "/usr/local" ]]; then
                echo "/usr/local"
            else
                echo "/opt/homebrew"
            fi
            ;;
        *)
            # Fallback detection
            if [[ -d "/opt/homebrew" ]]; then
                echo "/opt/homebrew"
            elif [[ -d "/usr/local" ]]; then
                echo "/usr/local"
            else
                echo ""
            fi
            ;;
    esac
}

# Get macOS version information
get_macos_info() {
    local macos_version
    local macos_build
    local major_version
    local minor_version
    local patch_version
    
    # Get macOS version (e.g., "14.7.6")
    macos_version=$(sw_vers -productVersion)
    
    # Get macOS build number (e.g., "23G93")
    macos_build=$(sw_vers -buildVersion)
    
    # Parse version components
    major_version=$(echo "${macos_version}" | cut -d. -f1)
    minor_version=$(echo "${macos_version}" | cut -d. -f2)
    patch_version=$(echo "${macos_version}" | cut -d. -f3)
    
    echo "${macos_version}:${macos_build}:${major_version}:${minor_version}:${patch_version}"
}

# Check if Homebrew is available
check_homebrew_available() {
    local prefix="$1"
    
    if [[ -f "${prefix}/bin/brew" ]]; then
        echo "true"
    else
        echo "false"
    fi
}

# Main detection function
detect_system() {
    # Detect architecture
    SYSTEM_ARCH=$(detect_architecture)
    
    # Detect Homebrew prefix
    HOMEBREW_PREFIX=$(detect_homebrew_prefix "${SYSTEM_ARCH}")
    
    # Set boolean flags
    if [[ "${SYSTEM_ARCH}" == "arm64" ]]; then
        IS_APPLE_SILICON="true"
        IS_INTEL_MAC="false"
    else
        IS_APPLE_SILICON="false"
        IS_INTEL_MAC="true"
    fi
    
    # Get macOS info
    local macos_info
    macos_info=$(get_macos_info)
    MACOS_VERSION=$(echo "${macos_info}" | cut -d: -f1)
    MACOS_BUILD=$(echo "${macos_info}" | cut -d: -f2)
    MACOS_MAJOR=$(echo "${macos_info}" | cut -d: -f3)
    MACOS_MINOR=$(echo "${macos_info}" | cut -d: -f4)
    MACOS_PATCH=$(echo "${macos_info}" | cut -d: -f5)
    
    # Check Homebrew availability
    HOMEBREW_AVAILABLE=$(check_homebrew_available "${HOMEBREW_PREFIX}")
    
    # Export variables for use in other scripts
    export SYSTEM_ARCH
    export HOMEBREW_PREFIX
    export IS_APPLE_SILICON
    export IS_INTEL_MAC
    export MACOS_VERSION
    export MACOS_BUILD
    export MACOS_MAJOR
    export MACOS_MINOR
    export MACOS_PATCH
    export HOMEBREW_AVAILABLE
}

# Print system information
print_system_info() {
    echo "System Information:"
    echo "  Architecture: ${SYSTEM_ARCH}"
    echo "  Apple Silicon: ${IS_APPLE_SILICON}"
    echo "  Intel Mac: ${IS_INTEL_MAC}"
    echo "  macOS Version: ${MACOS_VERSION}"
    echo "  macOS Build: ${MACOS_BUILD}"
    echo "  Homebrew Prefix: ${HOMEBREW_PREFIX}"
    echo "  Homebrew Available: ${HOMEBREW_AVAILABLE}"
}

# Run detection if script is executed directly
if [[ "${BASH_SOURCE[0]}" == "${0}" ]]; then
    detect_system
    print_system_info
fi 