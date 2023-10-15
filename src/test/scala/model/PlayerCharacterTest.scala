package cl.uchile.dcc.citric
package model

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val _name = "testPlayer1"
  private val _num = 1
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val _randomNumberGenerator = new Random(11)
  private val currentHp = 10
  private val _stars = 2
  private val _wins = 6
  private val _norma = 2

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
    character = new PlayerCharacter(_name, _num, _randomNumberGenerator, _stars, _wins, _norma)
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, _name)
    assertEquals(character.name, _name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.attackPts, attack)
    assertEquals(character.defensePts, defense)
    assertEquals(character.evasionPts, evasion)
    assertEquals(character.currentHp, currentHp)
    assertEquals(character.stars, _stars)
    assertEquals(character.wins, _wins)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  test("A character can take a certain amount of damage"){
    assertEquals(character.takeDmg(5), 5)
  }

  test("A character can do damage to another player or wild unit"){
    assertEquals(character.doDmg(character2, 5), 5)
  }

}
