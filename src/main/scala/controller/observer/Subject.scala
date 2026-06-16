package cl.uchile.dcc.citric
package controller.observer

import scala.collection.mutable.ArrayBuffer

/** A Subject can add new observers, and notify them of any changes
 */
trait Subject[T] {

  /** Add observers to the observer ArrayBuffer
   *
   * @param observer the observer to add
   */
  def addObserver(observer: Observer[T]): Unit

  /** Function to notify the observers of any change
   *
   * @param value The change to notify
   */
  def notifyObservers(value: T): Unit

}
