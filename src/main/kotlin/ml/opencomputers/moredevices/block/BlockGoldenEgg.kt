package ml.opencomputers.moredevices.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.util.ResourceLocation

class BlockGoldenEgg : Block(Material.ROCK) {
    init {
        blockHardness = 1F
        registryName = ResourceLocation("moredevices", "golden_egg_block")
        unlocalizedName = "moredevices.goldenEggBlock"
    }
}