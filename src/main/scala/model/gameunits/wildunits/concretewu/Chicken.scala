package cl.uchile.dcc.citric
package model.gameunits.wildunits.concretewu

import model.gameunits.wildunits.WildUnit

/** Represents a Chicken wild unit with predefined stats.
 * Chickens have low health and negative stats for attack and defense, but a slight evasion bonus.
 * They start with a set number of stars.
 *
 * @constructor Create a new Chicken with predefined stats.
 */
class Chicken extends WildUnit(3, -1, -1, 1, "Chicken") {
  override var _bonusStars = 3 // Initializes the Chicken with 3 stars.
}
