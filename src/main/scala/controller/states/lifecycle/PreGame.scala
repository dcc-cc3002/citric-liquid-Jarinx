package cl.uchile.dcc.citric
package controller.states.lifecycle

import controller.GameController
import controller.states.{Chapter, GameState}

/** State that indicates that the game is about to start, so in this state
 * every variable should be initialized (players, wild units, etc)
 *
 * @param controller controls the flow of the game
 */
class PreGame(controller: GameController) extends GameState(controller) {
  override def startGame(): Unit = {
    // do something
    controller.changeState(new Chapter(controller))
  }

}
