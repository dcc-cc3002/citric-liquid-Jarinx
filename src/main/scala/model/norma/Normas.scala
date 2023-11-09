package cl.uchile.dcc.citric
package model.norma


abstract class Normas(var number: Int, var neededStars: Int, var neededWins: Int) extends Norma {

  override def setNumber(newNumber: Int): Unit = {
    number =  newNumber
  }

  override def setNeedStars(newNeedStars: Int): Unit = {
    neededStars = newNeedStars
  }

  override def setNeedWins(newNeedWins: Int): Unit = {
    neededWins = newNeedWins
  }

  override def normaCheck(playerStars: Int, playerWins: Int): Boolean = {
    playerStars >= neededStars || playerWins >= neededWins
  }

  override def normaClear(playerStars: Int, playerWins: Int): Boolean = {
    if (normaCheck(playerStars, playerWins)) {
      setNumber(getNumber + 1)
      // logic to change players norma
      true
    }
    else{
      println("Conditions for leveling not met")
      false
    }

  }


}
