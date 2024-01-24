package cl.uchile.dcc.citric
package controller.states.panel

import controller.GameController
import controller.states.{Chapter, GameState}

import cl.uchile.dcc.citric.controller.states.combat.Combat
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.Panel
import cl.uchile.dcc.citric.model.panels.concretepanels.EncounterPanel

/** This state represents that a player has landed on a panel, and therefore
 * a certain effect should happen
 *
 * @param controller controls the flow of the game
 */
class LandingPanel(controller: GameController) extends GameState(controller) {

  override def doAction(): Unit = {
    val player = controller.currentPlayer()
    val currentPanel = player.standingIn.get

    doEffect(player, currentPanel)

    controller.changeState(new Chapter(controller))
  }
  override def doEffect(player: PlayerCharacter, panel: Panel): Unit = {

    panel.apply(player)

    panel match {
      case encounterPanel: EncounterPanel =>
        var currentEnemy = encounterPanel.enemy.get
        controller.receiver_(currentEnemy)

        controller.changeState(new Combat(controller))

      case _ =>
    }

  }

}
