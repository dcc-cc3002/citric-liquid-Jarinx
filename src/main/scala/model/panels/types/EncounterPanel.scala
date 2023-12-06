package cl.uchile.dcc.citric
package model.panels.types

import model.gameunits.PlayerCharacter
import model.gameunits.wildunits.WildUnit
import model.panels.Panels

/**
 * Represents an encounter panel on the game board.
 * An encounter panel is a type of space where players can engage with a wild unit enemy.
 *
 * @constructor Create a new encounter panel with a specified type.
 * @param panelType The type of the panel, which should be "encounter" for this class.
 */
class EncounterPanel(panelType: String) extends Panels(panelType) {

  var enemy: WildUnit = _ // The wild unit enemy associated with this encounter panel.

  /** Retrieves the wild unit enemy associated with this encounter panel.
   *
   * @return The WildUnit enemy present on this panel.
   */
  def getEnemy: WildUnit = enemy

  /** Sets the wild unit enemy for this encounter panel.
   *
   * @param newEnemy The WildUnit to set as the enemy on this panel.
   */
  def setEnemy(newEnemy: WildUnit): Unit = {
    enemy = newEnemy
  }

  override def apply(player: PlayerCharacter, roll: Int): Unit = {}

}