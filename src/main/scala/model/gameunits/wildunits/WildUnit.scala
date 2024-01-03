package cl.uchile.dcc.citric
package model.gameunits.wildunits

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
                         var _enemy: String)
                          extends Entities(maxHp, attackPts, defensePts, evasionPts) {

  /** Returns the current type of the wild unit.
   *
   * @return A string representing the type of enemy.
   */
  def enemy: String = _enemy

}
