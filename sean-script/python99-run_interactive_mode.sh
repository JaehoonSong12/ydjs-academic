#!/bin/bash
cd "src"
EXECUTABLE="cli"                                #### YOUR DATA HERE
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
$PYTHON_CMD