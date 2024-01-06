package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.gameunitstests.playercharacter.PlayerCharacter

/** Abstract class that defines the structure and behavior of Norma levels in the game.
 * A Norma level is associated with certain conditions based on stars and wins that a player must meet to advance.
 *
 * @constructor Create a new set of Norma conditions with specified initial values.
 * @param _neededStars The number of stars required to level up the Norma.
 * @param _neededWins The number of wins required to level up the Norma.
 */
abstract class Normas(val _neededStars: Int,
                      val _neededWins: Int)
                      extends Norma {

  override var _target: Option[Int] = None

  override def normaCheckStars(player: PlayerCharacter): Boolean = {
    player.stars >= _neededStars
  }

  override def normaCheckWins(player: PlayerCharacter): Boolean = {
    player.wins >= _neededWins
  }

  override def normaClear(player: PlayerCharacter): Boolean = {
    if (_target.contains(1)) {
      normaCheckStars(player)
    }
    else if (_target.contains(2)) {
      normaCheckWins(player)
    }
    else
      false
  }

  override def target: Option[Int] = _target

  override def target_(newTarget: Option[Int]): Boolean = {
    if (_target.isDefined) false
    else if (newTarget.contains(1)){
      _target = newTarget
      true
    }
    else if (newTarget.contains(2)){
      _target = newTarget
      true
    }
    else
      false
  }

  override def nextNorma: Norma

}
