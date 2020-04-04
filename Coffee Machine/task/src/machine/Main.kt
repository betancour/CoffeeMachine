package machine

import java.util.*
import kotlin.system.exitProcess

var money = 550
var water = 400
var milk = 540
var coffee = 120
var cups = 9

val coffeeMachine = CoffeeMachine(MachineState.READY)

fun main() {
    val scanner = Scanner(System.`in`)

    printPrompt()
    while (true) {
        coffeeMachine.handleEvent(scanner.nextLine())
    }
}

private fun printPrompt() {
    println("Write action (buy, fill, take, remaining, exit):")
}

class CoffeeMachine(machineState: MachineState) {
    var machineState: MachineState = machineState

    fun handleEvent(inputCommand: String) {
        if ("buy" == inputCommand && coffeeMachine.machineState == MachineState.READY) {
            handleBuy()
        } else if (coffeeMachine.machineState == MachineState.BUY_COFFEE) {
            when (inputCommand) {
                "1" -> {
                    buyCoffee(250, 16, 4, 0)
                }
                "2" -> {
                    buyCoffee(350, 20, 7, 75)
                }
                "3" -> {
                    buyCoffee(200, 12, 6, 100)
                }
                "back" -> {
                    printPrompt()
                    coffeeMachine.machineState = MachineState.READY
                    return
                }
                else -> {
                    println("not a valid option")
                    handleBuy()
                }
            }
        } else if (inputCommand == "exit") {
            exitProcess(0)
        } else if (inputCommand == "fill" && coffeeMachine.machineState == MachineState.READY) {
            handleFill();
        } else if (coffeeMachine.machineState == MachineState.WAITING_FOR_WATER) {
            water += inputCommand.toInt()
            println("Write how many ml of milk do you want to add:")
            coffeeMachine.machineState = MachineState.WAITING_FOR_MILK
        } else if (coffeeMachine.machineState == MachineState.WAITING_FOR_MILK) {
            milk += inputCommand.toInt()
            println("Write how many grams of coffee beans do you want to add:")
            coffeeMachine.machineState = MachineState.WAITING_FOR_COFFEE
        } else if (coffeeMachine.machineState == MachineState.WAITING_FOR_COFFEE) {
            coffee += inputCommand.toInt()
            println("Write how many disposable cups of coffee do you want to add:")
            coffeeMachine.machineState = MachineState.WAITING_FOR_CUPS
        } else if (coffeeMachine.machineState == MachineState.WAITING_FOR_CUPS) {
            cups += inputCommand.toInt()
            coffeeMachine.machineState = MachineState.READY
            printPrompt()
        } else if ("remaining" == inputCommand) {
            printState()
            printPrompt()
        } else if ("take" == inputCommand) {
            handleTake()
            printPrompt()
        }
    }
}

private fun handleFill() {
    println("Write how many ml of water do you want to add:")
    coffeeMachine.machineState = MachineState.WAITING_FOR_WATER
}

private fun handleBuy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    coffeeMachine.machineState = MachineState.BUY_COFFEE
}

fun buyCoffee(waterF: Int, coffeeF: Int, priceF: Int, milkF: Int) {
    val errorMessage = "Sorry, not enough %s!"
    when {
        waterF > water -> {
            println(String.format(errorMessage, "water"))
        }
        coffeeF > coffee -> {
            println(String.format(errorMessage, "coffee"))
        }
        milkF > milk -> {
            println(String.format(errorMessage, "milk"))
        }
        else -> {
            println("I have enough resources, making you a coffee!")
            water -= waterF
            coffee -= coffeeF
            money += priceF
            milk -= milkF
            cups--
        }
    }
    coffeeMachine.machineState = MachineState.READY
    printPrompt()
}

fun printState() {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$coffee of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
    println("")
}

fun handleTake() {
    val moneyToGive = money
    money = 0
    println("I gave you $moneyToGive")
    coffeeMachine.machineState = MachineState.READY
}

enum class MachineState {
    READY,
    SERVE_COFFEE,
    EXIT,
    FILL,
    TAKE,
    WAITING_FOR_WATER,
    WAITING_FOR_MILK,
    WAITING_FOR_COFFEE,
    WAITING_FOR_CUPS,
    BUY_COFFEE,
    STATE
}
