package gildedrose

@Suppress("MemberVisibilityCanBePrivate", "KotlinConstantConditions")
class GuildedRose {
    
    val items = listOf(
        Item(name="+5 Dexterity Vest", sellInDays = 10, quality = 20),
        Item(name="Aged Brie", sellInDays = 2, quality = 0),
        Item(name="Elixir of the Mongoose", sellInDays = 5, quality = 7),
        Item(name="Sulfuras, Hand of Ragnaros", sellInDays = 0, quality = 80),
        Item(name="Backstage passes to a TAFKAL80ETC concert", sellInDays = 15, quality = 20),
        Item(name="Conjured Mana Cake", sellInDays = 3, quality = 6),
    )

    fun Item.decreaseQuality() {
        sellInDays -= 1
        if (quality > 0) {
            quality -= 1
        }
        if (sellInDays < 0) {
            quality -= 1
        }
    }

    fun Item.increaseQuality() {
        if (quality < 50) {
            quality += 1
        }
    }

    fun updateQuality() {
        for (item in items) {
            when (item.name) {
                "Sulfuras, Hand of Ragnaros" -> continue
                "Aged Brie" -> {item.increaseQuality(); item.sellInDays -= 1; if (item.sellInDays < 0) item.increaseQuality(); }
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    item.increaseQuality()
                    if (item.sellInDays < 11) {
                        item.increaseQuality()
                    }
                    if (item.sellInDays < 6) {
                        item.increaseQuality()
                    }
                    item.sellInDays -= 1
                    if (item.sellInDays < 0) {
                        item.quality = 0
                    }
                }
                else -> item.decreaseQuality()
            }
        }
    }
}

class Item(
    var name: String,
    var sellInDays: Int,
    var quality: Int
) 

fun List<Item>.name(name: String): Item = this.first { it.name == name }

fun main() {
    println("Opening guilded rose store...")
    GuildedRose().updateQuality()
}
