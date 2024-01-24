package cl.uchile.dcc.citric
package model.panels.concretepanels

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.Panels

/** Represents a neutral panel on the game board.
 * A neutral panel is a basic type of space that does not have
 * any special effects on the player.
 */
class NeutralPanel extends Panels("Neutral") {
  override def apply(player: PlayerCharacter): Unit = {}
}
