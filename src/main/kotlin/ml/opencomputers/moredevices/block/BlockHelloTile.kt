package ml.opencomputers.moredevices.block

import li.cil.oc.api.machine.Arguments
import li.cil.oc.api.machine.Callback
import li.cil.oc.api.machine.Context
import li.cil.oc.api.network.SimpleComponent
import net.minecraft.tileentity.TileEntity

class BlockHelloTile : TileEntity(), SimpleComponent {
    override fun getComponentName(): String = "fancy_thing"

    @Callback
    fun greet(context: Context, args: Arguments): Array<Any> {
        return arrayOf(
            String.format("Hello, %s!", args.checkString(0))
        )
    }
}