package cl.uchile.dcc.citric
package model.panelstests.concretepanelstests

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels._
import scala.util.Random

class NeutralPanelTest extends munit.FunSuite {
  private val name = "Arthas"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var panelN: NeutralPanel = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    panelN = new NeutralPanel
    player = new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts, rng)
  }

  test("Nothing happens in a Neutral Panel"){
    var prevHp = player.currentHp
    var prevStars = player.stars
    var prevWins = player.wins

    panelN.apply(player)

    assertEquals(player.currentHp, prevHp)
    assertEquals(player.stars, prevStars)
    assertEquals(player.wins, prevWins)
  }

}