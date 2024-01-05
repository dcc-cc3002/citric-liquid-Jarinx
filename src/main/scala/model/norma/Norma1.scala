package cl.uchile.dcc.citric
package model.norma

import model.gameunits.PlayerCharacter

/** The initial player's Norma
 *
 */
class Norma1 extends Normas (10, 1) {
  override var _number: Int = 1

  override def nextNorma: Norma = new Norma2

}
