package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.gameunits.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

abstract class Panels (var panelType: String) extends Panel {

  var characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty[PlayerCharacter]
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty[Panel]

  override def setPanelType(newType: String): Unit = {
    panelType = newType
  }

  override def addCharacter(player: PlayerCharacter): Unit = {
    characters += player
  }

  override def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }

  override def addPanel(panel: Panel): Unit = {
    nextPanels += panel
  }

  override def removePanel(panel: Panel): Unit = {
    nextPanels -= panel
  }
}
