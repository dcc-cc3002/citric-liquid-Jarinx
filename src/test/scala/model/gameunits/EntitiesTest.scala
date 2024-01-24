package cl.uchile.dcc.citric
package model.gameunits

import model.gameunits.playercharacter.PlayerCharacter

import scala.util.Random

class EntitiesTest extends munit.FunSuite {

  private val name1 = "Arthas"
  private val name2 = "Anduin"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var player1: PlayerCharacter = _  // <- x = _ is the same as x = null
  private var player2: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter(name1, maxHp, attackPts, defensePts, evasionPts, rng)
    player2 = new PlayerCharacter(name2, maxHp, attackPts, defensePts, evasionPts, rng)
  }

  test("An entity should have correctly set their initial attributes") {
    assertEquals(player1.name, name1)
    assertEquals(player1.maxHp, maxHp)
    assertEquals(player1.attackPts, attackPts)
    assertEquals(player1.defensePts, defensePts)
    assertEquals(player1.evasionPts, evasionPts)
    assertEquals(player1.currentHp, maxHp)
    assertEquals(player1.stars, 0)
    assertEquals(player1.wins, 0)
    assertEquals(player1._isDead, false)
  }

  test("An entity's HP goes from 0 to max HP"){
    player1.currentHp_(-1)
    assertEquals(player1.currentHp, 0)

    player1.currentHp_(20)
    assertEquals(player1.currentHp, maxHp)
  }

  test("An entity cannot have negative stars"){
    player1.stars_(-1)
    assertEquals(player1.stars, 0)
  }

  test("An entity cannot have negative wins"){
    player1.wins_(-1)
    assertEquals(player1.wins, 0)
  }

  test("An entity should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(player1.rollDice >= 1 && player1.rollDice <= 6)
    }
  }

  test("An entity cannot receive a negative amount of damage") {
    val thrown = intercept[IllegalArgumentException] {
      player1.takeDmg(-5, 1)
    }
    assert(thrown.getMessage.contains("Quantity of damage must be non-negative"))
  }

  test("An entity can choose to either defend or evade from an attack"){
    val prevHp1 = player1.currentHp
    player1.takeDmg(5, 1) // defend
    val prevHp2 = player2.currentHp
    player2.takeDmg(5, 2) // evade
    assert(player1.currentHp <= prevHp1)
    assert(player2.currentHp <= prevHp2)
  }

  test("We can know if an entity is in Recovery State or not"){
    assertEquals(player1.inRecovery, false)
  }

  test("A dead entity cannot attack"){
    player1.currentHp_(0)
    val thrown = intercept[IllegalArgumentException] {
      player1.attack(player2)
    }
    assert(thrown.getMessage.contains("You're in Recovery State (Unable to attack)"))
  }

  test("An entity cannot attack a dead entity"){
    player2.currentHp_(0)
    val thrown = intercept[IllegalArgumentException] {
      player1.attack(player2)
    }
    assert(thrown.getMessage.contains("You can´t attack a KO'd entity"))
  }

  test("You can retrieve the total attack from an entity"){
    assert(player1.attack(player2) >= player1.attackPts)
  }



}