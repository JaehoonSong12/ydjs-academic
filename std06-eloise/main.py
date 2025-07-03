import turtle # getting someone else's code

import platform
platform.mac_ver = lambda: ('14.7.6', ('', '', ''), '')


screen = turtle.Screen()
screen.setup(width=600, height=600)  # Set window size
screen.bgcolor("lightgreen") # Set background color
screen.title("My Turtle Program")

pen = turtle.Turtle()
pen.color("blue")
pen.pensize(3)
pen.speed(2) # Set drawing speed (0 is fastest, 10 is slowest)

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


















# import os

# # Create a single directory
# os.mkdir("my_new_directory")



# import os

# directory_to_remove = "my_new_directory"

# try:
#     os.rmdir(directory_to_remove)
#     print(f"Directory '{directory_to_remove}' removed successfully.")
# except OSError as e:
#     print(f"Error removing directory: {e}")