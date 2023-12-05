package cl.uchile.dcc.citric
package model.norma


/** Represents the second Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 2 with predefined conditions.
 */
class Norma2 extends Normas (_number = 2, _neededStars = 10, _neededWins = 1){
  override def nextNorma: Norma = new Norma3()
}
