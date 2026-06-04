package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class MovingState(controller: GameController) extends GameState(controller) {
//  override def stopMovement(): Unit = {
//    controller.changeState(new LandingPanelState(controller))
//  }

  override def outOfMovements(): Unit = {
    controller.changeState(new CombatState(controller))
  }

  override def choosePath(): Unit = {
    // Lógica para elegir el camino
  }
}
