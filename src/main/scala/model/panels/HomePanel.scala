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
class HomePanel(val _owner: PlayerCharacter) extends Panels("Home") {

  /** Returns the owner of this home panel.
   *
   * @return The PlayerCharacter who owns this panel.
   */
  def owner: PlayerCharacter = _owner

  override def apply(player: PlayerCharacter): Unit = {
    player.currentHp_(player.currentHp + 1)
    player.normaClear(player)
  }

}

