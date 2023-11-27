package cl.uchile.dcc.citric
package model.norma

/** Abstract class that defines the structure and behavior of Norma levels in the game.
 * A Norma level is associated with certain conditions based on stars and wins that a player must meet to advance.
 *
 * @constructor Create a new set of Norma conditions with specified initial values.
 * @param number The initial Norma level.
 * @param neededStars The initial number of stars required to level up the Norma.
 * @param neededWins The initial number of wins required to level up the Norma.
 */
abstract class Normas(var number: Int, var neededStars: Int, var neededWins: Int) extends Norma {

  /** Sets the Norma level of the player.
   *
   * @param newNumber The new Norma level.
   */
  override def setNumber(newNumber: Int): Unit = {
    number =  newNumber
  }

  /** Sets the number of stars needed for the player to level up the Norma.
   *
   * @param newNeedStars The new number of needed stars.
   */
  override def setNeedStars(newNeedStars: Int): Unit = {
    neededStars = newNeedStars
  }

  /** Sets the number of wins needed for the player to level up the Norma.
   *
   * @param newNeedWins The new number of needed wins.
   */
  override def setNeedWins(newNeedWins: Int): Unit = {
    neededWins = newNeedWins
  }

  /** Checks if the player meets the conditions to level up their Norma based on stars or wins.
   *
   * @param playerStars The current number of stars the player has.
   * @param playerWins  The current number of wins the player has.
   * @return True if the player meets the conditions, false otherwise.
   */
  override def normaCheck(playerStars: Int, playerWins: Int): Boolean = {
    playerStars >= neededStars || playerWins >= neededWins
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
      setNumber(getNumber + 1) // Increment the Norma level.
      // logic to change players norma
      true
    }
    else{
      println("Conditions for leveling not met")
      false
    }

  }
}
