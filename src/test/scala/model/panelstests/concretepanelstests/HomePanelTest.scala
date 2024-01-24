package cl.uchile.dcc.citric
package model.panelstests.concretepanelstests

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels._
import scala.util.Random

class HomePanelTest extends munit.FunSuite {
  private val name = "Arthas"
  private val name2 = "NotArthas"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var panelH: HomePanel = _
  private var player: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts, rng)
    panelH = new HomePanel(player)
    player2 = new PlayerCharacter(name2, maxHp, attackPts, defensePts, evasionPts, rng)
  }

  test("A Home Panel has an owner"){
    assertEquals(panelH.owner.name, player.name)
  }

  test("We can check if a player is the owner of a HomePanel"){
    assert(panelH.ownerInPanel(player))
    assert(!panelH.ownerInPanel(player2))
  }

  test("A player heals and NormaCheck is performed in the Home Panel"){
    player.currentHp_(8)

    panelH.apply(player)

    assertEquals(player.currentHp, 9)
  }



}
