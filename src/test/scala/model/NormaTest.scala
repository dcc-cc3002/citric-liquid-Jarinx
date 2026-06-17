package cl.uchile.dcc.citric
package model

class NormaTest extends munit.FunSuite {
  private val _number = 2
  private val _neededStars = 10
  private val _neededWins = 1

  private var norma: Norma = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma(_number, _neededStars, _neededWins)
  }

  test("To level up to Norma 2, a player needs a certain amount of stars (10) or wins (1)"){
    assertEquals(norma.normaCheck(10, 1), true)
  }

  test("If the conditions are met, a player levels up"){
    norma.normaClear()
    assertEquals(norma.number, _number+1)
  }

  test("You can get the attributes"){
    assertEquals(norma.number, _number)
    assertEquals(norma.neededStars, _neededStars)
    assertEquals(norma.neededWins, _neededWins)
  }

  test("You can update the attributes, when needed"){
    assertEquals(norma.setNumber(3), _number+1)
    assertEquals(norma.setNeedStars(30), _neededStars+20)
    assertEquals(norma.setNeedWins(3), _neededWins+2)
  }

}
