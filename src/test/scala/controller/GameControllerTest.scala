package cl.uchile.dcc.citric
package controller

import exceptions.InvalidTransitionException

import cl.uchile.dcc.citric.controller.states.Chapter
import cl.uchile.dcc.citric.controller.states.combat.{Combat, Wait}
import cl.uchile.dcc.citric.controller.states.panel.LandingPanel
import cl.uchile.dcc.citric.controller.states.player.{Moving, PlayerTurn, Recovery}

class GameControllerTest extends munit.FunSuite {

  var game: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    game = new GameController
  }

  // TESTS FOR TRANSITIONS BELOW

  test("From PreGame, a certain transition is permitted"){
    try game.startGame()
    catch {
      case e: InvalidTransitionException =>
        throw new AssertionError(e.getMessage)
    }
  }

  test("From PreGame, some transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.attack(),
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.rollDice(),
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements(),
      (game: GameController) => game.defend(),
      (game: GameController) => game.evade(),
      (game: GameController) => game.endCombat(),
      (game: GameController) => game.doEffect(),
      (game: GameController) => game.norma6Reached()
    )

    forbiddenTransitions.foreach(transition => {
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

  test("From Chapter, certain transitions are permitted"){
    val permittedTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.norma6Reached()
    )

    permittedTransitions.foreach(transition => {
      game.changeState(new Chapter(game))
      try transition(game)
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
    })
  }

  test("From Chapter, certain transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll(),
      (game: GameController) => game.rollDice(),
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements(),
      (game: GameController) => game.attack(),
      (game: GameController) => game.defend(),
      (game: GameController) => game.evade(),
      (game: GameController) => game.endCombat(),
      (game: GameController) => game.doEffect()
    )
    forbiddenTransitions.foreach(transition => {
      game.changeState(new Chapter(game))
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

  test("From PlayerTurn, certain transitions are permitted"){
      game.changeState(new PlayerTurn(game))
      try game.rollDice()
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
  }

  test("From PlayerTurn, some transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.startGame(),
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements(),
      (game: GameController) => game.attack(),
      (game: GameController) => game.defend(),
      (game: GameController) => game.evade(),
      (game: GameController) => game.endCombat(),
      (game: GameController) => game.doEffect(),
      (game: GameController) => game.norma6Reached()
    )

    forbiddenTransitions.foreach(transition => {
      game.changeState(new PlayerTurn(game))
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

  test("From Recovery, certain transitions are permitted"){
    val permittedTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll()
    )

    permittedTransitions.foreach(transition => {
      game.changeState(new Recovery(game))
      try transition(game)
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
    })
  }

  test("From Recovery, some transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.rollDice(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.startGame(),
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements(),
      (game: GameController) => game.attack(),
      (game: GameController) => game.defend(),
      (game: GameController) => game.evade(),
      (game: GameController) => game.endCombat(),
      (game: GameController) => game.doEffect(),
      (game: GameController) => game.norma6Reached()
    )

    forbiddenTransitions.foreach(transition => {
      game.changeState(new Recovery(game))
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

  test("From Moving, certain transitions are permitted"){
    val permittedTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements()
    )

    permittedTransitions.foreach(transition => {
      game.changeState(new Moving(game))
      try transition(game)
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
    })
  }

  test("From Moving, some transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.rollDice(),
      (game: GameController) => game.startGame(),
      (game: GameController) => game.attack(),
      (game: GameController) => game.defend(),
      (game: GameController) => game.evade(),
      (game: GameController) => game.endCombat(),
      (game: GameController) => game.doEffect(),
      (game: GameController) => game.norma6Reached()
    )

    forbiddenTransitions.foreach(transition => {
      game.changeState(new Moving(game))
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

  test("From Combat, certain transitions are permitted"){
    val permittedTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.attack(),
      (game: GameController) => game.endCombat()
    )

    permittedTransitions.foreach(transition => {
      game.changeState(new Combat(game))
      try transition(game)
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
    })
  }

  test("From Combat, some transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.rollDice(),
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements(),
      (game: GameController) => game.defend(),
      (game: GameController) => game.evade(),
      (game: GameController) => game.startGame(),
      (game: GameController) => game.doEffect(),
      (game: GameController) => game.norma6Reached()
    )

    forbiddenTransitions.foreach(transition => {
      game.changeState(new Combat(game))
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

  test("From Wait, certain transitions are permitted"){
    val permittedTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.evade(),
      (game: GameController) => game.defend()
    )

    permittedTransitions.foreach(transition => {
      game.changeState(new Wait(game))
      try transition(game)
      catch {
        case e: InvalidTransitionException =>
          throw new AssertionError(e.getMessage)
      }
    })
  }

  test("From Wait, some transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.attack(),
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.rollDice(),
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements(),
      (game: GameController) => game.startGame(),
      (game: GameController) => game.endCombat(),
      (game: GameController) => game.doEffect(),
      (game: GameController) => game.norma6Reached()
    )

    forbiddenTransitions.foreach(transition => {
      game.changeState(new Wait(game))
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

  test("From LandingPanel, certain transitions are permitted"){
    game.changeState(new LandingPanel(game))
    try game.doEffect()
    catch {
      case e: InvalidTransitionException =>
        throw new AssertionError(e.getMessage)
    }
  }

  test("From LandingPanel, some transitions are forbidden"){
    val forbiddenTransitions: List[GameController => Unit] = List(
      (game: GameController) => game.attack(),
      (game: GameController) => game.newChapter(),
      (game: GameController) => game.isKo(),
      (game: GameController) => game.insufficientRoll(),
      (game: GameController) => game.sufficientRoll(),
      (game: GameController) => game.playTurn(),
      (game: GameController) => game.rollDice(),
      (game: GameController) => game.choosePath(),
      (game: GameController) => game.stopMovement(),
      (game: GameController) => game.outOfMovements(),
      (game: GameController) => game.defend(),
      (game: GameController) => game.evade(),
      (game: GameController) => game.endCombat(),
      (game: GameController) => game.startGame(),
      (game: GameController) => game.norma6Reached()
    )

    forbiddenTransitions.foreach(transition => {
      game.changeState(new LandingPanel(game))
      var thrown = intercept[InvalidTransitionException]{
        transition(game)
      }
      assert(thrown.getMessage.contains("Invalid transition"))
    })
  }

}
