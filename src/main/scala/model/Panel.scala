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
 *
 * @author Julieta Ayelli
 */
abstract class NeutralPanel extends Panel{}

/** A class that represent a Home Panel
 *
 * @param owner: owner of the Home Panel
 * @param playerNum: this will be the number of the panel
 *
 * @author Julieta Ayelli
 */
abstract class HomePanel(val owner: PlayerCharacter,
                         val playerNum: Int) extends Panel{

  /** Once any player ends up here, they restore 1 HP
   *
   */
  def restoreHP(): Unit = {}
}


/** A class that represents a Bonus Panel
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
 * Players that end up here will fight with a random Wild Unit,
 * if the win, they'll win stars, and if they lose, they'll lose stars
 *
 * @param enemy: the Wild Unit that will be randomly generated on this panel
 *
 * @author Julieta Ayelli
 */
abstract class encounterPanel(var enemy: WildUnit) extends Panel {

  /** The battle between players and wild units
   * The player attacks, and the wild unit can evade or defend themselves
   * Later, the wild unit attacks, and the player needs to evade or defend himself
   *
   * @return
   */
  def battle(): Unit{}
}

/** A class that represent the overall board
 *
 *@author Julieta Ayelli
 */
abstract class board{
  var panels: List[Panel]
}