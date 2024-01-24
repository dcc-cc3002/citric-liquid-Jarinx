package cl.uchile.dcc.citric
package model.norma.concretenormas

import model.norma.{Norma, Normas}

/** Represents the final Norma level.
 *
 */
class Norma6 extends Normas(200, 14){
  override val _number: Int = 6
  override def nextNorma: Norma = this

}
