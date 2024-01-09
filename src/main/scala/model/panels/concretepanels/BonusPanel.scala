package cl.uchile.dcc.citric
package model.panels.concretepanels

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.Panels

import scala.math.min

/** Represents a bonus panel on the game board.
 * A bonus panel is a type of space where players can gain additional stars based on a dice roll.
 */
class BonusPanel extends Panels("Bonus") {

  /** Grants stars to a player character based on a dice roll when they land on this bonus panel.
   *
   * @param player The player character who lands on this panel.
   */
  override def apply(player: PlayerCharacter): Unit = {
    var roll = player.rollDice()
    var starsGained: Int = min(roll * player.norma._number, roll * 3)
    var newStars = player.stars + starsGained
    player.stars_(newStars)
  }

}
