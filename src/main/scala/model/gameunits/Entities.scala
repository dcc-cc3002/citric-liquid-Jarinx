package cl.uchile.dcc.citric
package model.gameunits

import cl.uchile.dcc.citric.exceptions.Require

import scala.util.Random

/** Abstract class representing a specific type of game entity with  maximum health, attack, defense, and evasion points.
 *
 * @constructor Create a new entity with specified maximum health, attack, defense, and evasion points.
 * @param _maxHp The maximum health points of the entity.
 * @param _attackPts The attack points of the entity.
 * @param _defensePts The defense points of the entity.
 * @param _evasionPts The evasion points of the entity.
 */
abstract class Entities (val _maxHp: Int,
                         val _attackPts: Int,
                         val _defensePts: Int,
                         val _evasionPts: Int,
                         var _randomNumberGenerator: Random = new Random())
                        extends GameEntity {

  var _currentHp: Int = _maxHp // Initializes current health points to the maximum.
  var _stars: Int = 0 // The number of stars associated with the entity (uninitialized).
  var _wins: Int = 0 // The number of wins the entity has achieved (uninitialized).

  override def currentHp_(newCurrentHp: Int): Unit = {
    _currentHp = Require.Stat(newCurrentHp, "Current HP").in(0 to _maxHp)
  }

  override def stars_(newStars: Int): Unit = {
    _stars = Require.Stat(newStars, "Stars").atLeast(0)
  }

  override def wins_(newWins: Int): Unit = {
    _wins = Require.Stat(newWins, "Wins").atLeast(0)
  }

  override def rollDice(): Int = {
    _randomNumberGenerator.nextInt(6) + 1
  }

//  /** Reduces the current health points by the damage quantity specified.
//   *
//   * @param qty The quantity of damage to take.
//   * @throws IllegalArgumentException If the damage quantity is negative.
//   */
//  override def takeDmg(qty: Int): Unit = {
//    if (qty < 0) {
//      throw new IllegalArgumentException("Quantity of damage must be non-negative")
//    }
//    _currentHp -= qty
//  }
//
//  /** Inflicts damage on another entity.
//   *
//   * @param someone The entity to do damage to.
//   * @param qty     The quantity of damage to inflict.
//   * @throws IllegalArgumentException If the damage quantity is negative.
//   */
//  def doDmg(someone: Entities, qty: Int): Unit = {
//    if (qty < 0) {
//      throw new IllegalArgumentException("Quantity of damage must be non-negative")
//    }
//    someone._currentHp -= qty
//  }

  override def attack(someone: GameEntity, qty: Int): Unit = {
    assert(someone._currentHp > 0, "Player is K.O.")

    //qty of dmg done code here

//    doDmg(someone, qty)
    if (someone._currentHp <= 0) {
      someone.currentHp_(0)
      //goes to K0 state
    }
  }

  def defend(fromSomeone: GameEntity, qty: Int): Unit = {
    //qty of dmg taken (while defending) code here
    //qty can´t be less than 1
//    takeDmg(qty)
    if (_currentHp <= 0) {
      currentHp_(0)
      //goes to K0 state
    }
  }

  def evade(formSomeone: GameEntity, qty: Int): Unit = {
    if (true) {
//      takeDmg(0)
    }
    else {
      //qty of dmg taken (while evading) code here
//      takeDmg(qty)
      if (_currentHp <= 0) {
        //goes to K0 state
//        takeDmg(qty)
      }
    }
  }
}