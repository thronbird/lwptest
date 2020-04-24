package com.liwanping.kotlin.lambda

fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun main(args: Array<String>) {
    val items = listOf(1, 2, 3, 4, 5)
// Lambdas are code blocks enclosed in curly braces.
    items.fold(0, {
        // When a lambda has parameters, they go first, followed by '->'
        acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    })

// Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

// Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)

    val animals = listOf("raccoon", "reindeer", "cow", "camel", "giraffe", "goat")

// grouping by first char and collect only max of contains vowels
    val compareByVowelCount = compareBy { s: String -> s.count { it in "aeiou" } }

    val maxVowels = animals.groupingBy { it.first() }.reduce { _, a, b -> maxOf(a, b, compareByVowelCount) }

    println(maxVowels) // {r=reindeer, c=camel, g=giraffe}

}

