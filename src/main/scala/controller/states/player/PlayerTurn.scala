package cl.uchile.dcc.citric
package controller.states.player

import controller.GameController
import controller.states.GameState

/** This state represents a player's turn. A player simply rolls a dice
 *
 * @param controller controls the flow of the game
 */
class PlayerTurn(controller: GameController) extends GameState(controller) {
  override def rollDice(): Unit = {
    // do something
    controller.changeState(new Moving(controller))
  }

}
