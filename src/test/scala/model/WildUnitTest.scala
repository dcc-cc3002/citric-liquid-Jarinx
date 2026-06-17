package cl.uchile.dcc.citric
package model

class WildUnitTest extends munit.FunSuite {
  private val enemy = "Chicken"
  private val maxHp = 10
  private val currentHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val stars = 7

  private var badGuy: WildUnit = _
  private var character: PlayerCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    badGuy = new WildUnit(enemy, stars)
  }

  //tests
  test("A wild unit should have correctly set their atttributes"){
    assertEquals(badGuy.enemy, enemy)
    assertEquals(badGuy.maxHp, maxHp)
    assertEquals(badGuy.currentHp, currentHp)
    assertEquals(badGuy.attack, attack)
    assertEquals(badGuy.defense, defense)
    assertEquals(badGuy.evasion, evasion)
    assertEquals(badGuy.stars, stars)
  }

  test("A wild unit can take a certain amount of damage from a player"){
    assertEquals(badGuy.takeDmg(5), 5)
  }

  test("A wild unit can do a certain amount of damage to a player"){
    assertEquals(badGuy.doDmg(character, 5), 5)
  }
}

