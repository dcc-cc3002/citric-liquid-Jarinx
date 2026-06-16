package cl.uchile.dcc.citric
package controller.states.player

import controller.GameController
import controller.states.{Chapter, GameState}

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.view.Prompt

/** This state indicates that a player has 0 HP, and to exit
 * this state, they have to roll the dice and get a minimum amount to go on.
 * If they don't reach the min amount, their turn ends, otherwise, they continue
 * as normal.
 *
 * @param controller controls the flow of the game
 */
class Recovery(controller: GameController) extends GameState(controller) with Prompt {
  // the minimum roll the player has to get in order to recover.
  // the maximum needed decreases by 1 as the Chapters advance
  var requirement: Int = math.max(0, 6 - controller.chapter)

  override def doAction(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()
    player.recover(requirement)
    //if the player couldn't recover, ie, InRecovery is still true
    if(player.inRecovery){
      promptInsufficientRoll()
      insufficientRoll()
    }
    //if the player could recover, ie, InRecovery is false
    else{
      promptSufficientRoll()
      sufficientRoll()
    }
  }

  override def insufficientRoll(): Unit = {
    controller.nextTurn()
    controller.changeState(new Chapter(controller))
  }

  override def sufficientRoll(): Unit = {
    controller.changeState(new PlayerTurn(controller))
  }

}
