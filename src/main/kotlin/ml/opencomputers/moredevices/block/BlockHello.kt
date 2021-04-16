package ml.opencomputers.moredevices.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World

class BlockHello : Block(Material.ROCK) {
    init {
        blockHardness = 1F
        registryName = ResourceLocation("moredevices", "hello_block")
        unlocalizedName = "moredevices.helloBlock"
    }

    override fun hasTileEntity(state: IBlockState): Boolean = true
    override fun createTileEntity(world: World, state: IBlockState): TileEntity = BlockHelloTile()
}