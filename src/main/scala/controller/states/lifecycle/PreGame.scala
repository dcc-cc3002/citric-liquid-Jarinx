package cl.uchile.dcc.citric
package controller.states.lifecycle

import controller.GameController
import controller.states.{Chapter, GameState}

import cl.uchile.dcc.citric.controller.factory.BoardBuilder
import cl.uchile.dcc.citric.controller.factory.gameunitsfactory.PlayerCharacterFactory
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.Panel
import cl.uchile.dcc.citric.view.Prompt

import scala.collection.mutable.ArrayBuffer

/** State that indicates that the game is about to start, so in this state
 * every variable should be initialized (players, wild units, etc)
 *
 * @param controller controls the flow of the game
 */
class PreGame(controller: GameController) extends GameState(controller) with Prompt{

  var playerFactory: PlayerCharacterFactory = new PlayerCharacterFactory

  override def doAction(): Unit = {
    promptStartGame()
    val players: ArrayBuffer[PlayerCharacter] = arrangePlayers()
    val boardBuilder = new BoardBuilder(players) // factory for building the board
    boardBuilder.buildBoard()
    val board: ArrayBuffer[Panel] = boardBuilder.getBoard // the game board
    promptBoard()

    controller.changeState(new Chapter(controller))
  }

  private def arrangePlayers(): ArrayBuffer[PlayerCharacter] = {
    var players: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty // array of players
    for (i <- 1 to 4) {
      var name: String =
        controller.view.readStringInput(s"Enter the name of player $i: ")

      if (name.isEmpty) {
        println("You didn't enter anything, please retry.\n")
        controller.view.readStringInput(s"Enter the name of player $i: ")
      }

      var player = playerFactory.createPlayer(name)

      players += player

      player.addObserver(controller)
      player.notifyObservers(player)

      controller.addPlayer(player)

      promptShowStats(player)
    }
    players
  }

}
