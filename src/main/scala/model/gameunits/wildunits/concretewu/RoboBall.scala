package cl.uchile.dcc.citric
package model.gameunits.wildunits.concretewu

import model.gameunits.wildunits.WildUnit

/** Represents a Robo Ball wild unit with predefined stats.
 * Robo Balls have a balanced health and a defensive orientation with their stats,
 * having a slight bonus to defense and a penalty to evasion.
 * They start with a set number of stars.
 *
 * @constructor Create a new Robo Ball with predefined stats.
 */
class RoboBall extends WildUnit(3, -1,  1, -1, "RoboBall") {
  override var _bonusStars = 2 // Initializes the Robo Ball with 2 stars.
}
