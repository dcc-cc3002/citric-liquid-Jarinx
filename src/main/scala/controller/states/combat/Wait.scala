package cl.uchile.dcc.citric
package controller.states.combat

import controller.GameController
import controller.states.GameState

/** This state represents the actions of the attacked entity
 *
 * @param controller controls the flow of the game
 */
class Wait(controller: GameController) extends GameState(controller) {
  override def evade(): Unit = {
    //do something
    controller.changeState(new Combat(controller))
  }

  override def defend(): Unit = {
    //do something
    controller.changeState(new Combat(controller))
  }

}
