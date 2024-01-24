package cl.uchile.dcc.citric
package controller.factory.panelsfactory.concretepanelsfactory

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.HomePanel
import cl.uchile.dcc.citric.controller.factory.panelsfactory.PanelFactory

/** Factory for Home Panels
 */
class HomePanelFactory extends PanelFactory[HomePanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): HomePanel = {
    owner match {
      case Some(o) => new HomePanel(o)
      case None => throw new IllegalArgumentException("HomePanel requires an owner")
    }
  }

}
