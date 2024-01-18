package cl.uchile.dcc.citric
package factory.gameunitsfactory

import exceptions.FactoryConfigError
import model.gameunits.wildunits.WildUnit
import model.gameunits.wildunits.concretewu.{Chicken, RoboBall, Seagull}

import scala.util.Random

/** Factory to create a Wild Unit randomly
 */
class WildUnitFactory {

  // the enemy type (0: Chicken, 1: Seagull, 2: Roboball)
  var enemy: Int = _

  /** Sets the type of enemy randomly
   */
  private def setRandomType(): Unit = {
    enemy = new Random().nextInt(3) // Range: 0 to 2
  }

  /** Checks if the type was properly set
   *
   * @return true if properly set, false otherwise
   */
  private def isReady: Boolean = {
    enemy >= 0
  }

  def createWildUnit(): WildUnit = {
    setRandomType()
    if(isReady){
      if(enemy == 0){
        new Chicken
      }
      else if(enemy== 1){
        new Seagull
      }
      else{
        new RoboBall
      }
    }
    else{
      throw new FactoryConfigError("Enemy wasn't set properly")
    }

  }

}
