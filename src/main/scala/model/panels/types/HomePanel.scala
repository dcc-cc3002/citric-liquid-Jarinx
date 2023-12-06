package cl.uchile.dcc.citric
package model.panels.types

import model.gameunits.PlayerCharacter
import model.panels.Panels

/** A class that represent a Home Panel
 * The owner of the Home Panel can stop here even if they have moves left, other players can´t.
 * When any player ends up here, Norma Check is performed and 1 HP is restored.
 *
 * @constructor Create a new home panel with a specified type.
 * @param panelType The type of the panel, which should be "home" for this class.
 */
class HomePanel(panelType: String) extends Panels(panelType) {

  var _owner: PlayerCharacter = _ // The player character who owns this home panel.

  /** Returns the owner of this home panel.
   *
   * @return The PlayerCharacter who owns this panel.
   */
  def owner: PlayerCharacter = _owner

  /** Sets the owner of this home panel.
   *
   * @param newOwner The PlayerCharacter to set as the new owner.
   */
  def owner_(newOwner: PlayerCharacter): Unit = {
    _owner = newOwner
  }

  /** Applies the panel effect on the player.
   *
   * @param player The character to whom the panel effect will be applied.
   * @param roll   Dice roll.
   */
  override def apply(player: PlayerCharacter, roll: Int): Unit = {
    player.currentHp_(player.currentHp + 1)

    if (player.norma.normaClear(player.stars, player.wins, player)) {
      println(s"${player.name} has leveled up their Norma!")
      // Lógica adicional para efectos de subida de nivel si es necesario
    }
  }
}

