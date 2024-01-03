package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** A class that represent a Home Panel
 * The owner of the Home Panel can stop here even if they have moves left, other players can´t.
 * When any player ends up here, Norma Check is performed and 1 HP is restored.
 *
 * @constructor Create a new home panel with a specified type.
 * @param panelType The type of the panel, which should be "home" for this class.
 */
class HomePanel extends Panels("Home") {

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

  /** Restores 1 HP to a player character when they land on this home panel.
   *
   * @param player The PlayerCharacter who lands on this panel.
   */
  def restoreHP(player: PlayerCharacter): Unit = {
    var currentHp = player.currentHp
    player.currentHp_(currentHp + 1)
  }
}

