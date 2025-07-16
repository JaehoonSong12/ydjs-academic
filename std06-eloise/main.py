def draw_diagram(): # Organaizer: "Function defined with Signature(Parameters):"
    import turtle                       # getting someone else's code (by Python, so not visible in your project directory)

    screen = turtle.Screen()            # in turtle.py file, calling "def Screen()" function, returning your computer screen
    screen.setup(width=500, height=700) # screen's setup by 300px width x 300px height, set window size
    screen.bgcolor("lavender")          # screen's background color to "lightblue"
    screen.title("Eloise First Graphics")   # screen's title to "Eloise First Graphics"

    pen = turtle.Turtle()               # Turtle means "pen in python language"
    pen.color("lightpink")
    pen.pensize(6)
    pen.speed(5) # Set drawing speed (0 is fastest, 10 is slowest)

    pen.forward(100)
    pen.left(90)
    pen.forward(50)
    pen.right(180)
    pen.forward(100)
    pen.hideturtle() # Make the turtle invisible

    screen.mainloop()









# her_name = "Eloise"
# her_age = 11

# his_name = "Jaehoon"
# his_age = 17 + her_age

# print('s')
# print('''s''')
# print("s")
# print("""s""")

# her_name = input('what is your name')

# print("Hi,", her_name, ", my age is", her_age)

# print("Hi,", his_name, ", my age is", his_age)
















import os

def create_directory(name):
    try:
        os.mkdir(name)
        print(f"Directory '{name}' created.")
    except FileExistsError:
        print(f"Directory '{name}' already exists.")

def remove_directory(name):
    try:
        os.rmdir(name)
        print(f"Directory '{name}' removed successfully.")
    except OSError as e:
        print(f"Error removing directory: {e}")








#### Eloise's response
def echo_request(request):
    print(f"Yes mom, I will do {request}")






##################################################################
##################################################################
#                           Chapter 1
##################################################################
##################################################################
# 1. A(n) program is a set of instructions that a computer follows to perform a task. 
# a. compiler
# b. 
# c. interpreter
# d. programming language
# 2. The physical devices that a computer is made of are referred to as __________. a. hardware
# b. software
# c. the operating system d. tools
# 3. The part of a computer that runs programs is called __________. a. RAM
# b. secondary storage c. main memory
# e. the CPU
# 4. Today, CPUs are small chips known as __________. a. ENIACs
# b. microprocessors c. memory chips
# d. operating systems
# 5. The computer stores a program while the program is running, as well as the data that the program is working with, in __________.
# a. secondary storage
# b. the CPU
# c. main memory
# d. the microprocessor
# 6. This is a volatile type of memory that is used only for temporary storage while a pro- gram is running.
# a. RAM
# b. secondary storage
# c. the disk drive d. the USB drive
#                  7. A type of memory that can hold data for long periods of time, even when there is no power to the computer, is called __________.
# a. RAM
# b. main memory
# c. secondary storage d. CPU storage
# 8. A component that collects data from people or other devices and sends it to the com- puter is called __________.
# a. an output device
# b. an input device
# c. a secondary storage device d. main memory
# 9. A video display is a(n) __________ device. a. output
# b. input
# c. secondary storage d. main memory
# 10. A __________ is enough memory to store a letter of the alphabet or a small number. a. byte
# b. bit
# c. switch
# d. transistor
# 11. A byte is made up of eight __________. a. CPUs
# b. instructions c. variables
# d. bits
# 12. In the __________ numbering system, all numeric values are written as sequences of 0s and 1s.
# a. hexadecimal b. binary
# c. octal
# d. decimal
# 13. A bit that is turned off represents the following value: __________. a. 1
# b. −1
# c. 0
# d. “no”
# 14. A set of 128 numeric codes that represent the English letters, various punctuation marks, and other characters is __________.
# a. binary numbering
# b. ASCII
# c. Unicode d. ENIAC
# Review Questions 25

#                  26 Chapter 1 Introduction to Computers and Programming
# 15. An extensive encoding scheme that can represent characters for many languages in the world is __________.
# a. binary numbering
# b. ASCII
# c. Unicode d. ENIAC
# 16. Negative numbers are encoded using the __________ technique. a. two’s complement
# b. floating point
# c. ASCII
# d. Unicode
# 17. Real numbers are encoded using the __________ technique. a. two’s complement
# b. floating point
# c. ASCII
# d. Unicode
# 18. The tiny dots of color that digital images are composed of are called __________. a. bits
# b. bytes
# c. color packets d. pixels
# 19. If you were to look at a machine language program, you would see __________. a. Python code
# b. a stream of binary numbers c. English words
# d. circuits
# 20. In the __________ part of the fetch-decode-execute cycle, the CPU determines which operation it should perform.
# a. fetch
# b. decode
# c. execute
# d. deconstruct
# 21. Computers can only execute programs that are written in __________. a. Java
# b. assembly language c. machine language d. Python
# 22. The __________ translates an assembly language program to a machine language program.
# a. assembler b. compiler c. translator d. interpreter

                
# 23. The words that make up a high-level programming language are called __________. a. binary instructions
# b. mnemonics
# c. commands
# d. keywords
# 24. The rules that must be followed when writing a program are called __________. a. syntax
# b. punctuation c. keywords d. operators
# 25. A(n) __________ program translates a high-level language program into a separate machine language program.
# a. assembler
# b. compiler
# c. translator d. utility





