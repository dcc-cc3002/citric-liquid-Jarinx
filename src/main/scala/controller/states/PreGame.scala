package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class PreGameState(controller: GameController) extends GameState(controller) {
  override def startGame(): Unit = {
    controller.changeState(new ChapterState(controller))
  }
}
