package cl.uchile.dcc.citric
package controller.states.panel

import controller.GameController
import controller.states.{Chapter, GameState}

/** This state represents that a player has landed on a panel, and therefore
 * a certain effect should happen
 *
 * @param controller controls the flow of the game
 */
class LandingPanel(controller: GameController) extends GameState(controller) {
  override def doEffect(): Unit = {
    // do something
    controller.changeState(new Chapter(controller))
  }

}
