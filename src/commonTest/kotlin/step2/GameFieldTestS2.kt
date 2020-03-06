package step2

import j4k.candycrush.model.GameField
import j4k.candycrush.model.Row
import j4k.candycrush.model.Tile
import kotlin.test.Test
import kotlin.test.assertEquals

class GameFieldTestS2 {


    @Test
    fun testGetFieldOutOfSpace() {
        val field = GameField(2, 2)
        assertEquals(Tile.OutOfSpace, field.getTile(-1, 0))
        assertEquals(Tile.OutOfSpace, field.getTile(0, -1))
        assertEquals(Tile.OutOfSpace, field.getTile(0, 2))
        assertEquals(Tile.OutOfSpace, field.getTile(2, 0))
    }


    @Test
    fun testGetRowOutOfSpace() {
        val field = GameField(2, 2)
        assertEquals(Row.outOfSpace(), field.getRow(-1))
        assertEquals(Row.outOfSpace(), field.getRow(2))
    }


}