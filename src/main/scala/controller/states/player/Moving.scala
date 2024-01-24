package cl.uchile.dcc.citric
package controller.states.player

import controller.GameController
import controller.states.GameState
import controller.states.combat.Combat

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.Panel
import cl.uchile.dcc.citric.model.panels.concretepanels.HomePanel
import cl.uchile.dcc.citric.view.Prompt

/** This state indicates that a player is moving throughout the board.
 *
 * @param controller controls the flow of the game
 */
class Moving(controller: GameController) extends GameState(controller) with Prompt{

  override def doAction(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()
    var movesLeft = controller.moves

    promptMovesLeft(movesLeft)

    while(choosePath(player)){
      promptCurrentPanel(player.standingIn.get)
      promptMovesLeft(controller.moves - 1)
      controller.moves_(controller.moves - 1)
    }

    outOfMovements()

  }

  override def choosePath(player: PlayerCharacter): Boolean = {
    if (controller.moves == 0) {
      false
    }
    else {
      var currentPanel = player.standingIn.get
      var nextPanel = currentPanel._nextPanels

      if (controller.chapter == 1) {
        if (currentPanel.nextPanelsAmount == 1) {
          controller.movePanels(nextPanel(0))
          true
        }
        else {
          val panelChosen = controller.view.readIntInput1toX(promptPathBranch(), 1, 2)
          // panelChosen: 1 -> straight ahead ; 2 -> turn left
          controller.movePanels(nextPanel(panelChosen - 1))
          true
        }
      }

      else {
        if (currentPanel.ownerInPanel(player) && controller.moves > 0 && stopMovement()) {
          false
        }
        else if (currentPanel.nextPanelsAmount == 1) {
          controller.movePanels(nextPanel(0))
          true
        }
        else {
          val panelChosen = controller.view.readIntInput1toX(promptPathBranch(), 1, 2)
          // panelChosen: 1 -> straight ahead ; 2 -> turn left
          controller.movePanels(nextPanel(panelChosen - 1))
          true
        }
      }
    }
  }

  override def stopMovement(): Boolean = {
    var choice = controller.view.readIntInput1toX(promptStopMoving(), 1, 2)
    if (choice == 1) { // player chose to stop
      controller.moves_(0)
      true
    }
    else { // player chose to keep going
      false
    }
  }

  override def outOfMovements(): Unit = {
    controller.moves_(0)
    controller.changeState(new Combat(controller))
  }



}
