package cl.uchile.dcc.citric
package factory.panelsfactory.concretepanelsfactory

import factory.panelsfactory.PanelFactory
import model.gameunits.playercharacter.PlayerCharacter
import model.panels.concretepanels.BonusPanel

/** Factory for Bonus Panels
 */
class BonusPanelFactory extends PanelFactory[BonusPanel] {

  override def createPanel(owner: Option[PlayerCharacter] = None): BonusPanel = {
    new BonusPanel
  }
}
