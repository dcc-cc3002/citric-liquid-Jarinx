package cl.uchile.dcc.citric
package model.panels.concretepanels

import model.gameunitstests.playercharacter.PlayerCharacter
import model.panels.Panels

/** Represents a neutral panel on the game board.
 * A neutral panel is a basic type of space that does not have any special effects on the player.
 *
 * @constructor Create a new neutral panel with a specified type.
 * @param panelType The type of the panel, which should be "neutral" for this class.
 */
class NeutralPanel extends Panels("Neutral") {
  override def apply(player: PlayerCharacter): Unit = {}
}
