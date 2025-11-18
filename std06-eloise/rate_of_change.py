import numpy as np
import matplotlib.pyplot as plt







def plot_linear_function(m: float, b: float):
    """
    Generates data points and plots a linear function in the form y = mx + b.

    Args:
        m (float): The slope of the line, denoted as 'k' as well.
        b (float): The y-intercept of the line.
    """
    print(f"\n--- Graphing: y = {m}x + {b} ---")

    range_min=-20
    range_max=20

    # 1. Generate x-values
    # Create 100 equally spaced points from -10 to 10 for the x-axis
    x = np.linspace(range_min, range_max, 50)

    # 2. Calculate y-values (y = mx + b)
    y = m * x + b

    # 3. Setup the plot figure and axes
    plt.figure(figsize=(8, 6)) # Set the size of the plot
    plt.plot(x, y, label=f'y = {m}x + {b}', color='darkcyan', linewidth=2.5)

    # 4. Add grid, axes, labels, and title
    plt.title('Linear Function Grapher', fontsize=16, fontweight='bold')
    plt.xlabel('X-axis', fontsize=12)
    plt.ylabel('Y-axis', fontsize=12)

    # Set the x and y limits for better visualization
    plt.xlim(range_min, range_max)
    plt.ylim(range_min, range_max)

    # Draw the axes (lines for x=0 and y=0)
    plt.axhline(0, color='gray', linestyle='--', linewidth=0.8)
    plt.axvline(0, color='gray', linestyle='--', linewidth=0.8)

    # Add a grid for readability
    plt.grid(True, linestyle=':', alpha=0.6)

    # Add a legend to show the function equation
    plt.legend(loc='upper left')

    # add points for each integer with coordinates
    for xi in range(range_min, range_max + 1):
        yi = m * xi + b

        if yi < range_min or yi > range_max:
            continue

        # graphing
        plt.plot(xi, yi, 'ro')  # 'ro' means red color, round points
        plt.text(xi, yi, f'({xi:.1f},{yi:.1f})', fontsize=9, ha='right', va='bottom')

    # 5. Display the plot
    plt.show()
















def get_user_input():
    """
    Prompts the user to enter the slope (m) and y-intercept (b).

    Returns:
        tuple: A tuple containing (m, b) as floats.
    """
    while True:
        try:
            m_str = input("Enter the slope (m): ")
            m = float(m_str)

            b_str = input("Enter the y-intercept (b): ")
            b = float(b_str)

            return m, b
        except ValueError:
            print("Invalid input. Please enter valid numbers for both slope and intercept.")
        except Exception as e:
            print(f"An unexpected error occurred: {e}")





if __name__ == "__main__":
    

    # Main loop to allow multiple graphs
    while True:
        m, b = get_user_input()
        plot_linear_function(m, b)

        # Ask if the user wants to continue
        answer = input("\nDo you want to quit? (yes/no): ").strip().lower()
        if answer.startswith('y'):
            print("Exiting the grapher. Goodbye!")
            break


