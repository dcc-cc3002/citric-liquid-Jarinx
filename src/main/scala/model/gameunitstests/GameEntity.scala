package cl.uchile.dcc.citric
package model.gameunitstests

import cl.uchile.dcc.citric.model.gameunitstests.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunitstests.wildunits.{TWildUnit, WildUnit}

import scala.util.Random

/**
 * Represents a game entity with various stats and abilities.
 *
 * @constructor Create a new game entity with default stats.
 */

trait GameEntity {
  val _maxHp: Int      // The maximum health points of the entity.
  var _currentHp: Int  // The current health points of the entity.
  val _attackPts: Int  // The attack points of the entity.
  val _defensePts: Int // The defense points of the entity.
  val _evasionPts: Int // The evasion points of the entity.
  var _randomNumberGenerator: Random // For the dice rolls.
  var _stars: Int      // The number of stars associated with the entity.
  var _wins: Int       // The number of wins the entity has achieved.
  var _alive: Boolean  // true if the entity is alive, false if it's 'dead'

  /** Returns the maximum health points of the entity. */
  def maxHp: Int = _maxHp

  /** Returns the current health points of the entity. */
  def currentHp: Int = _currentHp

  /** Returns the attack points of the entity. */
  def attackPts: Int = _attackPts

  /** Returns the defense points of the entity. */
  def defensePts: Int = _defensePts

  /** Returns the evasion points of the entity. */
  def evasionPts: Int = _evasionPts

  /** Returns the current number of stars of the entity. */
  def stars: Int = _stars

  /** Returns the current number of wins of the entity. */
  def wins: Int = _wins

  /** Sets the current health points of the entity.
   * An entity cannot have below 0 HP's.
   *
   * @param newCurrentHp The new current health points.
   */
  def currentHp_(newCurrentHp: Int): Unit

  /**  Sets the number of stars of the entity.
   * An entity cannot have below 0 stars.
   *
   * @param newStars The new number of stars.
   */
  def stars_(newStars: Int): Unit

  /** Sets the number of wins of the entity.
   * An entity cannot have below 0 wins.
   *
   * @param newWins The new number of wins.
   */
  def wins_(newWins: Int): Unit

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int

  /** Tells if the entity is in recovery state, i.e., has 0 HP
   *
   * @return true if it's KO'd, false otherwise
   */
  def inRecovery: Boolean

  /** Reduces the current health points by the damage quantity specified.
   *
   * @param qty The quantity of damage to take.
   * @throws IllegalArgumentException If the damage quantity is negative.
   */
  def takeDmg(qty: Int): Unit

  /** Performs an attack on another game entity.
   *
   * @param someone The entity to attack.
   * @throws IllegalArgumentException If the attacked entity is KO'd.
   */
  def attack(someone: GameEntity): Unit

  /** Defends against an attack from another game entity.
   *
   * @param qty The quantity of the damage.
   */
  def defend(qty: Int): Unit

  /** Attempts to evade an attack from another game entity.
   *
   * @param qty The quantity of the damage.
   */
  def evade(qty: Int): Unit

  /** When an entity defeats a player, they'll get rewarded
   * a certain amount of stars and wins from the player.
   *
   * Used for Double Dispatch Pattern.
   *
   * @param player the player overthrown
   *
   */
  def rewardFromPlayer(player: PlayerCharacter): Unit

  /** When an entity defeats a wild unit, they'll get
   * rewarded a certain amount of stars and wins form
   * the wild unit.
   *
   * Used for Double Dispatch Pattern.
   *
   * @param wildUnit the wild unit defeated
   */
  def rewardFromWU(wildUnit: TWildUnit): Unit

  /** When an entity loses against another. The result of this
   * defeat depends on who got attacked and who got attacked.
   * The attacker gets a reward for overthrowing the entity.
   *
   * Used for Double Dispatch Pattern.
   *
   * @param attacker the entity attacking
   */
  def overthrownBy(attacker: GameEntity): Unit

}
