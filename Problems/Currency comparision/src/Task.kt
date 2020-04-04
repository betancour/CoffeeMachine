import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val countries = input.nextLine()
    val firstCountry = countries.split(" ")[0]
    val secondCountry = countries.split(" ")[1]
    if (isValidCountry(firstCountry) && isValidCountry(secondCountry)) {
        val firstCurrency = Currency.valueOf(firstCountry.toUpperCase())
        val secondCurrency = Currency.valueOf(secondCountry.toUpperCase())
        println(firstCurrency.currency == secondCurrency.currency)
    } else {
        println(false)
    }

}

enum class Currency(val countryName: String, val currency: String) {
    GERMANY("Germany", "Euro"),
    MALI("Mali", "CFA franc"),
    DOMINICA("Dominica", "Eastern Caribbean dollar"),
    CANADA("Canada", "Canadian dollar"),
    SPAIN("Spain", "Euro"),
    AUSTRALIA("Australia", "Australian dollar"),
    BRAZIL("Brazil", "Brazilian real"),
    SENEGAL("Senegal", "CFA franc"),
    FRANCE("France", "Euro"),
    GRENADA("Grenada", "Eastern Caribbean dollar"),
    KIRIBATI("Kiribati", "Australian dollar")
}

fun isValidCountry(name: String): Boolean {
    return Currency.values().any { it.countryName == name }
}