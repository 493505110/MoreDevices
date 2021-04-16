package ml.opencomputers.moredevices.item

import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

class ItemGoldenEgg : Item() {
    init {
        registryName = ResourceLocation("moredevices", "golden_egg")
        unlocalizedName = "moredevices.goldenEgg"
    }
}