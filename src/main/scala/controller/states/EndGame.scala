package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class EndGameState(controller: GameController) extends GameState(controller) {
  override def endGame(): Unit = {
    // Lógica para terminar el juego
  }
}
