class Application(private val name: String) {

    fun run(args: Array<String>) {
        println(this.name)
        args.forEach {
            println(it)
        }
    }
}
//
//fun main() {
//    println(Application("name").run(arrayOf("first", "second")))
//}