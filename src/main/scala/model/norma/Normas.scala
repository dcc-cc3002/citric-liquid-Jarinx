package cl.uchile.dcc.citric
package model.norma
import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter

/** Abstract class that defines the structure and behavior of Norma levels in the game.
 * A Norma level is associated with certain conditions based on stars and wins that a player must meet to advance.
 *
 * @constructor Create a new set of Norma conditions with specified initial values.
 * @param _number The initial Norma level.
 * @param _neededStars The initial number of stars required to level up the Norma.
 * @param _neededWins The initial number of wins required to level up the Norma.
 */
abstract class Normas(var _number: Int, var _neededStars: Int, var _neededWins: Int) extends Norma {

  override def number: Int = _number

  override def neededStars: Int = _neededStars

  override def neededWins: Int = _neededWins


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
  override def normaClear(playerStars: Int, playerWins: Int, player: PlayerCharacter): Boolean = {
    if (normaCheck(playerStars, playerWins)) {
      player.norma_(nextNorma)
      true
    }
    else{
      println("Conditions for leveling not met")
      false
    }

  }

  /** Provides the next Norma level for a player character.
   * This method is intended to be used when a player successfully clears their current Norma level,
   * allowing them to advance to the next level with new goals.
   *
   * @return An instance of the next Norma level, advancing the player's progression in the game.
   */
  override def nextNorma: Norma

}
