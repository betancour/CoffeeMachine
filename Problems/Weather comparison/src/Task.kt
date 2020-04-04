class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value < -92 || value > 57) {
                when (name) {
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    "Dubai" -> 30
                    else -> 0
                }
            } else value
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    print(if (firstCity.degrees == secondCity.degrees && secondCity.degrees == thirdCity.degrees) {
        "neither"
    } else {
        when (minOf(firstCity.degrees, secondCity.degrees, thirdCity.degrees)) {
            firstCity.degrees -> firstCity.name
            secondCity.degrees -> secondCity.name
            else -> thirdCity.name
        }
    })
}