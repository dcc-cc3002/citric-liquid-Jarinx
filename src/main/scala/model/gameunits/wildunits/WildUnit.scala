package cl.uchile.dcc.citric
package model.gameunits.wildunits

import cl.uchile.dcc.citric.model.gameunits.{Entities, GameEntity}

/**
 *
 * @param enemy: enemy type ("Chicken", "Robo ball", "Seagull")
 * @param stars: current stars accumulated by the Wild Unit
 *
 * @author Julieta Ayelli
 */
abstract class WildUnit (maxHp: Int, attackPts: Int, defensePts: Int, evasionPts: Int)
                          extends Entities(maxHp, attackPts, defensePts, evasionPts) {

  var enemy: String

  /** gets the current type of Wild Unit */
  def getEnemy: String = enemy

  /** sets (updates) the enemy*/
  def setEnemy(newEnemy: String): String = {
    enemy = newEnemy
    return enemy
  }

}
