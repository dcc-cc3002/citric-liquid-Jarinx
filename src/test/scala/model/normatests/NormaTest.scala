package cl.uchile.dcc.citric
package model.normatests

import model.gameunits.playercharacter.PlayerCharacter
import model.norma.concretenormas._

import cl.uchile.dcc.citric.model.panels.concretepanels.HomePanel

import scala.util.Random

class NormaTest extends munit.FunSuite {
  private val name = "Arthas"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  var player: PlayerCharacter = _
  var norma2: Norma2 = _
  var norma3: Norma3 = _
  var norma4: Norma4 = _
  var norma5: Norma5 = _
  var norma6: Norma6 = _
  var panelH: HomePanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma2 = new Norma2
    norma3 = new Norma3
    norma4 = new Norma4
    norma5 = new Norma5
    norma6 = new Norma6
    player = new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts, rng)
    panelH = new HomePanel(player)
  }

  test("Each Norma has a requirement to reach in order to level up"){
    assertEquals(player.norma.neededStars, 10)
    assertEquals(player.norma.neededWins, 1)
  }

  test("With target set as stars, NormaCheck will check if the player can level up"){
    player.target_(Some(1))
    panelH.apply(player)
    assert(player.norma._number == 1)

    player.stars_(13)
    panelH.apply(player)
    assert(player.norma._number == 2)
  }

  test("With target set as wins, NormaCheck will check if the player can level up"){
    player.target_(Some(2))
    panelH.apply(player)
    assert(player.norma._number == 1)

    player.wins_(2)
    panelH.apply(player)
    assert(player.norma._number == 2)

    player.wins_(10)
    panelH.apply(player)
    assert(player.norma._number == 3)

  }

  test("A player can keep leveling up to Norma 6, but no more than that"){
    player.target_(Some(1))

    // lvl up to norma2
    player.stars_(10)
    panelH.apply(player)
    assert(player.norma._number == 2)
    // lvl up to norma3
    player.stars_(30)
    panelH.apply(player)
    assert(player.norma._number == 3)
    // lvl up to norma4
    player.stars_(70)
    panelH.apply(player)
    assert(player.norma._number == 4)
    // lvl up to norma5
    player.stars_(120)
    panelH.apply(player)
    assert(player.norma._number == 5)
    // lvl up to norma 6
    player.stars_(200)
    panelH.apply(player)
    assert(player.norma._number == 6)
    // try to lvl up again
    player.stars_(500)
    panelH.apply(player)
    assert(player.norma._number == 6)
  }




}
