// std06-c/main.c


/*
main.c -- Simple "Guess the Number" console game for beginners

Style:
  - Each function documents: purpose, steps, assumptions.
  - Single-file, portable C (C11). Uses only stdio.h, stdlib.h, time.h, string.h.
  - Input is line-based (fgets + atoi) to avoid scanf pitfalls.

Compile:
  gcc -std=c11 -O2 -Wall -Wextra -o guess main.c

Run:
  ./guess


  
gcc stands for GNU Compiler Collection, 
which is a widely used compiler for C and C++ programming languages.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define BUF_SZ 100

/* print_welcome
   Purpose: show title and short instructions.
   Steps: prints brief game instructions.
   Assumptions: none.
*/
void print_welcome(void) {
    puts("Guess the Number");
    puts("----------------");
    puts("I will pick a number between 1 and the difficulty you choose.");
    puts("You try to guess it. I will tell you if your guess is too low or too high.");
    puts("");
}

/* read_line
   Purpose: safely read one line from stdin into buf.
   Steps:
     1. call fgets to read up to sz-1 chars.
     2. remove trailing newline if present.
     3. return 1 on success, 0 on EOF.
   Assumptions:
     - buf has space for at least sz bytes.
*/
int read_line(char *buf, size_t sz) {
    if (!fgets(buf, (int)sz, stdin)) return 0;
    size_t L = strlen(buf);
    if (L > 0 && buf[L-1] == '\n') buf[L-1] = '\0';
    return 1;
}

/* ask_int
   Purpose: prompt the user and parse an integer (non-negative).
   Steps:
     1. print prompt, read a line.
     2. convert with atoi (simple validation).
     3. on invalid (<=0) return default_value.
   Assumptions:
     - default_value > 0 typically.
*/
int ask_int(const char *prompt, int default_value) {
    char line[BUF_SZ];
    printf("%s", prompt);
    fflush(stdout);
    if (!read_line(line, sizeof(line))) return default_value;
    int v = atoi(line);
    if (v <= 0) return default_value;
    return v;
}

/* play_round
   Purpose: play a single round of guessing until correct.
   Steps:
     1. pick random target in [1, max].
     2. loop: prompt user for guess, compare, give hint.
     3. count attempts and print result when guessed.
   Assumptions:
     - max >= 1.
*/
void play_round(int max) {
    int target = (rand() % max) + 1;
    int attempts = 0;
    char line[BUF_SZ];

    printf("I picked a number between 1 and %d. Start guessing!\n", max);

    while (1) {
        printf("Your guess: ");
        fflush(stdout);
        if (!read_line(line, sizeof(line))) {
            puts("\nInput closed. Exiting round.");
            return;
        }
        int g = atoi(line);
        if (g <= 0) {
            puts("Please enter a positive integer.");
            continue;
        }
        attempts++;
        if (g < target) {
            puts("Too low.");
        } else if (g > target) {
            puts("Too high.");
        } else {
            printf("Correct! You found the number in %d attempt%s.\n",
                   attempts, (attempts == 1 ? "" : "s"));
            break;
        }
    }
}

/* main
   Purpose: program entry; runs game loop.
   Steps:
     1. seed RNG.
     2. print welcome.
     3. ask difficulty (max number).
     4. play rounds until user says no.
   Assumptions:
     - user input via stdin; simple text responses expected ("y" to continue).
*/
int main(void) {
    int x = 10;
    int y = 25;
    int t =
    int z = x + y;
    printf("Hello, Eloise! Ths sum of %i and %i is %i.\n", x, y, z);
    


/*
gcc -std=c11 -O2 -Wall -Wextra -o guess main.c
./guess
*/
    // srand((unsigned)time(NULL));

    // print_welcome();

    // /* choose difficulty */
    // int max = ask_int("Choose difficulty (max number, default 100): ", 100);
    // if (max < 1) max = 100;

    // while (1) {
    //     play_round(max);

    //     printf("Play again? (y/n, default n): ");
    //     fflush(stdout);
    //     char line[BUF_SZ];
    //     if (!read_line(line, sizeof(line))) break;
    //     if (line[0] == 'y' || line[0] == 'Y') {
    //         /* optionally allow difficulty change */
    //         printf("Keep same difficulty (%d)? (y/n): ", max);
    //         fflush(stdout);
    //         if (!read_line(line, sizeof(line))) break;
    //         if (line[0] == 'n' || line[0] == 'N') {
    //             max = ask_int("New difficulty (max number, default 100): ", 100);
    //             if (max < 1) max = 100;
    //         }
    //         continue;
    //     } else {
    //         break;
    //     }
    // }

    // puts("Thanks for playing. Goodbye.");
    return 0;
}
