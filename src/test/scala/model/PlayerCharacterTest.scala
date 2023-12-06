package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.exceptions.InvalidStatException
import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.{Chicken, WildUnit}
import cl.uchile.dcc.citric.model.norma.{Norma2, Norma6}

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
  val norma6 = new Norma6()
  norma6.nextNorma

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
    character.norma_(norma)
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
    assertEquals(character.stars, stars)
    assertEquals(character.wins, wins)
    assertEquals(character.norma, norma)
    assertEquals(character.num, num)
    assertEquals(character.rng, randomNumberGenerator)
  }

  test("The amount of stars set can't be negative"){
    val exception = intercept[InvalidStatException] {
      character.stars_(-3)
    }
    assertEquals(exception.getMessage, "An invalid stat was found -- Star count cannot be negative.")

  }


  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  test("A character can take a certain amount of damage"){
    character.takeDmg(5)
    assertEquals(character.currentHp, 5)
  }

  test("The amount of damage taken cannot be negative"){
    val exception = intercept[InvalidStatException] {
      character.takeDmg(-3)
    }
    assertEquals(exception.getMessage, "An invalid stat was found -- Quantity of damage must be non-negative")

  }


  test("A character can defend himself from another Entity's attack and survive"){
    character.defend(character2)
    assert(character.currentHp < currentHp)
  }

  test("A character can defend himself form another Entity's attack and get K0'd"){
    character.currentHp_(1)
    character.defend(character2)
    assert(character.currentHp == 0)
  }

  test("An entity can't attack a K0'd entity"){
    val exception = intercept[InvalidStatException] {
      character.currentHp_(0)
      character.defend(character2)
    }
    assertEquals(exception.getMessage, "An invalid stat was found -- You cannot attack a unit that is already K0'd.")
  }

  test("A K0'd entity cannot attack") {
    val exception = intercept[InvalidStatException] {
      character.currentHp_(0)
      character.attack(character2)
    }
    assertEquals(exception.getMessage, "An invalid stat was found -- A K0'd unit cannot attack.")
  }

  test("An entity can evade another entity's attack"){
    character.evasionPts_(6)
    character.evade(character2)
    assertEquals(character.currentHp, currentHp)
  }

  test("An entity might attempt to evade but fail"){
    character2.attackPts_(10)
    character.evade(character2)
    assertEquals(character.currentHp,  0)
  }

  test("If an entity looses, their stars and wins change"){
    character.attackPts_(10)
    character.attack(character2)
    assert(character2.stars != stars)
    assert(character2.wins != wins)
  }

}
