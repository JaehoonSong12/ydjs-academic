#!/bin/bash
JAVA_SOURCE_CODE="main/java"
EXECUTABLE="Cli"                                #### YOUR DATA HERE
cd ${JAVA_SOURCE_CODE}
############################################
########## Shell Script (Scripts) ##########
############################################
java --version
javac --version

javac *.java



cd chapter01
javac *.java
cd ..

# cd chapter02
# javac *.java
# cd ..

# cd chapter03
# javac *.java
# cd ..

# cd chapter04
# javac *.java
# cd ..

# cd chapter05
# javac *.java
# cd ..

clear

# java -cp . ${EXECUTABLE} "hello" "My name is" "Eugene"
java -cp . ${EXECUTABLE}
echo ""
echo ""