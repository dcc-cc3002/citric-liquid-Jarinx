package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class RecoveryState(controller: GameController) extends GameState(controller) {
  override def sufficientRoll(): Unit = {
    controller.changeState(new PlayerTurnState(controller))
  }
}
