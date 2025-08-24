fun whoAmI(value: Any): String {
    return value::class.simpleName ?: "Unknown"
}

fun main() {
    println("Type: " + whoAmI(10))
    println("Type: " + whoAmI(10.5))
    println("Type: " + whoAmI("Hello"))
    println("Type: " + whoAmI(true))
}