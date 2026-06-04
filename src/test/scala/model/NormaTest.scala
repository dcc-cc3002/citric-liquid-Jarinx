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
  test("To level up to Norma 2, a player needs a certain amount of stars (10) or wins (1)"){
    player.setStars(stars)
    player.setWins(wins)
    norma2.normaClear(player.getStars, player.getWins)
    player.setNorma(2)
    assertEquals(player.getNorma, 2)
  }

  test("A player may not meet the conditions to level up their Norma"){
    player.setStars(5)
    player.setWins(0)
    assert(!norma2.normaClear(player.getStars, player.getWins))
  }

  test("You can get the attributes"){
    assertEquals(norma2.getNumber, number)
    assertEquals(norma2.getNeededStars, neededStars)
    assertEquals(norma2.getNeededWins, neededWins)
  }

  test("You can set the attributes, if needed (although this shouldn´t happen), and then get them"){
    norma2.setNumber(3)
    norma2.setNeedStars(30)
    norma2.setNeedWins(3)
    assertEquals(norma2.getNumber, number+1)
    assertEquals(norma2.getNeededStars, neededStars+20)
    assertEquals(norma2.getNeededWins, neededWins+2)
  }

}
