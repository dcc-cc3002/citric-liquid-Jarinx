package cl.uchile.dcc.citric
package controller.states.lifecycle

import controller.GameController
import controller.states.GameState
import view.Prompt

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter

/** Once a player reaches Norma 6. the game ends. This state represents that,
 * the ending of the game.
 *
 * @param controller controls the flow of the game
 */
class EndGame(controller: GameController) extends GameState(controller)
                                              with Prompt {

  override def doAction(): Unit = {
    val winner: PlayerCharacter = controller.winner.get
    val chapter: Int = controller.chapter
    promptEndGame(winner, chapter)
  }

}
