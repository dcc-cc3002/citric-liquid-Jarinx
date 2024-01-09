package cl.uchile.dcc.citric
package model.gameunits

import model.gameunits.playercharacter.PlayerCharacter

import cl.uchile.dcc.citric.model.norma.Norma
import cl.uchile.dcc.citric.model.norma.concretenormas.Norma1

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {

  private val name1 = "Arthas"
  private val name2 = "Anduin"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var player1: PlayerCharacter = _  // <- x = _ is the same as x = null
  private var player2: PlayerCharacter = _

  private val norma1 : Norma = new Norma1


  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter(name1, maxHp, attackPts, defensePts, evasionPts, rng)
    player2 = new PlayerCharacter(name2, maxHp, attackPts, defensePts, evasionPts)
  }


  test("A player should have correctly set their attributes") {
    assertEquals(player1.name, name1)
    assertEquals(player1.maxHp, maxHp)
    assertEquals(player1.attackPts, attackPts)
    assertEquals(player1.defensePts, defensePts)
    assertEquals(player1.evasionPts, evasionPts)
    assertEquals(player1.target, None)
  }

  test("A player starts the game with Norma 1"){
    assertEquals(player1.norma._number, norma1._number)
  }

  test("When a player gets defeated by another player, they'll get rewarded"){
    player1.wins_(5)
    player1.stars_(10)
    player2.wins_(7)
    player2.stars_(15)
    player2.overthrownBy(player1)
    assertEquals(player1.wins, 7)
    assertEquals(player1.stars, 17)
    assertEquals(player2.stars, 8)
  }

  test("A player can get out of Recovery State by rolling their dice"){
    player1.currentHp_(0)
    player1.recover(6)
    assertEquals(player1.inRecovery, true)

    player1.recover(1)
    assertEquals(player1.inRecovery, false)
  }

  test("A player can choose a target (amount of stars or wins) in order to level up"){
    assert(player1.target_(Some(1)))
  }

  test("If a target is already established, the player cannot choose a new target"){
    assert(player1.target_(Some(1)))
    assert(!player1.target_(Some(2)))
  }

  test("A player cannot choose as target anything else than stars or wins (1 or 2)"){
    assert(!player1.target_(Some(3)))
  }




}
