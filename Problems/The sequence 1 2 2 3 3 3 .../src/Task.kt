import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val inputValue = scanner.nextInt()

    var counter = 1
    var repeats = 1
    while (counter <= inputValue) {
        repeat(counter) {
            if (repeats <= inputValue) {
                print(counter)
                print(" ")
            }
            repeats++
        }
        counter++
    }
}