package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.WildUnit

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

  /** corresponde al tipo del panel (neutral, home, bonus, drop o encounter) */
  var panelType: String

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  var characters: ArrayBuffer[PlayerCharacter]

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

  def getPanelType: String = panelType

  def getCharacters: ArrayBuffer[PlayerCharacter] = characters

  def getNextPanels: ArrayBuffer[Panel] = nextPanels

  def setPanelType(newType: String): Unit

  def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  def removeCharacter(player: PlayerCharacter): Unit
  def addPanel(panel: Panel): Unit
  def removePanel(panel: Panel): Unit

//  def apply(): Unit = {
//  }
}

///** A class that represent the overall board
// * It´s a combination of the different panels, arranged in a certain manner.
// * Could always be the same, or have a few different ones, like "Map Types" (IN EVALUATION)
// *
// *@author Julieta Ayelli
// */
//abstract class board{
//  var panels: List[Panel]
//}