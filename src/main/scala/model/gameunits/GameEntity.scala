package cl.uchile.dcc.citric
package model.gameunits

/**
 * Represents a game entity with various stats and abilities.
 *
 * @constructor Create a new game entity with default stats.
 */

trait GameEntity {
  var maxHp: Int      // The maximum health points of the entity.
  var currentHp: Int  // The current health points of the entity.
  var attackPts: Int  // The attack points of the entity.
  var defensePts: Int // The defense points of the entity.
  var evasionPts: Int // The evasion points of the entity.
  var stars: Int      // The number of stars associated with the entity.
  var wins: Int       // The number of wins the entity has achieved.

  /** Returns the maximum health points of the entity. */
  def getMaxHp: Int = maxHp

  /** Returns the current health points of the entity. */
  def getCurrentHp: Int = currentHp

  /** Returns the attack points of the entity. */
  def getAttackPts: Int = attackPts

  /** Returns the defense points of the entity. */
  def getDefensePts: Int = defensePts

  /** Returns the evasion points of the entity. */
  def getEvasionPts: Int = evasionPts

  /** Returns the current number of stars of the entity. */
  def getStars: Int = stars

  /** Returns the current number of wins of the entity. */
  def getWins: Int = wins

  /** Sets the maximum health points of the entity.
   *
   * @param newMaxHp The new maximum health points.
   */
  def setMaxHp(newMaxHp: Int): Unit = {}

  /** Sets the current health points of the entity.
   *
   * @param newCurrentHp The new current health points.
   */
  def setCurrentHp(newCurrentHp: Int): Unit = {}

  /** Sets the attack points of the entity.
   *
   * @param newAttackPts The new attack points.
   */
  def setAttackPts(newAttackPts: Int): Unit = {}

  /** Sets the defense points of the entity.
   *
   * @param newDefensePts The new defense points.
   */
  def setDefensePts(newDefensePts: Int): Unit = {}

  /** Sets the evasion points of the entity.
   *
   * @param newEvasionPts The new evasion points.
   */
  def setEvasionPts(newEvasionPts: Int): Unit = {}

  /**  Sets the number of stars of the entity.
   *
   * @param newStars The new number of stars.
   */
  def setStars(newStars: Int): Unit = {}

  /** Sets the number of wins of the entity.
   *
   * @param newWins The new number of wins.
   */
  def setWins(newWins: Int): Unit = {}

  /** Reduces the current health points by the damage quantity specified.
   *
   * @param qty The quantity of damage to take.
   */
  def takeDmg(qty: Int): Unit = {}

  /** Inflicts a certain amount of damage on another game entity.
   *
   * @param someone The entity to do damage to.
   * @param qty     The quantity of damage to inflict.
   */
  def doDmg(someone: GameEntity, qty: Int): Unit = {}

  /** Performs an attack on another game entity.
   *
   * @param someone The entity to attack.
   * @param qty     The quantity of the attack.
   */
  def attack(someone: GameEntity, qty: Int): Unit = {}

  /** Defends against an attack from another game entity.
   *
   * @param fromSomeone The entity from which to defend.
   * @param qty         The quantity of the damage.
   */
  def defend(fromSomeone: GameEntity, qty: Int): Unit = {}

  /** Attempts to evade an attack from another game entity.
   *
   * @param formSomeone The entity from which to evade.
   * @param qty         The quantity of the damage.
   */
  def evade(formSomeone: GameEntity, qty: Int): Unit = {}

}
