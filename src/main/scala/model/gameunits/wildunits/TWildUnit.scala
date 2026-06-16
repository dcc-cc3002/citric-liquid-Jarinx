package cl.uchile.dcc.citric
package model.gameunits.wildunits

import model.gameunits.GameEntity

trait TWildUnit extends GameEntity {
  var _bonusStars: Int // the star bonus.

  /** Gets the amount of bonus stars
   *
   * @return bonus stars
   */
  def bonusStars: Int

}
