#include <stdio.h>

// Function to calculate Fibonacci number using recursion
int fibonacci(int n) {
    if (n <= 1) {
        return n;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

int main() {
    int n;

    // Asking user for input
    printf("Enter the number of terms for the Fibonacci sequence: ");
    scanf("%d", &n);

    printf("Fibonacci sequence up to %d terms:\n", n);
    
    // Printing Fibonacci sequence
    for (int i = 0; i < n; i++) {
        printf("%d ", fibonacci(i));
    }
    printf("\n");

    return 0;
}
