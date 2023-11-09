package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** A class that represent a Home Panel
 * The owner of the Home Panel can stop here even if they have moves left, other players can´t
 * When any player ends up here, Norma Check is performed and 1 HP is restored
 *
 * @param _owner: owner of the Home Panel
 * @param _playerNum: this will be the number of the panel
 * @author Julieta Ayelli
 */
class HomePanel(panelType: String) extends Panels(panelType) {

  var owner: PlayerCharacter = _
  var playerNum: Int = _

  /** gets the current owner of a certain Home Panel */
  def getOwner: PlayerCharacter = owner

  /** gets the number associated with a player (1, 2, 3 or 4),
   *  and therefore, the number of the Home Panel */
  def getPlayerNum: Int = playerNum

  /** sets (updates) the owner of the Home Panel*/
  def setOwner(newOwner: PlayerCharacter): Unit = {
    owner = newOwner
  }
  /** sets (updates) the number associated with a player*/
  def setPlayerNum(newPlayerNum: Int): Unit = {
    playerNum = newPlayerNum
  }

  /** Once any player ends up here, they restore 1 HP */
  def restoreHP(player: PlayerCharacter): Unit = {
    var currentHp = player.getCurrentHp
    player.setCurrentHp(currentHp + 1)
  }
}

