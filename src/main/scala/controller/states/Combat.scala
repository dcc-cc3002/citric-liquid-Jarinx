package cl.uchile.dcc.citric
package controller.states

import controller.{GameController, GameState}

class CombatState(controller: GameController) extends GameState(controller) {
  override def attack(): Unit = {
    // Lógica para atacar
  }

  override def defend(): Unit = {
    // Lógica para defender
  }

  override def evade(): Unit = {
    // Lógica para evadir
  }

  override def endCombat(): Unit = {
    controller.changeState(new WaitState(controller))
  }
}