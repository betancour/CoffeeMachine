import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val firstOperand = scanner.nextLine()
    val operand = scanner.nextLine()
    val secondOperand = scanner.nextLine()

    when (operand) {
        "equals" -> println(firstOperand.equals(secondOperand))
        "plus" -> println(firstOperand + secondOperand)
        "endsWith" -> println(firstOperand.endsWith(secondOperand))
        else -> println("Unknown operation")
    }
}