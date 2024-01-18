package cl.uchile.dcc.citric
package controller

import cl.uchile.dcc.citric.factory.gameunitsfactory.PlayerCharacterFactory

class PlayerCharacterFactoryTest extends munit.FunSuite {
  var playerFactory: PlayerCharacterFactory = _

  override def beforeEach(context: BeforeEach): Unit = {
    playerFactory = new PlayerCharacterFactory
  }

  test("A player can be created through its factory"){
    var player = playerFactory.createPlayer("Kek")
    assert(player.maxHp > 0)
  }

  test("Two players may not have the same stats as they are set randomly"){
    var player1 = playerFactory.createPlayer("player1")
    var player2 = playerFactory.createPlayer("player2")

    assertNotEquals(player1.maxHp, player2.maxHp)
  }
}