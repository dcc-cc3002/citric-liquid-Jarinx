package cl.uchile.dcc.citric
package model.gameunits

import cl.uchile.dcc.citric.exceptions.Require
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.{TWildUnit, WildUnit}

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
  override var _isDead: Boolean = false

  override def currentHp_(newCurrentHp: Int): Unit = {
    _currentHp = math.max(0, newCurrentHp)
    if (_currentHp > _maxHp) {
      _currentHp = _maxHp
    }
    else if (_currentHp == 0) {
      _isDead = true
    }
    else {
      _isDead = false
    }
  }

  override def stars_(newStars: Int): Unit = {
    _stars = math.max(0, newStars)
  }

  override def wins_(newWins: Int): Unit = {
    _wins = math.max(0, newWins)
  }

  override def rollDice(): Int = {
    _randomNumberGenerator.nextInt(6) + 1
  }

  override def inRecovery: Boolean = _isDead

  override def takeDmg(qty: Int, option: Int): Unit = {
    if (qty < 0) {
      throw new IllegalArgumentException("Quantity of damage must be non-negative")
    }
    else {
      if (option == 1) {
        defend(qty)
      }
      else if (option == 2){
        evade(qty)
      }
    }
  }

  override def attack(someone: GameEntity): Int = {
    if (this.currentHp == 0) { // if the attacker is KO'd
      throw new IllegalArgumentException("You're in Recovery State (Unable to attack)")
    }
    else if (someone.currentHp == 0){ // if the attacked entity is KO'd
      throw new IllegalArgumentException("You can´t attack a KO'd entity")
    }
    else {
      val totalAtkPts: Int = attackPts + rollDice()
      totalAtkPts
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
      return
    }
    else {
      val dmgReceived: Int = attackPts + roll
      this.currentHp_(this.currentHp - attackPts)
    }
  }

  override def rewardFromPlayer(player: PlayerCharacter): Unit

  override def rewardFromWU(wildUnit: TWildUnit): Unit

  override def overthrownBy(attacker: GameEntity): Unit
}