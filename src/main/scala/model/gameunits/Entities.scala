package cl.uchile.dcc.citric
package model.gameunits

/** Abstract class representing a specific type of game entity with  maximum health, attack, defense, and evasion points.
 *
 * @constructor Create a new entity with specified maximum health, attack, defense, and evasion points.
 * @param _maxHp The maximum health points of the entity.
 * @param _attackPts The attack points of the entity.
 * @param _defensePts The defense points of the entity.
 * @param _evasionPts The evasion points of the entity.
 */
abstract class Entities (val _maxHp: Int, val _attackPts: Int, val _defensePts: Int, val _evasionPts: Int) extends GameEntity {

  var _currentHp: Int = _maxHp // Initializes current health points to the maximum.
  var _stars: Int = _ // The number of stars associated with the entity (uninitialized).
  var _wins: Int = _ // The number of wins the entity has achieved (uninitialized).


  /** Sets the current health points of the entity.
   *
   * @param newCurrentHp The new current health points.
   */
  override def currentHp_(newCurrentHp: Int): Unit = {
    _currentHp = newCurrentHp
  }

  /** Sets the number of stars of the entity.
   *
   * @param newStars The new number of stars.
   */
  override def stars_(newStars: Int): Unit = {
    _stars = newStars
  }

  /** Sets the number of wins of the entity.
   *
   * @param newWins The new number of wins.
   */
  override def wins_(newWins: Int): Unit = {
    _wins = newWins
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

  /** Performs an attack on another entity.
   *
   * @param someone The entity to attack.
   * @param qty     The quantity of the attack.
   * @throws AssertionError If the target entity is already knocked out.
   */
  override def attack(someone: GameEntity, qty: Int): Unit = {
    assert(someone._currentHp > 0, "Player is K.O.")

    //qty of dmg done code here

//    doDmg(someone, qty)
    if (someone._currentHp <= 0) {
      someone.currentHp_(0)
      //goes to K0 state
    }
  }

  /** Defends against an attack from another entity.
   *
   * @param fromSomeone The entity from which to defend.
   * @param qty         The quantity of the damage inflicted by the entity.
   */
  def defend(fromSomeone: GameEntity, qty: Int): Unit = {
    //qty of dmg taken (while defending) code here
    //qty can´t be less than 1
//    takeDmg(qty)
    if (_currentHp <= 0) {
      currentHp_(0)
      //goes to K0 state
    }
  }

  /** Attempts to evade an attack from another entity.
   *
   * @param formSomeone The entity from which to evade.
   * @param qty         The quantity of the damage inflicted by the entity.
   */
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