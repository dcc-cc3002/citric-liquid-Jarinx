package cl.uchile.dcc.citric
package model.gameunits.wildunits

/** Represents a Chicken wild unit with predefined stats.
 * Chickens have low health and negative stats for attack and defense, but a slight evasion bonus.
 * They start with a set number of stars.
 *
 * @constructor Create a new Chicken with predefined stats.
 */
class Chicken extends WildUnit(maxHp = 3, attackPts = -1, defensePts = -1, evasionPts = 1) {
  override var _enemy: String = "Chicken" // The type of enemy is set to "Chicken".
  override var _bonusStars: Int = 3
  this.bonusStars_(_bonusStars)

}