def study_chapter1_part1():
    import turtle
    radius = turtle.numinput("Input Needed", 'enter the radius of the circle')
    turtle.circle(radius)
    turtle.done()





def study_chapter1_part2():
    # This program draws the stars of the Orion constellation,
    # the names of the stars, and the constellation lines.
    import turtle

    # Set the window size.
    turtle.setup(500, 600)

    # Setup the turtle.
    turtle.penup()
    turtle.hideturtle()

    # Create named constants for the star coordinates.
    LEFT_SHOULDER_X = -70
    LEFT_SHOULDER_Y = 200

    RIGHT_SHOULDER_X = 80
    RIGHT_SHOULDER_Y = 180

    LEFT_BELTSTAR_X = -40
    LEFT_BELTSTAR_Y = -20

    MIDDLE_BELTSTAR_X = 0
    MIDDLE_BELTSTAR_Y = 0

    RIGHT_BELTSTAR_X = 40
    RIGHT_BELTSTAR_Y = 20

    LEFT_KNEE_X = -90
    LEFT_KNEE_Y = -180

    RIGHT_KNEE_X = 120
    RIGHT_KNEE_Y = -140

    # Draw the stars.
    turtle.goto(LEFT_SHOULDER_X, LEFT_SHOULDER_Y) # Left shoulder
    turtle.dot()
    turtle.goto(RIGHT_SHOULDER_X, RIGHT_SHOULDER_Y) # Right shoulder
    turtle.dot()
    turtle.goto(LEFT_BELTSTAR_X, LEFT_BELTSTAR_Y) # Left belt star
    turtle.dot()
    turtle.goto(MIDDLE_BELTSTAR_X, MIDDLE_BELTSTAR_Y) # Middle belt star
    turtle.dot()
    turtle.goto(RIGHT_BELTSTAR_X, RIGHT_BELTSTAR_Y) # Right belt star
    turtle.dot()
    turtle.goto(LEFT_KNEE_X, LEFT_KNEE_Y) # Left knee
    turtle.dot()
    turtle.goto(RIGHT_KNEE_X, RIGHT_KNEE_Y) # Right knee
    turtle.dot()

    # Display the star names
    turtle.goto(LEFT_SHOULDER_X, LEFT_SHOULDER_Y)
    turtle.write('Betelgeuse')
    turtle.goto(RIGHT_SHOULDER_X, RIGHT_SHOULDER_Y)
    turtle.write('Meissa')
    turtle.goto(LEFT_BELTSTAR_X, LEFT_BELTSTAR_Y)
    turtle.write('Alnitak')
    turtle.goto(MIDDLE_BELTSTAR_X, MIDDLE_BELTSTAR_Y)
    turtle.write('Alnilam')
    turtle.goto(RIGHT_BELTSTAR_X, RIGHT_BELTSTAR_Y)
    turtle.write('Mintaka')
    turtle.goto(LEFT_KNEE_X, LEFT_KNEE_Y)
    turtle.write('Saiph')
    turtle.goto(RIGHT_KNEE_X, RIGHT_KNEE_Y)
    turtle.write('Rigel')

    # Draw lines between the stars
    turtle.goto(LEFT_SHOULDER_X, LEFT_SHOULDER_Y)
    turtle.pendown()
    turtle.goto(LEFT_BELTSTAR_X, LEFT_BELTSTAR_Y)
    turtle.penup()

    turtle.goto(RIGHT_SHOULDER_X, RIGHT_SHOULDER_Y)
    turtle.pendown()
    turtle.goto(RIGHT_BELTSTAR_X, RIGHT_BELTSTAR_Y)
    turtle.penup()

    turtle.goto(LEFT_BELTSTAR_X, LEFT_BELTSTAR_Y)
    turtle.pendown()
    turtle.goto(MIDDLE_BELTSTAR_X, MIDDLE_BELTSTAR_Y)
    turtle.penup()

    turtle.goto(MIDDLE_BELTSTAR_X, MIDDLE_BELTSTAR_Y)
    turtle.pendown()
    turtle.goto(RIGHT_BELTSTAR_X, RIGHT_BELTSTAR_Y)
    turtle.penup()

    turtle.goto(LEFT_BELTSTAR_X, LEFT_BELTSTAR_Y)
    turtle.pendown()
    turtle.goto(LEFT_KNEE_X, LEFT_KNEE_Y)
    turtle.penup()

    turtle.goto(RIGHT_BELTSTAR_X, RIGHT_BELTSTAR_Y)
    turtle.pendown()
    turtle.goto(RIGHT_KNEE_X, RIGHT_KNEE_Y)

    # Keep the window open
    turtle.done()














# Modularization is the way you organize your own code.
def main():
    # print("Doing Nothing Yet")


    # draw_diagram() # Open process of Organizer: "Function call, signature(arguments)"


    # # Eloise Mom
    # request = "viola"
    # echo_request(request)

    # study_chapter1_part1()
    study_chapter1_part2()


if __name__ == "__main__":
    main()