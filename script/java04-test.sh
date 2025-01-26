#!/bin/bash
if [ -f ~/.bashrc ]; then
    source ~/.bashrc
fi
# /usr
cd "ydls-java"


if [[ "$OSTYPE" == "msys" || "$OSTYPE" == "cygwin" ]]; then          # Windows
    if ! java -version 2>/dev/null; then
        INIT_JDK
    fi
    if ! gradle -v 2>/dev/null; then
        INIT_GRADLE
    fi
elif [[ "$OSTYPE" == "darwin"* ]]; then                              # macOS
    java -version
    gradle -v
    # Add macOS-specific commands here if needed
elif [[ "$OSTYPE" == "linux-gnu"* ]]; then                           # Linux
    echo "Detected Linux: $OSTYPE"
    # Add Linux-specific commands here if needed
else
    echo "Unsupported OS type: $OSTYPE"
    exit 1
fi
############################################
# cd "src/main/python"
# EXECUTABLE="cli"                                #### YOUR DATA HERE
############################################
########## Shell Script (Scripts) ##########
############################################
clear
gradle clean
gradle build
opens 'app/build/reports/tests/test/index.html'
# opens 'list/build/reports/tests/test/index.html'
# opens 'utilities/build/reports/tests/test/index.html'