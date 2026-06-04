package cl.uchile.dcc.citric
package model.panels.types

import model.gameunits.PlayerCharacter
import model.panels.Panels

/** Represents a bonus panel on the game board.
 * A bonus panel is a type of space where players can gain additional stars based on a dice roll.
 *
 * @constructor Create a new bonus panel with a specified type.
 * @param panelType The type of the panel, which should be "bonus" for this class.
 */
class BonusPanel (panelType: String) extends Panels(panelType) {

  /** Grants stars to a player character based on a dice roll when they land on this bonus panel.
   * The number of stars gained is: min(roll * player.norma, roll * 3) .
   *
   * @param player The player character who lands on this panel.
   * @param roll   The result of the dice roll.
   */

  override def apply(player: PlayerCharacter, roll: Int): Unit = {
    val starsGained = math.min(roll * player.norma._number, roll * 3)
    var newStars = player.stars + starsGained
    player.stars_(newStars)
  }

}
