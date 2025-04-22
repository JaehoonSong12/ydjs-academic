import turtle
import math





# Set up the screen
screen = turtle.Screen()
# Create a custom pentagon shape
def create_pentagon(radius=50):
    points = []
    # Calculate the vertices of the pentagon
    for i in range(5):
        angle = math.radians(90 + i * 72)  # start at top and move around
        x = radius * math.cos(angle)
        y = radius * math.sin(angle)
        points.append((x, y))
    return points

pentagon_points = create_pentagon()
screen.register_shape("pentagon", pentagon_points)

# Create a custom heart shape
# The coordinates below form an approximate heart shape

# Function to generate heart shape points using a parametric equation
def generate_heart_points(scale=1, steps=100):
    points = []
    for i in range(steps):
        # t goes from pi to -pi to trace the heart
        t = math.pi - (2 * math.pi * i / steps)
        x = scale * 16 * (math.sin(t) ** 3)
        y = scale * (13 * math.cos(t) - 5 * math.cos(2*t) - 2 * math.cos(3*t) - math.cos(4*t))
        points.append((x, y))
    return points

# Generate points for the heart shape
heart_pts = generate_heart_points(scale=3, steps=100)
screen.register_shape("heart", heart_pts)

# # Set up the screen
# screen = turtle.Screen()
# screen.title("Custom Turtle Shape")
# screen.bgcolor("lightblue")

# # Register a custom shape (make sure 'start_shape.gif' is in the same directory)
# screen.register_shape("start_shape.gif")

































# Create a turtle
t = turtle.Turtle()
# Change the shape (uncomment one of the following lines to try different shapes)
# t.shape("arrow")
# t.shape("circle")
# t.shape("square")
# t.shape("triangle")
t.shape("turtle")
# t.shape("classic")  # using classic shape as an example
# t.shape("pentagon")
# t.shape("heart")


# t.color("black")
# t.color("green")
t.color("red")
# t.color("blue")
# t.color("lightblue")
# t.color("white")
# t.color("#39FF14")  # neon green
t.speed(10)  # Set turtle speed; 1 is slow, 10 is fast, 0 is instantaneous




































# # Draw a square
# for _ in range(4):
#     t.forward(100)  # Move forward by 100 units
#     t.left(90)      # Turn left by 90 degrees









##### 러시안 엉겅퀴
# https://www.youtube.com/watch?v=P2bDD5rRn_0
size = 56

for round in range(360):
    t.forward(size)
    t.left(120)
    t.forward(size)
    t.left(120)
    t.forward(size)
    t.forward(size)
    t.left(round * 1)
    t.forward(18)
    t.left(120)
    t.forward(size * 3)
    t.left(120)






#### triangle (HW)



#### Ractangle (HW)


#### Pentagon (HW)


























# Wait for the user to close the window
turtle.done()