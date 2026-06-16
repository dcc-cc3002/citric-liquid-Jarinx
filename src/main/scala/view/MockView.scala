package cl.uchile.dcc.citric
package view

import scala.util.Random

class MockView(responses: Iterator[String]) extends Prompt with TView {

  /** Reads the string input from the user
   *
   * @param prompt the message to indicate the user what to write
   * @return the string inserted by the user
   */
  def readStringInput(prompt: String): String = {
    print(prompt)
    val input = if (responses.hasNext) responses.next() else ""

    input
  }

  /** Reads the number input from the user
   *
   * @param prompt the message to indicate the user what to write
   * @param lowerBound the lower bound if permitted numbers
   * @param upperBound the upper bound if permitted numbers
   * @return the number inserted by the user
   */
  def readIntInput1toX(prompt: String, lowerBound: Int, upperBound: Int): Int = {
    print(prompt)
    val input: Int = Random.nextInt(3)
    try {
      if (input >= lowerBound && input <= upperBound) {
        input
      }
      else {
        println(s"Wrong number input. Please enter a number between $lowerBound and $upperBound.\n")
        readIntInput1toX(prompt, lowerBound, upperBound)
      }
    } catch {
      case _: NumberFormatException =>
        println("Invalid input. Please enter a valid integer number.\n")
        readIntInput1toX(prompt, lowerBound, upperBound)
    }

    }


}
