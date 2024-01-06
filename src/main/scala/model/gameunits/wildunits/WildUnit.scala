package cl.uchile.dcc.citric
package model.gameunits.wildunits

import cl.uchile.dcc.citric.exceptions.WildUnitException
import cl.uchile.dcc.citric.model.gameunits.{Entities, GameEntity, PlayerCharacter}

/** Abstract class representing a wild unit in the game with specific stats and an enemy type.
 *
 * @constructor Create a new wild unit with specified maximum health, attack, defense, and evasion points.
 * @param maxHp The maximum health points of the wild unit.
 * @param attackPts The attack points of the wild unit.
 * @param defensePts The defense points of the wild unit.
 * @param evasionPts The evasion points of the wild unit.
 * @param enemy The type of enemy ("Chicken", "Robo ball", "Seagull").
 * @author Julieta Ayelli
 */
abstract class WildUnit (maxHp: Int,
               attackPts: Int,
               defensePts: Int,
               evasionPts: Int,
               var _enemy: String)
                extends Entities(maxHp, attackPts, defensePts, evasionPts)
                with TWildUnit {

  def bonusStars: Int = _bonusStars

  /** Returns the current type of the wild unit.
   *
   * @return A string representing the type of enemy.
   */
  def enemy: String = _enemy

  override def overthrownBy(attacker: GameEntity): Unit = {
    attacker.rewardFromWU(this)
  }

  override def rewardFromPlayer(player: PlayerCharacter): Unit = {
    this.stars_(this.stars + player.stars / 2)
    player.stars_(player.stars - player.stars / 2)
  }

  /** Stays empty, because a Wild Unit cannot fight another Wild Unit.
   *
   * @param wildUnit the wild unit defeated
   * @throws WildUnitException because of the reason stated above.
   *
   */
  override def rewardFromWU(wildUnit: TWildUnit): Unit = {
    throw new WildUnitException("A Wild Unit cannot fight another Wild Unit.")
  }

}
