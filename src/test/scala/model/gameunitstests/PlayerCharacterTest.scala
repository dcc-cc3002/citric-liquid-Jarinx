package cl.uchile.dcc.citric
package model.gameunitstests

import model.gameunitstests.playercharacter.PlayerCharacter

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name = "LichKing"
  private val num = 1
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)
  private val currentHp = 10
  private val stars = 2
  private val wins = 6
  private val norma = 2

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  private var character2: PlayerCharacter = _
  /* Add any other variables you need here... */

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(maxHp, attack, defense, evasion)
    character2 = new PlayerCharacter(maxHp, attack, defense, evasion)
  }


  test("A character should have correctly set their attributes") {
    character.name_(name)
    character.currentHp_(currentHp)
    character.stars_(stars)
    character.wins_(wins)
    character.setNorma(norma)
    character.setNum(num)
    character.rng_(randomNumberGenerator)
    character.maxHp_(maxHp)
    character.attackPts_(attack)
    character.defensePts_(defense)
    character.evasionPts_(evasion)
    assertEquals(character.name, name)
    assertEquals(character._maxHp, maxHp)
    assertEquals(character._attackPts, attack)
    assertEquals(character._defensePts, defense)
    assertEquals(character._evasionPts, evasion)
    assertEquals(character.currentHp, currentHp)
    assertEquals(character.stars, stars)
    assertEquals(character.wins, wins)
    assertEquals(character.getNorma, norma)
    assertEquals(character.getNum, num)
    assertEquals(character.rng, randomNumberGenerator)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  test("A character can take a certain amount of damage"){
    character.takeDmg(5)
    assertEquals(character.currentHp, 5)
  }

  test("A character can do damage to another player or wild unit"){
    character.doDmg(character2, 5)
    assertEquals(character2.currentHp, 5)
  }

  test("A character can defend himself from another Entity's attack and survive"){
    character.defend(character2, 3)
    assertEquals(character.currentHp, 7)
  }

  test("A character can defend himself form another Entity's attack and get K0'ed"){
    character.defend(character2, 10)
    assertEquals(character.currentHp, 0)
  }

}
