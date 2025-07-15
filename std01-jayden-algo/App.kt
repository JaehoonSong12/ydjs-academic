/**
INSTRUCTIONS: 
    Running two different main methods (AppKt.main / ClassShell.main) in Kotlin
    The 'Kt' suffix is only for `top-level functions`, not for `class-based main methods`.



COMPILE & EXECUTE & CLEANUP (Kotlin #1 - top-level main function):

     kotlinc    -d out              App*.kt 
     kotlin             -cp out     AppKt
     rm -rf out/

COMPILE & EXECUTE & CLEANUP (Kotlin #2 - class-based main method):

     kotlinc    -d out              App*.kt
     kotlin             -cp out     ClassShell
     rm -rf out/




     

     
 */

fun main(args: Array<String>) {
    println("Hello from top-level main! (AppKt)")
    if (args.isNotEmpty()) {
    println("Arguments passed: ${args.joinToString(", ")}")
    } else {
    println("No arguments passed.")
    }
}

class ClassShell {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) { 
            println("Hello from ClassShell (any name can be done), Kotlin!")
        }
    }
}