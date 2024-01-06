package cl.uchile.dcc.citric
package model.norma.concretenormas

import model.norma.{Norma, Normas}

/** Represents the fifth Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 5 with predefined conditions.
 */
class Norma5 extends Normas (200, 14){
  override var _number: Int = 5
  override def nextNorma: Norma = new Norma6

}
