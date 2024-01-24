package cl.uchile.dcc.citric
package controller.factory.gameunitsfactory

import exceptions.FactoryConfigError
import model.gameunits.playercharacter.PlayerCharacter

import scala.util.Random

/** Player Character Factory. Stats are randomly set
 */
class PlayerCharacterFactory {

  // Stats of the players, assigned randomly upon call of createEntity function
  var maxHp: Int = _
  var attackPts: Int = _
  var defensePts: Int = _
  var evasionPts: Int = _

  /** Randomly sets the stats of the player
   */
  private def setRandomStats(): Unit = {
    maxHp = Random.nextInt(6) + 5   // Range: 5 to 10
    attackPts = Random.nextInt(3)       // Range: 0 to 2
    defensePts = Random.nextInt(3) - 1  // Range: -1 to 1
    evasionPts = Random.nextInt(3) - 1  // Range: -1 to 1
  }

  /** Checks if the stats were properly set
   *
   * @return true if properly set, false otherwise
   */
  private def isReady: Boolean = {
    maxHp >= 5 && attackPts >= 0 && defensePts >= -1 && evasionPts >= -1
  }

  def createPlayer(name: String): PlayerCharacter = {
    setRandomStats()
    if(isReady){
      new PlayerCharacter(name, maxHp, attackPts, defensePts, evasionPts)
    }
    else {
      throw new FactoryConfigError("Player's stats weren't set properly")
    }
  }

}
