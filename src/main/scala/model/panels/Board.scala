package cl.uchile.dcc.citric
package model.panels

import model.panels.types.{BonusPanel, DropPanel, EncounterPanel, HomePanel, NeutralPanel}

class Board {

  /**
   * A map that associates characters with panel constructor functions.
   * 'N' for neutral panels, 'H' for home panels, etc.
   */
  private val panelCreators: Map[Char, () => Panel] = Map(
    'N' -> (() => new NeutralPanel("Neutral")),
    'H' -> (() => new HomePanel("Home")),
    'B' -> (() => new BonusPanel("Bonus")),
    'D' -> (() => new DropPanel("Drop")),
    'E' -> (() => new EncounterPanel("Encounter"))
  )


  /**
   * Creates a game board from a matrix of characters.
   * Each character represents a specific type of panel on the board.
   *
   * @param matrix A matrix of characters representing the board layout.
   * @return An array of panels representing the game board.
   */
  def createBoard(matrix: Array[Array[Char]]): Array[Array[Panel]] = {
    val board = Array.ofDim[Panel](matrix.length, matrix.head.length)
    for (i <- matrix.indices; j <- matrix(i).indices) {
      val panelCreator = panelCreators.getOrElse(matrix(i)(j), () => new NeutralPanel("Neutral")) // NeutralPanel por defecto.
      board(i)(j) = panelCreator()
    }
    connectPanels(board)
    board
  }

  /** Connect adjacent panels of a 2D board.
   *
   * @param board The panel made board
   */
  def connectPanels(board: Array[Array[Panel]]): Unit = {
    for (i <- board.indices; j <- board(i).indices) {
      if (i > 0) board(i)(j).addPanel(board(i - 1)(j)) // Conectar con el panel de arriba
      if (i < board.length - 1) board(i)(j).addPanel(board(i + 1)(j)) // Conectar con el panel de abajo
      if (j > 0) board(i)(j).addPanel(board(i)(j - 1)) // Conectar con el panel de la izquierda
      if (j < board(i).length - 1) board(i)(j).addPanel(board(i)(j + 1)) // Conectar con el panel de la derecha
    }
  }

}
