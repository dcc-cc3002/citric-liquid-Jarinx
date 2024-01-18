package cl.uchile.dcc.citric
package factory.panelsfactory.concretepanelsfactory

import factory.panelsfactory.PanelFactory
import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.NeutralPanel

/** Factory for Neutral Panels
 */
class NeutralPanelFactory extends PanelFactory[NeutralPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): NeutralPanel = {
    new NeutralPanel
  }
}
