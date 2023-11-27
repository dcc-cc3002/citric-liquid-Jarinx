package cl.uchile.dcc.citric
package controller

class GameController {
  // Estado actual del juego
  var state: GameState[Alive[Null]] = new Alive

  def startGame(): Unit = {
    state.isAlive()
    /* ... */
  }

  def rollDice(): Unit = {
    /* ... */
  }

  def doEffect(): Unit = {
    /* ... */
  }
}
