package cl.uchile.dcc.citric
package factory

import cl.uchile.dcc.citric.factory.panelsfactory.concretepanelsfactory.{BonusPanelFactory, DropPanelFactory, EncounterPanelFactory, HomePanelFactory, NeutralPanelFactory}
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.Panel

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

/** Builder for the game board
 *
 * @param players the players initialized beforehand
 */
class BoardBuilder(players: Array[PlayerCharacter]) {
  private val panels = ArrayBuffer.empty[Panel]

  private val neutralPanelFactory = new NeutralPanelFactory
  private val homePanelFactory = new HomePanelFactory
  private val bonusPanelFactory = new BonusPanelFactory
  private val dropPanelFactory = new DropPanelFactory
  private val encounterPanelFactory = new EncounterPanelFactory

  def buildBoard(): Unit = {
    // Create panels using factories
    // 1. 20 neutral panels
    val n1 = neutralPanelFactory.createPanel()
    val n2 = neutralPanelFactory.createPanel()
    val n3 = neutralPanelFactory.createPanel()
    val n4 = neutralPanelFactory.createPanel()
    val n5 = neutralPanelFactory.createPanel()
    val n6 = neutralPanelFactory.createPanel()
    val n7 = neutralPanelFactory.createPanel()
    val n8 = neutralPanelFactory.createPanel()
    val n9 = neutralPanelFactory.createPanel()
    val n10 = neutralPanelFactory.createPanel()
    val n11 = neutralPanelFactory.createPanel()
    val n12 = neutralPanelFactory.createPanel()
    val n13 = neutralPanelFactory.createPanel()
    val n14 = neutralPanelFactory.createPanel()
    val n15 = neutralPanelFactory.createPanel()
    val n16 = neutralPanelFactory.createPanel()
    val n17 = neutralPanelFactory.createPanel()
    val n18 = neutralPanelFactory.createPanel()
    val n19 = neutralPanelFactory.createPanel()
    val n20 = neutralPanelFactory.createPanel()

    // 2. 4 home panels
    val h1 = homePanelFactory.createPanel(Some(players(0)))
    val h2 = homePanelFactory.createPanel(Some(players(1)))
    val h3 = homePanelFactory.createPanel(Some(players(2)))
    val h4 = homePanelFactory.createPanel(Some(players(3)))

    // 3. 4 encounter panels
    val e1 = encounterPanelFactory.createPanel()
    val e2 = encounterPanelFactory.createPanel()
    val e3 = encounterPanelFactory.createPanel()
    val e4 = encounterPanelFactory.createPanel()

    // 4. 3 bonus panels
    val b1 = bonusPanelFactory.createPanel()
    val b2 = bonusPanelFactory.createPanel()
    val b3 = bonusPanelFactory.createPanel()

    // 5. 2 drop panels
    val d1 = dropPanelFactory.createPanel()
    val d2 = dropPanelFactory.createPanel()

    // Connect all the panels according to the board layout:
    //
    // H4  E3  N9  D2  N8  N7  H3
    // N10         N16         E2
    // N11         N15         N6
    // B3  N20 N19 B2  N18 N17 B1
    // N12         N14         N5
    // E4          N13         N4
    // H1  N1  N2  D1  N3  E1  H2

    h1.addNextPanel(n1)
    n1.addNextPanel(n2)
    n2.addNextPanel(d1)
    d1.addNextPanel(n3)
    d1.addNextPanel(n13)

    val seq1 = Seq(h1, n1, n2, d1)

    n3.addNextPanel(e1)
    e1.addNextPanel(h2)
    h2.addNextPanel(n4)
    n4.addNextPanel(n5)
    n5.addNextPanel(b1)
    b1.addNextPanel(n6)
    b1.addNextPanel(n17)

    val seq2 = Seq(n3, e1, h2, n4, n5, b1)

    n6.addNextPanel(e2)
    e2.addNextPanel(h3)
    h3.addNextPanel(n7)
    n7.addNextPanel(n8)
    n8.addNextPanel(d2)
    d2.addNextPanel(n9)
    d2.addNextPanel(n16)

    val seq3 = Seq(n6, e2, h3, n7, n8, d2)

    n9.addNextPanel(e3)
    e3.addNextPanel(h4)
    h4.addNextPanel(n10)
    n10.addNextPanel(n11)
    n11.addNextPanel(b3)
    b3.addNextPanel(n12)
    b3.addNextPanel(n20)

    val seq4 = Seq(n9, e3, h4, n10, n11, b3)

    n12.addNextPanel(e4)
    e4.addNextPanel(h1)

    val seq5 = Seq(n12, e4)

    n13.addNextPanel(n14)
    n14.addNextPanel(b2)
    b2.addNextPanel(n19)
    b2.addNextPanel(n15)

    val seq6 = Seq(n13, n14, b2)

    n19.addNextPanel(n20)
    n20.addNextPanel(b3)

    val seq7 =  Seq(n19, n20)

    n15.addNextPanel(n16)
    n16.addNextPanel(d2)

    val seq8 = Seq(n15, n16)

    n17.addNextPanel(n18)
    n18.addNextPanel(b2)

    val seq9 = Seq(n17, n18)

    panels ++= seq1
    panels ++= seq2
    panels ++= seq3
    panels ++= seq4
    panels ++= seq5
    panels ++= seq6
    panels ++= seq7
    panels ++= seq8
    panels ++= seq9

  }

  def getBoard: ArrayBuffer[Panel] = panels
}
