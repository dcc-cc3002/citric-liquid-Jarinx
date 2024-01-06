package cl.uchile.dcc.citric
package model.norma.concretenormas

import model.norma.{Norma, Normas}

/** Represents the third Norma level with specific conditions that a player must meet to advance.
 *
 * @constructor Create a new Norma level 3 with predefined conditions.
 */
class Norma3 extends Normas (70, 6){
  override var _number: Int = 3
  override def nextNorma: Norma = new Norma4

}
