package cl.uchile.dcc.citric
package model.gameunits


abstract class Entities (var maxHp: Int, var attackPts: Int, var defensePts: Int, var evasionPts: Int) extends GameEntity {

  var currentHp: Int = maxHp
  var stars: Int = _
  var wins: Int = _

  override def setMaxHp(newMaxHp: Int): Unit = {
    maxHp = newMaxHp
  }
  override def setCurrentHp(newCurrentHp: Int): Unit = {
    currentHp = newCurrentHp
  }
  override def setAttackPts(newAttackPts: Int): Unit = {
    attackPts = newAttackPts
  }
  override def setDefensePts(newDefensePts: Int): Unit = {
    defensePts = newDefensePts
  }
  override def setEvasionPts(newEvasionPts: Int): Unit = {
    evasionPts = newEvasionPts
  }
  /** sets (updates) the stars of an entity */
  override def setStars(newStars: Int): Unit = {
    stars = newStars
  }
  /** sets (updates) the stars of an entity */
  override def setWins(newWins: Int): Unit = {
    wins = newWins
  }

  override def takeDmg(qty: Int): Unit = {
    if (qty < 0) {
      throw new IllegalArgumentException("Quantity of damage must be non-negative")
    }
    currentHp -= qty
  }

  def doDmg(someone: Entities, qty: Int): Unit = {
    if (qty < 0) {
      throw new IllegalArgumentException("Quantity of damage must be non-negative")
    }
    someone.currentHp -= qty
  }

  def attack(someone: Entities, qty: Int): Unit = {
    assert(someone.currentHp > 0, "Player is K.O.")

    //qty of dmg done code here

    doDmg(someone, qty)
    if (someone.currentHp <= 0) {
      someone.setCurrentHp(0)
      //goes to K0 state
    }
  }

  def defend(fromSomeone: Entities, qty: Int): Unit = {
    //qty of dmg taken (while defending) code here
    //qty can´t be less than 1
    takeDmg(qty)
    if (currentHp <= 0) {
      setCurrentHp(0)
      //goes to K0 state
    }
  }

  def evade(formSomeone: Entities, qty: Int): Unit = {
    if (true) {
      takeDmg(0)
    }
    else {
      //qty of dmg taken (while evading) code here
      takeDmg(qty)
      if (currentHp <= 0) {
        //goes to K0 state
      }
    }
  }
}