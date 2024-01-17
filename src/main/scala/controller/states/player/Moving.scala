package cl.uchile.dcc.citric
package controller.states.player

import controller.GameController
import controller.states.GameState
import controller.states.combat.Combat

/** This state indicates that a player is moving throughout the board.
 *
 * @param controller controls the flow of the game
 */
class Moving(controller: GameController) extends GameState(controller) {
  override def choosePath(): Unit = {
    // do something
    controller.changeState(new Moving(controller))
  }

  override def stopMovement(): Unit = {
    // do something
    controller.changeState(new Combat(controller))
  }

  override def outOfMovements(): Unit = {
    // do something
    controller.changeState(new Combat(controller))
  }

}
