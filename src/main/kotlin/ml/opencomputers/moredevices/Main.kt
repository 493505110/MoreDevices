package ml.opencomputers.moredevices

import ml.opencomputers.moredevices.block.BlockGoldenEgg
import ml.opencomputers.moredevices.block.BlockGoldenEgg2
import ml.opencomputers.moredevices.block.BlockHello
import ml.opencomputers.moredevices.block.BlockHelloTile
import ml.opencomputers.moredevices.item.ItemGoldenEgg
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.apache.logging.log4j.Logger

@Mod(modid = "moredevices", name = "More devices", version = "0.1.0")
class Main {
    companion object {
        lateinit var logger: Logger

        var itemGoldenEgg: Item = ItemGoldenEgg()

        var blockGoldenEgg: Block = BlockGoldenEgg()
        var blockGoldenEgg2: Block = BlockGoldenEgg2()
        var blockHello: Block = BlockHello()

        val moredevices_tab: CreativeTabs = object : CreativeTabs("moredevices") {
            override fun getTabIconItem(): ItemStack {
                return ItemStack(itemGoldenEgg)
            }
        }
    }

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger=event.modLog
        logger.info("Hello,kotlin and forge!")
        logger.info("Registering events...")
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        logger.info("Loading items...")
        event.registry.registerAll(
            itemGoldenEgg.setCreativeTab(moredevices_tab),
            ItemBlock(blockGoldenEgg).setRegistryName("golden_egg_block"),
            ItemBlock(blockGoldenEgg2).setRegistryName("golden_egg_block2"),
            ItemBlock(blockHello).setRegistryName("hello_block")
        )
    }

    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        logger.info("Loading blocks...")
        event.registry.registerAll(
            blockGoldenEgg.setCreativeTab(moredevices_tab),
            blockGoldenEgg2.setCreativeTab(moredevices_tab),
            blockHello.setCreativeTab(moredevices_tab)
        )
        GameRegistry.registerTileEntity(BlockHelloTile::class.java,
                ResourceLocation("moredevices", "hello_block"))

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    fun registerItemModels(event: ModelRegistryEvent) {
        logger.info("Loading models...")
        ModelLoader.setCustomModelResourceLocation(
            itemGoldenEgg,
            0,
            ModelResourceLocation(itemGoldenEgg.registryName!!, "inventory")
        )
        ModelLoader.setCustomModelResourceLocation(
            Item.getItemFromBlock(blockGoldenEgg),
            0,
            ModelResourceLocation(blockGoldenEgg.registryName!!, "inventory")
        )
        ModelLoader.setCustomModelResourceLocation(
            Item.getItemFromBlock(blockGoldenEgg2),
            0,
            ModelResourceLocation(blockGoldenEgg2.registryName!!, "inventory")
        )
        ModelLoader.setCustomModelResourceLocation(
            Item.getItemFromBlock(blockHello),
            0,
            ModelResourceLocation(blockHello.registryName!!, "inventory")
        )
    }
}