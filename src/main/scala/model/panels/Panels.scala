package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunitstests.playercharacter.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** Abstract class that serves as a base for different types of panels on the game board.
 * It implements the common functionality shared by all panels, such as managing characters on the panel
 * and the connections to other panels.
 *
 * @constructor Create a base panel with a specified type.
 * @param _panelType The type of the panel (e.g., neutral, home, bonus, drop, encounter).
 */
abstract class Panels (val _panelType: String) extends Panel {

  // Buffer holding the characters currently on this panel.
  var _characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty[PlayerCharacter]

  // Buffer holding the panels that are directly connected to this one.
  var _nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty[Panel]

  /** Adds a character to this panel.
   * This method is called when a character lands on or passes through this panel.
   *
   * @param player The PlayerCharacter to add to this panel.
   */
  override def addCharacter(player: PlayerCharacter): Unit = {
    _characters += player
  }

  /** Removes a character from this panel.
   * This method is called when a character leaves this panel.
   *
   * @param player The PlayerCharacter to remove from this panel.
   */
  override def removeCharacter(player: PlayerCharacter): Unit = {
    _characters -= player
  }

  /** Adds a connection to another panel.
   * This method is used to link this panel to another, allowing for movement between them.
   *
   * @param panel The Panel to connect to this one.
   */
  override def addPanel(panel: Panel): Unit = {
    _nextPanels += panel
  }

  /** Removes a connection to another panel.
   * This method is used to unlink this panel from another, disallowing movement between them.
   *
   * @param panel The Panel to disconnect from this one.
   */
  override def removePanel(panel: Panel): Unit = {
    _nextPanels -= panel
  }
}
