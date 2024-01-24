package cl.uchile.dcc.citric
package controller.states.player

import controller.GameController
import controller.states.GameState

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.view.Prompt

/** This state represents a player's turn. A player simply rolls a dice
 *
 * @param controller controls the flow of the game
 */
class PlayerTurn(controller: GameController) extends GameState(controller) with Prompt{

  override def doAction(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()
    var playsTurn = controller.view.readStringInput(promptPlayerTurn(player))

    val currentChapter: Int = controller.chapter
    val chapterBonus: Int = (currentChapter / 5) + 1
    player.stars_(player.stars + chapterBonus)

    promptShowStats(player)
    promptRollDice(player)

    rollDice()
  }

  override def rollDice(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()
    var initialMoves: Int = player.rollDice()
    controller.moves_(initialMoves)
//    controller.view.promptMovesLeft(initialMoves)

    controller.changeState(new Moving(controller))
  }

}
