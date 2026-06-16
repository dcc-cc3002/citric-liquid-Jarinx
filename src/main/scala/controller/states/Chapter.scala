package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.controller.states.lifecycle.EndGame
import cl.uchile.dcc.citric.controller.states.player.{PlayerTurn, Recovery}
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.view.Prompt

/** State that indicates the game rounds. Once all 4 players
 * have finished their turns, a new round, ie, a new Chapter begins.
 * A Chapter is simply a counter.
 * *
 * @param controller controls the flow of the game
 */
class Chapter(controller: GameController) extends GameState(controller) with Prompt{

  controller.nextTurn()

  override def doAction(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()

    if(player.norma._number == 6){
      norma6Reached()
    }
    else if (player.currentHp == 0){
      isKo()
    }
    else{
      playTurn()
    }
  }

//  override def newChapter(): Unit = {
//    val currentChapter = controller.chapter
//    print(s"Finished Chapter number $currentChapter. ")
//    val newChapter = currentChapter + 1
//    controller.chapter_(newChapter)
//    println(s"Starting Chapter number $newChapter...")

//    controller.changeState(new Chapter(controller))
//  }

  override def norma6Reached(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()
    controller.winner_(player)
    controller.changeState(new EndGame(controller))
    controller.doAction()
  }

  override def isKo(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()
    player._isDead = true
    controller.changeState(new Recovery(controller))
    controller.doAction()
  }

  override def playTurn(): Unit = {
    controller.changeState(new PlayerTurn(controller))
  }

}
