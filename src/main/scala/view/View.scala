package cl.uchile.dcc.citric
package view

import scala.reflect.runtime.universe.Try
import scala.util.{Failure, Success}
import scala.util.Try

/** The View collects data from the user and displays it.
 * In this project's case, the view represents the simple console interface
 */
class View extends Prompt with TView {

  /** Reads the string input from the user
   *
   * @param prompt the message to indicate the user what to write
   * @return the string inserted by the user
   */
  def readStringInput(prompt: String): String = {
    print(prompt)
    val input = scala.io.StdIn.readLine()

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
    val input = scala.io.StdIn.readLine()

    if (input.isEmpty) {
      println("You didn't enter anything, please retry.\n")
      readIntInput1toX(prompt, lowerBound, upperBound)
    } else {
      try {
        val intInput = input.toInt
        if (intInput >= lowerBound && intInput <= upperBound) {
          intInput
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

}
