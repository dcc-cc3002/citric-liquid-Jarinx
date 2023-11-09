package cl.uchile.dcc.citric
package model.norma

trait Norma {
  var number: Int
  var neededStars: Int
  var neededWins: Int

  /** gets the current number of the player's Norma */
  def getNumber: Int = number

  /** gets the current number of needed stars of the player to level up a Norma */
  def getNeededStars: Int = neededStars

  /** gets the current number of needed wins of the player to level up a Norma */
  def getNeededWins: Int = neededWins

  /** Sets (updates) the number of the player's Norma
   * You update the number when the player meets the conditions of Norma Check
   *
   * @param newNumber the new number of the Norma
   * @return the new number of the Norma
   */
  def setNumber(newNumber: Int): Unit

  /** Sets (updates) the number of needed stars to level up
   * You update the number when the player meets the conditions of Norma Check
   *
   * @param newNeedStars the new number of needed stars
   * @return the updated number of needed stars
   */
  def setNeedStars(newNeedStars: Int): Unit

  /** Sets (updates) the number of needed wins to level up
   * You update the number when the player meets the conditions of Norma Check
   *
   * @param newNeedWins the new number of wins
   * @return the updated number of needed wins
   */
  def setNeedWins(newNeedWins: Int): Unit

  /** Checks if the player meets the conditions to level up
   *
   * @param playerStars : current stars of the player
   * @param playerWins  : current wins of the player
   * @return true or false
   */
  def normaCheck(playerStars: Int, playerWins: Int): Boolean

  /** If the player meets the conditions (normaCheck is true), they level up */
  def normaClear(playerStars: Int, playerWins: Int): Boolean

}
