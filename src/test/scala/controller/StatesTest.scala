package cl.uchile.dcc.citric
package controller

import controller.states.lifecycle.{EndGame, PreGame}

import cl.uchile.dcc.citric.controller.factory.gameunitsfactory.PlayerCharacterFactory
import cl.uchile.dcc.citric.controller.states.Chapter
import cl.uchile.dcc.citric.controller.states.combat.{Combat, Wait}
import cl.uchile.dcc.citric.controller.states.panel.LandingPanel
import cl.uchile.dcc.citric.controller.states.player.{Moving, PlayerTurn, Recovery}
import cl.uchile.dcc.citric.exceptions.InvalidTransitionException
import cl.uchile.dcc.citric.model.panels.concretepanels.{HomePanel, NeutralPanel}
import cl.uchile.dcc.citric.view.MockView

class StatesTest extends munit.FunSuite {

  var game: GameController = _
  var mockView: MockView = _
  var playerFactory: PlayerCharacterFactory = _
  private var panelN: NeutralPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    game = new GameController
    mockView = new MockView(Iterator("player1", "player2", "player3", "player4"))
    playerFactory = new PlayerCharacterFactory
  }

  test("The game starts when the controller gets initialized"){
    val state = game.getState()
    assert(state.isInstanceOf[PreGame])
  }

  test("The game ends when a player has reached norma 6"){
    game.changeState(new EndGame(game))
    val state = game.getState()
      assert(state.isInstanceOf[EndGame])
  }

  test("A player in Recovery state cannot play") {
    val playerTurn: Int = 1
    val player = playerFactory.createPlayer("player1")
    val panelN = new NeutralPanel
    game.setMockView(mockView)
    player.standingIn_(panelN)
    panelN.addCharacter(player)
    player.currentHp_(0)

    game.start()

    assert(player.inRecovery)

  }

  test("From PreGame, a certain transition is permitted"){
    val permittedTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.doAction())
    permittedTransitions.foreach(transition => {
      game.setMockView(mockView)
      try transition(game)
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
    })
  }

  test("From PreGame, a certain transition is forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.newChapter())
    forbiddenTransitions.foreach(transition => {
      game.setMockView(mockView)
      try transition(game)
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
    })
  }

    test("From Recovery, certain transitions are permitted"){
      val permittedTransitions: List[GameController => Unit] = List(
        (game: GameController) => game.insufficientRoll(),
        (game: GameController) => game.sufficientRoll()
      )

      permittedTransitions.foreach(transition => {
        game.setMockView(mockView)
        game.changeState(new Recovery(game))
        try transition(game)
        catch {
          case e: InvalidTransitionException =>
            throw new AssertionError(e.getMessage)
        }
      })
    }

}
