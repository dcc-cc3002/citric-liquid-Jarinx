package cl.uchile.dcc.citric
package controller.observer

class Subject {
  private var observers: List[Observer] = List()

  def attach(observer: Observer): Unit = {
    observers = observer :: observers
  }

  def detach(observer: Observer): Unit = {
    observers = observers.filterNot(_ == observer)
  }

  def notifyObservers(): Unit = {
    observers.foreach(_.update(this))
  }
}
