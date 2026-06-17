package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/Jarinx Julieta Ayelli]]
  */


trait Panel {

  var panelType: String /** corresponde al tipo del panel (neutral, home, bonus, drop o encounter) */

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  val characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
    *
    * This might be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The player character to add to this panel.
    */
  def addCharacter(player: PlayerCharacter): Unit = {
    characters += player
  }

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }
}

/** A class that represents a Neutral Panel
 * Nothing happens when a player ends up here
 *
 * @author Julieta Ayelli
 */
abstract class NeutralPanel extends Panel{}

/** A class that represent a Home Panel
 * The owner of the Home Panel can stop here even if they have moves left, other players can´t
 * When any player ends up here, Norma Check is performed and 1 HP is restored
 *
 * @param _owner: owner of the Home Panel
 * @param _playerNum: this will be the number of the panel
 *
 * @author Julieta Ayelli
 */
abstract class HomePanel(private var _owner: PlayerCharacter,
                private var _playerNum: Int) extends Panel{

  /** gets the current owner of a certain Home Panel */
  def owner: PlayerCharacter = _owner

  /** gets the number associated with a player (1, 2, 3 or 4),
  *  and therefore, the number of the Home Panel */
  def playerNum: Int = _playerNum

  /** sets (updates) the owner of the Home Panel
  * it's private because this SHOULD NOT change throughout the match*/
  private def setOwner(newOwner: PlayerCharacter): PlayerCharacter = {
    _owner = newOwner
    return _owner
  }
  /** sets (updates) the number associated with a player
  *it's private because this SHOULD NOT change throughout the match*/
  private def setPlayerNum(newPlayerNum: Int): Int = {
    _playerNum = newPlayerNum
    return _playerNum
  }

  /** Once any player ends up here, they restore 1 HP */
  def restoreHP(characters: PlayerCharacter): Unit = {}
}


/** A class that represents a Bonus Panel
 * When a player ends up here, they gain a certain number of stars (depends on the roll)
 *
 *@author Julieta Ayelli
 */
abstract class bonusPanel extends Panel {

  /** Once any player ends up here, the gain a certain number of stars
   * Stars gained = min(roll * Norma, roll * 3)
   */
  def gainStars(): Unit = {}
}

/** A class that represents a Drop Panel
 * When a player ends up here, they lose a certain number of stars (depends on the roll)
 *
 *@author Julieta Ayelli
 */
abstract class dropPanel extends Panel {

  /** Once any player ends up here, they lose a certain number of stars
   * Stars lost = roll * Norma
   */
  def loseStars(): Unit = {}
}

/** A class that represents an Encounter Panel
 * Players that end up here will fight with a random Wild Unit;
 * if the win, they'll win stars, and if they lose, they'll lose stars.
 * The stars won depends on how many stars the Wild Unit has accumulated
 * by fighting other players.
 *
 * @param enemy: the Wild Unit that will be randomly generated on this panel
 *
 * @author Julieta Ayelli
 */
abstract class encounterPanel(var _enemy: WildUnit) extends Panel {

  /** gets the current enemy of a certain Encounter Panel */
  def enemy: WildUnit = _enemy

  /** sets (updates) the enemy of a certain Encounter Panel
   * it's private because each Encounter Panel will have a specific Wild Unit,
   * therefore it SHOULD NOT be changed throughout the match*/
  private def setEnemy(newEnemy: WildUnit): WildUnit = {
    _enemy = newEnemy
    return _enemy
  }

  /** The battle between players and wild units
   * The player attacks, and the wild unit can evade or defend themselves
   * Later, the wild unit attacks, and the player needs to evade or defend himself
   *
   * @return
   */
  def battle(): Unit{}
}

/** A class that represent the overall board
 * It´s a combination of the different panels, arranged in a certain manner.
 * Could always be the same, or have a few different ones, like "Map Types" (IN EVALUATION)
 *
 *@author Julieta Ayelli
 */
abstract class board{
  var panels: List[Panel]
}