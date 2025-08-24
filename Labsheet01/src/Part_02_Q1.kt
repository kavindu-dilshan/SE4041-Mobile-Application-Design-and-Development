abstract class Employee(val name: String, val id: Int) {
    abstract fun work()
}

class TemporaryStaff(name: String, id: Int, val hourlyRate: Double) : Employee(name, id) {
    override fun work() {
        println("Employee ID: $id")
        println("$name works in the temporary staff.")
        println("He works on hourly rate: $hourlyRate")
    }
}

class PermanentStaff(name: String, id: Int, val salary: Double) : Employee(name, id) {
    override fun work() {
        println("Employee ID: $id")
        println("$name works in the permanent staff.")
        println("He has a monthly salary: $salary")
    }
}

fun main() {
    val temporary = TemporaryStaff("Ashen", 101, 1000.00)
    val permanent = PermanentStaff("Rushan", 102, 250000.00)

    temporary.work()
    permanent.work()
}