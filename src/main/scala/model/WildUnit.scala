package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.Entity

/**
 *
 * @param enemy: enemy type ("Chicken", "Robo ball", "Seagull")
 * @param stars: current stars accumulated by the Wild Unit
 *
 * @author Julieta Ayelli
 */
class WildUnit (var _enemy: String,
                var _stars: Int) extends Entity {

  /** gets the current type of Wild Unit */

  def enemy: String = _enemy

  /** gets the current number of stars accumulated */

  def stars: Int = _stars

  /** sets (updates) the enemy*/
  def setEnemy(newEnemy: String): String = {
    _enemy = newEnemy
    return _enemy
  }

  /** sets (updates) the number of stars
  * it's protected because only subclasses can access it to, for example,
   * update the number of stars they have*/
  protected def setStars(newStars: Int): Int = {
    _stars = newStars
    return _stars
  }


}
