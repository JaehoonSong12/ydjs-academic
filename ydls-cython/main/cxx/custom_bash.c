#include <stdio.h>
#include <string.h>


// char* pwd(void) {
//     .....
// }


// Procedural/Function
void print(char* str) {
    char buffer[1024]; // Ensure this is large enough for the concatenated string
    snprintf(buffer, sizeof(buffer), "%s\n", str);
    printf("%s", buffer);
    return;
}

int main(void) {
    print("Try programiz.pro");
    // Write C code here
    
    
    print("Hello World!");
    print("I am learning C.");
    print("And it is awesome!");
    
    return 0;
}