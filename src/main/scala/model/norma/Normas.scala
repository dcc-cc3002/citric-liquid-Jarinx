package cl.uchile.dcc.citric
package model.norma

/** Abstract class that defines the structure and behavior of Norma levels in the game.
 * A Norma level is associated with certain conditions based on stars and wins that a player must meet to advance.
 *
 * @constructor Create a new set of Norma conditions with specified initial values.
 * @param _number The Norma level.
 * @param _neededStars The number of stars required to level up the Norma.
 * @param _neededWins The number of wins required to level up the Norma.
 */
abstract class Normas(val _number: Int, val _neededStars: Int, val _neededWins: Int) extends Norma {

  /** Checks if the player meets the conditions to level up their Norma based on stars or wins.
   *
   * @param playerStars The current number of stars the player has.
   * @param playerWins  The current number of wins the player has.
   * @return True if the player meets the conditions, false otherwise.
   */
  override def normaCheck(playerStars: Int, playerWins: Int): Boolean = {
    playerStars >= _neededStars || playerWins >= _neededWins
  }

  /** Levels up the player's Norma if they meet the conditions specified by `normaCheck`.
   * This method also contains the logic to change the player's Norma level.
   *
   * @param playerStars The current number of stars the player has.
   * @param playerWins  The current number of wins the player has.
   * @return True if the Norma level was increased, false otherwise.
   */
  override def normaClear(playerStars: Int, playerWins: Int): Boolean = {
    if (normaCheck(playerStars, playerWins)) {
      // logic to change players norma
      true
    }
    else{
      println("Conditions for leveling not met")
      false
    }

  }
}
