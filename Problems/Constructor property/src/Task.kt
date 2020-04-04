fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    timer.time = timerValue
    println(timer.time)
}

class ByteTimer(time: Int) {
    var time: Int = time
        get() = field
        set(value) {
            field = when {
                value < -128 -> -128
                value > 127 -> 127
                else -> value
            }
        }
}