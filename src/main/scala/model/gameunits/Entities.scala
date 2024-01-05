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
    _currentHp = math.min(0, newCurrentHp)
  }

  override def stars_(newStars: Int): Unit = {
    _stars = math.min(0, newStars)
  }

  override def wins_(newWins: Int): Unit = {
    _wins = math.min(0, newWins)
  }

  override def rollDice(): Int = {
    _randomNumberGenerator.nextInt(6) + 1
  }


  override def takeDmg(qty: Int): Unit = {
    if (qty < 0) {
      throw new IllegalArgumentException("Quantity of damage must be non-negative")
    }
    else {
      val roll = rollDice()
      if (roll > 3) {
        defend(qty)
      }
      else {
        evade(qty)
      }
    }
  }

  override def attack(someone: GameEntity): Unit = {
    if (this.currentHp == 0) { // if the attacker is KO'd
      throw new IllegalArgumentException("You're in Recovery State (Unable to attack)")
    }
    else if (someone.currentHp == 0){ // if the attacked entity is KO'd
      throw new IllegalArgumentException("You can´t attack a KO'd entity")
    }
    else {
      val totalAtkPts: Int = attackPts + rollDice()
      someone.takeDmg(totalAtkPts)
    }
  }

  override def defend(qty: Int): Unit = {
    val dmgReceived: Int = math.max(1, qty - (rollDice() + this.defensePts))
    this.currentHp_(this.currentHp - dmgReceived)
    if (this.currentHp == 0) {
      // recovery
    }
  }

  override def evade(qty: Int): Unit = {
    val roll: Int = rollDice()
    val eva: Int = roll + this.evasionPts
    if (eva > qty) {
      takeDmg(0)
    }
    else {
      takeDmg(qty)
      if (this.currentHp == 0){
        //recovery
      }
    }
  }
}