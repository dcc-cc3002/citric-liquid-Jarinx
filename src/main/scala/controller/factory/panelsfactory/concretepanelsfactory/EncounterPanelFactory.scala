package cl.uchile.dcc.citric
package controller.factory.panelsfactory.concretepanelsfactory

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.EncounterPanel
import cl.uchile.dcc.citric.controller.factory.panelsfactory.PanelFactory

/** Factory for Encounter Panels
 */
class EncounterPanelFactory extends PanelFactory[EncounterPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): EncounterPanel = {
    new EncounterPanel
  }
}
