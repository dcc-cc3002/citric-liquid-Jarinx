package cl.uchile.dcc.citric
package controller

import controller.states.{EndGameState, PreGameState}
import controller.observer.{Game, Observer, Subject, VictoryChecker}

// Controlador principal del juego
class GameController {
  var state: GameState = new PreGameState(this)

  def changeState(newState: GameState): Unit = {
    state = newState
  }

  def startGame(): Unit = state.startGame()

  def playTurn(): Unit = state.playTurn()

  def rollDice(): Unit = state.rollDice()

  def move(): Unit = state.move()

  def combat(): Unit = state.combat()

  def update(subject: Subject): Unit = {
    subject match {
      case game: Game if game.gameOver =>
        // Manejar el fin del juego
        println("Game over. Processing end game state...")
        state = new EndGameState(this)
      case _ =>
    }
  }

}