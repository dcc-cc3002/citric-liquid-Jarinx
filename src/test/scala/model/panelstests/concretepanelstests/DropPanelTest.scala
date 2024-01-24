package cl.uchile.dcc.citric
package model.panelstests.concretepanelstests

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels._
import scala.util.Random

class DropPanelTest extends munit.FunSuite {
  private val name = "Arthas"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var panelD: DropPanel = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    panelD = new DropPanel
    player = new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts, rng)
  }

  test("A player loses stars in the Drop Panel"){
    player.stars_(10)
    var prevStars: Int = player.stars
    panelD.apply(player)
    assert(player.stars <= prevStars)
  }

  test("A player can lose all their stars"){
    player.stars_(1)
    panelD.apply(player)
    assertEquals(player.stars, 0)

  }

}
