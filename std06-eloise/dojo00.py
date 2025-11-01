#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Instructions to run the tests via the CLI:
    1. Open your terminal or command prompt.
    2. Run the tests by executing: `python std06-eloise/dojo00.py`

This is a list of quiz questions for practice, including:
1.  sleepIn: Determine if we sleep in based on weekday and vacation status.
"""
# Import the unittest module, needed for creating test cases.
# We only need to import it once at the top of the file.
import unittest

# Import List from the typing module for type hinting (e.g., List[str])
# This is preferred for compatibility with Python versions < 3.10
from typing import List


















# -----------------------------------------------------------------
# Question 1: sleepIn
# -----------------------------------------------------------------
def sleepIn(weekday: bool, vacation: bool) -> bool:
    """
    Description:
        The parameter weekday is True if it is a weekday, and the parameter 
        vacation is True if we are on vacation. We sleep in if it is not a 
        weekday or we're on vacation. Return True if we sleep in.

    Examples:
        sleepIn(True, True) -> True
        sleepIn(True, False) -> False
        sleepIn(False, True) -> True
        sleepIn(False, False) -> True

    Args:
        weekday (bool): True if it is a weekday, False otherwise.
        vacation (bool): True if we are on vacation, False otherwise.

    Returns:
        bool: True if we sleep in (not a weekday or on vacation), False otherwise.
    """
    ### [Your Implementation Here]

    # Case-1. If the question can be solved with 'iteration (for/while)', 
    # design the most efficient algorithm.
    
    # Case-2. If the question can be solved with 'recursion', design a 
    # correct algorithm. Since the recursion can be inefficient, use 
    # either 'tabulation' or 'memorization' to break it down into 'iteration'.
    return False


























# -----------------------------------------------------------------
# Unit Tests
# -----------------------------------------------------------------
class TestSleepIn(unittest.TestCase):
    def test_sleepIn(self):
        self.assertTrue(sleepIn(True, True))       # -> True
        self.assertFalse(sleepIn(True, False))    # -> False
        self.assertTrue(sleepIn(False, True))     # -> True
        self.assertTrue(sleepIn(False, False))    # -> True


# -----------------------------------------------------------------
# Main execution block
# -----------------------------------------------------------------

if __name__ == "__main__":
    """
    This conditional block checks if the script is being run directly.
    If it is, it calls `unittest.main()`.
    
    `unittest.main()` discovers all test cases (TestWordsFront
    and TestWordsWithoutList) and runs them.
    
    `verbosity=2` is added to provide a more detailed output,
    showing the result of each test method individually, which
    satisfies the requirement for clear results for each function.
    """
    unittest.main(verbosity=2)











