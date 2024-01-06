package cl.uchile.dcc.citric
package model.gameunitstests.playercharacter

import model.gameunitstests.wildunits.TWildUnit
import model.gameunitstests.{Entities, GameEntity}
import model.norma.Norma
import cl.uchile.dcc.citric.model.norma.concretenormas.Norma1

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
  * @param _name The name of the player. This is an identifier and should be unique.
  * @param _maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param _attackPts The player's capability to deal damage to opponents.
  * @param _defensePts The player's capability to resist or mitigate damage from opponents.
  * @param _evasionPts The player's skill to completely avoid certain attacks.
  * @param _randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
 * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/~Your github account~/ Julieta Ayelli]]
  */
class PlayerCharacter(var _name: String,
                      override val _maxHp: Int,
                      override val _attackPts: Int,
                      override val _defensePts: Int,
                      override val _evasionPts: Int)
                      extends Entities(_maxHp, _attackPts, _defensePts, _evasionPts){

  /** The player starts with Norma 1. */
  var _norma: Norma = new Norma1

  /** Gets the current player's Norma */
  def norma: Norma = _norma

  /** Sets the player's Norma */
  def norma_(newNorma: Norma) : Unit = {
    _norma = newNorma
  }

  /** Gets the name of the player character. */
  def name: String = _name

  /** Sets the name of the player character */
  def name_(newName: String): Unit = {
    _name = newName
  }

  /** Checks if the player can level up their Norma.
   *
   * @param player The player which Norma will be checked
   * @return true if the player can level up, false otherwise
   */
  def normaClear(player: PlayerCharacter): Boolean = {
    if (player.norma.normaClear(player)) {
      player.norma_(player.norma.nextNorma)
      true
    }
    else
      false
  }

  override def overthrownBy(attacker: GameEntity): Unit = {
    attacker.rewardFromPlayer(this)
  }

  override def rewardFromPlayer(player: PlayerCharacter): Unit = {
    this.wins_(this.wins + 2)
    this.stars_(this.stars + player.stars / 2)
    player.stars_(player.stars - player.stars / 2)

  }

  override def rewardFromWU(wildUnit: TWildUnit): Unit = {
    this.wins_(this.wins + 1)
    this.stars_(this.stars + wildUnit.stars + wildUnit.bonusStars)
    wildUnit.stars_(0)
  }

}
