package cl.uchile.dcc.citric
package model.norma

import model.gameunits.PlayerCharacter

/** Represents the fourth Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 4 with predefined conditions.
 */
class Norma4 extends Normas (_number = 4, _neededStars = 70, _neededWins = 6){
  override def nextNorma: Norma = new Norma5()
}
