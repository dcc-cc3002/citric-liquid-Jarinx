package cl.uchile.dcc.citric
package controller.states.lifecycle

import controller.GameController
import controller.states.GameState

/** Once a player reaches Norma 6. the game ends. This state represents that,
 * the ending of the game.
 *
 * @param controller controls the flow of the game
 */
class EndGame(controller: GameController) extends GameState(controller) {

}
