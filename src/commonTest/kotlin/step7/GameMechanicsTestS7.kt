package step7

import j4k.candycrush.GameMechanics
import j4k.candycrush.math.PositionGrid
import j4k.candycrush.model.GameField
import j4k.candycrush.model.TileCell
import kotlin.test.Test
import kotlin.test.assertEquals

class GameMechanicsTestS7 {

    @Test
    fun testGetHorizontalConnectedSix() {
        val field = GameField.fromString(
                """
                |[H, A, A, A, A, A, A, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        val horizontal: List<TileCell> = listOf(1, 2, 3, 4, 5, 6).map { field.getTileCell(column = it) }

        assertEquals(horizontal, mechanics.getHorizontalSurroundings(PositionGrid.Position(column = 1)))
        assertEquals(horizontal, mechanics.getHorizontalSurroundings(PositionGrid.Position(column = 2)))
        assertEquals(horizontal, mechanics.getHorizontalSurroundings(PositionGrid.Position(column = 3)))
        assertEquals(horizontal, mechanics.getHorizontalSurroundings(PositionGrid.Position(column = 4)))
        assertEquals(horizontal, mechanics.getHorizontalSurroundings(PositionGrid.Position(column = 5)))
        assertEquals(horizontal, mechanics.getHorizontalSurroundings(PositionGrid.Position(column = 6)))
    }


    @Test
    fun testGetVerticalConnectedSix() {
        val field = GameField.fromString(
                """
                |[H]
                |[A]
                |[A]
                |[A]
                |[A]
                |[A]
                |[A]
                |[H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        val vertical: List<TileCell> = listOf(1, 2, 3, 4, 5, 6).map { field.getTileCell(row = it) }

        assertEquals(vertical, mechanics.getVerticalSurroundings(PositionGrid.Position(row = 1)))
        assertEquals(vertical, mechanics.getVerticalSurroundings(PositionGrid.Position(row = 2)))
        assertEquals(vertical, mechanics.getVerticalSurroundings(PositionGrid.Position(row = 3)))
        assertEquals(vertical, mechanics.getVerticalSurroundings(PositionGrid.Position(row = 4)))
        assertEquals(vertical, mechanics.getVerticalSurroundings(PositionGrid.Position(row = 5)))
        assertEquals(vertical, mechanics.getVerticalSurroundings(PositionGrid.Position(row = 6)))
    }
}