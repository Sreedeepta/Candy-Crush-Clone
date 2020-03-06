package step8

import j4k.candycrush.GameMechanics
import j4k.candycrush.GameMechanics.InsertMove
import j4k.candycrush.math.PositionGrid.Position
import j4k.candycrush.model.GameField
import j4k.candycrush.model.Tile
import kotlin.test.Test
import kotlin.test.assertEquals

class GameMechanicsTestS8 {


    @Test
    fun testListEmptyCells() {
        val field = GameField.fromString(
                """
                |[H, H, H]
                |[H, A, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)
        val listEmptyCells: Set<Position> = mechanics.listEmptyCells().toSet()
        val holes = setOf(Position(0, 0), Position(1, 0), Position(2, 0), Position(0, 1), Position(2, 1))
        assertEquals(holes, listEmptyCells)
    }


    @Test
    fun testOrderOfNewTileMoves() {
        val field = GameField.fromString(
                """
                |[H]
                |[H]
                |[H]
                """.trimMargin())
        val newTileMoves: List<InsertMove> = GameMechanics(field).getNewTileMoves { Tile.A }
        val rows: List<Int> = newTileMoves.map { it.target }.map { it.row }
        assertEquals(listOf(2, 1, 0), rows)
    }

    @Test
    fun testGetNewTileMoves() {
        val field = GameField.fromString(
                """
                |[A, H, H, H]
                |[A, A, H, H]
                |[A, A, A, H]
                """.trimMargin())
        val mechanics = GameMechanics(field)

        val nextMoves: List<InsertMove> = mechanics.getNewTileMoves { Tile.B }
        mechanics.insert(nextMoves)

        assertEquals(
                """
                |[A, B, B, B]
                |[A, A, B, B]
                |[A, A, A, B]
                """.trimMargin(), mechanics.toString())
    }
}