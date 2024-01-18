package cl.uchile.dcc.citric
package controller

import exceptions.FactoryConfigError

import cl.uchile.dcc.citric.factory.gameunitsfactory.WildUnitFactory

class WildUnitFactoryTest extends munit.FunSuite {
  var wildUnitFactory: WildUnitFactory = _

  override def beforeEach(context: BeforeEach): Unit = {
    wildUnitFactory = new WildUnitFactory
  }

  test("A random Wild Unit can be created with a factory"){
    var enemy = wildUnitFactory.createWildUnit()
    assert(enemy.maxHp > 0)
  }

}
