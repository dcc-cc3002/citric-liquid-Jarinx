package cl.uchile.dcc.citric
package model.panels.concretepanels

import model.gameunits.wildunits.{TWildUnit, WildUnit}
import model.panels.Panels

import cl.uchile.dcc.citric.controller.factory.gameunitsfactory.WildUnitFactory
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.concretewu.{Chicken, RoboBall, Seagull}

import scala.util.Random

/** Represents an encounter panel on the game board.
 * An encounter panel is a type of space where players can engage with a wild unit enemy.
 */
class EncounterPanel extends Panels("Encounter") {

  var _enemy: Option[TWildUnit] = None  // The wild unit enemy associated with this encounter panel.
  var enemyFactory: WildUnitFactory = new WildUnitFactory

  /** Retrieves the wild unit enemy associated with this encounter panel.
   *
   * @return The WildUnit enemy present on this panel.
   */
  def enemy: Option[TWildUnit] = _enemy

  /** Sets the wild unit enemy for this encounter panel randomly. */
  override def enemy_(): Option[TWildUnit] = {
    // if there is no wild unit alive
    if (_enemy.isEmpty || _enemy.get.inRecovery) {
      var newEnemy = enemyFactory.createWildUnit()
      _enemy = Some(newEnemy)
      _enemy
    }
    // if there is an active wild unit
    else {
      _enemy = _enemy
      _enemy
    }
  }

  override def apply(player: PlayerCharacter): Unit = enemy_()
}
