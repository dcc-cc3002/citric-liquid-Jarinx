package cl.uchile.dcc.citric
package model.panelstests.concretepanelstests

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels._
import scala.util.Random

class BonusPanelTest extends munit.FunSuite {
  private val name = "Arthas"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var panelB: BonusPanel = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    panelB = new BonusPanel
    player = new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts, rng)
  }

  test("A player gains stars in the Bonus Panel"){
    player.stars_(10)
    var prevStars: Int = player.stars
    panelB.apply(player)
    assert(player.stars >= prevStars)
  }

}
