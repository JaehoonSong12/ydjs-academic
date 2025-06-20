
# Check for Python command (python3 or python)
if command -v python &>/dev/null; then
    PYTHON_CMD=python
elif command -v python3 &>/dev/null; then
    PYTHON_CMD=python3
else
    echo "Python is not installed or not found in PATH"
    exit 1
fi

# Python Virtual Environment (PVE)
if $PYTHON_CMD -c "import venv" &>/dev/null; then
    echo "'venv' module is available. Creating virtual environment using 'venv'..."
    $PYTHON_CMD -m venv venv
elif $PYTHON_CMD -c "import virtualenv" &>/dev/null; then
    echo "'virtualenv' module is available. Creating virtual environment using 'virtualenv'..."
    $PYTHON_CMD -m virtualenv venv
else
    echo "Error: Neither 'venv' nor 'virtualenv' module is available. Please install one of them."
    exit 1
fi


# Suggest command to activate the virtual environment based on OS type
if [[ "$OSTYPE" == "msys" || "$OSTYPE" == "cygwin" ]]; then # Windows
    echo "==============================================================="
    echo "Run the following command to activate the virtual environment:"
    echo "source venv/Scripts/activate"
    echo "==============================================================="
elif [[ "$OSTYPE" == "darwin"* || "$OSTYPE" == "linux-gnu"* ]]; then # macOS or Linux
    echo "==============================================================="
    echo "Run the following command to activate the virtual environment:"
    echo "source venv/bin/activate"
    echo "==============================================================="
else
    echo "==============================================================="
    echo "Unsupported OS type: $OSTYPE"
    exit 1
    echo "==============================================================="
fi