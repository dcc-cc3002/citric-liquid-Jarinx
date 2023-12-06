package cl.uchile.dcc.citric
package controller.observer

class VictoryChecker extends Observer {
  def update(subject: Subject): Unit = {
    subject match {
      case game: Game if game.gameOver =>
        println("Victory condition met. The game is over.")
      case _ =>
    }
  }
}
