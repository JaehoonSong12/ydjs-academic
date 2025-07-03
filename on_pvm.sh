#!/usr/bin/env bash
set -euo pipefail



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
