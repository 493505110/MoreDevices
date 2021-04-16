package ml.opencomputers.moredevices.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.util.ResourceLocation

class BlockGoldenEgg2 : Block(Material.ROCK) {
    init {
        blockHardness = 1F
        registryName = ResourceLocation("moredevices", "golden_egg_block2")
        unlocalizedName = "moredevices.goldenEggBlock"
    }
}