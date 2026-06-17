package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.Entity

/**
 *
 * @param enemy: enemy type ("Chicken", "Robo ball", "Seagull")
 * @param stars: current stars accumulated by the Wild Unit
 *
 * @author Julieta Ayelli
 */
class WildUnit (val enemy: String,
                var stars: Int) extends Entity {

}
