package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter

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
    character.setName(name)
    character.setCurrentHp(currentHp)
    character.setStars(stars)
    character.setWins(wins)
    character.setNorma(norma)
    character.setNum(num)
    character.setRNG(randomNumberGenerator)
    character.setMaxHp(maxHp)
    character.setAttackPts(attack)
    character.setDefensePts(defense)
    character.setEvasionPts(evasion)
    assertEquals(character.getName, name)
    assertEquals(character.getMaxHp, maxHp)
    assertEquals(character.getAttackPts, attack)
    assertEquals(character.getDefensePts, defense)
    assertEquals(character.getEvasionPts, evasion)
    assertEquals(character.getCurrentHp, currentHp)
    assertEquals(character.getStars, stars)
    assertEquals(character.getWins, wins)
    assertEquals(character.getNorma, norma)
    assertEquals(character.getNum, num)
    assertEquals(character.getRNG, randomNumberGenerator)
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
    assertEquals(character.getCurrentHp, 5)
  }

  test("A character can do damage to another player or wild unit"){
    character.doDmg(character2, 5)
    assertEquals(character2.getCurrentHp, 5)
  }

  test("A character can defend himself from another Entity's attack and survive"){
    character.defend(character2, 3)
    assertEquals(character.getCurrentHp, 7)
  }

  test("A character can defend himself form another Entity's attack and get K0'ed"){
    character.defend(character2, 10)
    assertEquals(character.getCurrentHp, 0)
  }

}
