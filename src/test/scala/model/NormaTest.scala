package cl.uchile.dcc.citric
package model

import model.norma.{Norma, Norma2, Norma3, Norma4, Norma5, Norma6}

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter

class NormaTest extends munit.FunSuite {
  val number = 2
  val neededStars = 10
  val neededWins = 1
  var stars = 7
  var wins = 1
  val maxHp = 10
  val attack = 1
  val defense = 1
  val evasion = 1

  var player: PlayerCharacter = _
  var norma2: Norma2 = _
  var norma3: Norma3 = _
  var norma4: Norma4 = _
  var norma5: Norma5 = _
  var norma6: Norma6 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma2 = new Norma2
    norma3 = new Norma3
    norma4 = new Norma4
    norma5 = new Norma5
    norma6 = new Norma6
    player = new PlayerCharacter(maxHp, attack, defense, evasion)
  }

  // in this test I check for methods normaCheck and normaClear
  test("To level up to Norma 3, a player needs a certain amount of stars (10) or wins (1)"){
    player.stars_(stars)
    player.wins_(wins)
    norma2.normaClear(player.stars, player.wins, player)
    assertEquals(player.norma._number, 3)
  }

  test("To level up to Norma 4, a player needs a certain amount of stars (70) or wins (6)") {
    player.stars_(70)
    player.wins_(6)
    norma3.normaClear(player.stars, player.wins, player)
    assertEquals(player.norma._number, 4)
  }

  test("To level up to Norma 5, a player needs a certain amount of stars (120) or wins (10)") {
    player.stars_(120)
    player.wins_(10)
    norma4.normaClear(player.stars, player.wins, player)
    assertEquals(player.norma._number, 5)
  }

  test("To level up to Norma 6, a player needs a certain amount of stars (200) or wins (14)") {
    player.stars_(200)
    player.wins_(14)
    norma5.normaClear(player.stars, player.wins, player)
    assertEquals(player.norma._number, 6)
  }

  test("A player may not meet the conditions to level up their Norma"){
    player.stars_(5)
    player.wins_(0)
    assert(!norma2.normaClear(player.stars, player.wins, player))
  }

  test("You can get the attributes"){
    assertEquals(norma2.number, number)
    assertEquals(norma2.neededStars, neededStars)
    assertEquals(norma2.neededWins, neededWins)
  }



}
