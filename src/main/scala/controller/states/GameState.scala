package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.InvalidTransitionException
import cl.uchile.dcc.citric.model.gameunits.GameEntity
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.Panel


/** Class representing the overall state of the game. It's not meant
 * to be a concrete state, it just has all the possible transitions between
 * the different states initialized with an exception.
 *
 * @param controller controls the flow of the game
 */
class GameState (controller: GameController) {

  /** Exception thrown when a transition is invalid
   */
  private def transitionError(): Unit = {
    throw new InvalidTransitionException(s"Invalid transition")
  }

  /** The action performed. Every state has a different action to perform,
   * so every time the controller calls this method, something will happen
   * according to the current state
   */
  def doAction(): Unit = transitionError()

  /** Denotes the change in chapters
   * (after every player had its turn)
   */
  def newChapter(): Unit = transitionError()

  /** Denotes that a player has 0 HP starting
   * a Chapter and needs to try to recover in order to play its turn
   */
  def isKo(): Unit = transitionError()

  /** Denotes that a player didn't
   * get the minimum roll to exit Recovery state
   */
  def insufficientRoll(): Unit = transitionError()

  /** Denotes that a player did
   * get the minimum roll to exit Recovery state
   */
  def sufficientRoll(): Unit = transitionError()

  /** Denotes each player's turn
   */
  def playTurn(): Unit = transitionError()

  /** Denotes that a player rolled its
   * dice and will move a certain amount
   */
  def rollDice(): Unit = transitionError()

  /** Denotes that a player can change its
   * course if it reaches a branch in the board. Can choose to continue
   * straight or turn
   */
  def choosePath(player: PlayerCharacter): Boolean = {
    transitionError()
    false
  }

  /** A player can choose to stop even if it has
   * remaining moves, denotes that they reached their own Home Panel.
   * The player is given two choices: 1 to stop, 2 to keep going
   *
   * @return true if the player chose to stop, false otherwise
   */
  def stopMovement(): Boolean = {
    transitionError()
    false
  }

  /** Denotes that a player no longer has moves left
   */
  def outOfMovements(): Unit = transitionError()

  /**  Denotes that a player attacked another entity
   * and is waiting for their response
   */
  def attack(attacker: GameEntity, receiver: GameEntity): Unit = transitionError()

  /** Denotes that the attacked entity chose to defend
   */
  def defend(receiver: GameEntity): Unit = transitionError()

  /** Denotes that the attacked entity chose to evade
   */
  def evade(receiver: GameEntity): Unit = transitionError()

  /** Denotes that the player, if alive,
   * after the combat stays at the panel they landed at
   */
  def endCombat(): Unit = transitionError()

  /** Denotes the effect on the player
   * of the panel they landed at
   */
  def doEffect(player: PlayerCharacter, panel: Panel): Unit = transitionError()

  /** Denotes that a player reached Norma 6,
   * thus winning the game
   */
  def norma6Reached(): Unit = transitionError()



}
