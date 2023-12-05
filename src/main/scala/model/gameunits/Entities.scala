package cl.uchile.dcc.citric
package model.gameunits

import exceptions.InvalidStatException

import cl.uchile.dcc.citric.model.gameunits.wildunits.{Chicken, RoboBall, Seagull}

import scala.util.Random

/** Abstract class representing a specific type of game entity with  maximum health, attack, defense, and evasion points.
 *
 * @constructor Create a new entity with specified maximum health, attack, defense, and evasion points.
 * @param _maxHp The maximum health points of the entity.
 * @param _attackPts The attack points of the entity.
 * @param _defensePts The defense points of the entity.
 * @param _evasionPts The evasion points of the entity.
 */
abstract class Entities (var _maxHp: Int, var _attackPts: Int, var _defensePts: Int, var _evasionPts: Int) extends GameEntity {

  var _currentHp: Int = _maxHp // Initializes current health points to the maximum.
  var randomNumberGenerator: Random = new Random() // Random number generator for dice rolls.

  /** Returns the maximum health points of the entity. */
  override def maxHp: Int = _maxHp

  /** Returns the current health points of the entity. */
  override def currentHp: Int = _currentHp

  /** Returns the attack points of the entity. */
  override def attackPts: Int = _attackPts

  /** Returns the defense points of the entity. */
  override def defensePts: Int = _defensePts

  /** Returns the evasion points of the entity. */
  override def evasionPts: Int = _evasionPts

  /** Returns the current number of stars of the entity. */
  override def stars: Int = _stars

  /** Returns the current number of wins of the entity. */
  override def wins: Int = _wins

  /** Sets the maximum health points of the entity.
   *
   * @param newMaxHp The new maximum health points.
   */
  override def maxHp_(newMaxHp: Int): Unit = {
    _maxHp = newMaxHp
  }

  /** Sets the current health points of the entity.
   *
   * @param newCurrentHp The new current health points.
   * @throws InvalidStatException If the new currentHp is negative.
   */
  override def currentHp_(newCurrentHp: Int): Unit = {
    if (newCurrentHp < 0) {
      throw new InvalidStatException("HP cannot be negative.")
      _currentHp = 0
    }
    else {
      _currentHp = newCurrentHp
    }
  }

  /** Sets the attack points of the entity.
   *
   * @param newAttackPts The new attack points.
   */
  override def attackPts_(newAttackPts: Int): Unit = {
    _attackPts = newAttackPts
  }

  /** Sets the defense points of the entity.
   *
   * @param newDefensePts The new defense points.
   */
  override def defensePts_(newDefensePts: Int): Unit = {
    _defensePts = newDefensePts
  }

  /** Sets the evasion points of the entity.
   *
   * @param newEvasionPts The new evasion points.
   */
  override def evasionPts_(newEvasionPts: Int): Unit = {
    _evasionPts = newEvasionPts
  }

  /** Sets the number of stars of the entity.
   *
   * @param newStars The new number of stars.
   * @throws InvalidStatException If newStars is negative.
   */
  override def stars_(newStars: Int): Unit = {
    if (newStars < 0) {
      throw new InvalidStatException("Star count cannot be negative.")
    }
    else {
      _stars = newStars
    }

  }

  /** Sets the number of wins of the entity.
   *
   * @param newWins The new number of wins.
   */
  override def wins_(newWins: Int): Unit = {
    _wins = newWins
  }

  /** Rolls a dice and returns a value between 1 to 6. */
  override def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** Reduces the current health points by the damage quantity specified.
   *
   * @param qty The quantity of damage to take.
   * @throws InvalidStatException If the damage quantity is negative.
   */
  override def takeDmg(qty: Int): Unit = {
    if (qty < 0) {
      throw new InvalidStatException("Quantity of damage must be non-negative")
    }
    this.currentHp_(this.currentHp - qty)
  }

//  /** Inflicts damage on another entity.
//   *
//   * @param someone The entity to do damage to.
//   * @param qty     The quantity of damage to inflict.
//   * @throws InvalidStatException If the damage quantity is negative.
//   */
//  override def doDmg(someone: GameEntity, qty: Int): Unit = {
//    if (qty < 0) {
//      throw new InvalidStatException("Quantity of damage must be non-negative")
//    }
//    someone.currentHp_(-qty)
//  }

  override def attackedBy(attacker: GameEntity, qty: Int): Unit = {
    require(qty >= 0, "Damage cannot be negative.")
    handleAttack(this, attacker, qty)
  }

  protected def handleAttack(victim: GameEntity, attacker: GameEntity, qty: Int): Unit = {
    if (victim.currentHp == 0) {
      throw new InvalidStatException("You cannot attack a unit that is already K0'd.")
    }
    else if (attacker.currentHp == 0) {
      throw new InvalidStatException("A K0'd unit cannot attack.")
    }
    this.takeDmg(qty)
    if (this.currentHp == 0) {
      transferStarsAndWins(attacker, this)
    }
    else {
      this.attack(attacker)
    }
  }

  protected def transferStarsAndWins(attacker: GameEntity, victim: GameEntity): Unit = {
    victim.stars_(victim.stars - (victim.stars / 2))
    attacker.stars_(attacker.stars + (this.stars / 2))
  }


  /** Performs an attack on another entity.
   *
   * @param someone The entity to attack.
   * @param qty     The rolled amount
   * @throws InvalidStatException If the target entity is already knocked out.
   */
  override def attack(someone: GameEntity): Int = {
    if (someone.currentHp <= 0) {
      throw new InvalidStatException("You cannot attack a unit that is already K0'd.")
    }
    else if (this.currentHp == 0) {
      throw new InvalidStatException("A K0'd unit cannot attack.")
    }
    var totalDamage: Int = this.attackPts + this.rollDice()
    return totalDamage
  }

  /** Defends against an attack from another entity.
   *
   * @param fromSomeone The entity from which to defend.
   * @param qty         The quantity of the damage inflicted by the entity.
   */
  override def defend(fromSomeone: GameEntity): Unit = {
    val atkRoll = fromSomeone.rollDice()
    val defRoll = this.rollDice()
    val damageReceived = math.max(atkRoll + fromSomeone.attackPts - (defRoll + this.defensePts), 1) // Asegura un daño mínimo de 1

    this.attackedBy(fromSomeone, atkRoll + fromSomeone.attackPts)

  }

    /** Attempts to evade an attack from another entity.
     *
     * @param formSomeone The entity from which to evade.
     * @param qty         The quantity of the damage inflicted by the entity.
     */
  override def evade(fromSomeone: GameEntity): Unit = {
    val atkRoll = fromSomeone.rollDice()
    val evaRoll = this.rollDice()
    if (evaRoll + this.evasionPts > atkRoll + fromSomeone.attackPts) {
      this.takeDmg(0)
    }
    else {
      // Evade failed: Take full damage
      this.attackedBy(fromSomeone, fromSomeone.attackPts + atkRoll)

    }
  }
}