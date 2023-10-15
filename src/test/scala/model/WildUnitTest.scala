package cl.uchile.dcc.citric
package model

class WildUnitTest extends munit.FunSuite {
  private val _enemy = "Chicken"
  private val maxHp = 10
  private val currentHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val _stars = 7

  private var badGuy: WildUnit = _
  private var character: PlayerCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    badGuy = new WildUnit(_enemy, _stars)
  }

  //tests
  test("A wild unit should have correctly set their attributes"){
    assertEquals(badGuy.enemy, _enemy)
    assertEquals(badGuy.maxHp, maxHp)
    assertEquals(badGuy.currentHp, currentHp)
    assertEquals(badGuy.attackPts, attack)
    assertEquals(badGuy.defensePts, defense)
    assertEquals(badGuy.evasionPts, evasion)
    assertEquals(badGuy.stars, _stars)
  }

  test("A wild unit can take a certain amount of damage from a player"){
    assertEquals(badGuy.takeDmg(5), 5)
  }

  test("A wild unit can do a certain amount of damage to a player"){
    assertEquals(badGuy.doDmg(character, 5), 5)
  }
   test("You can set a Wild Unit, for example, to a certain Encounter Panel"){
     assertEquals(badGuy.setEnemy("Robo ball"), "Robo ball")
   }
  /*
  test("You can´t change the number of stars a Wild Unit has (TEST FAILING IS OK"){
    assertEquals((badGuy.setStars(5)), 5)
  }

   */
}

