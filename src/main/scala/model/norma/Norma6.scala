package cl.uchile.dcc.citric
package model.norma

import model.gameunits.PlayerCharacter

/** Represents the  final Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 6 with predefined conditions.
 */
class Norma6 extends Normas (_number = 6, _neededStars = 200, _neededWins = 14){
  println("Game Over!")
  override def nextNorma: Norma = this
}
