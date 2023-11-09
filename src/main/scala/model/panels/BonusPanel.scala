package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer
import scala.math.min

/** A class that represents a Bonus Panel
 * When a player ends up here, they gain a certain number of stars (depends on the roll)
 *
 *@author Julieta Ayelli
 */
class BonusPanel (panelType: String) extends Panels(panelType) {

  /** Once any player ends up here, the gain a certain number of stars
   * Stars gained = min(roll * Norma, roll * 3)
   */
  def gainStars(player: PlayerCharacter, roll: Int): Unit = {
    // var roll = player.rollDice()
    var starsGained: Int = min(roll * player.norma, roll * 3)
    var newStars = player.stars + starsGained
    player.setStars(newStars)
  }

//  override def apply(): Unit = {
//  }
}
