package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import cl.uchile.dcc.citric.model.gameunits.wildunits.WildUnit

import scala.collection.mutable.ArrayBuffer

/** A class that represents an Encounter Panel
 * Players that end up here will fight with a random Wild Unit;
 * if the win, they'll win stars, and if they lose, they'll lose stars.
 * The stars won depends on how many stars the Wild Unit has accumulated
 * by fighting other players.
 *
 * @param enemy: the Wild Unit that will be randomly generated on this panel
 * @author Julieta Ayelli
 */
class EncounterPanel(panelType: String) extends Panels(panelType) {

  var enemy: WildUnit = _

  /** gets the current enemy of a certain Encounter Panel */
  def getEnemy: WildUnit = enemy

  /** sets (updates) the enemy of a certain Encounter Panel
   * it's private because each Encounter Panel will have a specific Wild Unit,
   * therefore it SHOULD NOT be changed throughout the match*/
  def setEnemy(newEnemy: WildUnit): Unit = {
    enemy = newEnemy
  }

  /** The battle between players and wild units
   * The player attacks, and the wild unit can evade or defend themselves
   * Later, the wild unit attacks, and the player needs to evade or defend himself
   *
   * @return
   */
  //def battle(): Unit{}
}
