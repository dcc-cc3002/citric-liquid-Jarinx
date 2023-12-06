package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.exceptions.InvalidStatException
import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.{Chicken, RoboBall, Seagull, WildUnit}

class WildUnitTest extends munit.FunSuite {
  private val enemy = "Chicken"
  private val maxHp = 3
  private val currentHp = 3
  private val attack = -1
  private val defense = -1
  private val evasion = 1
  private val stars = 3
  var wins = 0

  private var badGuy: Chicken = _
  private var angryBirb: Seagull = _
  private var roundBoy: RoboBall = _
  private var character: PlayerCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    badGuy = new Chicken
    angryBirb = new Seagull
    roundBoy = new RoboBall
    character = new PlayerCharacter(maxHp, attack, defense, evasion)
  }

  //tests
  test("You can set the attributes of any wild unit, if needed"){
    badGuy.enemy_(enemy)
    badGuy.maxHp_(maxHp)
    badGuy.currentHp_(currentHp)
    angryBirb.attackPts_(attack)
    angryBirb.defensePts_(defense)
    angryBirb.evasionPts_(evasion)
    roundBoy.stars_(stars)
    roundBoy.wins_(wins)
    assertEquals(badGuy.enemy, enemy)
    assertEquals(badGuy.maxHp, maxHp)
    assertEquals(badGuy.currentHp, currentHp)
    assertEquals(badGuy.attackPts, attack)
    assertEquals(badGuy.defensePts, defense)
    assertEquals(badGuy.evasionPts, evasion)
    assertEquals(badGuy.stars, stars)
    assertEquals(badGuy.wins, 0)
  }

  test("The amount of stars set can't be negative") {
    val exception = intercept[InvalidStatException] {
      angryBirb.stars_(-3)
    }
    assertEquals(exception.getMessage, "An invalid stat was found -- Star count cannot be negative.")

  }

  test("A wild unit can take a certain amount of damage from a player"){
    badGuy.takeDmg(1)
    assertEquals(badGuy.currentHp, 2)
  }

  test("The amount of damage taken can't be negative") {
    val exception = intercept[InvalidStatException] {
      angryBirb.takeDmg(-1)
    }
    assertEquals(exception.getMessage, "An invalid stat was found -- Quantity of damage must be non-negative")
  }


  test("A wild unit can´t attack a player in Recovery state") {
    character.currentHp_(0)
    val exception = intercept[InvalidStatException] {
      angryBirb.attack(character)
    }
    assertEquals(exception.getMessage, "An invalid stat was found -- You cannot attack a unit that is already K0'd.")
  }

  test("If an entity looses, their stars and wins change") {
    character.attackPts_(10)
    character.attack(angryBirb)
    assert(angryBirb.stars != stars)
    assert(character.stars != stars)
  }


}

