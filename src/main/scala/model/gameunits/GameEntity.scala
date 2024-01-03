package cl.uchile.dcc.citric
package model.gameunits

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
  var _stars: Int      // The number of stars associated with the entity.
  var _wins: Int       // The number of wins the entity has achieved.

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
   *
   * @param newCurrentHp The new current health points.
   */
  def currentHp_(newCurrentHp: Int): Unit

  /**  Sets the number of stars of the entity.
   *
   * @param newStars The new number of stars.
   */
  def stars_(newStars: Int): Unit

  /** Sets the number of wins of the entity.
   *
   * @param newWins The new number of wins.
   */
  def wins_(newWins: Int): Unit

//  /** Reduces the current health points by the damage quantity specified.
//   *
//   * @param qty The quantity of damage to take.
//   */
//  def takeDmg(qty: Int): Unit
//
//  /** Inflicts a certain amount of damage on another game entity.
//   *
//   * @param someone The entity to do damage to.
//   * @param qty     The quantity of damage to inflict.
//   */
//  def doDmg(someone: GameEntity, qty: Int): Unit

  /** Performs an attack on another game entity.
   *
   * @param someone The entity to attack.
   * @param qty     The quantity of the attack.
   */
  def attack(someone: GameEntity, qty: Int): Unit

  /** Defends against an attack from another game entity.
   *
   * @param fromSomeone The entity from which to defend.
   * @param qty         The quantity of the damage.
   */
  def defend(fromSomeone: GameEntity, qty: Int): Unit

  /** Attempts to evade an attack from another game entity.
   *
   * @param formSomeone The entity from which to evade.
   * @param qty         The quantity of the damage.
   */
  def evade(formSomeone: GameEntity, qty: Int): Unit

}
