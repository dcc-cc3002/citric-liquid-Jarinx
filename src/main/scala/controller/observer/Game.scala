package cl.uchile.dcc.citric
package controller.observer

class Game extends Subject {
  var gameOver: Boolean = false

  def checkVictoryCondition(): Unit = {
    // Lógica para verificar la condición de victoria
    // Si se cumple, se actualiza el estado del juego y se notifica a los observadores
    gameOver = true
    notifyObservers()
  }
}
