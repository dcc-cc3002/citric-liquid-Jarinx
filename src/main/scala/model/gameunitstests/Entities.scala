package cl.uchile.dcc.citric
package model.gameunitstests

import cl.uchile.dcc.citric.exceptions.Require
import cl.uchile.dcc.citric.model.gameunitstests.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunitstests.wildunits.{TWildUnit, WildUnit}

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

  override var _currentHp: Int = _maxHp
  override var _stars: Int = 0
  override var _wins: Int = 0
  override var _alive: Boolean = false

  override def currentHp_(newCurrentHp: Int): Unit = {
    _currentHp = math.min(0, newCurrentHp)
    if (_currentHp == 0) {
      _alive = false
    }
    else {
      _alive = true
    }
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

  override def inRecovery: Boolean = _alive

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
  }

  override def evade(qty: Int): Unit = {
    val roll: Int = rollDice()
    val eva: Int = roll + this.evasionPts
    if (eva > qty) {
      takeDmg(0)
    }
    else {
      takeDmg(qty)
    }
  }

  override def rewardFromPlayer(player: PlayerCharacter): Unit

  override def rewardFromWU(wildUnit: TWildUnit): Unit

  override def overthrownBy(attacker: GameEntity): Unit
}