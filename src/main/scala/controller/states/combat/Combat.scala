package cl.uchile.dcc.citric
package controller.states.combat

import controller.GameController
import controller.states.GameState
import cl.uchile.dcc.citric.controller.states.panel.LandingPanel

/** This state represents that a player is in a combat (PvP or PvE)
 *
 * @param controller controls the flow of the game
 */
class Combat(controller: GameController) extends GameState(controller) {
  override def attack(): Unit = {
    // do something
    controller.changeState(new Wait(controller))
  }

  override def endCombat(): Unit = {
    // do something
    controller.changeState(new LandingPanel(controller))
  }

}
