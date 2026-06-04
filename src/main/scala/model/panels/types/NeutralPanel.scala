package cl.uchile.dcc.citric
package model.panels.types

import model.gameunits.PlayerCharacter
import model.panels.Panels

/** Represents a neutral panel on the game board.
 * A neutral panel is a basic type of space that does not have any special effects on the player.
 *
 * @constructor Create a new neutral panel with a specified type.
 * @param panelType The type of the panel, which should be "neutral" for this class.
 */
class NeutralPanel (panelType: String) extends Panels(panelType) {

  /** Applies the panel effect on the player.
   *
   * @param player The character to whom the panel effect will be applied.
   * @param roll   Dice roll.
   */
  override def apply(player: PlayerCharacter, roll: Int): Unit = {
    // Este método puede estar vacío por ahora.
  }
}
