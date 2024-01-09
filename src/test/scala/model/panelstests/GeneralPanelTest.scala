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

//
//  // tests for Home Panel
//
//  test("A Home Panel has an owner, whose name you can retrieve"){
//    panelH.owner_(player1)
//    assertEquals(panelH._owner, player1)
//    assertEquals(panelH.owner, player1)
//  }
//
//  test("A Home Panel associates a number to its owner, which you can retrieve") {
//    panelH.setPlayerNum(1)
//    assertEquals(panelH.playerNum, 1)
//    assertEquals(panelH.getPlayerNum, 1)
//  }
//
//  test("Once any player end up in a Home Panel, they get restored 1 HP"){
//    player1.currentHp_(5)
//    panelH.restoreHP(player1)
//    assertEquals(player1.currentHp, 6)
//  }
//
//  // tests for Bonus Panel
//
//  test("Once a player falls in a Bonus Panel, they gain stars"){
//    player1.stars_(stars)
//    player1.setNorma(norma)
//    panelB.gainStars(player1, roll)
//    assertEquals(player1.stars, 10)
//  }
//
//  // tests for Drop Panel
//
//  test("Once a player falls in a Drop Panel, they lose stars") {
//    player1.stars_(10)
//    player1.setNorma(norma)
//    panelD.loseStars(player1, roll)
//    assertEquals(player1.stars, 2)
//  }
//
//  test("A player can't end up with a negative number of stars"){
//    player1.stars_(stars)
//    player1.setNorma(norma)
//    panelD.loseStars(player1, roll)
//    assertEquals(player1.stars, 0)
//  }
//
//  // tests for Encounter Panel
//
//  test("An Encounter Panel has a Wild Unit waiting to fight in it, which type you can retrieve"){
//    panelE.enemy_(angryBirb)
//    assertEquals(panelE.enemy, angryBirb)
//  }
//
//  test("You can set a new Wild Unit in the Encounter Panel"){
//    var rudeBirb = new Seagull
//    panelE.enemy_(rudeBirb)
//    assertEquals(panelE.enemy, rudeBirb)
//  }
}
