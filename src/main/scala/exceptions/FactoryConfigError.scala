package cl.uchile.dcc.citric
package exceptions

/** Custom exception for when stats weren't properly set by a factory
 *
 * @param message The details of the exception
 */
class FactoryConfigError (message: String) extends Exception(message) {

}
