package cl.uchile.dcc.citric
package model.panelstests

import model.gameunits.playercharacter.PlayerCharacter
import model.gameunits.wildunits.concretewu.{Chicken, Seagull}
import model.panels.concretepanels._

import scala.util.Random

class GeneralPanelTest extends munit.FunSuite {
  private val name1 = "Arthas"
  private val name2 = "Anduin"
  private val maxHp = 10
  private val attackPts = 1
  private val defensePts = 1
  private val evasionPts = 1
  private val rng = new Random(11)

  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  private var angryBirb: Chicken = _

  private var panelN: NeutralPanel = _
  private var panelH: HomePanel = _
  private var panelB: BonusPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter(name1, maxHp, attackPts, defensePts, evasionPts, rng)
    player2 = new PlayerCharacter(name2, maxHp, attackPts, defensePts, evasionPts)
    angryBirb = new Chicken

    panelN = new NeutralPanel
    panelH = new HomePanel(player1)
    panelB = new BonusPanel

  }


  test("A panel has a type"){
    assertEquals(panelN.panelType, "Neutral")
  }

  test("A panel has 0 or more players currently in it"){
    panelN.addCharacter(player1)
    panelN.addCharacter(player2)
    assertEquals(panelN.charactersAmount, 2)

    panelN.removeCharacter(player2)
    assertEquals(panelN.charactersAmount, 1)

    panelN.removeCharacter(player1)
    assertEquals(panelN.charactersAmount, 0)
  }

  test("A panel contains a particular player"){
    panelN.addCharacter(player1)
    assert(panelN.containsPlayer(player1))
  }

  test("A panel can have 1 or more adjacent panels"){
    panelN.addNextPanel(panelH)
    panelN.addNextPanel(panelB)
    assertEquals(panelN.nextPanelsAmount, 2)

    panelN.removeNextPanel(panelB)
    assertEquals(panelN.nextPanelsAmount, 1)
  }

  test("We can check for a particular panel in the array of next panels"){
    panelN.addNextPanel(panelH)
    assert(panelN.containsNextPanel(panelH))
  }

  test("The owner of a Home Panel is determined in the init of each Home Panel"){
    assert(!panelN.ownerInPanel(player1))
  }

  test("Only the Encounter Panels can spawn a wild unit"){
    assert(panelN.enemy_().isEmpty)
  }


}
