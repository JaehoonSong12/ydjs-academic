#!/usr/bin/env bash
set -euo pipefail

echo
echo "Checking environment for Homebrew setup in ${PWD}"
echo "----------------------------------------------"

# 1. Ensure we’re on macOS
if [[ "$(uname)" != "Darwin" ]]; then
  echo "This script is for macOS only. Exiting."
  exit 1
fi

# 2. Install Homebrew if missing
if ! command -v brew >/dev/null 2>&1; then
  echo "Homebrew not found. Installing..."
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
else
  echo "Homebrew is already installed."
fi

# 3. Determine your shell and RC file
SHELL_NAME="$(basename "${SHELL}")"
if [[ "${SHELL_NAME}" == "zsh" ]]; then
  RC_FILE="${HOME}/.zshrc"
  SHELL_NAME="zsh"
else
  RC_FILE="${HOME}/.bash_profile"
  SHELL_NAME="bash"
fi

echo
echo "Detected shell: ${SHELL_NAME}"
echo "Using RC file: ${RC_FILE}"

# 4. Create RC file if missing
if [[ ! -f "${RC_FILE}" ]]; then
  echo "${RC_FILE} not found. Creating it now."
  touch "${RC_FILE}"
else
  echo "${RC_FILE} already exists."
fi

# 5. Append Homebrew PATH if not already present
EXPORT_LINE='export PATH="/opt/homebrew/bin:$PATH"'
if grep -Fxq "${EXPORT_LINE}" "${RC_FILE}"; then
  echo "PATH export already present in ${RC_FILE}."
else
  echo "Appending Homebrew path to ${RC_FILE}."
  {
    echo ""
    echo "# Added by setup-homebrew.sh on $(date '+%Y-%m-%d')"
    echo "${EXPORT_LINE}"
  } >> "${RC_FILE}"
fi

# 6. Source RC file so brew becomes immediately available
echo
echo "Sourcing ${RC_FILE}..."
# shellcheck source=/dev/null
source "${RC_FILE}"

# 7. Verify installation
echo
echo "Final check:"
if brew --version >/dev/null 2>&1; then
  echo "Homebrew is installed and reachable:"
  brew --version
else
  echo "Error: brew command still not found."
  exit 1
fi

echo "----------------------------------------------"
echo "Setup complete!"







################ PYTHON SETUP
# 1. Install the correct formula name
brew install python@3.11

# 2. Unlink any other brew‑installed Pythons (ignore errors if none)
brew unlink python@3.9 2>/dev/null || true
brew unlink python@3.10 2>/dev/null || true
brew unlink python@3.11       # undo any existing link
brew unlink python@3.12 2>/dev/null || true
brew unlink python@3.13 2>/dev/null || true

# 3. Link 3.11 into /opt/homebrew/bin
brew link --force --overwrite python@3.11

ls -l /opt/homebrew/bin/python3
export PATH="/opt/homebrew/opt/python@3.11/bin:/opt/homebrew/bin:$PATH" # Ensure Homebrew’s Python comes first
source ~/.zshrc



# 4. Verify
which python3
python3 --version

# or download from https://www.python.org/downloads/macos/
# python3.12 -m venv newenv
# source newenv/bin/activate
# python main.py
