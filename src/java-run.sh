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

java ${EXECUTABLE} "hello" "My name is" "Eugene"