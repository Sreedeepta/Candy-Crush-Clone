package step3

import j4k.candycrush.GameMechanics
import j4k.candycrush.math.PositionGrid.Position
import j4k.candycrush.model.GameField
import kotlin.test.Test
import kotlin.test.assertEquals

class GameMechanicsTestS3 {


    @Test
    fun testSwapTiles() {
        val field = GameField.fromString(
                """
                |[H, H, H, H]
                |[H, A, B, H]
                |[H, H, H, H]
                """.trimMargin())

        val mechanics = GameMechanics(field)
        mechanics.swapTiles(Position(1, 1), Position(2, 1))

        assertEquals(
                """
                |[H, H, H, H]
                |[H, B, A, H]
                |[H, H, H, H]
                """.trimMargin(), field.toString())
    }


    @Test
    fun removeTilesTest() {
        val field = GameField.fromString(
                """
                |[A, A]
                |[A, A]
                """.trimMargin())
        val mechanics = GameMechanics(field)
        mechanics.removeTile(Position(0, 0))
        mechanics.removeTile(Position(1, 1))
        assertEquals(
                """
                |[H, A]
                |[A, H]
                """.trimMargin(), field.toString())
    }


}