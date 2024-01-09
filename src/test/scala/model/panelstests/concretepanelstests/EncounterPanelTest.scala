package cl.uchile.dcc.citric
package model.panelstests.concretepanelstests

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels._
import scala.util.Random

class EncounterPanelTest extends munit.FunSuite {
  private val name = "Arthas"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var panelE: EncounterPanel = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts, rng)
    panelE = new EncounterPanel
  }

  test("The enemy contained in an Encounter Panel gets spawned randomly"){
    panelE.enemy_()
    assert(panelE.enemy.isDefined)
  }

  // PROVISORIO
  test("nothing happens to the player yet"){
    var prevHp = player.currentHp
    var prevStars = player.stars
    var prevWins = player.wins

    panelE.apply(player)

    assertEquals(player.currentHp, prevHp)
    assertEquals(player.stars, prevStars)
    assertEquals(player.wins, prevWins)
  }



}
