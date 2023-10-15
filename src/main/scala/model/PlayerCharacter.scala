package cl.uchile.dcc.citric
package model

import scala.util.Random
import cl.uchile.dcc.citric.model.Entity

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
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/~Your github account~/ Julieta Ayelli]]
  */
class PlayerCharacter(
              var _name: String,
              var _num: Int,
              var _randomNumberGenerator: Random = new Random(),
              var _stars: Int,
              var _wins: Int,
              var _norma: Int) extends Entity {
  /** gets the name of the player */
  def name: String = _name

  /** gets the number associated with the player */
  def num: Int = _num

  /** gets the roll number (1 to 6) */
  def randomNumberGenerator: Random = _randomNumberGenerator

  /** gets the current stars of the player */
  def stars: Int = _stars

  /** gets the curent wins of the player */
  def wins: Int = _wins

  /** gets the current norma of the player */
  def norma: Int = _norma

  /** sets (updates) the name of a player
   * it's protected because it shouldn't change throughout the match */
  protected def setName(newName: String): String = {
    _name = newName
    return _name
  }

  /** sets (updates) the number associated with a player
   * it's protected because it shouldn't change throughout the match */
  protected def setNum(newNum: Int): Int = {
    _num = newNum
    return _num
  }

  /** sets (updates) the roll number of a player
   * it's protected because it shouldn't change once the dice is thrown */
  protected def setRNG(newRNG: Random): Random = {
    _randomNumberGenerator = newRNG
    return _randomNumberGenerator
  }

  /** sets (updates) the stars of a player
   * it's protected because only subclasses should access it to change it */
  def setStars(newStars: Int): Int = {
    _stars = newStars
    return _stars
  }

  /** sets (updates) the wins of a player
   * it's protected because only subclasses should access it to change it */
  protected def setWins(newWins: Int): Int = {
    _wins = newWins
    return  _wins
  }

  /** sets (updates) the norma number of a player
   * it's protected because only subclasses should access it to change it */
  protected def setNorma(newNorma: Int): Int = {
    _norma = newNorma
    return _norma
  }

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    _randomNumberGenerator.nextInt(6) + 1
  }
}
