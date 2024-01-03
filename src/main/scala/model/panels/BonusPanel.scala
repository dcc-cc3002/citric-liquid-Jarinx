package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer
import scala.math.min

/** Represents a bonus panel on the game board.
 * A bonus panel is a type of space where players can gain additional stars based on a dice roll.
 *
 * @constructor Create a new bonus panel with a specified type.
 * @param panelType The type of the panel, which should be "bonus" for this class.
 */
class BonusPanel extends Panels("Bonus") {

  /** Grants stars to a player character based on a dice roll when they land on this bonus panel.
   * The number of stars gained is: min(roll * player.norma, roll * 3) .
   *
   * @param player The player character who lands on this panel.
   * @param roll   The result of the dice roll.
   */
  def gainStars(player: PlayerCharacter, roll: Int): Unit = {
    // var roll = player.rollDice()
    var starsGained: Int = min(roll * player.norma, roll * 3)
    var newStars = player._stars + starsGained
    player.stars_(newStars)
  }

//  override def apply(): Unit = {
//  }
}
