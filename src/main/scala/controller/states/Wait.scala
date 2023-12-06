package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class WaitState(controller: GameController) extends GameState(controller) {
  override def waiting(): Unit = {
    // Lógica para esperar
  }
}
