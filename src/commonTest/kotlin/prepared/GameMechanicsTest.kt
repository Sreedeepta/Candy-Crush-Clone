package prepared

import j4k.candycrush.GameMechanics
import j4k.candycrush.math.PositionGrid
import j4k.candycrush.model.GameField
import j4k.candycrush.model.Tile
import kotlin.test.Test
import kotlin.test.assertEquals

class GameMechanicsTest {


    @Test
    fun testMove() {
        val field = GameField.fromString(
                """
                |[H, H, A, H]
                |[A, A, H, A]
                |[H, H, H, H]
                |[H, A, A, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        mechanics.move(GameMechanics.Move(PositionGrid.Position(0, 3), PositionGrid.Position(0, 1)))
        mechanics.move(GameMechanics.Move(PositionGrid.Position(1, 2), PositionGrid.Position(1, 1)))
        mechanics.move(GameMechanics.Move(PositionGrid.Position(2, 2), PositionGrid.Position(2, 0)))
        mechanics.move(GameMechanics.Move(PositionGrid.Position(3, 3), PositionGrid.Position(3, 1)))

        assertEquals(
                """
                |[H, H, H, H]
                |[H, H, H, H]
                |[H, A, A, H]
                |[A, A, A, A]
                """.trimMargin(), mechanics.toString())
    }


    @Test
    fun testDropToGround() {
        val field = GameField.fromString(
                """
                |[H, A, A, A]
                |[H, A, H, A]
                |[A, H, A, A]
                |[H, H, H, H]
                |[H, A, A, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)
        mechanics.dropToGround(0)
        assertEquals(
                """
                |[H, A, A, A]
                |[H, A, H, A]
                |[H, H, A, A]
                |[H, H, H, H]
                |[A, A, A, H]
                """.trimMargin(), mechanics.field.toString())
        mechanics.dropToGround(1)
        assertEquals(
                """
                |[H, H, A, A]
                |[H, H, H, A]
                |[H, A, A, A]
                |[H, A, H, H]
                |[A, A, A, H]
                """.trimMargin(), mechanics.field.toString())
        mechanics.dropToGround(2)
        assertEquals(
                """
                |[H, H, H, A]
                |[H, H, H, A]
                |[H, A, A, A]
                |[H, A, A, H]
                |[A, A, A, H]
                """.trimMargin(), mechanics.field.toString())
        mechanics.dropToGround(3)
        assertEquals(
                """
                |[H, H, H, H]
                |[H, H, H, H]
                |[H, A, A, A]
                |[H, A, A, A]
                |[A, A, A, A]
                """.trimMargin(), mechanics.field.toString())
    }


    @Test
    fun testGetNextMove() {
        val field = GameField.fromString(
                """
                |[H, H, A, H]
                |[A, A, H, A]
                |[H, H, H, H]
                |[H, A, A, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        assertEquals(
                GameMechanics.Move(PositionGrid.Position(0, 3), PositionGrid.Position(0, 1)), mechanics.getNextMove(0))
        assertEquals(
                GameMechanics.Move(PositionGrid.Position(1, 2), PositionGrid.Position(1, 1)), mechanics.getNextMove(1))
        assertEquals(
                GameMechanics.Move(PositionGrid.Position(2, 2), PositionGrid.Position(2, 0)), mechanics.getNextMove(2))
        assertEquals(
                GameMechanics.Move(PositionGrid.Position(3, 3), PositionGrid.Position(3, 1)), mechanics.getNextMove(3))
    }


    @Test
    fun testSortInsertMoves() {
        val moves: List<GameMechanics.InsertMove> = listOf(1, 2, 0).map { mockInsertMove(it) }
        val sorted: List<GameMechanics.InsertMove> = moves.sorted()
        assertEquals(listOf(2, 1, 0).map { mockInsertMove(it) }, sorted)
    }

    private fun mockInsertMove(row: Int = 0, column: Int = 0, tile: Tile = Tile.A): GameMechanics.InsertMove {
        return GameMechanics.InsertMove(PositionGrid.Position(column, row), tile)
    }

}