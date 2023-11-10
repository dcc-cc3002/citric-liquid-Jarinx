package cl.uchile.dcc.citric
package model.gameunits.wildunits

/** Represents a Seagull wild unit with predefined stats.
 * Seagulls have a standard health level and are characterized by their offensive capabilities,
 * having a bonus to attack and penalties to defense and evasion.
 * They start with a set number of stars.
 *
 * @constructor Create a new Seagull with predefined stats.
 */
class Seagull extends WildUnit(maxHp = 3, attackPts = 1, defensePts = -1, evasionPts = -1) {
  override var enemy: String = "Seagull" // The type of enemy is set to "Seagull".
  stars = 2 // Initializes the Seagull with 2 stars.
}
