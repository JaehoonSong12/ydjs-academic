#!/bin/bash
if [ -f ~/.bashrc ]; then
    source ~/.bashrc
# else
#     echo -e "\033[1;31mError: ~/.bashrc not found. Exiting...\033[0m"
#     exit 1
fi
# /usr
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
elif [[ "$OSTYPE" == "linux-gnu"* ]]; then                           # Linux
    echo "Detected Linux: $OSTYPE"
    # Add Linux-specific commands here if needed
else
    echo "Unsupported OS type: $OSTYPE"
    exit 1
fi
############################################
########## Shell Script (Scripts) ##########
############################################
gradle init



# ./gradlew setClass               # Run the setClass task in all submodules (this will match all subprojects)
# ./gradlew :app:setClass          # Run the setClass task in the 'app' module
# ./gradlew :utilities:setClass    # Run the setClass task in the 'utilities' module
