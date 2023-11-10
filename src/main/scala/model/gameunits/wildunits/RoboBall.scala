package cl.uchile.dcc.citric
package model.gameunits.wildunits

/** Represents a Robo Ball wild unit with predefined stats.
 * Robo Balls have a balanced health and a defensive orientation with their stats,
 * having a slight bonus to defense and a penalty to evasion.
 * They start with a set number of stars.
 *
 * @constructor Create a new Robo Ball with predefined stats.
 */
class RoboBall extends WildUnit(maxHp = 3, attackPts = -1, defensePts = 1, evasionPts = -1) {
  override var enemy: String = "Robo Ball" // The type of enemy is set to "Robo Ball".
  stars = 2 // Initializes the Robo Ball with 2 stars.
}
