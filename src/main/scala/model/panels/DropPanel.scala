package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** A class that represents a Drop Panel
 * When a player ends up here, they lose a certain number of stars (depends on the roll)
 *
 *@author Julieta Ayelli
 */
class DropPanel (panelType: String) extends Panels(panelType) {

  /** Once any player ends up here, they lose a certain number of stars
   * Stars lost = roll * Norma
   */
  def loseStars(player: PlayerCharacter, roll: Int): Unit = {
    var starsLost: Int = roll * player.getNorma
    var newStars = player.getStars - starsLost
    if(newStars < 0){
      player.setStars(0)
    }
    else{
      player.setStars(newStars)
    }

  }
}