import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val sumString = scanner.nextLine()
    println(sumString.map { c -> c.toString().toInt() }.sum())

    var a = 10
    when (a) {
        in 1..22 -> print("Ok")
        11, 12 -> print("Ok")
        a + a -> print("Ok")
        in 1..20 -> print("Ok")
    }
}