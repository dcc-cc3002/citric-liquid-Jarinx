package cl.uchile.dcc.citric
package controller

trait HasState[T] {
  def setState(s: GameState[T]): Unit
}