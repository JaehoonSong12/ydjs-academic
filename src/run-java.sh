#!/bin/bash
javac --version
javac *.java


MAIN_EXECUTABLE="MyProgram01NumberGame"
java --version
java ${MAIN_EXECUTABLE} "hello" "My name is" "Eugene"

rm hello_c
rm hello_cpp
rm *.class