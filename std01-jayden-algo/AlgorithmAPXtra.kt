/**
INSTRUCTIONS: 
    Kotlin port of algorithmic problems for AP practice. All methods are 
    static via companion object and @JvmStatic,
    so they can be called from Java (e.g., from AlgorithmAPXtraTest.java).


COMPILE & EXECUTE & CLEANUP (Kotlin):

     kotlinc    -d out                                                  AlgorithmAPXtra*.kt
     kotlin             -cp out                                         AlgorithmAPXtra
     rm -rf out/

COMPILE & EXECUTE & CLEANUP (Java x Kotlin):

     kotlinc    -d out                                                  AlgorithmAPXtra*.kt
     java               -cp "./out:$KOTLIN_HOME/lib/kotlin-stdlib.jar"  AlgorithmAPXtra
     rm -rf out/


TIP:
     - On Windows, use ';' as the classpath separator
     - On Mac/Linux, use ':' as the classpath separator
     - java   `-cp` (Mac/Linux) flag must sepcify absolute paths.
     - kotlin `-cp` (Windows) flag accepts relative paths.
 */

class AlgorithmAPXtra {
    companion object {
        /**
         * This is a placeholder for the main method. It can be used to test the methods in this class.
         *
         * @param args Command line arguments (not used).
         */
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello, Kotlin World!")
            println(countYZ("!!day--yaz!!"))    // 2
            println(countYZ("yak zak"))         // 0
            println(countYZ("DAY abc XYZ"))     // 2
        }

        /**
         * Determines if it is possible to reach the desired goal length using a combination of small bricks (1 inch each) and big bricks (5 inches each).
         *
         * @param small Number of small bricks (1 inch each).
         * @param big Number of big bricks (5 inches each).
         * @param goal The target length to achieve.
         * @return `true` if the goal can be reached using the available bricks, `false` otherwise.
         *
         * Example:
         * - `makeBricks(3, 1, 8)` returns `true`
         * - `makeBricks(3, 1, 9)` returns `false`
         * - `makeBricks(3, 2, 10)` returns `true`
         */
        @JvmStatic
        fun makeBricks(small: Int, big: Int, goal: Int): Boolean {
            return false
        }

        /**
         * Counts the number of words ending in 'y' or 'z'.
         * The character must appear at the end of a word (not immediately followed by another letter).
         * Comparison is case-insensitive.
         *
         * @param s The input string.
         * @return The number of words ending in 'y' or 'z'.
         *
         * Example:
         * - `countYZ("fez day")` returns `2`
         * - `countYZ("day fez")` returns `2`
         * - `countYZ("day fyyyz")` returns `2`
         */
        @JvmStatic
        fun countYZ(s: String): Int {
            val lower = s.lowercase()
            var count = 0
            for (i in 0 until lower.length - 1) {
                if ((lower[i] == 'y' || lower[i] == 'z') && !lower[i + 1].isLetter()) {
                    count++
                }
            }
            if (lower.lastOrNull()?.let { it == 'y' || it == 'z' } == true) count++
            return count
        }

        /**
         * Returns the largest span found in the array.
         * The span is the number of elements between the leftmost and rightmost appearances of a value, inclusive.
         * A single occurrence has a span of 1.
         *
         * @param nums The input array of integers.
         * @return The largest span found in the array.
         *
         * Example:
         * - `maxSpan(intArrayOf(1, 2, 1, 1, 3))` returns `4`
         * - `maxSpan(intArrayOf(1, 4, 2, 1, 4, 1, 4))` returns `6`
         * - `maxSpan(intArrayOf(1, 4, 2, 1, 4, 4, 4))` returns `6`
         */
        @JvmStatic
        fun maxSpan(nums: IntArray): Int {
            return 0
        }

        /**
         * Returns `true` if the strings "cat" and "dog" appear the same number of times in the given string.
         * Comparison is case-sensitive and counts non-overlapping occurrences.
         *
         * @param s The input string to examine.
         * @return `true` if "cat" and "dog" occur the same number of times; `false` otherwise.
         *
         * Example:
         * - `catDog("catdog")` returns `true`
         * - `catDog("catcat")` returns `false`
         * - `catDog("1cat1cadodog")` returns `true`
         */
        @JvmStatic
        fun catDog(s: String): Boolean {
            return true
        }

        /**
         * Returns the number of times that the string "code" appears anywhere in the given string,
         * except any letter is allowed for the 'd' position (e.g., "cope" and "cooe" count as well).
         *
         * @param s The input string to search within.
         * @return The count of substrings matching the pattern "co_e".
         *
         * Example:
         * - `countCode("aaacodebbb")` returns `1`
         * - `countCode("codexxcode")` returns `2`
         * - `countCode("cozexxcope")` returns `2`
         */
        @JvmStatic
        fun countCode(s: String): Int {
            return 0
        }

        /**
         * Returns the sum of the numbers in the list, returning 0 for an empty list.
         * The number 13 is unlucky: it does not count toward the sum, and any number immediately following a 13 also does not count.
         *
         * @param nums A list of integers.
         * @return The sum according to the "13" rules described above.
         *
         * Example:
         * - `sum13(intArrayOf(1, 2, 2, 1))` returns `6`
         * - `sum13(intArrayOf(1, 1, 13, 2, 1, 13))` returns `3`
         * - `sum13(intArrayOf(13, 1, 2, 13, 2, 1, 13))` returns `3`
         */
        @JvmStatic
        fun sum13(nums: IntArray): Int {
            return 0
        }

        /**
         * Returns `true` if the list contains a 2 next to a 2 somewhere.
         *
         * @param nums The list of integers to check.
         * @return `true` if there is at least one occurrence of two consecutive 2's, `false` otherwise.
         *
         * Example:
         * - `has22(intArrayOf(1, 2, 2))` returns `true`
         * - `has22(intArrayOf(1, 2, 1, 2))` returns `false`
         * - `has22(intArrayOf(2, 2, 1, 2))` returns `true`
         */
        @JvmStatic
        fun has22(nums: IntArray): Boolean {
            return false
        }

        /**
         * Returns the sum of the values that are not duplicated among the three integers.
         * If one of the values is the same as another, that value does not count toward the sum.
         *
         * @param a First integer.
         * @param b Second integer.
         * @param c Third integer.
         * @return The sum of the values that are not duplicated.
         *
         * Example:
         * - `loneSum(1, 2, 3)` returns `6`
         * - `loneSum(3, 2, 3)` returns `2`
         * - `loneSum(3, 3, 3)` returns `0`
         */
        @JvmStatic
        fun loneSum(a: Int, b: Int, c: Int): Int {
            return 0
        }

        /**
         * Returns a version of the base string where all non-overlapping instances of the remove string have been removed.
         * Removal is not case sensitive, but the remaining characters keep their original case.
         *
         * All whitespace in the string is replaced with a single space.
         *
         * @param base The original string.
         * @param remove The substring to remove (case-insensitive).
         * @return The resulting string after all instances of remove have been removed.
         *
         * Example:
         * - `withoutString("Hello there", "llo")` returns `"He there"`
         * - `withoutString("Hello there", "e")` returns `"Hllo thr"`
         * - `withoutString("abxxxxab", "xx")` returns `"abab"`
         */
        @JvmStatic
        fun withoutString(base: String, remove: String): String {
            return "null"
        }
    }
}
