/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package gildedrose

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GuildedRoseTest {

//    val items = listOf(
//        Item(name="+5 Dexterity Vest", sellInDays = 10, quality = 20),
//        Item(name="Aged Brie", sellInDays = 2, quality = 0),
//        Item(name="Elixir of the Mongoose", sellInDays = 5, quality = 7),
//        Item(name="Sulfuras, Hand of Ragnaros", sellInDays = 0, quality = 80),
//        Item(name="Backstage passes to a TAFKAL80ETC concert", sellInDays = 15, quality = 20),
//        Item(name="Conjured Mana Cake", sellInDays = 3, quality = 6),
//    )

    var rose = GuildedRose()
    @BeforeTest
    fun updateQuality() {
        rose = GuildedRose()
        rose.updateQuality()
    }

    @Test
    fun `sulfuras cost always 80`() {
        assertEquals(80, rose.items.first { it.name == "Sulfuras, Hand of Ragnaros" }.quality)
    }

    @Test
    fun `quality is never negative`() {
        rose.items.forEach {
            assertTrue( it.quality > 0)
        }
    }

    @Test
    fun `elixir reduces both values by one`() {
        assertEquals(6, rose.items.first {it.name == "Elixir of the Mongoose"}.quality )
        assertEquals(4, rose.items.first {it.name == "Elixir of the Mongoose"}.sellInDays )
    }

    @Test
    fun `Vest quality decreases twice as fast after sellInDays`() {
        assertEquals(19, rose.items.first {it.name == "+5 Dexterity Vest"}.quality )
        assertEquals(9, rose.items.first {it.name == "+5 Dexterity Vest"}.sellInDays )
        for (times in 1..10) {
            rose.updateQuality()
        }
        assertEquals(8, rose.items.first {it.name == "+5 Dexterity Vest"}.quality )
        assertEquals(-1, rose.items.first {it.name == "+5 Dexterity Vest"}.sellInDays )
    }

    @Test
    fun `Aged Brie increases in quality once its sellIn passes`() {

    }
}
