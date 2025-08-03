interface Shape {
    fun setup()
    fun draw()
}

class Circle : Shape {
    override fun setup() {
        println("Setting up a Circle")
    }

    override fun draw() {
        println("Drawing a Circle")
    }
}

class Rectangle : Shape {
    override fun setup() {
        println("Setting up a Rectangle")
    }

    override fun draw() {
        println("Drawing a Rectangle")
    }
}

fun main() {
    val circle = Circle()
    circle.setup()
    circle.draw()

    val rectangle = Rectangle()
    rectangle.setup()
    rectangle.draw()
}