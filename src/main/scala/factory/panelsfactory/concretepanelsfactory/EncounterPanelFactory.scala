package cl.uchile.dcc.citric
package factory.panelsfactory.concretepanelsfactory

import factory.panelsfactory.PanelFactory
import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.EncounterPanel

/** Factory for Encounter Panels
 */
class EncounterPanelFactory extends PanelFactory[EncounterPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): EncounterPanel = {
    new EncounterPanel
  }
}
