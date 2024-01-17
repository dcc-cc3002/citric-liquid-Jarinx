package cl.uchile.dcc.citric
package exceptions

/** Custom exception for when a transition between states cannot happen
 *
 * @param message The details of the exception
 */
class InvalidTransitionException (message: String) extends Exception(message) {

}
