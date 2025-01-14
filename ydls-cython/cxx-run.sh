#!/bin/bash

# Check if Xcode Command Line Tools are installed
echo "Checking for Xcode Command Line Tools..."

if ! xcode-select -p &> /dev/null; then
    echo "Xcode Command Line Tools not found. Installing..."
    xcode-select --install
    echo "Installation initiated. Please complete the installation and re-run this script."
    exit 1
else
    echo "Xcode Command Line Tools are already installed."
fi

# Check if the C compiler (clang) is installed and display version
echo "Checking for C compiler (clang) version..."
if command -v clang &> /dev/null; then
    clang --version
else
    echo "C compiler (clang) not found. Installing Xcode Command Line Tools should resolve this."
    exit 1
fi

# Check if the C++ compiler (clang++) is installed and display version
echo "Checking for C++ compiler (clang++) version..."
if command -v clang++ &> /dev/null; then
    clang++ --version
else
    echo "C++ compiler (clang++) not found. Installing Xcode Command Line Tools should resolve this."
    exit 1
fi









# Compile the C program
echo "Compiling C program..."
clang hello.c -o hello_c  # compilation, human lang -> machine lang
if [ $? -eq 0 ]; then
    echo "C program compiled successfully!"
else
    echo "Error compiling C program."
    exit 1
fi

# Run the compiled C program
echo "Running C program:"
./hello_c                   # machine reads the program.






# Compile the C++ program
echo "Compiling C++ program..."
clang++ hello.cpp -o hello_cpp   # compilation, human lang -> machine lang
if [ $? -eq 0 ]; then
    echo "C++ program compiled successfully!"
else
    echo "Error compiling C++ program."
    exit 1
fi

# Run the compiled C++ program
echo "Running C++ program:"
./hello_cpp                 # machine reads the program.








echo "Setup complete. Both C and C++ programs are compiled and executed successfully."
