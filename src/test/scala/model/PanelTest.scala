package cl.uchile.dcc.citric
package model

class PanelTest extends munit.FunSuite {
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  private var panel1: Panel = _
  private var panel2: Panel = _

  private val panelType = "Neutral Panel"
  //private val characters = Ar[player1, player2]
  //private val nextPanels = [panel1, panel2]

  private val owner = player1
  private val playerNum = 1


  override def beforeEach(context: BeforeEach): Unit = {
  }

  test("A panel has a type"){
    assertEquals(panel1.panelType, panelType)
  }
/*
  test("A panel has 1 or more players currently in it"){
    assertEquals(panel1.characters, characters)
  }

  test("A panel can have 1 or more adjacent panels"){
    assertEquals(panel1.nextPanels, nextPanels)
  }
*/
  test("We can add or remove a player form a certain panel"){
    assertEquals(panel1.addCharacter(player1), panel1.removeCharacter(player1))
  }
/*
  test("In a Home Panel, a player restores 1 HP"){
    assertEquals(panel1.restoreHP)
  }
  */

}
