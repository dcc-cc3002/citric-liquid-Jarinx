package cl.uchile.dcc.citric
package controller.observer

trait Observer {
  def update(subject: Subject): Unit
}
