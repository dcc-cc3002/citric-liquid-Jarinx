package cl.uchile.dcc.citric
package model

/** A class that represents a certain Norma to be achieved
 *
 * @param number: number of the level
 * @param neededStars: stars needed to level up
 * @param neededWins: wins needed to level up
 *
 * @author Julieta Ayelli
 */
class Norma(var number: Int,
            var neededStars: Int,
            var neededWins: Int){

  /** Checks if the player meets the conditions to level up
   *
   * @param playerStars: current stars of the player
   * @param playerWins: current wins of the player
   * @return true or false
   */
  def normaCheck(playerStars: Int, playerWins: Int): Boolean = {
    if (playerStars == neededStars){
      return true
    }
    else if (playerWins == neededWins){
      return true
    }
    else{
      return false
    }
  }

  /** If the player meets the conditions, they level up
   *
   */
  def normaClear(): Unit = {
    number += 1
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
