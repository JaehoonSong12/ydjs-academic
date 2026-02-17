#!/bin/bash
set -euo pipefail

# Color definitions
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
RESET='\033[0m'

echo -e "${CYAN}==========================================${RESET}"
echo -e "${CYAN}macOS Development Environment Setup${RESET}"
echo -e "${CYAN}==========================================${RESET}"
echo ""

# Determine shell and RC file
SHELL_NAME=$(basename "${SHELL:-}")
if [[ "$SHELL_NAME" == "zsh" ]]; then
  RC_FILE="$HOME/.zshrc"
elif [[ "$SHELL_NAME" == "bash" ]]; then
  RC_FILE="$HOME/.bash_profile"
else
  RC_FILE="$HOME/.zshrc"
fi

# Ensure RC file exists
if [[ ! -f "$RC_FILE" ]]; then
  touch "$RC_FILE"
fi








# -----------------------------------------------------------------------------
# 1. Xcode Command Line Tools (Mac Package Manager)
# -----------------------------------------------------------------------------
echo -e "${CYAN}1. Checking Xcode Command Line Tools...${RESET}"
if ! xcode-select -p &> /dev/null; then
  echo -e "   ${YELLOW}Installing Xcode Command Line Tools...${RESET}"
  xcode-select --install
  echo -e "   ${YELLOW}Installation initiated. Please complete and re-run this script.${RESET}"
  exit 1
else
  echo -e "   ${GREEN}[OK]${RESET} Xcode Command Line Tools installed"
fi
echo ""

# -----------------------------------------------------------------------------
# 2. Homebrew
# -----------------------------------------------------------------------------
echo -e "${CYAN}2. Checking Homebrew...${RESET}"
if ! command -v brew >/dev/null 2>&1; then
  echo -e "   ${YELLOW}Installing Homebrew...${RESET}"
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  
  # Add Homebrew to PATH for Apple Silicon
  if [[ "$(uname -m)" == "arm64" ]]; then
    BREW_PATH='export PATH="/opt/homebrew/bin:$PATH"'
    if ! grep -Fxq "$BREW_PATH" "$RC_FILE"; then
      echo "$BREW_PATH" >> "$RC_FILE"
      export PATH="/opt/homebrew/bin:$PATH"
    fi
  fi
else
  echo -e "   ${GREEN}[OK]${RESET} Homebrew installed: $(brew --version | head -n1)"
fi

# Add Homebrew to PATH in shell config (Apple Silicon: /opt/homebrew, Intel: /usr/local)
if command -v brew >/dev/null 2>&1; then
  BREW_PREFIX=$(brew --prefix)
  BREW_PATH="export PATH=\"$BREW_PREFIX/bin:\$PATH\""
  if ! grep -Fxq "$BREW_PATH" "$RC_FILE"; then
    echo "$BREW_PATH" >> "$RC_FILE"
    echo -e "   ${GREEN}[OK]${RESET} Homebrew path added to $RC_FILE"
  fi
  export PATH="$BREW_PREFIX/bin:$PATH"
fi
echo ""

# -----------------------------------------------------------------------------
# 3. Git
# -----------------------------------------------------------------------------
echo -e "${CYAN}3. Checking Git...${RESET}"
if ! command -v git >/dev/null 2>&1; then
  echo -e "   ${YELLOW}Installing Git...${RESET}"
  brew install git
else
  echo -e "   ${GREEN}[OK]${RESET} Git installed: $(git --version)"
fi
echo ""

# -----------------------------------------------------------------------------
# 4. Python
# -----------------------------------------------------------------------------
echo -e "${CYAN}4. Checking Python...${RESET}"
if ! command -v python3 >/dev/null 2>&1; then
  echo -e "   ${YELLOW}Installing Python...${RESET}"
  brew install python
  echo -e "   ${GREEN}[OK]${RESET} Python installed"
else
  echo -e "   ${GREEN}[OK]${RESET} Python installed: $(python3 --version)"
fi
# Ensure 'python' points to python3 (macOS no longer provides /usr/bin/python)
PYTHON_ALIAS="alias python='python3'"
if ! grep -Fxq "$PYTHON_ALIAS" "$RC_FILE"; then
  echo "$PYTHON_ALIAS" >> "$RC_FILE"
  echo -e "   ${GREEN}[OK]${RESET} python alias added (python -> python3)"
fi
echo ""

