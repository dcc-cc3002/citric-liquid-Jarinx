package cl.uchile.dcc.citric
package controller.states.player

import controller.GameController
import controller.states.{Chapter, GameState}

/** This state indicates that a player has 0 HP, and to exit
 * this state, they have to roll the dice and get a minimum amount to go on.
 * If they don't reach the min amount, their turn ends, otherwise, they continue
 * as normal.
 *
 * @param controller controls the flow of the game
 */
class Recovery(controller: GameController) extends GameState(controller) {
  override def insufficientRoll(): Unit = {
    // do something
    controller.changeState(new Chapter(controller))
  }

  override def sufficientRoll(): Unit = {
    // do something
    controller.changeState(new PlayerTurn(controller))
  }

}
