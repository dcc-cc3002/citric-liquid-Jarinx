package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter

/** Trait representing the Norma condition in the game, which is a set of requirements a player must meet to level up.
 * Norma conditions typically involve accumulating a certain number of stars or achieving a number of wins.
 */
trait Norma {
  val _number: Int          // The level number
  val _neededStars: Int     // The number of stars needed to reach the next Norma level.
  val _neededWins: Int      // The number of wins needed to reach the next Norma level.


  /** Returns the number of stars needed for the player to level up the Norma.
   *
   * @return The number of needed stars.
   */
  def neededStars: Int

  /** Returns the number of wins needed for the player to level up the Norma.
   *
   * @return The number of needed wins.
   */
  def neededWins: Int

  /** Checks if the player meets the conditions to level up their Norma.
   *
   * @param player The player to check
   * @return True if the player meets the conditions, false otherwise.
   */
  def normaCheckStars(player: PlayerCharacter): Boolean

  /** Checks if the player meets the conditions to level up their Norma.
   *
   * @param player the player to check
   * @return True if the player meets the conditions, false otherwise.
   */
  def normaCheckWins(player: PlayerCharacter): Boolean

  /** Levels up the player's Norma if they meet the conditions specified by `normaCheck`.
   * This method also contains the logic to change the player's Norma level.
   * It's applied differently in each Norma.
   *

   * @return True if the Norma level was increased, false otherwise.
   */
  def normaClear(player: PlayerCharacter): Boolean

  /** Used to change the player's Norma level.
   *
   * @return The next Norma
   */
  def nextNorma: Norma

}
