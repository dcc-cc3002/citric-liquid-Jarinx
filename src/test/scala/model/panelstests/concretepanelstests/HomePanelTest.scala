package cl.uchile.dcc.citric
package model.panelstests.concretepanelstests

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels._
import scala.util.Random

class HomePanelTest extends munit.FunSuite {
  private val name = "Arthas"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var panelH: HomePanel = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts, rng)
    panelH = new HomePanel(player)
  }

  test("A Home Panel has an owner"){
    assertEquals(panelH.owner.name, player.name)
  }

  test("A player heals and NormaCheck is performed in the Home Panel"){
    player.currentHp_(8)

    panelH.apply(player)

    assertEquals(player.currentHp, 9)
  }

}
