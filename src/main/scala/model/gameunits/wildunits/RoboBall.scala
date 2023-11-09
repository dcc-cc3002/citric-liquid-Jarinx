package cl.uchile.dcc.citric
package model.gameunits.wildunits

class RoboBall extends WildUnit(maxHp = 3, attackPts = -1, defensePts = 1, evasionPts = -1) {
  override var enemy: String = "Robo Ball"
  stars = 2
}
