package cl.uchile.dcc.citric
package model.norma

import model.gameunits.PlayerCharacter

/** Represents the fifth Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 5 with predefined conditions.
 */
class Norma5 extends Normas (200, 14){
  override var _number: Int = 5
  override def nextNorma: Norma = new Norma6

}