# -----------------------------------------------------------------------------
# 5. Node.js
# -----------------------------------------------------------------------------
echo -e "${CYAN}5. Checking Node.js...${RESET}"
if ! command -v node >/dev/null 2>&1; then
  echo -e "   ${YELLOW}Installing Node.js...${RESET}"
  brew install node
  echo -e "   ${GREEN}[OK]${RESET} Node.js installed: $(node --version)"
  echo -e "   ${GREEN}[OK]${RESET} npm installed: $(npm --version)"
else
  echo -e "   ${GREEN}[OK]${RESET} Node.js installed: $(node --version)"
  echo -e "   ${GREEN}[OK]${RESET} npm installed: $(npm --version)"
fi
echo ""

# -----------------------------------------------------------------------------
# 6. Java (OpenJDK 21)
# -----------------------------------------------------------------------------
echo -e "${CYAN}6. Checking Java...${RESET}"
# macOS provides a /usr/bin/java stub that only opens "Install Java" dialog; treat as no Java
JAVA_OK=false
if command -v java >/dev/null 2>&1; then
  JAVA_OUT=$(java -version 2>&1) || true
  if [[ -n "$JAVA_OUT" && "$JAVA_OUT" != *"Unable to locate a Java Runtime"* && "$JAVA_OUT" != *"No Java runtime present"* ]]; then
    JAVA_OK=true
  fi
fi
if [[ "$JAVA_OK" != true ]]; then
  echo -e "   ${YELLOW}Installing Java (OpenJDK 21)...${RESET}"
  brew install openjdk@21
  echo -e "   ${GREEN}[OK]${RESET} Java installed"
else
  echo -e "   ${GREEN}[OK]${RESET} Java installed: $(java -version 2>&1 | head -n1)"
fi

# Add OpenJDK to PATH and JAVA_HOME (Homebrew installs to versioned path, not on PATH by default)
if command -v brew >/dev/null 2>&1 && [[ -d "$(brew --prefix openjdk@21 2>/dev/null)/bin" ]]; then
  JAVA_PREFIX=$(brew --prefix openjdk@21)
  JAVA_PATH="export PATH=\"$JAVA_PREFIX/bin:\$PATH\""
  JAVA_HOME_LINE="export JAVA_HOME=\"$JAVA_PREFIX\""
  if ! grep -Fq "$JAVA_PREFIX/bin" "$RC_FILE"; then
    echo "$JAVA_PATH" >> "$RC_FILE"
    echo -e "   ${GREEN}[OK]${RESET} OpenJDK path added to $RC_FILE"
  fi
  if ! grep -Fxq "$JAVA_HOME_LINE" "$RC_FILE"; then
    echo "$JAVA_HOME_LINE" >> "$RC_FILE"
  fi
  export PATH="$JAVA_PREFIX/bin:$PATH"
  export JAVA_HOME="$JAVA_PREFIX"
fi
echo ""

# -----------------------------------------------------------------------------
# 7. GitHub CLI (gh) and GitHub Desktop
# -----------------------------------------------------------------------------
echo -e "${CYAN}7. Checking GitHub CLI (gh)...${RESET}"
if ! command -v gh >/dev/null 2>&1; then
  echo -e "   ${YELLOW}Installing GitHub CLI...${RESET}"
  brew install gh
  echo -e "   ${GREEN}[OK]${RESET} GitHub CLI installed: $(gh --version | head -n1)"
else
  echo -e "   ${GREEN}[OK]${RESET} GitHub CLI installed: $(gh --version | head -n1)"
fi

echo -e "${CYAN}   Checking GitHub Desktop...${RESET}"
if ! [ -d "/Applications/GitHub Desktop.app" ] && ! [ -d "$HOME/Applications/GitHub Desktop.app" ]; then
  echo -e "   ${YELLOW}Installing GitHub Desktop...${RESET}"
  brew install --cask github
  echo -e "   ${GREEN}[OK]${RESET} GitHub Desktop installed"
else
  echo -e "   ${GREEN}[OK]${RESET} GitHub Desktop installed"
fi
echo ""

# -----------------------------------------------------------------------------
# 8. VS Code CLI
# -----------------------------------------------------------------------------
echo "8. Configuring VS Code CLI..."

# Check common VS Code installation locations
VSCODE_PATHS=(
  "/Applications/Visual Studio Code.app/Contents/Resources/app/bin"
  "$HOME/Applications/Visual Studio Code.app/Contents/Resources/app/bin"
  "$PWD/Downloads/Visual Studio Code.app/Contents/Resources/app/bin"
)

VSCODE_CLI=""
for path in "${VSCODE_PATHS[@]}"; do
  if [ -d "$path" ]; then
    VSCODE_CLI="$path"
    break
  fi
done

