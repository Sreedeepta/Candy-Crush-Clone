package j4k.candycrush.model

/**
 * A single tile which can be placed on the [GameField].
 */
enum class Tile {

    A, B, C, D, E,
    /**
     * A wall which blocks falling stones. Not used.
     */
    Wall,
    /**
     * An empty field.
     */
    Hole,

    /**
     * The Tile is not present. Happens if Tile coordinates are out of the [GameField].
     */
    OutOfSpace;

    val index = ordinal

    /**
     * @return One upper case letter representation of this tile.
     */
    fun shortName(): String {
        // TODO
        return ""
    }

    fun isWall() = this == Wall

    fun isHole() = this == Hole

    /**
     * Returns `true` if this is a tile, which can be moved by the player.
     */
    fun isTile(): Boolean {
        // TODO
        return false
    }

    fun isNotTile() = !isTile()

    fun isOutOfSpace() = this == OutOfSpace

    companion object {

        private val shortNames = mutableMapOf<String, Tile>()

        init {

        }

        fun getTile(index: Int): Tile {
            if (index > values().size) {
                throw IllegalArgumentException("Tile index $index > ${values().size} is not available")
            }
            val tile = values()[index]
            if (tile.isNotTile()) {
                throw IllegalArgumentException("Tile $tile for index $index is not a tile")
            }
            return tile
        }

        /**
         * @return The [Tile] which is mapped to the given one character.
         */
        fun getTile(shortName: String): Tile {
            // TODO
            return A
        }

        fun randomTile() = values().filter { it.isTile() }.random()

    }


}