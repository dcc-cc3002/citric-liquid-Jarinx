package cl.uchile.dcc.citric
package model.norma

/** Trait representing the Norma condition in the game, which is a set of requirements a player must meet to level up.
 * Norma conditions typically involve accumulating a certain number of stars or achieving a number of wins.
 */
trait Norma {
  var number: Int          // The current Norma level of the player.
  var neededStars: Int     // The number of stars needed to reach the next Norma level.
  var neededWins: Int      // The number of wins needed to reach the next Norma level.

  /** Returns the current Norma level of the player.
   *
   * @return The current Norma level.
   */
  def getNumber: Int = number

  /** Returns the number of stars needed for the player to level up the Norma.
   *
   * @return The number of needed stars.
   */
  def getNeededStars: Int = neededStars

  /** Returns the number of wins needed for the player to level up the Norma.
   *
   * @return The number of needed wins.
   */
  def getNeededWins: Int = neededWins

  /** Sets the Norma level of the player.
   * This is typically updated when the player meets the conditions of a Norma Check.
   *
   * @param newNumber The new Norma level.
   */
  def setNumber(newNumber: Int): Unit

  /** Sets the number of stars needed for the player to level up the Norma.
   * This is typically updated when the player meets the conditions of a Norma Check.
   *
   * @param newNeedStars The new number of needed stars.
   */
  def setNeedStars(newNeedStars: Int): Unit

  /** Sets the number of wins needed for the player to level up the Norma.
   * This is typically updated when the player meets the conditions of a Norma Check.
   *
   * @param newNeedWins The new number of needed wins.
   */
  def setNeedWins(newNeedWins: Int): Unit

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

}
