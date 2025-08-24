fun greetings(name: String, age: Int) {
    println("Hello $name, you are $age years old.")
    if (age >= 18) {
        println("You are eligible to apply for a driving license.")
    } else {
        println("You are not eligible to apply for a driving license.")
    }
}

fun main() {
    print("Enter your name: ")
    val name = readLine() ?: ""

    print("Enter your age: ")
    val age = readLine()?.toIntOrNull() ?: 0

    greetings(name, age)
}