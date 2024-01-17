package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.InvalidTransitionException


/** Class representing the overall state of the game. It's not meant
 * to be a concrete state, it just has all the possible transitions between
 * the different states initialized with an exception.
 *
 * @param controller controls the flow of the game
 */
class GameState (controller: GameController) {

  /** Exception thrown when a transition is invalid
   */
  def transitionError(): Unit = {
    throw new InvalidTransitionException(s"Invalid transition")
  }

  /** From PreGame to Chapter. Denotes the start of the game
   */
  def startGame(): Unit = transitionError()

  /** From Chapter to Chapter. Denotes the change in chapters
   * (after every player had its turn)
   */
  def newChapter(): Unit = transitionError()

  /** From Chapter to Recovery. Denotes that a player has 0 HP starting
   * a Chapter and needs to try to recover in order to play its turn
   */
  def isKo(): Unit = transitionError()

  /** From Recovery to Chapter. Denotes that a player didn't
   * get the minimum roll to exit Recovery state
   */
  def insufficientRoll(): Unit = transitionError()

  /** From Recovery to PlayerTurn. Denotes that a player did
   * get the minimum roll to exit Recovery state
   */
  def sufficientRoll(): Unit = transitionError()

  /** From Chapter to PlayerTurn. Denotes each player's turn
   */
  def playTurn(): Unit = transitionError()

  /** From PlayerTurn to Moving. Denotes that a player rolled its
   * dice and will move a certain amount
   */
  def rollDice(): Unit = transitionError()

  /** From Moving to Moving. Denotes that a player can change its
   * course if it reaches a branch in the board. Can choose to continue
   * straight or turn
   */
  def choosePath(): Unit = transitionError()

  /** From Moving to Combat. A player can choose to stop even if it has
   * remaining moves, either to fight in PvP or if it reached its own
   * Home Panel
   */
  def stopMovement(): Unit = transitionError()

  /** From Moving to Combat. Denotes that a player no longer has moves left
   */
  def outOfMovements(): Unit = transitionError()

  /** From Combat to Wait. Denotes that a player attacked another entity
   * and is waiting for their response
   */
  def attack(): Unit = transitionError()

  /** From Wait to Combat. Denotes that the attacked entity chose to defend
   */
  def defend(): Unit = transitionError()

  /** From Wait to Combat. Denotes that the attacked entity chose to evade
   */
  def evade(): Unit = transitionError()

  /** From Combat to LandingPanel. Denotes that the player, if alive,
   * after the combat stays at the panel they landed at
   */
  def endCombat(): Unit = transitionError()

  /** From LandingPanel to Chapter. Denotes the effect on the player
   * of the panel they landed at
   */
  def doEffect(): Unit = transitionError()

  /** From Chapter to EndGame. Denotes that a player reached Norma 6,
   * thus winning the game
   */
  def norma6Reached(): Unit = transitionError()

}
