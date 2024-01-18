package cl.uchile.dcc.citric
package factory.panelsfactory.concretepanelsfactory

import factory.panelsfactory.PanelFactory
import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.DropPanel

/** Factory for Drop Panels
 */
class DropPanelFactory extends PanelFactory[DropPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): DropPanel = {
    new DropPanel
  }

}
