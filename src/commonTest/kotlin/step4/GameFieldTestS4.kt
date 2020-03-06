package step4

import j4k.candycrush.model.GameField
import j4k.candycrush.model.Tile
import kotlin.test.Test
import kotlin.test.assertEquals

class GameFieldTestS4 {

    @Test
    fun testGetColumn() {
        val field = GameField.fromString(
                """
                |[H, A, H]
                |[H, B, A]
                |[H, C, H]
                """.trimMargin())

        val row0 = listOf(Tile.Hole, Tile.Hole, Tile.Hole)
        assertEquals(row0, field.getColumn(0))

        val row1 = listOf(Tile.A, Tile.B, Tile.C)
        assertEquals(row1, field.getColumn(1))

        val row2 = listOf(Tile.Hole, Tile.A, Tile.Hole)
        assertEquals(row2, field.getColumn(2))
    }
}