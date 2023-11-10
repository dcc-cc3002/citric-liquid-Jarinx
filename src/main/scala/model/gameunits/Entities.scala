package cl.uchile.dcc.citric
package model.gameunits

/** Abstract class representing a specific type of game entity with  maximum health, attack, defense, and evasion points.
 *
 * @constructor Create a new entity with specified maximum health, attack, defense, and evasion points.
 * @param maxHp The maximum health points of the entity.
 * @param attackPts The attack points of the entity.
 * @param defensePts The defense points of the entity.
 * @param evasionPts The evasion points of the entity.
 */
abstract class Entities (var maxHp: Int, var attackPts: Int, var defensePts: Int, var evasionPts: Int) extends GameEntity {

  var currentHp: Int = maxHp // Initializes current health points to the maximum.
  var stars: Int = _ // The number of stars associated with the entity (uninitialized).
  var wins: Int = _ // The number of wins the entity has achieved (uninitialized).

  /** Sets the maximum health points of the entity.
   *
   * @param newMaxHp The new maximum health points.
   */
  override def setMaxHp(newMaxHp: Int): Unit = {
    maxHp = newMaxHp
  }

  /** Sets the current health points of the entity.
   *
   * @param newCurrentHp The new current health points.
   */
  override def setCurrentHp(newCurrentHp: Int): Unit = {
    currentHp = newCurrentHp
  }

  /** Sets the attack points of the entity.
   *
   * @param newAttackPts The new attack points.
   */
  override def setAttackPts(newAttackPts: Int): Unit = {
    attackPts = newAttackPts
  }

  /** Sets the defense points of the entity.
   *
   * @param newDefensePts The new defense points.
   */
  override def setDefensePts(newDefensePts: Int): Unit = {
    defensePts = newDefensePts
  }

  /** Sets the evasion points of the entity.
   *
   * @param newEvasionPts The new evasion points.
   */
  override def setEvasionPts(newEvasionPts: Int): Unit = {
    evasionPts = newEvasionPts
  }

  /** Sets the number of stars of the entity.
   *
   * @param newStars The new number of stars.
   */
  override def setStars(newStars: Int): Unit = {
    stars = newStars
  }

  /** Sets the number of wins of the entity.
   *
   * @param newWins The new number of wins.
   */
  override def setWins(newWins: Int): Unit = {
    wins = newWins
  }

  /** Reduces the current health points by the damage quantity specified.
   *
   * @param qty The quantity of damage to take.
   * @throws IllegalArgumentException If the damage quantity is negative.
   */
  override def takeDmg(qty: Int): Unit = {
    if (qty < 0) {
      throw new IllegalArgumentException("Quantity of damage must be non-negative")
    }
    currentHp -= qty
  }

  /** Inflicts damage on another entity.
   *
   * @param someone The entity to do damage to.
   * @param qty     The quantity of damage to inflict.
   * @throws IllegalArgumentException If the damage quantity is negative.
   */
  def doDmg(someone: Entities, qty: Int): Unit = {
    if (qty < 0) {
      throw new IllegalArgumentException("Quantity of damage must be non-negative")
    }
    someone.currentHp -= qty
  }

  /** Performs an attack on another entity.
   *
   * @param someone The entity to attack.
   * @param qty     The quantity of the attack.
   * @throws AssertionError If the target entity is already knocked out.
   */
  def attack(someone: Entities, qty: Int): Unit = {
    assert(someone.currentHp > 0, "Player is K.O.")

    //qty of dmg done code here

    doDmg(someone, qty)
    if (someone.currentHp <= 0) {
      someone.setCurrentHp(0)
      //goes to K0 state
    }
  }

  /** Defends against an attack from another entity.
   *
   * @param fromSomeone The entity from which to defend.
   * @param qty         The quantity of the damage inflicted by the entity.
   */
  def defend(fromSomeone: Entities, qty: Int): Unit = {
    //qty of dmg taken (while defending) code here
    //qty can´t be less than 1
    takeDmg(qty)
    if (currentHp <= 0) {
      setCurrentHp(0)
      //goes to K0 state
    }
  }

  /** Attempts to evade an attack from another entity.
   *
   * @param formSomeone The entity from which to evade.
   * @param qty         The quantity of the damage inflicted by the entity.
   */
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