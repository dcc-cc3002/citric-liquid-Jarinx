package cl.uchile.dcc.citric
package controller

import controller.states.PreGameState

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


}