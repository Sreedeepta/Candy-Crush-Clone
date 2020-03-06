package step1

import j4k.candycrush.model.Tile
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TileTestS1 {


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

}