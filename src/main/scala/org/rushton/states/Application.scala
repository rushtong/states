package org.rushton.states

object Application extends Utils {

  // Moved outside of main for testing purposes. 
  var firstLetterChoice: String = randomFirstLetter

  def main(args: Array[String]): Unit = {

    Console.println(s"Name a state that begins with $firstLetterChoice")

    val input = scala.io.StdIn.readLine()
    Console.println(s"You entered $input")


    if (!input.toLowerCase.trim.startsWith(firstLetterChoice.toLowerCase.trim)) {
      Console.println(s"Sorry, '$input' does not begin with $firstLetterChoice")
    } else if (!isRealState(input)) {
      Console.println(s"Sorry, '$input' is not a real state")
    } else {
      Console.println(s"Congratulations, you win!")
    }

    // Reset for the next run.
    firstLetterChoice = randomFirstLetter

  }

}
