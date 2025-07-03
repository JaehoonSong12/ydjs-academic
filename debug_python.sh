#!/usr/bin/env bash
#
# Python Installation Debug Script
# This script helps diagnose Python installation issues

set -euo pipefail

echo "Python Installation Debug Report"
echo "================================="

# Check system architecture
echo "System Architecture:"
echo "  uname -m: $(uname -m)"
echo "  uname -a: $(uname -a)"
echo

# Check Homebrew locations
echo "Homebrew Locations:"
if [[ -d "/opt/homebrew" ]]; then
    echo "  /opt/homebrew: EXISTS (Apple Silicon)"
    ls -la /opt/homebrew/bin/ | grep python || echo "    No Python in /opt/homebrew/bin/"
    ls -la /opt/homebrew/opt/ | grep python || echo "    No Python in /opt/homebrew/opt/"
    ls -la /opt/homebrew/Cellar/ | grep python || echo "    No Python in /opt/homebrew/Cellar/"
else
    echo "  /opt/homebrew: NOT FOUND"
fi

if [[ -d "/usr/local" ]]; then
    echo "  /usr/local: EXISTS (Intel Mac)"
    ls -la /usr/local/bin/ | grep python || echo "    No Python in /usr/local/bin/"
    ls -la /usr/local/opt/ | grep python || echo "    No Python in /usr/local/opt/"
    ls -la /usr/local/Cellar/ | grep python || echo "    No Python in /usr/local/Cellar/"
else
    echo "  /usr/local: NOT FOUND"
fi
echo

# Check brew list
echo "Brew Installed Python Versions:"
if command -v brew >/dev/null 2>&1; then
    brew list | grep python || echo "  No Python versions found via brew list"
else
    echo "  brew command not found"
fi
echo

# Check brew info
echo "Brew Python Info:"
for version in "3.9" "3.10" "3.11" "3.12" "3.13"; do
    if brew list "python@${version}" >/dev/null 2>&1; then
        echo "  python@${version}: INSTALLED"
        brew --prefix "python@${version}" 2>/dev/null || echo "    Could not get prefix"
    else
        echo "  python@${version}: NOT INSTALLED"
    fi
done
echo

# Check current Python
echo "Current Python:"
echo "  which python3: $(which python3)"
echo "  python3 --version: $(python3 --version)"
echo "  python3 -c 'import sys; print(sys.executable)': $(python3 -c 'import sys; print(sys.executable)')"
echo

# Check PATH
echo "PATH Analysis:"
echo "$PATH" | tr ':' '\n' | grep -E "(homebrew|local)" | while read -r path; do
    echo "  $path"
done
echo

# Check .zshrc
echo ".zshrc Python-related lines:"
grep -i python ~/.zshrc || echo "  No Python-related lines found"
echo

echo "Debug complete!" 