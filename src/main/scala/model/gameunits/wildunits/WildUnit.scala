package cl.uchile.dcc.citric
package model.gameunits.wildunits

import cl.uchile.dcc.citric.exceptions.WildUnitException
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.{Entities, GameEntity}

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
                         name: String)
                        extends Entities(name, maxHp, attackPts, defensePts, evasionPts)
                        with TWildUnit {

  override var _canChooseCounter: Boolean = false

  def bonusStars: Int = _bonusStars

  def overthrownBy(attacker: GameEntity): Unit = {
    attacker.rewardFromWU(this)
  }

  def rewardFromPlayer(player: PlayerCharacter): Unit = {
    this.stars_(this.stars + player.stars / 2)
    player.stars_(player.stars - player.stars / 2)
  }

  /** Stays empty, because a Wild Unit cannot fight another Wild Unit.
   *
   * @param wildUnit the wild unit defeated
   * @throws WildUnitException because of the reason stated above.
   *
   */
  def rewardFromWU(wildUnit: TWildUnit): Unit = {
    throw new WildUnitException("A Wild Unit cannot fight another Wild Unit")
  }

}
