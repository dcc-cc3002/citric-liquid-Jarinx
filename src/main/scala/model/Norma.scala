package cl.uchile.dcc.citric
package model

/** A class that represents a certain Norma to be achieved
 *
 * @param _number: number of the level
 * @param _neededStars: stars needed to level up
 * @param _neededWins: wins needed to level up
 *
 * @author Julieta Ayelli
 */
class Norma(private var _number: Int,
            private var _neededStars: Int,
            private var _neededWins: Int){

  /** gets the current number of the player's Norma */
  def number: Int = _number

  /** gets the current number of needed stars of the player to level up a Norma */
  def neededStars: Int = _neededStars

  /** gets the current number of needed wins of the player to level up a Norma */
  def neededWins: Int = _neededWins

  /** Sets (updates) the number of the player's Norma
   * You update the number when the player meets the conditions of Norma Check
   * @param newNumber the new number of the Norma
   * @return the new number of the Norma
   */
  def setNumber(newNumber: Int): Int = {
    _number = newNumber
    return _number
  }

  /** Sets (updates) the number of needed stars to level up
   * You update the number when the player meets the conditions of Norma Check
   * @param newNeedStars the new number of needed stars
   * @return the updated number of needed stars
   */
  def setNeedStars(newNeedStars: Int): Int = {
    _neededStars = newNeedStars
    return _neededStars
  }

  /** Sets (updates) the number of needed wins to level up
   * You update the number when the player meets the conditions of Norma Check
   * @param newNeedWins the new number of wins
   * @return the updated number of needed wins
   */
  def setNeedWins(newNeedWins: Int): Int = {
    _neededWins = newNeedWins
    return _neededWins
  }

  /** Checks if the player meets the conditions to level up
   *
   * @param playerStars: current stars of the player
   * @param playerWins: current wins of the player
   * @return true or false
   */
  def normaCheck(playerStars: Int, playerWins: Int): Boolean = {
    if (playerStars == _neededStars){
      return true
    }
    else if (playerWins == _neededWins){
      return true
    }
    else{
      return false
    }
  }

  /** If the player meets the conditions (normaCheck is true), they level up */
  def normaClear(): Unit = {
    _number += 1
  }

}

object Norma {

  /** Matches a certain number to its Norma number
   *
   * @param nivel
   * @return the Norma, with its attributes
   */
  def apply(number: Int): Norma = number match {
    case 2 => new Norma(2, 10, 1)
    case 3 => new Norma(3, 30, 3)
    case 4 => new Norma(4, 70, 6)
    case 5 => new Norma(5, 120, 10)
    case 6 => new Norma(6, 200, 14)
  }
}
