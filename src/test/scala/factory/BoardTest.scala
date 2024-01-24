package cl.uchile.dcc.citric
package factory

import cl.uchile.dcc.citric.controller.factory.BoardBuilder
import cl.uchile.dcc.citric.controller.factory.gameunitsfactory.PlayerCharacterFactory
import cl.uchile.dcc.citric.exceptions.FactoryConfigError
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class BoardTest extends munit.FunSuite {
  var playerFactory: PlayerCharacterFactory = _
  var boardBuilder: BoardBuilder = _
  var players: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty

  override def beforeEach(context: BeforeEach): Unit = {
    playerFactory = new PlayerCharacterFactory
    boardBuilder = new BoardBuilder(players)
    players.clear()
  }

  test("A board can be built if all 4 players were created"){
    val player1 = playerFactory.createPlayer("player1")
    val player2 = playerFactory.createPlayer("player2")
    val player3 = playerFactory.createPlayer("player3")
    val player4 = playerFactory.createPlayer("player4")
    val seq = Seq(player1, player2, player3, player4)
    players ++= seq

    boardBuilder.buildBoard()
  }

  test("If less than 4 players were created, a board cannot be built"){
    val player1 = playerFactory.createPlayer("player1")
    val player2 = playerFactory.createPlayer("player2")
    val seq = Seq(player1, player2)
    players ++= seq

    val thrown = intercept[FactoryConfigError] {
      boardBuilder.buildBoard()
    }
    assert(thrown.getMessage.contains("4 players are needed to build the board"))
  }

  test("A game board is of type ArrayBuffer, which contains all panels"){
    val player1 = playerFactory.createPlayer("player1")
    val player2 = playerFactory.createPlayer("player2")
    val player3 = playerFactory.createPlayer("player3")
    val player4 = playerFactory.createPlayer("player4")
    val seq = Seq(player1, player2, player3, player4)
    players ++= seq

    boardBuilder.buildBoard()

    val board = boardBuilder.getBoard

    assert(board.isInstanceOf[ArrayBuffer[PlayerCharacter]])
  }

}
