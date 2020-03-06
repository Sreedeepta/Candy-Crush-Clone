package step6

import j4k.candycrush.GameMechanics
import j4k.candycrush.math.PositionGrid
import j4k.candycrush.model.GameField
import j4k.candycrush.model.TileCell
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameMechanicsTestS6 {


    @Test
    fun testGetConnectedTiles() {
        val field = GameField.fromString(
                """
                |[H, A, H, H]
                |[H, A, A, A]
                |[H, A, H, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        val vertical: List<TileCell> = listOf(
                field.getTileCell(1, 0), field.getTileCell(1, 1), field.getTileCell(1, 2))

        assertEquals(vertical, mechanics.getConnectedTiles(PositionGrid.Position(1, 0)))
        assertEquals(vertical, mechanics.getConnectedTiles(PositionGrid.Position(1, 2)))

        val horizontal: List<TileCell> = listOf(
                field.getTileCell(1, 1), field.getTileCell(2, 1), field.getTileCell(3, 1))

        assertEquals(horizontal, mechanics.getConnectedTiles(PositionGrid.Position(2, 1)))
        assertEquals(horizontal, mechanics.getConnectedTiles(PositionGrid.Position(3, 1)))

        assertEquals(vertical + horizontal, mechanics.getConnectedTiles(PositionGrid.Position(1, 1)))
    }


    @Test
    fun testIsInRowWithThree() {
        val field = GameField.fromString(
                """
                |[H, A, H, H]
                |[H, A, A, A]
                |[H, A, H, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        // Horizontal
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(1, 0)))
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(1, 1)))
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(1, 2)))

        // Vertical
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(2, 1)))
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(3, 1)))

        // Dont't match holes!
        assertFalse(mechanics.isInRowWithThree(PositionGrid.Position(0, 1)))
    }


    @Test
    fun testHolesAreNotConnected() {
        val field = GameField.fromString(
                """
                |[H, A, H, H]
                |[H, A, A, A]
                |[H, A, H, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        assertEquals(emptyList(), mechanics.getConnectedTiles(PositionGrid.Position(0, 0)))
        assertEquals(emptyList(), mechanics.getConnectedTiles(PositionGrid.Position(0, 1)))
        assertEquals(emptyList(), mechanics.getConnectedTiles(PositionGrid.Position(0, 2)))
    }


    @Test
    fun testIsNotInRowWithThreeIfEmpty() {
        val field = GameField.fromString(
                """
                |[H, A, H, H]
                |[H, A, A, A]
                |[H, A, H, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        // Horizontal
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(1, 0)))
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(1, 1)))
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(1, 2)))
        // Vertical
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(2, 1)))
        assertTrue(mechanics.isInRowWithThree(PositionGrid.Position(3, 1)))
        // Dont't match holes)
        assertFalse(mechanics.isInRowWithThree(PositionGrid.Position(0, 1)))
    }


}