package cl.uchile.dcc.citric
package factory.panelsfactory

import model.panels.Panels

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter
import cl.uchile.dcc.citric.model.panels.concretepanels.HomePanel

/** Trait for the creation of the different kinds of panels
 */
trait PanelFactory[+T] {

  /** The panel creator
   *
   * @param owner useful if the panel requires an owner (HomePanel), and if no owner
   *              is required (rest of the panels), it's simply left empty
   * @return the panel
   */
  def createPanel(owner: Option[PlayerCharacter] = None): T
}


