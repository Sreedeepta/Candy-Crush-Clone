package step2

import j4k.candycrush.GameMechanics
import j4k.candycrush.math.PositionGrid.Position
import j4k.candycrush.model.GameField
import j4k.candycrush.model.TileCell
import kotlin.test.Test
import kotlin.test.assertEquals

class GameMechanicsTestS5 {

    @Test
    fun testThreeVerticalSurroundings() {
        val field = GameField.fromString(
                """
                |[H, A, H, H]
                |[H, A, A, A]
                |[H, A, H, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        val vertical: List<TileCell> = listOf(
                field.getTileCell(1, 0), field.getTileCell(1, 1), field.getTileCell(1, 2))
        assertEquals(vertical, mechanics.getVerticalSurroundings(Position(1, 0)))
        assertEquals(vertical, mechanics.getVerticalSurroundings(Position(1, 1)))
        assertEquals(vertical, mechanics.getVerticalSurroundings(Position(1, 2)))
    }


    @Test
    fun testThreeHorizontalSurroundings() {
        val field = GameField.fromString(
                """
                |[H, A, H, H]
                |[H, A, A, A]
                |[H, A, H, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        val horizontal: List<TileCell> = listOf(
                field.getTileCell(1, 1), field.getTileCell(2, 1), field.getTileCell(3, 1))

        assertEquals(horizontal, mechanics.getHorizontalSurroundings(Position(2, 1)))
        assertEquals(horizontal, mechanics.getHorizontalSurroundings(Position(1, 1)))
        assertEquals(horizontal, mechanics.getHorizontalSurroundings(Position(3, 1)))
    }


    @Test
    fun testGetDisconnectedHoles() {
        val field = GameField.fromString(
                """
                |[H, A, H, H]
                |[H, A, A, A]
                |[H, A, H, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        val hole1: List<TileCell> = listOf(field.getTileCell(0, 0))
        assertEquals(hole1, mechanics.getHorizontalSurroundings(Position(0, 0)))
        assertEquals(hole1, mechanics.getVerticalSurroundings(Position(0, 0)))

        val hole2: List<TileCell> = listOf(field.getTileCell(0, 1))
        assertEquals(hole2, mechanics.getHorizontalSurroundings(Position(0, 1)))
        assertEquals(hole2, mechanics.getVerticalSurroundings(Position(0, 1)))

        val hole3: List<TileCell> = listOf(field.getTileCell(0, 2))
        assertEquals(hole3, mechanics.getHorizontalSurroundings(Position(0, 2)))
        assertEquals(hole3, mechanics.getVerticalSurroundings(Position(0, 2)))
    }

}