package cl.uchile.dcc.citric
package model.normatests

import model.gameunitstests.playercharacter.PlayerCharacter
import model.norma.concretenormas._

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
    player.stars_(stars)
    player.wins_(wins)
    norma2.normaClear(player.stars, player.wins)
    player.setNorma(2)
    assertEquals(player.getNorma, 2)
  }

  test("A player may not meet the conditions to level up their Norma"){
    player.stars_(5)
    player.wins_(0)
    assert(!norma2.normaClear(player.stars, player.wins))
  }

  test("You can get the attributes"){
    assertEquals(norma2.number, number)
    assertEquals(norma2.neededStars, neededStars)
    assertEquals(norma2.neededWins, neededWins)
  }

  test("You can set the attributes, if needed (although this shouldn´t happen), and then get them"){
    norma2.number_(3)
    norma2.needStars_(30)
    norma2.needWins_(3)
    assertEquals(norma2.number, number+1)
    assertEquals(norma2.neededStars, neededStars+20)
    assertEquals(norma2.neededWins, neededWins+2)
  }

}
