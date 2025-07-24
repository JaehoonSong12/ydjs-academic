"""
Georgia Institute of Technology - CS1301
HW01 - Functions and Expressions
"""


"""
Function Name: dominosTime()
Parameters: N/A
Returns: None
"""
def dominosTime():
    return

#########################################

#  <-- is called "docstring"
"""
Function Name: tipAndSplit()
Parameters: N/A
Returns: None
"""
def tipAndSplit():
    """
    This function calculates the tip for a food delivery and splits the total cost (including the tip) among friends.

    Steps:
    1. Ask the user for the order total (positive integer).
    2. Ask the user for the tip percentage they want to give the driver (positive integer).
    3. Ask the user for the number of friends splitting the total (positive integer).
    4. Calculate the tip using the formula:
       Tip = (Order Total × Tip Percentage) / 100.
    5. Calculate the total cost by adding the tip to the order total.
    6. Divide the total cost by the number of friends to get the amount each friend must pay.
    7. Round the tip and each friend's share to 2 decimal places.
    8. Print the tip and the amount each friend must pay.

    Assumptions:
    - All inputs are positive integers.
    - Outputs are rounded to 2 decimal places for clarity.
    """
    return

################# < Sample Run >

# >>> tipAndSplit()
# What was the order total? 150
# What percentage would you like to tip? 20
# How many people are splitting the order? 3
# The driver got a tip of $\$ 30.0$. Each person paid $\$ 60.0$.

# >>> tipAndSplit()
# What was the order total? 25
# What percentage would you like to tip? 18
# How many people are splitting the order? 1
# The driver got a tip of $\$ 4.5$. Each person paid $\$ 29.5$.


#########################################

"""
Function Name: youtuber()
Parameters: N/A
Returns: None
"""
def youtuber():
    """
    This function calculates your total earnings from YouTube based on:
      - The number of videos you have made.
      - The number of views each video has (assumed to be the same for all videos).
      - The payment you receive per view.

    Steps:
    1. Ask the user for the number of videos created.
    2. Ask the user for the number of views per video.
    3. Ask the user for the payment received per view.
    4. Calculate total earnings using the formula:
       Total Earnings = Number of Videos × Views per Video × Payment per View.
    5. Round the result to 2 decimal places.
    6. Print the total earnings.

    Assumptions:
    - All inputs are positive numbers.
    - Outputs are rounded to 2 decimal places for clarity.
    """
    return

################# < Sample Run >

# >>> youtuber()
# How many videos have you made? 4
# How much do you get paid per view? 0.01
# How many views do your videos have? 100000
# You have made $ 4000.0 by making YouTube videos!

# >>> youtuber()
# How many videos have you made? 22
# How much do you get paid per view? 0.01
# How many views do your videos have? 1500000
# You have made $ 330000.0 by making YouTube videos!

#########################################

"""
Function Name: bathBomb()
Parameters: N/A
Returns: None
"""
def bathBomb():
    """
    This function calculates the volume of a spherical bath bomb based on the radius provided by the user.

    Steps:
    1. Ask the user for the radius of the bath bomb (can be a float).
    2. Use the formula for the volume of a sphere:
       Volume = (4/3) × π × (radius^3).
    3. Round the calculated volume to 2 decimal places.
    4. Print the volume.

    Assumptions:
    - The input radius is a positive number.
    - Outputs are rounded to 2 decimal places for clarity.
    """
    return

################# < Sample Run >

# >> bathBomb()
# What is the radius of the bath bomb? 3
# The volume of a bath bomb with radius 3.0 is 113.04.

# >>> bathBomb()
# What is the radius of the bath bomb? 7
# The volume of a bath bomb with radius 7.0 is 1436.03.