if [ -n "$VSCODE_CLI" ]; then
  VSCODE_EXPORT="export PATH=\"\$PATH:$VSCODE_CLI\""
  if ! grep -Fxq "$VSCODE_EXPORT" "$RC_FILE"; then
    echo "$VSCODE_EXPORT" >> "$RC_FILE"
    echo -e "   ${GREEN}[OK]${RESET} VS Code CLI path added"
  else
    echo -e "   ${GREEN}[OK]${RESET} VS Code CLI path already configured"
  fi
  
  # Verify code command availability
  export PATH="$PATH:$VSCODE_CLI"
  if command -v code >/dev/null 2>&1; then
    echo -e "   ${GREEN}[OK]${RESET} 'code' command is available"
  fi
else
  echo -e "   ${YELLOW}[WARN]${RESET} VS Code not found in common locations"
  echo -e "   ${BLUE}Please install VS Code or manually add it to PATH${RESET}"
fi
echo ""

# -----------------------------------------------------------------------------
# 9. chmod_all alias
# -----------------------------------------------------------------------------
echo -e "${CYAN}9. Setting up chmod_all alias...${RESET}"
ALIAS_LINE="alias chmod_all='find . -type f -name \"*.sh\" -exec chmod +x {} \;'"
if ! grep -qxF "$ALIAS_LINE" "$RC_FILE"; then
  echo "$ALIAS_LINE" >> "$RC_FILE"
  echo -e "   ${GREEN}[OK]${RESET} chmod_all alias added"
else
  echo -e "   ${GREEN}[OK]${RESET} chmod_all alias already exists"
fi
echo ""







# -----------------------------------------------------------------------------
# 10. MacTeX
# -----------------------------------------------------------------------------
echo -e "${CYAN}10. Checking MacTeX...${RESET}"
if ! command -v pdflatex >/dev/null 2>&1; then
  echo -e "   ${YELLOW}Installing MacTeX (this may take a while)...${RESET}"
  brew install --cask mactex
  echo -e "   ${GREEN}[OK]${RESET} MacTeX installed"
else
  echo -e "   ${GREEN}[OK]${RESET} MacTeX installed: $(pdflatex --version | head -n1)"
fi
echo ""

# Add TeX to PATH if needed
TEX_PATH='export PATH="/Library/TeX/texbin:$PATH"'
if ! grep -Fxq "$TEX_PATH" "$RC_FILE"; then
  echo "$TEX_PATH" >> "$RC_FILE"
fi
echo ""

# -----------------------------------------------------------------------------
# Apply config and verify installations
# -----------------------------------------------------------------------------
echo -e "${CYAN}Applying shell config...${RESET}"
# shellcheck source=/dev/null
source "$RC_FILE" 2>/dev/null || true
echo ""

echo -e "${CYAN}Verifying installed tools:${RESET}"
run_version() {
  local name="$1"
  local cmd="$2"
  shift 2
  if command -v "$cmd" >/dev/null 2>&1; then
    echo -e "   ${GREEN}$name:${RESET} $("$cmd" "$@" 2>&1 | head -n1)"
  else
    echo -e "   ${YELLOW}$name:${RESET} not in PATH (run: source $RC_FILE)"
  fi
}
run_version "Homebrew" "brew" --version
run_version "Git" "git" --version
run_version "Python" "python3" --version
run_version "Node.js" "node" --version
run_version "npm" "npm" --version
run_version "Java" "java" -version
run_version "GitHub CLI" "gh" --version
run_version "MacTeX (pdflatex)" "pdflatex" --version
if command -v code >/dev/null 2>&1; then
  echo -e "   ${GREEN}VS Code CLI:${RESET} $(code --version 2>/dev/null | head -n1)"
else
  echo -e "   ${YELLOW}VS Code CLI:${RESET} not in PATH (run: source $RC_FILE)"
fi
echo ""

# -----------------------------------------------------------------------------
# Finalize
# -----------------------------------------------------------------------------
echo -e "${CYAN}==========================================${RESET}"
echo -e "${GREEN}Setup Complete!${RESET}"
echo -e "${CYAN}==========================================${RESET}"
echo ""
echo -e "${BLUE}To apply changes to your current session, run:${RESET}"
echo -e "  ${YELLOW}source $RC_FILE${RESET}"
echo ""
echo -e "${BLUE}To verify your configuration, run:${RESET}"
echo -e "  ${YELLOW}code $RC_FILE${RESET}"
echo ""
echo -e "${BLUE}To log in to GitHub CLI (avoids terminal escape issues), run:${RESET}"
echo -e "  ${YELLOW}gh auth login --web --git-protocol https${RESET}"
echo ""