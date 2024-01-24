package cl.uchile.dcc.citric
package view

import model.gameunits.playercharacter.PlayerCharacter

import cl.uchile.dcc.citric.model.gameunits.GameEntity
import cl.uchile.dcc.citric.model.gameunits.wildunits.TWildUnit
import cl.uchile.dcc.citric.model.panels.Panel

import scala.collection.mutable.ArrayBuffer

/** Collection of the possible prompts to be used throughout the game.
 * To use a prompt, simply invoke the method*/
trait Prompt{

  // RETURN TYPE = UNIT (WHEN ONLY INFO DISPLAY IS NEEDED)
  def promptStartGame(): Unit = {
    println("Welcome to 99.7% Citric Liquid! Happy to have y'all here (/^u^)/")
  }

  def promptBoard(): Unit = {
    println("  Game Board:")
    println(" ")
    println(" | H4 | E3 | N9 | D2 | N8 | N7 | H3 |")
    println(" | N10|         | N16|         | E2 |")
    println(" | N11|         | N15|         | N6 |")
    println(" | B3 | N20| N19| B2 | N18| N17| B1 |")
    println(" | N12|         | N14|         | N5 |")
    println(" | E4 |         | N13|         | N4 |")
    println(" | H1 | N1 | N2 | D1 | N3 | E1 | H2 |")
    println(" ")
  }

  def promptEnemy(enemy: String): Unit = {
    println(s"A wild $enemy has appeared!")
  }

  def promptEndGame(winner: PlayerCharacter, chapters: Int): Unit = {
    println(s"The game has come to an end after $chapters arduous rounds, " +
      "congratulations everyone!\n\n" +
      s"Give a round of applause for the winner of this match: ${winner.name}\n\n+" +
      "Thank you all for playing! See ya another time, champs (/^w^)/")
  }

  def promptShowStats(player: PlayerCharacter): Unit = {
    println(s"${player.name}'s stats:")
    println(s"1. Current Hit Points: ${player.currentHp} / ${player.maxHp}")
    println(s"2. Current amount of stars: ${player.stars}")
    println(s"3. Current amount of wins: ${player.wins}")
    println(s"4. Current Norma level: ${player.norma._number}")
    println(s"5. Target chosen for leveling up: ${player.target.get}")
  }


  def promptInsufficientRoll(): Unit = {
    println("You didn't reach the minimum required, try your luck next round!")
  }

  def promptSufficientRoll(): Unit = {
    println("Great! You can continue normally now")
  }

  def promptRollDice(player: PlayerCharacter): Unit = {
    println(s"${player.name} rolls the dice and...")
  }


  def promptMovesLeft(moves: Int): Unit = {
    println(s"You have $moves moves left")
  }

  def promptAttackPts(attacker: GameEntity, attack: Int): Unit = {
    println(s"${attacker.name} is attacking with ${attack} points!")
  }

  def promptCurrentPanel(panel: Panel): Unit = {
    println(s"You are currently in a ${panel._panelType} panel")
  }

  // RETURN TYPE = STRING (WHEN USER'S INPUT IS NEEDED)
  def promptPlayerTurn(player: PlayerCharacter): String = {
    "-----------------------------------------------------------------\n" +
    s"It's ${player.name}'s turn. Please press 'Enter' to continue"
  }

  def promptDeadPlayer(defeated: GameEntity, executioner: GameEntity): String = {
    s"Oh no! ${defeated.name} was defeated by {${executioner.name}} (u-u). " +
      "Try your luck next round!\n\n"
  }

  def promptTarget(): String = {
    "Please choose how you wish to level up your Norma:\n" +
    "1) Stars\n2) Wins\n"
  }

  def promptCounter(player: GameEntity): String = {
    s"${player.name}, please choose how you wish to parry:\n" +
    "1) Defend (receive less amount of damage)\n" +
    "2) Evade (chance of receiving 0 damage)\n"
  }

  def promptStopMoving(): String = {
    "You are currently at your Home Panel, do you wish to stop here?\n" +
    "1) Yes\n2) No\n"
  }

  def promptPathBranch(): String = {
    "You are currently at a branching of the board, do you wish to change paths?\n" +
    "1) No, keep going straight\n2) Yes, turn left\n"
  }

  def promptAttackPlayer(): String = {
    "If you wish to fight a player, please enter their corresponding number.\n" +
    "If you do not wish to fight, enter '0' to continue.\n"
  }

}
