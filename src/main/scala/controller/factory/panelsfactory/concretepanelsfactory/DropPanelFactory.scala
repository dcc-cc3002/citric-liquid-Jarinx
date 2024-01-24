package cl.uchile.dcc.citric
package controller.factory.panelsfactory.concretepanelsfactory

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.DropPanel
import cl.uchile.dcc.citric.controller.factory.panelsfactory.PanelFactory

/** Factory for Drop Panels
 */
class DropPanelFactory extends PanelFactory[DropPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): DropPanel = {
    new DropPanel
  }

}
