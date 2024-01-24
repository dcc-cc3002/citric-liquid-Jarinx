package cl.uchile.dcc.citric
package factory

import cl.uchile.dcc.citric.controller.factory.gameunitsfactory.PlayerCharacterFactory
import cl.uchile.dcc.citric.controller.factory.panelsfactory.concretepanelsfactory.{BonusPanelFactory, DropPanelFactory, EncounterPanelFactory, HomePanelFactory, NeutralPanelFactory}
import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.concretepanels._

class PanelFactoryTest extends munit.FunSuite{

  var neutralPanelFactory: NeutralPanelFactory = _
  var bonusPanelFactory: BonusPanelFactory = _
  var dropPanelFactory: DropPanelFactory = _
  var homePanelFactory: HomePanelFactory = _
  var encounterPanelFactory: EncounterPanelFactory = _

  var playerCharacterFactory: PlayerCharacterFactory = _

  override def beforeEach(context: BeforeEach): Unit = {
    neutralPanelFactory = new NeutralPanelFactory
    bonusPanelFactory = new BonusPanelFactory
    dropPanelFactory = new DropPanelFactory
    homePanelFactory = new HomePanelFactory
    encounterPanelFactory = new EncounterPanelFactory

    playerCharacterFactory = new PlayerCharacterFactory
  }

  test("New panels can be created through their factories"){
    var player = playerCharacterFactory.createPlayer("player1")

    var np1 = neutralPanelFactory.createPanel()
    var bp1 = bonusPanelFactory.createPanel()
    var dp1 = dropPanelFactory.createPanel()
    var hp1 = homePanelFactory.createPanel(Some(player))
    var ep1 = encounterPanelFactory.createPanel()

    assert(np1.isInstanceOf[NeutralPanel])
    assert(bp1.isInstanceOf[BonusPanel])
    assert(dp1.isInstanceOf[DropPanel])
    assert(hp1.isInstanceOf[HomePanel])
    assert(ep1.isInstanceOf[EncounterPanel])
  }

  test("A Home Panel Cannot be created without an owner"){
    var thrown = intercept[IllegalArgumentException]{
      homePanelFactory.createPanel()
    }
    assert(thrown.getMessage.contains("HomePanel requires an owner"))
  }



}
