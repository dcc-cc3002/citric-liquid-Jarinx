package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.gameunits.playercharacter.PlayerCharacter

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

  override def neededStars: Int = _neededStars

  override def neededWins: Int = _neededWins

  override def normaCheckStars(player: PlayerCharacter): Boolean = {
    player.stars >= _neededStars
  }

  override def normaCheckWins(player: PlayerCharacter): Boolean = {
    player.wins >= _neededWins
  }

  override def normaClear(player: PlayerCharacter): Boolean = {
    if (player.target.contains(1)) {
      normaCheckStars(player)
    }
    else {
      normaCheckWins(player)
    }
  }

  override def nextNorma: Norma
}