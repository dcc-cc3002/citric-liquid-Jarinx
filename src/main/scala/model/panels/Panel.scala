package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.{TWildUnit, WildUnit}

import scala.collection.mutable.ArrayBuffer
import scala.math._

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

  val _panelType: String // The type of the panel (e.g., neutral, home, bonus, drop, encounter).

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  var _characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var _nextPanels: ArrayBuffer[Panel]

  /** Returns the type of this panel.
   *
   * @return A string representing the panel type.
   */
  def panelType: String

  /** Adds a character to this panel.
   * This method is called when a character lands on or passes through this panel.
   *
   * @param player The PlayerCharacter to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from this panel.
   * This method is called when a character leaves this panel.
   *
   * @param player The PlayerCharacter to remove from this panel.
   */
  def removeCharacter(player: PlayerCharacter): Unit

  /** Adds a connection to another panel.
   * This method is used to link this panel to another, allowing for movement between them.
   *
   * @param panel The Panel to connect to this one.
   */
  def addNextPanel(panel: Panel): Unit

  /** Removes a connection to another panel.
   * This method is used to unlink this panel from another, disallowing movement between them.
   *
   * @param panel The Panel to disconnect from this one.
   */
  def removeNextPanel(panel: Panel): Unit

  /** Function with unique effects based on the class that is called upon
   *
   * @param player The player affected
   */
  def apply(player: PlayerCharacter): Unit

  /** To tell if a certain panel contains a player in _characters
   *
   * @param player the player to check in the array
   * @return true if a player is in the panel, false otherwise
   */
  def containsPlayer(player: PlayerCharacter): Boolean

  /** To tell if there are panels next to the current one, ie, if the nextPanel
   * is in _nextPanels
   *
   * @param nextPanel the panel to check in the array
   * @return true if there are more panels, false otherwise.
   */
  def containsNextPanel(nextPanel: Panel): Boolean

  def nextPanelsAmount: Int

  def charactersAmount: Int

  /** Useful for knowing if the player currently passing through
   * this Home Panel is its owner or not
   *
   * @param player the player to check
   * @return true if the player is the owner, false otherwise
   */
  def ownerInPanel(player: PlayerCharacter): Boolean

  /** Generates a new wild unit if there isn't any defined beforehand
   *
   * @return the wild unit
   */
  def enemy_(): Option[TWildUnit]
}