package cl.uchile.dcc.citric
package model.norma

import model.gameunits.PlayerCharacter

/** Represents the third Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 3 with predefined conditions.
 */
class Norma3 extends Normas (_number = 3, _neededStars = 30, _neededWins = 3){
  override def nextNorma: Norma = new Norma4()
}
