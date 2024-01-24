package cl.uchile.dcc.citric
package controller.factory.panelsfactory.concretepanelsfactory

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.NeutralPanel

import cl.uchile.dcc.citric.controller.factory.panelsfactory.PanelFactory

/** Factory for Neutral Panels
 */
class NeutralPanelFactory extends PanelFactory[NeutralPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): NeutralPanel = {
    new NeutralPanel
  }
}
