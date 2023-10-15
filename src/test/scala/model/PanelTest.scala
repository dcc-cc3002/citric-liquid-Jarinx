package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PanelTest extends munit.FunSuite {
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  private var panel1: Panel = _
  private var panel2: Panel = _

  private val panelTypeEx = "Neutral Panel"
  private val charactersEx = ArrayBuffer(player1, player2)
  private val nextPanelsEx = ArrayBuffer(panel1, panel2)
/*
  override def beforeEach(context: BeforeEach): Unit = {
    panel1 = new Panel {
      override var panelType: String = panelTypeEx

      override val characters: ArrayBuffer[PlayerCharacter] = charactersEx

      override var nextPanels: ArrayBuffer[Panel] = nextPanelsEx
    }

  }
*/
  // the next tests are for the Panel trait

  test("A panel has a type"){
    assertEquals(panel1.panelType, panelTypeEx)
  }

  test("A panel has 1 or more players currently in it"){
    assertEquals(panel1.characters, charactersEx)
  }

  test("A panel can have 1 or more adjacent panels"){
    assertEquals(panel1.nextPanels, nextPanelsEx)
  }

  test("We can add or remove a player form a certain panel"){
    assertEquals(panel1.addCharacter(player1), panel1.removeCharacter(player1))
  }

  //the next tests are for the different types of panels
  //IN PROGRESS
}
