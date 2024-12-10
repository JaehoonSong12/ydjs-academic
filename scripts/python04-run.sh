#!/bin/bash
PYTHON_SOURCE_CODE="src/main/python"
EXECUTABLE="cli"                                #### YOUR DATA HERE
cd ${PYTHON_SOURCE_CODE}
############################################
########## Shell Script (Scripts) ##########
############################################
clear
## python-execution
if command -v python &>/dev/null; then # Check for Python command (python3 or python)
    PYTHON_CMD=python
elif command -v python3 &>/dev/null; then
    PYTHON_CMD=python3
fi
$PYTHON_CMD "${EXECUTABLE}.py"