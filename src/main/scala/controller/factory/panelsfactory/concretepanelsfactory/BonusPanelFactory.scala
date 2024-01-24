package cl.uchile.dcc.citric
package controller.factory.panelsfactory.concretepanelsfactory

import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.BonusPanel
import cl.uchile.dcc.citric.controller.factory.panelsfactory.PanelFactory

/** Factory for Bonus Panels
 */
class BonusPanelFactory extends PanelFactory[BonusPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): BonusPanel = {
    new BonusPanel
  }
}
