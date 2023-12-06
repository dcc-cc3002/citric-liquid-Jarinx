package cl.uchile.dcc.citric
package model

import cl.uchile.dcc.citric.model.panels.Board

class BoardTest extends munit.FunSuite {

  // Test para verificar que se crea un panel neutral correctamente.
  test("Neutral panel is created") {
    val builder = new Board()
    val board = builder.createBoard(Array(Array('N')))
    assertEquals(board(0)(0).getPanelType, "Neutral")
  }

  // Test para verificar que se crea un panel de inicio correctamente.
  test("Home panel is created") {
    val builder = new Board()
    val board = builder.createBoard(Array(Array('H')))
    assertEquals(board(0)(0).getPanelType, "Home")
  }

  // Test para verificar que el tablero se crea con las dimensiones correctas.
  test("Board is created with correct dimensions") {
    val builder = new Board()
    val board = builder.createBoard(Array(
      Array('H', 'N', 'N'),
      Array('N', 'H', 'N')
    ))
    assertEquals(board.length, 2)
    assertEquals(board(0).length, 3)
  }

  // Test para verificar que los paneles se conectan correctamente (si la lógica de conexión está implementada).
  test("Panels are connected correctly") {
    val builder = new Board()
    val board = builder.createBoard(Array(
      Array('H', 'N'),
      Array('N', 'H')
    ))
    val connectedPanels = board(0)(0).getNextPanels
    assert(connectedPanels.contains(board(0)(1)), "Right panel should be connected")
    assert(connectedPanels.contains(board(1)(0)), "Bottom panel should be connected")
  }
}

