package cl.uchile.dcc.citric

import view.View

import cl.uchile.dcc.citric.controller.GameController

object Main {
  def main(args: Array[String]): Unit = {
    val game = new GameController
    game.start()
  }
}
