package cl.uchile.dcc.citric
package model.norma.concretenormas

import model.norma.{Norma, Normas}


/** Represents the second Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 2 with predefined conditions.
 */
class Norma2 extends Normas (30, 3){
  override var _number: Int = 2
  override def nextNorma: Norma = new Norma3

}
