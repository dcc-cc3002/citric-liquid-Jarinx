package cl.uchile.dcc.citric
package model.norma.concretenormas

import model.norma.{Norma, Normas}

/** The initial player's Norma
 *
 */
class Norma1 extends Normas (10, 1) {
  override val _number: Int = 1
  override def nextNorma: Norma = new Norma2
}
