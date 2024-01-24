package cl.uchile.dcc.citric
package controller.states.combat

import controller.GameController
import controller.states.GameState

import cl.uchile.dcc.citric.controller.states.panel.LandingPanel
import cl.uchile.dcc.citric.model.gameunits.GameEntity
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.view.Prompt

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/** This state represents that a player is in a combat (PvP or PvE)
 *
 * @param controller controls the flow of the game
 */
class Combat(controller: GameController) extends GameState(controller) with Prompt{

  override def doAction(): Unit = {
    val player: PlayerCharacter = controller.currentPlayer()
    var currentPanel = player.standingIn.get

    if (player.inRecovery) {
      endCombat()
    }
    // if the current panel is an Encounter Panel
    else if (player.standingIn.get.panelType == "Encounter"){
      var enemyCreated = currentPanel.enemy_()
      controller.receiver_(enemyCreated.get)
      var enemy = controller._receiver.get
      var enemyType = enemy.name
      controller.view.promptEnemy(enemyType)

      genericCombat(player, enemy)
    }
    // if the current panel contains another player(s)
    else if (currentPanel.charactersAmount > 1) {
      val totalPlayers = currentPanel._characters
      val restOfPlayers = totalPlayers.filter(_ != player)

      val pvpChoice = combatPvP(restOfPlayers)

      // if the player chose not to fight
      if (pvpChoice.isEmpty){
        endCombat()
      }
      // if the player chose a player to fight
      else {
        val chosenPlayer = pvpChoice.get
        genericCombat(player, chosenPlayer)
      }
    }

    endCombat()
  }

  override def attack(attacker: GameEntity, receiver: GameEntity): Unit = {
    controller.attacker_(attacker)
    controller.receiver_(receiver)
    val attackPts = attacker.attack(receiver)
    controller.totalAtk_(attackPts)
    controller.view.promptAttackPts(attacker, attackPts)

    if (receiver._canChooseCounter) { // if the receiver is another player
      val counterChoice: Int = controller.view.readIntInput1toX(promptCounter(receiver), 1, 2)
      controller.counter_(counterChoice)
    }
    else { // if the receiver is a wild unit
      val counterChoice: Int = Random.nextInt(2) + 1 // choice of 1 or 2 randomly
      println(s"The wild ${receiver.name} is parrying!")
      controller.counter_(counterChoice)
    }

    controller.changeState(new Wait(controller))
    controller.doAction()
  }

  override def endCombat(): Unit = {
    controller.changeState(new LandingPanel(controller))
  }

  def genericCombat(player: PlayerCharacter, receiver: GameEntity): Unit = {
    if (player.currentHp > 0 && receiver.currentHp > 0) { // if the player is alive
      println(s"${player.name} is attacking ${receiver.name}!")
      attack(player, receiver) // player attacks
      if (receiver.currentHp > 0) { // if the receiver is still alive
        println(s"${receiver.name} is counter attacking ${player.name}!")
        attack(receiver, player)

      }
      else { // if the receiver died
        promptDeadPlayer(receiver, player)
        receiver.overthrownBy(player)
      }
    }
    else { // if the player died
      promptDeadPlayer(player, receiver)
      player.overthrownBy(receiver)
    }

  }

  /** Manages the battle between players
   *
   * @param otherPlayers the array of the other players in the current panel
   * @return the player chosen to fight, or None if the player chose not to fight
   */
  def combatPvP(otherPlayers: ArrayBuffer[PlayerCharacter]): Option[PlayerCharacter] = {
    println("Player(s)'s already in this panel:")
    val playersLength: Int = otherPlayers.length
    for ((player, index) <- otherPlayers.zipWithIndex) {
      println(s"${index + 1}. ${player.name}")
    }
    val chosenOpponent = controller.view.readIntInput1toX(promptAttackPlayer(), 0, playersLength)
    // player chose to skip combat
    if(chosenOpponent == 0){
      None
    }
    // player chose to fight; 1 -> players(0), 2 -> players(1), 3 -> players(2)
    else {
      var playerChosen = otherPlayers(chosenOpponent - 1)
      //if the player chosen is dead
      if (playerChosen.currentHp == 0) {
        println(s"You can't fight ${playerChosen.name}! They're in Recovery state :( ")
        None
      }
      else {
        Some(playerChosen)
      }

    }

  }


}
