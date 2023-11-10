package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** Represents a drop panel on the game board.
 * A drop panel is a type of space where players can lose stars based on a dice roll.
 *
 * @constructor Create a new drop panel with a specified type.
 * @param panelType The type of the panel, which should be "drop" for this class.
 */
class DropPanel (panelType: String) extends Panels(panelType) {

  /** Deducts stars from a player character based on a dice roll when they land on this drop panel.
   * The number of stars lost is: roll * player.getNorma.
   * If the loss results in a negative star count, the player's stars are set to zero.
   *
   * @param player The player character who lands on this panel.
   * @param roll   The result of the dice roll.
   */
  def loseStars(player: PlayerCharacter, roll: Int): Unit = {
    var starsLost: Int = roll * player.getNorma
    var newStars = player.getStars - starsLost
    // ¿player.setStars(math.max(newStars, 0))?
    if(newStars < 0){
      player.setStars(0)
    }
    else{
      player.setStars(newStars)
    }
  }
}