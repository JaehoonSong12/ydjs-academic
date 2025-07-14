/**
 * AlgorithmAPXtra.kt
 * 
 * Kotlin port of algorithmic problems for AP practice. All methods are 
 * static via companion object and @JvmStatic,
 * so they can be called from Java (e.g., from AlgorithmAPXtraTest.java).
 *
 * ---
 * How to compile and run (from inside the std01-jayden-algo directory):
 *
 * 1. Compile:
 *  ```
 *      kotlinc AlgorithmAPXtra.kt -d .
 *  ```
 *
 * 2. Run (ensure kotlin-stdlib is on the classpath):
 *  ```
 *      java -cp ".:$KOTLIN_HOME/lib/kotlin-stdlib.jar" AlgorithmAPXtra
 *  ```
 *
 * 3. Clean:
 *  ```
 *      rm -rf AlgorithmAPXtra*.class META-INF/
 *  ```
 *
 * ---
 * To use from Java (e.g., in AlgorithmAPXtraTest.java):
 *   AlgorithmAPXtra.Companion.methodName(...)
 *   // or, if static import is used, just AlgorithmAPXtra.methodName(...)
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
            var remaining = goal
            repeat(big) {
                if (remaining >= 5) remaining -= 5
            }
            return small >= remaining
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
            var max = 0
            nums.forEachIndexed { i, value ->
                for (j in nums.indices.reversed()) {
                    if (nums[j] == value) {
                        val span = j - i + 1
                        if (span > max) max = span
                        break
                    }
                }
            }
            return max
        }

        @JvmStatic
        fun catDog(s: String): Boolean {
            return Regex("cat").findAll(s).count() == Regex("dog").findAll(s).count()
        }

        @JvmStatic
        fun countCode(s: String): Int {
            var count = 0
            for (i in 0..s.length - 4) {
                if (s.substring(i, i + 2) == "co" && s[i + 3] == 'e') count++
            }
            return count
        }

        @JvmStatic
        fun sum13(nums: IntArray): Int {
            var total = 0
            var skip = false
            for (n in nums) {
                when {
                    skip -> skip = false
                    n == 13 -> skip = true
                    else -> total += n
                }
            }
            return total
        }

        @JvmStatic
        fun has22(nums: IntArray): Boolean {
            for (i in 0 until nums.size - 1) {
                if (nums[i] == 2 && nums[i + 1] == 2) return true
            }
            return false
        }

        @JvmStatic
        fun loneSum(a: Int, b: Int, c: Int): Int {
            return listOf(a, b, c)
                .groupingBy { it }.eachCount()
                .filter { it.value == 1 }
                .keys.sum()
        }

        @JvmStatic
        fun withoutString(base: String, remove: String): String {
            return base.replace(Regex(remove, RegexOption.IGNORE_CASE), "").split(Regex("\\s+"))
                .joinToString(" ")
        }
    }
}
