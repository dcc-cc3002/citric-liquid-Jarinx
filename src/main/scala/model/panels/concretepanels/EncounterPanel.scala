package cl.uchile.dcc.citric
package model.panels.concretepanels

import model.gameunits.wildunits.WildUnit
import model.panels.Panels

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.concretewu.{Chicken, RoboBall, Seagull}

import scala.util.Random

/** Represents an encounter panel on the game board.
 * An encounter panel is a type of space where players can engage with a wild unit enemy.
 */
class EncounterPanel extends Panels("Encounter") {

  var _enemy: Option[WildUnit] = None  // The wild unit enemy associated with this encounter panel.

  /** Retrieves the wild unit enemy associated with this encounter panel.
   *
   * @return The WildUnit enemy present on this panel.
   */
  def enemy: Option[WildUnit] = _enemy

  /** Sets the wild unit enemy for this encounter panel randomly. */
  def enemy_(): Unit = {
    var randEnemy: Int = (new Random().nextInt(3))
    if (randEnemy == 0) {
      _enemy = Some(new Chicken)
    }
    else if (randEnemy == 1){
      _enemy = Some(new Seagull)
    }
    else {
      _enemy = Some(new RoboBall)
    }
  }

  override def apply(player: PlayerCharacter): Unit = {}
}
