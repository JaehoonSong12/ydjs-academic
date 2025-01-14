#!/bin/bash
source venv/Scripts/activate
PYTHON_SOURCE_CODE="main/python"
EXECUTABLE="cli"                                #### YOUR DATA HERE
cd ${PYTHON_SOURCE_CODE}
############################################
########## Shell Script (Scripts) ##########
############################################
## python-env_setup
pip install pipreqs
pipreqs . --force
pip install -r requirements.txt
clear
## python-execution
if command -v python &>/dev/null; then # Check for Python command (python3 or python)
    PYTHON_CMD=python
elif command -v python3 &>/dev/null; then
    PYTHON_CMD=python3
fi
$PYTHON_CMD "${EXECUTABLE}.py"