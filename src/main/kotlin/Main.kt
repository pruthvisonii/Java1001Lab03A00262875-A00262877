// Importing the necessary packages
import kotlin.random.Random

// A Die class with different constructors and methods to simulate a dice
class Die {
    var type: String // Type of die
    var sides: Int // Number of sides
    var currentSide: Int = 0 // Current side up
    // A 0 argument constructor
    constructor() {
        type = "d6"
        sides = 6
        roll()
    }

    // A 1 argument constructor
    constructor(sides: Int) {
        type = "d$sides"
        this.sides = sides
        roll()
    }

    // A 2 argument constructor
    constructor(type: String, sides: Int) {
        this.type = type
        this.sides = sides
        roll()
    }

    // A roll method to generate a random value
    fun roll() {
        currentSide = Random.nextInt(1, sides + 1)
    }

    // A method to show the current side of the die
    fun show() {
        println("$type: $currentSide")
    }
}

// A DiceGame class to test the Die class
class DiceGame {
    fun run() {
// Create different sized dice using each constructor
        val die1 = Die()
        val die2 = Die(10)
        val die3 = Die("d20", 20)


        // Display the initial value of the dice
        println("Before setting highest value:")
        die1.show()
        die2.show()
        die3.show()

        // Choose one Die object and set it to show it's highest value
        die1.currentSide = die1.sides
        die2.currentSide = die2.sides
        die3.currentSide = die3.sides

        // Display the value of the dice after setting the highest value
        println("After setting highest value:")
        die1.show()
        die2.show()
        die3.show()

        // Create 5 six-sided dice and roll them in a loop until you get 5 of a kind
        var count = 0
        val dice = Array(5) { Die() }
        var rolls = 0

        while (count < 5) {
            rolls++
            for (i in 0 until 5) {
                dice[i].roll()
            }
            val sides = dice.map { it.currentSide }.distinct()
            count = sides.size
        }

        // Display the number of rolls it took to get 5 of a kind
        println("Number of rolls to get 5 of a kind: $rolls")
    }
}

// The main function to run the DiceGame class
fun main() {
    val game = DiceGame()
    game.run()
}



