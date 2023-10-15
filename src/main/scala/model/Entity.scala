package cl.uchile.dcc.citric
package model

trait Entity {
  val maxHp: Int = 10
  var currentHp: Int = 10
  val attackPts: Int = 1
  val defensePts: Int = 1
  val evasionPts: Int = 1

  def takeDmg(qty: Int): Int = {
    if(qty < 0){
      //print an error
    }
    currentHp -= qty
    return currentHp
  }
  def doDmg(someone: Entity, qty: Int): Int = {
    if(qty < 0){
      //print an error
    }
    someone.currentHp -= qty
    return someone.currentHp
  }
  def attack(someone: Entity, qty: Int): Unit = {
    if(someone.currentHp == 0){
      //function not executed
    }
    else if(currentHp == 0){
      //function not executed
    }
    else{
      //qty of dmg done code here
      doDmg(someone, qty)
      if (someone.currentHp <= 0) {
        //goes to K0 state
      }
    }
  }
  def defend(fromSomeone: Entity, qty: Int): Unit = {
    //qty of dmg taken (while defending) code here
    //qty can´t be less than 1
    takeDmg(qty)
    if(currentHp <= 0){
      //goes to K0 state
    }
  }

  def evade(formSomeone: Entity, qty: Int): Unit = {
    if(true){
      takeDmg(0)
    }
    else{
      //qty of dmg taken (while evading) code here
      takeDmg(qty)
      if (currentHp <= 0) {
        //goes to K0 state
      }

    }
  }
}
