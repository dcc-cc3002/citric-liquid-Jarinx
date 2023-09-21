package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/YOUR-USERNAME YOUR NAME]]
  */
trait Panel {

  val panelType: String /** corresponde al tipo del panel (neutral, home, bonus, drop o encounter) */

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  val characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
    *
    * This might be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The player character to add to this panel.
    */
  def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  def removeCharacter(player: PlayerCharacter): Unit
}

class neutralPanel(){
}

class homePanel(){
  /** atributos:
   *  - owner: String -> de qué jugador es el panel
   *  - number: Int -> el número asociado al player
   *
   *  métodos:
   *  - restoreHP: Unit -> cada vez que se pasa por el panel se suma 1 al HP del jugador
   *  - nomraCheck: Boolean -> se checkea si el jugador tiene las estrellas suficientes
   */
}
class bonusPanel(){
  /** métodos:
   * - gainStars: Unit -> dependiendo del roll, gana 'x' estrellas
   */
}

class dropPanel(){
  /** métodos:
   * - loseStards: Unit -> dependiendo del roll, pierde 'y' estrellas
   */
}

class encounterPanel(){
  /** métodos:
   * - battle: Boolean -> True si gana el jugador, False si gana el Wild Unit
   */
}