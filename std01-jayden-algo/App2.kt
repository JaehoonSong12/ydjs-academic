/**
INSTRUCTIONS: 
    Running two different main methods (App2Kt.main / ClassShell.main) in Kotlin
    The 'Kt' suffix is only for `top-level functions`, not for `class-based main methods`.



COMPILE & EXECUTE & CLEANUP (Kotlin #1 - top-level main function):

     kotlinc    -d out              App2*.kt 
     kotlin             -cp out     App2Kt
     rm -rf out/

COMPILE & EXECUTE & CLEANUP (Kotlin #2 - class-based main method):

     kotlinc    -d out              App2*.kt
     kotlin             -cp out     ClassShell
     rm -rf out/




     

     
 */

import java.util.function.BiConsumer



// (a) declare your own consumer interface
interface EntryPrinter<K, V> {
    fun printEntry(key: K, value: V)
}

fun main(args: Array<String>) {
    println("Hello from top-level main! (App2Kt)")
    if (args.isNotEmpty()) {
    println("Arguments passed: ${args.joinToString(", ")}")
    } else {
    println("No arguments passed.")
    }


    // val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")

    map.put(4,"Dog")

    
    // (b) implement it
    val printer: EntryPrinter<Int,String> = object : EntryPrinter<Int, String> {
        override fun printEntry(key: Int, value: String) {
            println("$key -> $value")
        }
    }
    
    // (c) use a simple for-loop to invoke your interface
    for ((k, v) in map) {
        printer.printEntry(k, v)
    }


    map.forEach { key: Int, value: String -> println("$key -> $value") }
    

    

    
    // 1) define an object implementing BiConsumer<Int, String>
    val printer2 = object : BiConsumer<Int, String> {
        override fun accept(key: Int, value: String) {
            println("$key -> $value")
        }
    }

    // 2) hand it to forEach
    map.forEach(printer2)
}
