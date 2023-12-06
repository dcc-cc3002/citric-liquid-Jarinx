package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** Abstract class that serves as a base for different types of panels on the game board.
 * It implements the common functionality shared by all panels, such as managing characters on the panel
 * and the connections to other panels.
 *
 * @constructor Create a base panel with a specified type.
 * @param panelType The type of the panel (e.g., neutral, home, bonus, drop, encounter).
 */
abstract class Panels (var panelType: String) extends Panel {

  // Buffer holding the characters currently on this panel.
  var characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty[PlayerCharacter]

  // Buffer holding the panels that are directly connected to this one.
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty[Panel]

  /** Sets the type of this panel.
   *
   * @param newType The new type for the panel.
   */
  override def setPanelType(newType: String): Unit = {
    panelType = newType
  }

  /** Adds a character to this panel.
   * This method is called when a character lands on or passes through this panel.
   *
   * @param player The PlayerCharacter to add to this panel.
   */
  override def addCharacter(player: PlayerCharacter): Unit = {
    characters += player
  }

  /** Removes a character from this panel.
   * This method is called when a character leaves this panel.
   *
   * @param player The PlayerCharacter to remove from this panel.
   */
  override def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }

  /** Adds a connection to another panel.
   * This method is used to link this panel to another, allowing for movement between them.
   *
   * @param panel The Panel to connect to this one.
   */
  override def addPanel(panel: Panel): Unit = {
    nextPanels += panel
  }

  /** Removes a connection to another panel.
   * This method is used to unlink this panel from another, disallowing movement between them.
   *
   * @param panel The Panel to disconnect from this one.
   */
  override def removePanel(panel: Panel): Unit = {
    nextPanels -= panel
  }

  /** Default implementation of the apply method.
   * Will be overridden by subclasses for their specific cases.
   *
   * @param player The character to whom the panel effect will be applied
   * @param roll   Dice roll.
   * */
  override def apply(player: PlayerCharacter, roll: Int): Unit
}
