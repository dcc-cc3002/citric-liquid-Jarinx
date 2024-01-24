package cl.uchile.dcc.citric
package controller.states.combat

import controller.GameController
import controller.states.GameState

import cl.uchile.dcc.citric.model.gameunits.GameEntity
import cl.uchile.dcc.citric.view.Prompt

/** This state represents the actions of the attacked entity
 *
 * @param controller controls the flow of the game
 */
class Wait(controller: GameController) extends GameState(controller) with Prompt{

  override def doAction(): Unit = {
    val receiver = controller._receiver.get
    if (controller.counter == 1) { // chose to defend
      defend(receiver)
    }
    else { // chose to evade
      evade(receiver)
    }
    controller.changeState(new Combat(controller))
  }
  override def evade(receiver: GameEntity): Unit = {
    val totalAttack: Int = controller.totalAtk
    val evasion = receiver.takeDmg(totalAttack, 2)
    if (receiver.currentHp == 0) {
      promptDeadPlayer(receiver, controller._attacker.get)
      receiver._isDead = true
      controller.changeState(new Combat(controller))
      controller.endCombat()
    }
    else if (evasion) {
      println(s"Evasion is a success! ${receiver.name} is intact!")
    }
    else {
      println(s"Evasion failed! ${receiver.name} remaining HP: ${receiver.currentHp} / ${receiver.maxHp}. ")
    }
  }

  override def defend(receiver: GameEntity): Unit = {
    val totalAttack: Int = controller.totalAtk
    val defense = receiver.takeDmg(totalAttack, 1)
    if (receiver.currentHp == 0) {
      promptDeadPlayer(receiver, controller._attacker.get)
      receiver._isDead = true
      controller.changeState(new Combat(controller))
      controller.endCombat()
    }
    else if (defense) {
      println(s"Successfully defended! ${receiver.name} finished the battle" +
        s" with this amount of HP still intact: ${receiver.currentHp} / ${receiver.maxHp}")
    }
    else {
      println(s"Defense failed! ${receiver.name} remaining HP: ${receiver.currentHp} / ${receiver.maxHp}. ")
    }
  }

}
