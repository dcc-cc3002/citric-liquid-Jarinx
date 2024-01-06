package cl.uchile.dcc.citric
package model.panels.concretepanels

import exceptions.InvalidStatException
import model.gameunitstests.playercharacter.PlayerCharacter
import model.panels.Panels

/** Represents a drop panel on the game board.
 * A drop panel is a type of space where players can lose stars based on a dice roll.
 *
 * @constructor Create a new drop panel with a specified type.
 * @param panelType The type of the panel, which should be "drop" for this class.
 */
class DropPanel extends Panels("Drop") {

  /** Deducts stars from a player character based on a dice roll when they land on this drop panel.
   * If the loss results in a negative star count, the player's stars are set to zero.
   *
   * @param player The player character who lands on this panel.
   */

  override def apply(player: PlayerCharacter): Unit = {
    try {
      var roll = player.rollDice()
      var starsLost: Int = roll * player.norma._number
      var newStars = player.stars - starsLost
      player.stars_(newStars)
    } catch {
      case _: InvalidStatException => player.stars_(0)
    }
}