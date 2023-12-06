package cl.uchile.dcc.citric
package model.norma

import model.gameunits.PlayerCharacter

/** Represents the fifth Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 5 with predefined conditions.
 */
class Norma5 extends Normas (_number = 5, _neededStars = 120, _neededWins = 10){
  override def nextNorma: Norma = new Norma6()
}
