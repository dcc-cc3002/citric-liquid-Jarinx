package cl.uchile.dcc.citric
package controller

import controller.states._

import cl.uchile.dcc.citric.controller.states.lifecycle.PreGame
import cl.uchile.dcc.citric.exceptions.InvalidTransitionException
import cl.uchile.dcc.citric.factory.BoardBuilder
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.observer.{Observer, Subject}

import scala.collection.mutable.ArrayBuffer


/** Controller of the game Citric Liquid 99.7%:
 * Each game is divided in Chapters (rounds), and each of these is
 * divided in four turns, one for each player (the order is given randomly
 * at the start of the game, staying in this order throughout the entire match).
 * When all 4 players have finished their turns, a new Chapter begins.
 * Each player's turn consists of:
 *
 * a. If they're KO, they change their state to 'Recovery'
 * b. Receives [(Chapters / 5) + 1] stars
 * c. Rolls the dice, moving the amount rolled or less if they chose to stop
 * d. The panel effects gets activated
 * e. The player's turn ends, passing on to the next player
 *
 * The game ends when any of the players reaches Norma 6
 *
 */
class GameController extends Observer[PlayerCharacter] {

  private var state: GameState = new PreGame(this) // initial state

  val players: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty // array of players
  val boardBuilder = new BoardBuilder(players) // factory for building the board
  boardBuilder.buildBoard()
  val board = boardBuilder.getBoard // the game board

  var _winner: Option[PlayerCharacter] = None // the winner of the match



  /** Used for transitioning between states
   *
   * @param newState the state to transition to
   */
  def changeState(newState: GameState): Unit = {
    state = newState
  }

  // STATES TRANSITIONS BELOW

  def startGame(): Unit = state.startGame()
  def newChapter(): Unit = state.newChapter()
  def isKo(): Unit = state.isKo()
  def insufficientRoll(): Unit = state.insufficientRoll()
  def sufficientRoll(): Unit = state.sufficientRoll()
  def playTurn(): Unit = state.playTurn()
  def rollDice(): Unit = state.rollDice()
  def choosePath(): Unit = state.choosePath()
  def stopMovement(): Unit = state.stopMovement()
  def outOfMovements(): Unit = state.outOfMovements()
  def attack(): Unit = state.attack()
  def defend(): Unit = state.defend()
  def evade(): Unit = state.evade()
  def endCombat(): Unit = state.endCombat()
  def doEffect(): Unit = state.doEffect()
  def norma6Reached(): Unit = state.norma6Reached()

  // GameController must be notified when a player reaches Norma 6
  // Called when a player levels up their Norma
  override def update(subject: Subject[PlayerCharacter], value: PlayerCharacter): Unit = {
    var player = value
    if (player.norma._number == 6){
      _winner = Some(player)
    }
    else{
      // select goal
    }
  }


}
