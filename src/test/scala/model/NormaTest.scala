package cl.uchile.dcc.citric
package model

class NormaTest extends munit.FunSuite {
  private val level = 2
  private val neededStars = 10
  private val neededWins = 1

  private var norma: Norma = _


  test("To level up to Norma 2, a player needs a certain amount of stars (10) or wins (1)"){
    assertEquals(norma.normaCheck(10, 1), true)
  }

}
