package cl.uchile.dcc.citric
package model.gameunits

import model.gameunits.wildunits.{Chicken, RoboBall, Seagull, WildUnit}

/**
 * Represents a game entity with various stats and abilities.
 *
 * @constructor Create a new game entity with default stats.
 */

trait GameEntity {
  var _maxHp: Int // The maximum health points of the entity.
  var _currentHp: Int // The current health points of the entity.
  var _attackPts: Int // The attack points of the entity.
  var _defensePts: Int // The defense points of the entity.
  var _evasionPts: Int // The evasion points of the entity.
  var _stars: Int // The number of stars associated with the entity.
  var _wins: Int // The number of wins the entity has achieved.

  /** Returns the maximum health points of the entity. */
  def maxHp: Int

  /** Returns the current health points of the entity. */
  def currentHp: Int

  /** Returns the attack points of the entity. */
  def attackPts: Int

  /** Returns the defense points of the entity. */
  def defensePts: Int

  /** Returns the evasion points of the entity. */
  def evasionPts: Int

  /** Returns the current number of stars of the entity. */
  def stars: Int

  /** Returns the current number of wins of the entity. */
  def wins: Int

  /** Sets the maximum health points of the entity.
   *
   * @param newMaxHp The new maximum health points.
   */
  def maxHp_(newMaxHp: Int): Unit

  /** Sets the current health points of the entity.
   *
   * @param newCurrentHp The new current health points.
   */
  def currentHp_(newCurrentHp: Int): Unit

  /** Sets the attack points of the entity.
   *
   * @param newAttackPts The new attack points.
   */
  def attackPts_(newAttackPts: Int): Unit

  /** Sets the defense points of the entity.
   *
   * @param newDefensePts The new defense points.
   */
  def defensePts_(newDefensePts: Int): Unit

  /** Sets the evasion points of the entity.
   *
   * @param newEvasionPts The new evasion points.
   */
  def evasionPts_(newEvasionPts: Int): Unit

  /** Sets the number of stars of the entity.
   *
   * @param newStars The new number of stars.
   */
  def stars_(newStars: Int): Unit

  /** Sets the number of wins of the entity.
   *
   * @param newWins The new number of wins.
   */
  def wins_(newWins: Int): Unit

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int

  /** Reduces the current health points by the damage quantity specified.
   *
   * @param qty The quantity of damage to take.
   */
  def takeDmg(qty: Int): Unit

  /** Performs an attack on another game entity.
   *
   * @param someone The entity to attack.
   */
  def attack(someone: GameEntity): Unit

  /** Defends against an attack from another game entity.
   *
   * @param fromSomeone The entity from which to defend.
   */
  def defend(fromSomeone: GameEntity): Unit

  /** Attempts to evade an attack from another game entity.
   *
   * @param formSomeone The entity from which to evade.
   */
  def evade(formSomeone: GameEntity): Unit

  /** An entity calls this method to define the results based on
   * the type of the attacker
   *
   * @param attacker The entity that attacks
   * @param qty The roll
   */
  def attackedBy(attacker: GameEntity, qty: Int): Unit


}
