package cl.uchile.dcc.citric
package model

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
    badGuy.setEnemy(enemy)
    badGuy.setMaxHp(maxHp)
    badGuy.setCurrentHp(currentHp)
    angryBirb.setAttackPts(attack)
    angryBirb.setDefensePts(defense)
    angryBirb.setEvasionPts(evasion)
    roundBoy.setStars(stars)
    roundBoy.setWins(wins)
    assertEquals(badGuy.getEnemy, enemy)
    assertEquals(badGuy.getMaxHp, maxHp)
    assertEquals(badGuy.getCurrentHp, currentHp)
    assertEquals(badGuy.getAttackPts, attack)
    assertEquals(badGuy.getDefensePts, defense)
    assertEquals(badGuy.getEvasionPts, evasion)
    assertEquals(badGuy.getStars, stars)
    assertEquals(badGuy.getWins, 0)
  }

  test("A wild unit can take a certain amount of damage from a player"){
    badGuy.takeDmg(1)
    assertEquals(badGuy.getCurrentHp, 2)
  }

  test("The amount of damage taken can't be under 0") {
    val exception = intercept[IllegalArgumentException] {
      angryBirb.takeDmg(-1)
    }
    assertEquals(exception.getMessage, "Quantity of damage must be non-negative")
  }

  test("A wild unit can do a certain amount of damage to a player"){
    badGuy.doDmg(character, 1)
    assertEquals(character.getCurrentHp, 2)
  }

  test("The amount of damage inflicted can't be under 0") {
    val exception = intercept[IllegalArgumentException] {
      angryBirb.doDmg(character, -1)
    }
    assertEquals(exception.getMessage, "Quantity of damage must be non-negative")
  }

  test("A wild unit can´t attack a player in Recovery state") {
    character.setCurrentHp(0)
    val exception = intercept[AssertionError] {
      angryBirb.attack(character, 2)
    }
    assert(exception.getMessage.contains("Player is K.O."))
  }

  test("A wild unit can K0 a player (leave them with 0 HP)"){
    character.setCurrentHp(4)
    angryBirb.attack(character, 5)
    assertEquals(character.currentHp, 0)
  }

  test("A wild unit can evade a player's attack"){
    roundBoy.evade(character, 2)
  }


}

