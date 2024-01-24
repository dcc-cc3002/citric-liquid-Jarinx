package cl.uchile.dcc.citric
package controller

import controller.states._

import cl.uchile.dcc.citric.controller.factory.BoardBuilder
import cl.uchile.dcc.citric.controller.observer.{Observer, Subject}
import cl.uchile.dcc.citric.controller.states.lifecycle.{EndGame, PreGame}
import cl.uchile.dcc.citric.exceptions.InvalidTransitionException
import cl.uchile.dcc.citric.model.gameunits.GameEntity
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.Panel
import cl.uchile.dcc.citric.view.{MockView, TView, View}

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

  private var _view: TView = new View // the view of the game

  var _mockView: MockView = _

  private var _winner: Option[PlayerCharacter] = None // the winner of the match

  private var _chapter: Int = 1

  private var players: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty

  var _turn: Int = 0 // manages the turn system

  private var _moves: Int = 0 // manages the moves left of the player

  private var _totalAtk: Int = 0 // the attack amount the entity will inflict

  private var _counter: Int = 0 // the choice for defend or evade

  var _attacker: Option[GameEntity] = None // the type of attacker
  var _receiver: Option[GameEntity] = None

  def setMockView(newView: TView): Unit = {
    _view = newView
  }

  /** Getter for the state of the game
   *
   * @return the state
   */
  def getState(): GameState = state

  /** Used for transitioning between states
   *
   * @param newState the state to transition to
   */
  def changeState(newState: GameState): Unit = {
    state = newState
  }

  /** Getter for the view
   *
   * @return the view
   */
  def view: TView = _view

  /** Getter for the winner
   *
   * @return the winner
   */
  def winner: Option[PlayerCharacter] = _winner

  def winner_(winner: PlayerCharacter): Unit = {
    _winner = Some(winner)
  }

  /** Getter for the chapter number
   *
   * @return the chapter number
   */
  def chapter: Int = _chapter

  /** Setter for the Chapter
   *
   * @param newChap the new Chapter
   */
  def chapter_(newChap: Int): Unit = {_chapter = newChap}

  /** Cycles through the turns of the players (1 -> 4)
   * After reaching 4, it calls the function to advance to the
   * next Chapter, thus restarting the turns
   *
   * @return the turn of the player
   */
  def nextTurn(): Int = {
    if(_turn == 4){
      newChapter()
      _turn = 1
    }
    else{
      _turn = (_turn % 4) + 1
    }
    _turn
  }

  /** Getter for the moves
   *
   * @return the moves left of the player
   */
  def moves: Int = _moves

  /** Setter for the moves left
   *
   * @param newMoves the new amount of moves
   */
  def moves_(newMoves: Int): Unit = {
    _moves = newMoves
  }

  /** Getter for the totalAtk
   *
   * @return the attack amount
   */
  def totalAtk: Int = _totalAtk

  /** Setter for the attack amount
   *
   * @param newAtk the new attack amount
   */
  def totalAtk_(newAtk: Int): Unit = {
    _totalAtk = newAtk
  }

  /** Getter for the counter choice */
  def counter: Int = _counter

  /** the setter for the counter choice
   * 1 -> defend ; 2 -> evade
   *
   * @param newChoice the choice
   */
  def counter_(newChoice: Int): Unit = {
    _counter = newChoice
  }

  /** Setter for the attacker in combat
   *
   * @param newAttacker the attacker
   */
  def attacker_(newAttacker: GameEntity): Unit = {
    _attacker = Some(newAttacker)
  }

  /** Setter for the receiver in combat
   *
   * @param newReceiver the receiver
   */
  def receiver_(newReceiver: GameEntity): Unit = {
    _receiver = Some(newReceiver)
  }

  /** Used for moving forward through the board
   *
   * @param panel the panel to move to
   */
  def movePanels(panel: Panel): Unit = {
    var player= currentPlayer()
    var currentPanel = player.standingIn.get

    currentPanel.removeCharacter(player)

    panel.addCharacter(player)
    player.standingIn_(panel)
  }


  /** Returns the player currently playing its turn
   * Because _turn cycles through 1 to 4, it needs to get subtracted
   * by 1, ie, player 1 is players(0), player 2 is player(2), etc
   *
   * @return the player
   */
  def currentPlayer(): PlayerCharacter = players(_turn - 1)

  /** Controls a match
   */
  def start(): Unit = {
    doAction() //start of the game as GameController starts with PreGame state //while we are not in EndGame state
    while(!state.isInstanceOf[EndGame]){
      doAction()
    }

  }

  def addPlayer(player: PlayerCharacter): Unit = {
    players += player
  }

  def newChapter(): Unit = {
    val currentChapter = chapter
    print(s"Finished Chapter number $currentChapter. ")
    val newChapter = currentChapter + 1
    chapter_(newChapter)
    println(s"Starting Chapter number $newChapter...")
  }

  // STATES TRANSITIONS BELOW

  def doAction(): Unit = state.doAction()
//  def newChapter(): Unit = state.newChapter()
  def isKo(): Unit = state.isKo()
  def insufficientRoll(): Unit = state.insufficientRoll()
  def sufficientRoll(): Unit = state.sufficientRoll()
  def playTurn(): Unit = state.playTurn()
  def rollDice(): Unit = state.rollDice()
  def choosePath(): Boolean = state.choosePath(currentPlayer())
  def stopMovement(): Unit = state.stopMovement()
  def outOfMovements(): Unit = state.outOfMovements()
  def attack(): Unit = state.attack(_attacker.get, _receiver.get)
  def defend(): Unit = state.defend(_receiver.get)
  def evade(): Unit = state.evade(_receiver.get)
  def endCombat(): Unit = state.endCombat()
  def doEffect(): Unit = state.doEffect(currentPlayer(), currentPlayer().standingIn.get)
  def norma6Reached(): Unit = state.norma6Reached()

  // GameController must be notified when a player reaches Norma 6
  // Called when a player levels up their Norma
  override def update(subject: Subject[PlayerCharacter], value: PlayerCharacter): Unit = {
    var player = value
    if (player.norma._number == 6){
      _winner = Some(player)
    }
    else{
      var target = view.readIntInput1toX(view.promptTarget(), 1, 2)
      player.target_(Some(target))
    }
  }


}
