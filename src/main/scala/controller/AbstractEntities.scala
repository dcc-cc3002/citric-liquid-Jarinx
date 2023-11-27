package cl.uchile.dcc.citric
package controller

abstract class AbstractEntities[T] extends HasState[AbstractEntities[T]] {
  private var state: GameState[AbstractEntities[T]] = new Alive()

  def setState(s: GameState[AbstractEntities[T]]) = state = s
  def doDmg(): Unit = state.doDmg(this)
  def giveStars(): Unit = state.giveStars(this)
  def ko(): Unit = state.ko(this)

  def isAlive(): Boolean = state.isAlive()
  def isKo(): Boolean = state.isKo()
  def isFighting(): Boolean = state.isFighting()
}