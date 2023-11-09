package cl.uchile.dcc.citric
package model.gameunits

import scala.util.Random

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
 * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/~Your github account~/ Julieta Ayelli]]
  */
class PlayerCharacter(maxHp: Int, attackPts: Int, defensePts: Int, evasionPts: Int)
                       extends Entities(maxHp, attackPts, defensePts, evasionPts) {

  var randomNumberGenerator: Random = new Random()
  var name: String = _
  var num: Int = _
  var norma: Int = _

  /** gets the name of the player */
  def getName: String = name

  /** gets the number associated with the player */
  def getNum: Int = num

  /** gets the roll number (1 to 6) */
  def getRNG: Random = randomNumberGenerator

  /** gets the current norma of the player */
  def getNorma: Int = norma

  /** sets (updates) the name of a player
   * it's protected because it shouldn't change throughout the match */
  def setName(newName: String): Unit = {
    name = newName
  }

  /** sets (updates) the number associated with a player
   * it's protected because it shouldn't change throughout the match */
  def setNum(newNum: Int): Unit = {
    num = newNum
  }

  /** sets (updates) the roll number of a player
   * it's protected because it shouldn't change once the dice is thrown */
  def setRNG(newRNG: Random): Unit = {
    randomNumberGenerator = newRNG
  }


  /** sets (updates) the norma number of a player
   * it's protected because only subclasses should access it to change it */
  def setNorma(newNorma: Int): Unit = {
    norma = newNorma
  }

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
}
