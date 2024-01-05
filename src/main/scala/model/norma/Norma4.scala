package cl.uchile.dcc.citric
package model.norma

import model.gameunits.PlayerCharacter

/** Represents the fourth Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 4 with predefined conditions.
 */
class Norma4 extends Normas (120, 10){
  override var _number: Int = 4
  override def nextNorma: Norma = new Norma5

}
