package cl.uchile.dcc.citric
package controller

class WrongStateException extends Exception("Wrong State!")

trait GameState[T] {
  def doDmg(t: T): Unit
  def giveStars(t: T): Unit
  def ko(t: T): Unit

  def isAlive(): Boolean
  def isKo(): Boolean
  def isFighting(): Boolean
}
abstract class AbstractGameState[T <: HasState[T]] extends GameState[T] {
  def error = throw new WrongStateException()

  def doDmg(t: T): Unit = error
  def giveStars(t: T): Unit = error
  def ko(t: T): Unit = error

  def isAlive(): Boolean = false
  def isKo(): Boolean = false
  def isFighting(): Boolean = false

  protected def changeState(t: T, s: GameState[T]) = t.setState(s)
}
class Alive[T <: HasState[T]] extends AbstractGameState[T] {
  override def doDmg(t: T): Unit =
    changeState(t, new Ko())
  override def isAlive() = true
}

class Ko[T <: HasState[T]] extends AbstractGameState[T] {
  override def giveStars(t: T): Unit =
    changeState(t, new Fighting())
  override def isKo() = true
}
class Fighting[T <: HasState[T]] extends AbstractGameState[T] {
  override def ko(t: T): Unit =
    changeState(t, new Alive())
  override def isFighting() = true
}
