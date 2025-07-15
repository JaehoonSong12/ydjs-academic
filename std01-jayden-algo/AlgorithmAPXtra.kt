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
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello, Kotlin World!")
            println(countYZ("!!day--yaz!!"))    // 2
            println(countYZ("yak zak"))         // 0
            println(countYZ("DAY abc XYZ"))     // 2
        }

        @JvmStatic
        fun makeBricks(small: Int, big: Int, goal: Int): Boolean {
            return false
        }

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

        @JvmStatic
        fun maxSpan(nums: IntArray): Int {
            return 0
        }

        @JvmStatic
        fun catDog(s: String): Boolean {
            return true
        }

        @JvmStatic
        fun countCode(s: String): Int {
            return 0
        }

        @JvmStatic
        fun sum13(nums: IntArray): Int {
            return 0
        }

        @JvmStatic
        fun has22(nums: IntArray): Boolean {
            return false
        }

        @JvmStatic
        fun loneSum(a: Int, b: Int, c: Int): Int {
            return 0
        }

        @JvmStatic
        fun withoutString(base: String, remove: String): String {
            return "null"
        }
    }
}
