package cl.uchile.dcc.citric
package model

trait Entity {
  val maxHp: Int
  val currentHp: Int
  val attack: Int
  val defense: Int
  val evasion: Int

  def takeDmg(qty: Int): Unit
  def doDmg(someone: Entity): Unit
}
