package cl.uchile.dcc.citric
package model

trait Entity {
  val maxHp: Int = 10
  var currentHp: Int = 10
  val attack: Int = 1
  val defense: Int = 1
  val evasion: Int = 1

  def takeDmg(qty: Int): Int = {
    currentHp -= qty
    return currentHp
  }
  def doDmg(someone: Entity, qty: Int): Int = {
    currentHp -= qty
    return currentHp
  }
}
