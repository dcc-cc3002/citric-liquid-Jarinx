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
class HomePanel(panelType: String) extends Panels(panelType) {

  var owner: PlayerCharacter = _ // The player character who owns this home panel.
  var playerNum: Int = _ // The number associated with the player and this home panel.

  /** Returns the owner of this home panel.
   *
   * @return The PlayerCharacter who owns this panel.
   */
  def getOwner: PlayerCharacter = owner

  /** Returns the number associated with the player and this home panel.
   *
   * @return An integer representing the player number.
   */
  def getPlayerNum: Int = playerNum

  /** Sets the owner of this home panel.
   *
   * @param newOwner The PlayerCharacter to set as the new owner.
   */
  def setOwner(newOwner: PlayerCharacter): Unit = {
    owner = newOwner
  }

  /** Sets the number associated with the player for this home panel.
   *
   * @param newPlayerNum The new player number.
   */
  def setPlayerNum(newPlayerNum: Int): Unit = {
    playerNum = newPlayerNum
  }

  /** Restores 1 HP to a player character when they land on this home panel.
   *
   * @param player The PlayerCharacter who lands on this panel.
   */
  def restoreHP(player: PlayerCharacter): Unit = {
    var currentHp = player.getCurrentHp
    player.setCurrentHp(currentHp + 1)
  }
}

