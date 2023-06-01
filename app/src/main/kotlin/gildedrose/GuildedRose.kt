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

    fun updateQuality() {
        for (item in items) {
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.quality = item.quality - 1
                    }
                }
            }
            else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.sellInDays < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }
                        if (item.sellInDays < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }
                    }

                }
            }
            if (item.name != "Sulfuras, Hand of Ragnaros") {
                item.sellInDays = item.sellInDays - 1
            }
            if (item.sellInDays < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0) {
                            if (item.name != "Sulfuras, Hand of Ragnaros") {
                                item.quality = item.quality - 1
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }
        }
    }
}

data class Item(
    var name: String,
    var sellInDays: Int,
    var quality: Int
) 

fun List<Item>.name(name: String): Item = this.first { it.name == name }

fun main() {
    println("Opening guilded rose store...")
    GuildedRose().updateQuality()
}
