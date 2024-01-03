package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.WildUnit

import scala.collection.mutable.ArrayBuffer

/**
 * Represents an encounter panel on the game board.
 * An encounter panel is a type of space where players can engage with a wild unit enemy.
 *
 * @constructor Create a new encounter panel with a specified type.
 * @param panelType The type of the panel, which should be "encounter" for this class.
 */
class EncounterPanel extends Panels("Encounter") {

  var _enemy: WildUnit = _  // The wild unit enemy associated with this encounter panel.

  /** Retrieves the wild unit enemy associated with this encounter panel.
   *
   * @return The WildUnit enemy present on this panel.
   */
  def enemy: WildUnit = _enemy

  /** Sets the wild unit enemy for this encounter panel.
   *
   * @param newEnemy The WildUnit to set as the enemy on this panel.
   */
  def enemy_(newEnemy: WildUnit): Unit = {
    _enemy = newEnemy
  }

  /** The battle between players and wild units
   * The player attacks, and the wild unit can evade or defend themselves
   * Later, the wild unit attacks, and the player needs to evade or defend himself
   *
   * @return
   */
  //def battle(): Unit{}
}
