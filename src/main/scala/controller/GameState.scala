package cl.uchile.dcc.citric
package controller

abstract class GameState(controller: GameController) {
  def startGame(): Unit = {}

  def newChapter(): Unit= {}

  def playTurn(): Unit = {}
  def rollDice(): Unit = {}

  def doEffect(): Unit= {}

  def move(): Unit= {}
  def choosePath(): Unit= {}
  def stopMoving(): Unit= {}
  def outOfMovements(): Unit= {}

  def combat(): Unit= {}
  def attack(): Unit= {}
  def defend(): Unit= {}
  def evade(): Unit= {}

  def sufficientRoll(): Unit= {}

  def insufficientRoll(): Unit= {}

  def isKo(): Unit= {}

  def norma6Reached(): Unit= {}

  def waiting(): Unit={0

  }

}
