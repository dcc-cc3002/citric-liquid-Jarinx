package cl.uchile.dcc.citric
package model.gameunitstests

import model.gameunits.playercharacter.PlayerCharacter
import model.gameunits.wildunits.concretewu.{Chicken, RoboBall, Seagull}

import cl.uchile.dcc.citric.exceptions.WildUnitException

import scala.util.Random

class WildUnitTest extends munit.FunSuite {
  private val name = "Arthas"
  private val maxHp = 3
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val rng = new Random(11)

  private var badBirb: Chicken = _
  private var angryBirb: Seagull = _
  private var roundBoy: RoboBall = _
  private var player: PlayerCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    badBirb = new Chicken
    angryBirb = new Seagull
    roundBoy = new RoboBall
    player = new PlayerCharacter(name, maxHp, attack, defense, evasion, rng)
  }

  test("A wild unit should have correctly set their attributes") {
    assertEquals(badBirb.name, "Chicken")
    assertEquals(badBirb.maxHp, 3)
    assertEquals(badBirb.attackPts, -1)
    assertEquals(badBirb.defensePts, -1)
    assertEquals(badBirb.evasionPts, 1)
  }

  test("Each wild unit has a certain amount of bonus stars"){
    assertEquals(badBirb.bonusStars, 3)
    assertEquals(angryBirb.bonusStars, 2)
    assertEquals(roundBoy.bonusStars, 2)
  }

  test("A wild unit can defeat a player and get rewarded"){
    player.currentHp_(0)
    player.stars_(5)
    player.overthrownBy(badBirb)
    assertEquals(badBirb.stars, 2)
    assertEquals(player.stars, 3)
  }

  test("A player can defeat a wild unit and get rewarded"){
    badBirb.currentHp_(0)
    badBirb.stars_(5)
    player.stars_(5)
    player.wins_(2)
    badBirb.overthrownBy(player)
    assertEquals(player.wins, 3)
    assertEquals(player.stars, 13)
    assertEquals(badBirb.stars, 0)
  }

  test("A wild unit cannot fight against another wild unit"){
    val thrown = intercept[WildUnitException] {
      badBirb.overthrownBy(angryBirb)
    }
    assert(thrown.getMessage.contains("A Wild Unit cannot fight another Wild Unit"))
  }

}

