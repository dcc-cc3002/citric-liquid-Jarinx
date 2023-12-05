package cl.uchile.dcc.citric
package model.norma

/** Trait representing the Norma condition in the game, which is a set of requirements a player must meet to level up.
 * Norma conditions typically involve accumulating a certain number of stars or achieving a number of wins.
 */
trait Norma {
  var _number: Int          // The current Norma level of the player.
  var _neededStars: Int     // The number of stars needed to reach the next Norma level.
  var _neededWins: Int      // The number of wins needed to reach the next Norma level.

  /** Returns the current Norma level of the player.
   *
   * @return The current Norma level.
   */
  def number: Int = _number

  /** Returns the number of stars needed for the player to level up the Norma.
   *
   * @return The number of needed stars.
   */
  def neededStars: Int = _neededStars

  /** Returns the number of wins needed for the player to level up the Norma.
   *
   * @return The number of needed wins.
   */
  def neededWins: Int = _neededWins


//  /** Sets the number of stars needed for the player to level up the Norma.
//   * This is typically updated when the player meets the conditions of a Norma Check.
//   *
//   * @param newNeedStars The new number of needed stars.
//   */
//  def needStars_(newNeedStars: Int): Unit
//
//  /** Sets the number of wins needed for the player to level up the Norma.
//   * This is typically updated when the player meets the conditions of a Norma Check.
//   *
//   * @param newNeedWins The new number of needed wins.
//   */
//  def needWins_(newNeedWins: Int): Unit

  /** Checks if the player meets the conditions to level up their Norma.
   *
   * @param playerStars The current number of stars the player has.
   * @param playerWins  The current number of wins the player has.
   * @return True if the player meets the conditions, false otherwise.
   */
  def normaCheck(playerStars: Int, playerWins: Int): Boolean

  /** Levels up the player's Norma if they meet the conditions specified by `normaCheck`.
   *
   * @param playerStars The current number of stars the player has.
   * @param playerWins  The current number of wins the player has.
   * @return True if the Norma level was increased, false otherwise.
   */
  def normaClear(playerStars: Int, playerWins: Int): Boolean

  /** Provides the next Norma level for a player character.
   * This method is intended to be used when a player successfully clears their current Norma level,
   * allowing them to advance to the next level with new goals.
   *
   * @return An instance of the next Norma level, advancing the player's progression in the game.
   */
  def nextNorma: Norma

}
