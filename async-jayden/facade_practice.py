# Open file in write mode
f = open("sample.txt", "w")
f.write("This is the first line.\n")
f.write("This is the second line.\n")
# Manually close the file
f.close()



# Open file in read mode
f = open("sample.txt", "r")
try:
    content = f.read()
    print("File content:")
    print(content)
finally:
    # close the file
    f.close()
