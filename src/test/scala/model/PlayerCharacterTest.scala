package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.{Chicken, WildUnit}
import cl.uchile.dcc.citric.model.norma.Norma2

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
  private val norma = new Norma2()

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  private var character2: PlayerCharacter = _
  var enemy: WildUnit = _
  /* Add any other variables you need here... */

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(maxHp, attack, defense, evasion)
    character2 = new PlayerCharacter(maxHp, attack, defense, evasion)
    enemy = new Chicken()
  }


  test("A character should have correctly set their attributes") {
    character.name_(name)
    character.currentHp_(currentHp)
    character.stars_(stars)
    character.wins_(wins)
    character.setNorma(norma)
    character.num_(num)
    character.rng_(randomNumberGenerator)
    character.maxHp_(maxHp)
    character.attackPts_(attack)
    character.defensePts_(defense)
    character.evasionPts_(evasion)
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.attackPts, attack)
    assertEquals(character.defensePts, defense)
    assertEquals(character.evasionPts, evasion)
    assertEquals(character.currentHp, currentHp)
    assertEquals(character.getStars, stars)
    assertEquals(character.getWins, wins)
    assertEquals(character.norma, norma)
    assertEquals(character.num, num)
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

  // tests for combat methods

  test("A player can attack another Game Unit"){
    character.attack(character2, 3)
    assertEquals(character2.currentHp, 7)

    character.attack(enemy, 2)
    assertEquals(enemy.currentHp, 1)
  }

  test("A player cannot attack a K0'd Game Unit"){
    character2.currentHp_(0)
//    assert(character.attack(character2, 3))

  }

  test("A player cannot deal a negative amount of damage"){

  }

  test("A player can K0 another Game Unit"){
    // daño justo para dejar en 0: qty=10

    // daño mayor a currentHP: qty=11
  }


}
