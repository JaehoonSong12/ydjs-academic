from tkinter import *

def on_click():
    label.config(text="Button Clicked!")

# Create the main window
root = Tk()
root.title("Tkinter Sample")
root.geometry("300x400")

# Create a label
label = Label(root, text="Hello, Tkinter!", font=("Arial", 14))
label.pack(pady=20)

# Create a button
button = Button(root, text="Click Me", command=on_click)
button.pack()

# Run the application
root.mainloop()













# import tkinter as tk
# import random

# words = [
#     'function', 'variable', 'python', 'snake', 'codehs', 'karel', 'dog',
#     'turtle', 'tracy'
# ]
# word = random.choice(words)

# root = tk.Tk()
# root.geometry('300x300')
# frame = tk.Frame(root)
# frame.pack()

# instruction_label = tk.Label(root, bg='white', text="Type the word below!")
# instruction_label.pack()

# word_label_stringvar = tk.StringVar()
# word_label_stringvar.set(word)
# word_label = tk.Label(root, bg='white', textvariable=word_label_stringvar)
# word_label.pack()


# sv = tk.StringVar()
# sv.trace("w", lambda name, index, mode, sv=sv: input_changed(sv))
# e = tk.Entry(root, textvariable=sv)
# e.pack()

# def input_changed(sv):
#     global word
#     entry_input = sv.get()
#     if entry_input == word:
#         word = random.choice(words)
#         word_label_stringvar.set(word)
#         sv.set('')

# root.mainloop()