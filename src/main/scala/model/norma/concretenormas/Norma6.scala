package cl.uchile.dcc.citric
package model.norma.concretenormas

import model.norma.{Norma, Normas}

/** Represents the  final Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 6 with predefined conditions.
 */
class Norma6 extends Normas(200, 14){
  override var _number: Int = 6
  override def nextNorma: Norma = this

}
