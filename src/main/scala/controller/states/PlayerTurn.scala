package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class PlayerTurnState(controller: GameController) extends GameState(controller) {
  override def rollDice(): Unit = {
    controller.changeState(new MovingState(controller))
  }

  override def insufficientRoll(): Unit = {
    controller.changeState(new RecoveryState(controller))
  }

  override def isKo(): Unit = {
    controller.changeState(new RecoveryState(controller))
  }
}
