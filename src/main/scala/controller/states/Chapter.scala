package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class ChapterState(controller: GameController) extends GameState(controller) {
  override def playTurn(): Unit = {
    controller.changeState(new PlayerTurnState(controller))
  }

  override def norma6Reached(): Unit = {
    controller.changeState(new EndGameState(controller))
  }
}
