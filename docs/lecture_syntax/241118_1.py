hours_worked = input("How many hours did you work? \n") # <- for prompting users 
hourly_pay_rate = input("What is your hourly pay rate? \n") # <- for prompting users 
# input function is an abstraction of 
# 1. monitor (output system) just like print function 
# 2. keyboard (input system) for input values
# 3. wait for your `enter` to get the right input.
# 4. get (return) the str (string) value from keyboard


# Data types (primitive)
# 1. char -> sentences (string, str)
# 2. int (integer) <- 4 bytes
# 3. double (real) <- 8 bytes

# operation
gross_pay = float(hours_worked) * float(hourly_pay_rate)
# 124 <- 8 bytes as a number
# 124 <- 3 bytes as a English sentence


print("This is your calculated gross pay: ", gross_pay) # <-- inputting actual #
print("This is your calculated gross pay: " + str(gross_pay)) # <--- converting a # to string so you can concatenate (extend) English sentence.
# print function is an abstraction of either
# 1. a set of data to display
# 2. a single string (concatenated) to display







### escape char: \n - newline, \t - tap




"""
Question by Jaehoon

<Question> 
You have a data, 3524000, understanding it as string vs integer, 
what is the difference? Also, tell me how to change int -> string 
and string -> int

<Answer>
The data as a char would have 1 byte for each letter (so 7 letters, 7 bytes), 
while the data as an integer would have 4 bytes.
You can change the data from an integer to a string by using the str() function.
Usage for int to str. str(3524000)
Usage for str to int. int("3524000"), this will change str to int
"""




