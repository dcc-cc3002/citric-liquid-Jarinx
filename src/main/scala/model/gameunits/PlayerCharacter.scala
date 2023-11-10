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
  * @param attackPts The player's capability to deal damage to opponents.
  * @param defensePts The player's capability to resist or mitigate damage from opponents.
  * @param evasionPts The player's skill to completely avoid certain attacks.
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

  var randomNumberGenerator: Random = new Random() // Random number generator for dice rolls.
  var name: String = _ // The name of the player character.
  var num: Int = _  // The unique number associated with the player character.
  var norma: Int = _ // The current norma level of the player character.

  /** Retrieves the name of the player character. */
  def getName: String = name

  /** Retrieves the unique number associated with the player character. */
  def getNum: Int = num

  /** Retrieves the random number generator for dice rolls. */
  def getRNG: Random = randomNumberGenerator

  /** Retrieves the current norma level of the player character. */
  def getNorma: Int = norma

  /** Sets the name of the player character */
  def setName(newName: String): Unit = {
    name = newName
  }

  /** Sets the unique number associated with the player character. */
  def setNum(newNum: Int): Unit = {
    num = newNum
  }

  /** Sets the random number generator for dice rolls. */
  def setRNG(newRNG: Random): Unit = {
    randomNumberGenerator = newRNG
  }


  /** Sets the current norma level of the player character. */
  def setNorma(newNorma: Int): Unit = {
    norma = newNorma
  }

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
}
