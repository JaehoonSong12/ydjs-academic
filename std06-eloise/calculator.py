#!/usr/bin/env python3
"""
Usage:
    python calculator.py
"""


from time import sleep
import pygame
import sys
from pathlib import Path


# Initialize Pygame
pygame.init()

# Screen setup
WIDTH, HEIGHT = 860, 640
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Eloise Calculator: Hello World Button")

# Colors
WHITE       = (255, 255, 255)
BLUE        = (0,   120, 215)
LAVENDER   = (0,   90,  180)
BLACK       = (0,   0,   0)
LAVENDER    = pygame.Color('lavender')

# Font
font = pygame.font.Font(Path("./CedarvilleCursive-Regular.ttf"), 30) # Font file path and size





# Button properties
button_text = font.render("la vie est bella", True, BLACK)
# Get the rectangle of the text surface
text_rect = button_text.get_rect()
# Define padding values
padding_x = 20  # Horizontal padding
padding_y = 10  # Vertical padding
# Create the button rectangle, adding padding to the text dimensions
button_rect = pygame.Rect(
    120, 120, 
    text_rect.width + padding_x * 10, 
    text_rect.height + padding_y * 20
)

# Center the text within the button rectangle
text_rect.center = button_rect.center





class Button:
    def __init__(self, x, y, text, color, font=pygame.font.SysFont(None, 30)):
        self.font = font
        self.text = self.font.render(text, True, BLACK)
        self.rect = pygame.Rect(x, y, self.text.get_width() + 20, self.text.get_height() + 20)
        self.color = color

    def draw_on(self, screen):
        # Draw the button rectangle
        pygame.draw.rect(screen, self.color, self.rect) # Grey button

        # Render and blit the text
        screen.blit(self.text, self.text.get_rect(center=self.rect.center))

    def set_action(self, action):
        self.action = action

    def handle_event(self, event):
        print(pygame.mouse.get_pos())
        # print(event.pos)
        is_hover = self.rect.collidepoint(pygame.mouse.get_pos())
        if is_hover:
            self.color = LAVENDER
        else:
            self.color = BLUE
        if is_hover and event.buttons == (1, 0, 0):  # Check if the left mouse button is pressed
            self.action()

def hello_world_action():
    print("Hello World!")



# Create the button once
button = Button(600, 300, "la vie est bella!", BLUE, font=font)

# Main loop
while True:
    screen.fill(WHITE)



    
    mouse_pos = pygame.mouse.get_pos()
    
    
    button.draw_on(screen)




    # Button hover effect
    if button_rect.collidepoint(mouse_pos):
        pygame.draw.rect(screen, LAVENDER, button_rect)
    else:
        pygame.draw.rect(screen, BLUE, button_rect)

    # Draw text
    text_rect = button_text.get_rect(center=button_rect.center)
    screen.blit(button_text, text_rect)

    # Event handling
    for event in pygame.event.get():
        print(pygame.event.get())
        sleep(1)



        button.handle_event(event)
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.MOUSEBUTTONDOWN and event.button == 1:
            if button_rect.collidepoint(event.pos):
                print("Hello World!")

    pygame.display.update()
