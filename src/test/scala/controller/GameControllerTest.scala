package cl.uchile.dcc.citric
package controller

import exceptions.InvalidTransitionException

import cl.uchile.dcc.citric.controller.factory.gameunitsfactory.PlayerCharacterFactory
import cl.uchile.dcc.citric.controller.states.Chapter
import cl.uchile.dcc.citric.controller.states.combat.{Combat, Wait}
import cl.uchile.dcc.citric.controller.states.panel.LandingPanel
import cl.uchile.dcc.citric.controller.states.player.{Moving, PlayerTurn, Recovery}
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.concretepanels.HomePanel
import cl.uchile.dcc.citric.view.MockView

class GameControllerTest extends munit.FunSuite {

  var game: GameController = _
  var playerFactory: PlayerCharacterFactory = _
  private var panelH: HomePanel = _
  var mockView: MockView = _

  override def beforeEach(context: BeforeEach): Unit = {
    game = new GameController
    playerFactory = new PlayerCharacterFactory
    mockView = new MockView(Iterator("player1", "player2", "player3", "player4"))
  }

  test("The controller can end the game when the conditions are met (Norma 6)"){
    var player = playerFactory.createPlayer("Player1")
    panelH = new HomePanel(player)

    player.addObserver(game)
    player.standingIn_(panelH)
    panelH.addCharacter(player)

    player.stars_(500)
    player.wins_(200)

    player.target_(Some(1))

    assert(game.winner.isEmpty)

    for (_ <- 2 to 6) {
      panelH.apply(player)
    }

    game.update(player, player)

    assert(player.norma._number == 6)
    assert(game.winner.isDefined)

    assertEquals(player, game.winner.get)
  }

  test("The controller simulates an entire match"){
    assert(game.winner.isEmpty)
    game.setMockView(mockView)
    game.start()
    assert(game.winner.isDefined)
  }



}
