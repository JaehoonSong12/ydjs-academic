def binary_to_decimal(binary_number):
    result = 0
    binary_number = binary_number[::-1]
    base = 1
    for digit in binary_number:
        binary_digit = ord(digit) - 48
        
        print(f"{binary_digit}: {base}")
        result += binary_digit * base
        
        base *= 2 
    return str(result)





def decimal_to_binary(decimal_number):
    
    return "Not done yet!"










bin_num = "1011010111"
deci_num = binary_to_decimal(bin_num)









print(f"binary number: {bin_num}, in decimal: {deci_num}")
print(f"")


# sweet ,orangy,sour,fantish,fizzy,and

# sean = "sean is silly"  # string, collecion of pixel letters
# print(sean)

# for letter in sean:     # repetition structure (coding, for loop)
#     print(letter)