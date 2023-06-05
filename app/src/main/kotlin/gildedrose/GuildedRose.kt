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
            if (item.name == "Sulfuras, Hand of Ragnaros") continue
            item.sellInDays = item.sellInDays - 1

            if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                item.increaseQuality()
                if (item.sellInDays < 10) {
                    item.increaseQuality()
                }
                if (item.sellInDays < 5) {
                    item.increaseQuality()
                }
                if (item.isExpired()) {
                    item.quality = item.quality - item.quality
                }

            } else if (item.name == "Aged Brie") {
                item.increaseQuality()
                if (item.isExpired()) {
                    item.increaseQuality()
                }
            } else if (item.name == "Conjured Mana Cake") {
                item.decreaseQuality()
                if (item.isExpired()) {
                    item.decreaseQuality()
                }
                item.decreaseQuality()
                if (item.isExpired()) {
                    item.decreaseQuality()
                }
            } else {
                item.decreaseQuality()
                if (item.isExpired()) {
                    item.decreaseQuality()
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

fun Item.increaseQuality() {
    if (quality < 50) quality++
}

fun Item.decreaseQuality() {
    if (quality > 0) quality--
}

fun Item.isExpired() : Boolean {
    return sellInDays < 0
}

fun main() {
    println("Opening guilded rose store...")
    GuildedRose().updateQuality()
}
