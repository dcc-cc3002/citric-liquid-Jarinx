package cl.uchile.dcc.citric
package model.panels.concretepanels

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.Panels

/** A class that represent a Home Panel
 * The owner of the Home Panel can stop here even if they have moves left, other players can´t.
 * When any player ends up here, NormaCheck is performed and 1 HP is restored.
 *
 * @param _owner the owner of the Home Panel
 */
class HomePanel(val _owner: PlayerCharacter) extends Panels("Home") {

  /** Returns the owner of this home panel.
   *
   * @return The PlayerCharacter who owns this panel.
   */
  def owner: PlayerCharacter = _owner

  override def apply(player: PlayerCharacter): Unit = {
    player.currentHp_(player.currentHp + 1)
    player.normaClear()
  }

  override def ownerInPanel(player: PlayerCharacter): Boolean = {
    if (player == owner) {
      true
    }
    else {
      false
    }
  }

}

