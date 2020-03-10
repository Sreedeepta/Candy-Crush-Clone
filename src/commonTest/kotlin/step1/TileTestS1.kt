package step1

import j4k.candycrush.model.GameField
import j4k.candycrush.model.Tile
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TileTestS1 {


    /**
     * Only [Tile]s will be visible on the [GameField].
     * Check the the game after fixing this test.
     * You should see a level out of one equal tile.
     */
    @Test
    fun testIsTile() {
        assertTrue(Tile.A.isTile())
        assertTrue(Tile.B.isTile())
        assertTrue(Tile.C.isTile())
        assertTrue(Tile.D.isTile())
        assertTrue(Tile.E.isTile())
        assertFalse(Tile.Hole.isTile())
        assertFalse(Tile.OutOfSpace.isTile())
        assertFalse(Tile.Wall.isTile())
    }

    /**
     * To export or debug a level, wee need to convert a
     * [String] into a [Tile].
     */
    @Test
    fun testGetShortName() {
        assertEquals("A", Tile.A.shortName())
        assertEquals("B", Tile.B.shortName())
        assertEquals("C", Tile.C.shortName())
        assertEquals("D", Tile.D.shortName())
        assertEquals("E", Tile.E.shortName())
        assertEquals("H", Tile.Hole.shortName())
        assertEquals("O", Tile.OutOfSpace.shortName())
        assertEquals("W", Tile.Wall.shortName())
    }

    /**
     * Ensures we can load [Tile]s from textual stored levels.
     * Check the game after fixing this test. You should see level tiles.
     */
    @Test
    fun testConvertCharToTile() {
        assertEquals(Tile.A, Tile.getTile("A"))
        assertEquals(Tile.B, Tile.getTile("B"))
        assertEquals(Tile.C, Tile.getTile("C"))
        assertEquals(Tile.D, Tile.getTile("D"))
        assertEquals(Tile.E, Tile.getTile("E"))
        assertEquals(Tile.Hole, Tile.getTile("H"))
        assertEquals(Tile.OutOfSpace, Tile.getTile("O"))
        assertEquals(Tile.Wall, Tile.getTile("W"))
    }

}