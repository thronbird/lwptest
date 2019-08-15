import org.apache.coyote.http11.Constants.a

fun main(args: Array<String>) {
    val onClick: () -> Unit = { print("dss") }
    test1(onClick)
    val intf: (Int) -> ((Int) -> Unit) = { { print(it) } }
    val intf2: (Int) -> (Int) -> Unit = { { print(it) } }
    intf.invoke(8).invoke(9)
    print(intf.equals(intf2))

    // Function vs FuntionType
    val sum = { x: Int, y: Int -> x + y }
    val sum2: (Int, Int) -> Int = { x, y -> x + y }

    //FuntionType->lamnbda instance
    val fun4 = { a: Int, b: Int -> a + b }

    print(fun4.invoke(5, 7))
    print(fun4(5, 7))

    //invoke a function
    val stringPlus: (String, String) -> String = String::plus
    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    //invoke a function as if the value were an extension function
    val intPlus: Int.(Int) -> Int = Int::plus
    println(2.intPlus(3)) // extension-like call

    //An anonymous function looks very much like a regular function declaration, except that its name is omitted. Its body can be either an expression (as shown above) or a block:
    listOf(1, 2).filter(fun(item) = item > 0)
}

fun test1(x: () -> Unit) {
    x()
    x.invoke()
}

