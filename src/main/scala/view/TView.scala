package cl.uchile.dcc.citric
package view

trait TView extends Prompt {
  def readStringInput(prompt: String): String
  def readIntInput1toX(prompt: String, lowerBound: Int, upperBound: Int): Int

}
