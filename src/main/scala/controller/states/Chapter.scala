package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.controller.states.lifecycle.EndGame
import cl.uchile.dcc.citric.controller.states.player.{PlayerTurn, Recovery}

/** State that indicates the game rounds. Once all 4 players
 * have finished their turns, a new round, ie, a new Chapter begins.
 * A Chapter is simply a counter.
 * *
 * @param controller controls the flow of the game
 */
class Chapter(controller: GameController) extends GameState(controller){
  override def newChapter(): Unit = {
    // do something
    controller.changeState(new Chapter(controller))
  }

  override def norma6Reached(): Unit = {
    // do something
    controller.changeState(new EndGame(controller))
  }

  override def isKo(): Unit = {
    // do something
    controller.changeState(new Recovery(controller))
  }

  override def playTurn(): Unit = {
    // do something
    controller.changeState(new PlayerTurn(controller))
  }

}
