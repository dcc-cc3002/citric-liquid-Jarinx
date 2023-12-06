package cl.uchile.dcc.citric
package model.norma

/** Represents the starting Norma level. Conditions are set at 0.
 *
 * @constructor Create a new Norma level 1.
 */
class Norma1 extends Normas (_number = 1, _neededStars = 0, _neededWins = 0){
  override def nextNorma: Norma = new Norma2()
}
