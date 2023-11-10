package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.{Chicken, Seagull, WildUnit}
import cl.uchile.dcc.citric.model.panels.{BonusPanel, DropPanel, EncounterPanel, HomePanel, NeutralPanel, Panel, Panels}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PanelTest extends munit.FunSuite {
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val stars = 2
  private val norma = 2
  private val roll = 4

  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  private var angryBirb: Chicken = _

  private var panel1: NeutralPanel = _
  private var panel2: HomePanel = _
  private var panel3: BonusPanel = _
  private var panel4: DropPanel = _
  private var panel5: EncounterPanel = _

  private var panelTypeEx = "kekw"
  private var charactersEx: ArrayBuffer[PlayerCharacter] = _
  private var nextPanelsEx: ArrayBuffer[Panel] = ArrayBuffer[Panel](panel1, panel2)

  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new NeutralPanel(panelTypeEx)

    player1 = new PlayerCharacter(maxHp, attack, defense, evasion)
    player2 = new PlayerCharacter(maxHp, attack, defense, evasion)
    charactersEx = ArrayBuffer[PlayerCharacter](player1, player2)
    angryBirb = new Chicken

    panel2 = new HomePanel("Home")

    panel3 = new BonusPanel("Bonus")

    panel4 = new DropPanel("Drop")

    panel5 = new EncounterPanel("Encounter")
  }

  // the next tests are for the Panel trait and abstract class Panels

  test("A panel has a type"){
    panel1.setPanelType("Neutral")
    panelTypeEx = "Neutral"
    assertEquals(panel1.getPanelType, panelTypeEx)
  }

  test("A panel has 1 or more players currently in it"){
    panel1.addCharacter(player1)
    panel1.addCharacter(player2)
    assertEquals(panel1.characters, charactersEx)
  }

  test("A panel can have 1 or more adjacent panels"){
    panel1.addPanel(panel2)
    assert(panel1.nextPanels.contains(panel2))
  }

  test("We can add or remove a player form a certain panel"){
    assertEquals(panel1.addCharacter(player1), panel1.removeCharacter(player1))
  }

  test("We can add or remove a following panel") {
    assertEquals(panel1.addPanel(panel2), panel1.removePanel(panel2))
  }

  test("We can retrieve the array of players in a panel"){
    panel1.addCharacter(player1)
    panel1.addCharacter(player2)
    assertEquals(panel1.getCharacters, charactersEx)
  }

  test("We can retrieve the array of adjacent panels of a certain panel"){
    nextPanelsEx= ArrayBuffer[Panel](panel2, panel3)
    panel1.addPanel(panel2)
    panel1.addPanel(panel3)
    assertEquals(panel1.getNextPanels, nextPanelsEx)
  }

  //the next tests are for the different types of panels

  //  no tests for Neutral Panel (yet)

  // tests for Home Panel

  test("A Home Panel has an owner, whose name you can retrieve"){
    panel2.setOwner(player1)
    assertEquals(panel2.owner, player1)
    assertEquals(panel2.getOwner, player1)
  }

  test("A Home Panel associates a number to its owner, which you can retrieve") {
    panel2.setPlayerNum(1)
    assertEquals(panel2.playerNum, 1)
    assertEquals(panel2.getPlayerNum, 1)
  }

  test("Once any player end up in a Home Panel, they get restored 1 HP"){
    player1.setCurrentHp(5)
    panel2.restoreHP(player1)
    assertEquals(player1.getCurrentHp, 6)
  }

  // tests for Bonus Panel

  test("Once a player falls in a Bonus Panel, they gain stars"){
    player1.setStars(stars)
    player1.setNorma(norma)
    panel3.gainStars(player1, roll)
    assertEquals(player1.getStars, 10)
  }

  // tests for Drop Panel

  test("Once a player falls in a Drop Panel, they lose stars") {
    player1.setStars(10)
    player1.setNorma(norma)
    panel4.loseStars(player1, roll)
    assertEquals(player1.getStars, 2)
  }

  test("A player can't end up with a negative number of stars"){
    player1.setStars(stars)
    player1.setNorma(norma)
    panel4.loseStars(player1, roll)
    assertEquals(player1.getStars, 0)
  }

  // tests for Encounter Panel

  test("An Encounter Panel has a Wild Unit waiting to fight in it, which type you can retrieve"){
    panel5.setEnemy(angryBirb)
    assertEquals(panel5.getEnemy, angryBirb)
  }

  test("You can set a new Wild Unit in the Encounter Panel"){
    var rudeBirb = new Seagull
    panel5.setEnemy(rudeBirb)
    assertEquals(panel5.getEnemy, rudeBirb)
  }
}
