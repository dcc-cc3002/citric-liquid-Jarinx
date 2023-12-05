package cl.uchile.dcc.citric
package model.gameunits.wildunits

import cl.uchile.dcc.citric.exceptions.InvalidStatException
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
abstract class WildUnit (maxHp: Int, attackPts: Int, defensePts: Int, evasionPts: Int)
                          extends Entities(maxHp, attackPts, defensePts, evasionPts) {

  var _enemy: String // The type of enemy associated with the wild unit.
  var _bonusStars: Int // The bonus stars each type wild unit has by default
  override var _stars: Int = 0 // every wild unit starts with 0 accumulated stars
  override var _wins: Int = 0 // wild units won't accumulate wins, so theu're instanciated at 0

  /** Returns the current type of the wild unit.
   *
   * @return A string representing the type of enemy.
   */
  def enemy: String = _enemy

  /** Sets the type of enemy for the wild unit.
   *
   * @param newEnemy The new type of enemy.
   * @return The updated type of enemy.
   */
  def enemy_(newEnemy: String): Unit = {
    _enemy = newEnemy
  }

  /** Retrieves the bonus stars value for the specific wild unit.
   *
   * @return The number of bonus stars held by the specific wild unit.
   */
  protected def bonusStars: Int = _bonusStars

  /** Sets the number of bonus stars for the specific wild unit.
   *
   * @param newBS The new value for the bonus stars.
   */
  def bonusStars_(newBS: Int): Unit = {
    _bonusStars = newBS
  }

  /** Retrieves the total star count for the specific wild unit.
   * This count includes both the base stars and any additional bonus stars.
   *
   * @return The total number of stars (base stars plus bonus stars) held by the specific wild unit.
   */
  override def stars: Int = _stars + bonusStars

  /** Updates the star count for the specific wild unit.
   * This method adds the specified number of stars to the current total star count
   *
   * @param newStars The number of stars to be added to the current total.
   * @throws InvalidStatException If the amount of newStars is negative.
   */
  override def stars_(newStars: Int): Unit = {
    if (newStars < 0) {
      throw new InvalidStatException("Star count cannot be negative.")
    }
    stars + newStars
  }

  override protected def transferStarsAndWins(attacker: GameEntity, victim: GameEntity): Unit = {
    victim.stars_(victim.stars - (victim.stars / 2))
    attacker.stars_(attacker.stars + victim.stars)
    attacker.wins_(attacker.wins + 1)
  }


}
