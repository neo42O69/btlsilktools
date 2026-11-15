package com.battlestickk.silktools.mixin;
import com.battlestickk.silktools.item.moditems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*
"what is this"
this mixin is entirely dedicated to fix a bug where mining ores with the chisel dropped xp from that ore
that would let you dupe xp because then you can just place the ore and mine it again
my first mixin btw
also made trowels not drop xp jsut in case
 */

@Mixin(Block.class)
public abstract class noxpforchisel extends BlockBehaviour
{
    //this does nothing. ts breaks if I remove this
    public noxpforchisel(Properties properties) {
        super(properties);
    }

    //runs this everytime before a block drops xp
    @Inject(method = "tryDropExperience", at = @At("HEAD"), cancellable = true)
    protected void preventchiselxp(ServerLevel level, BlockPos pos, ItemStack tool, IntProvider xpRange, CallbackInfo ci)
    {
        if (tool.getItem() == moditems.CHISEL || tool.getItem() == moditems.TROWEL) //checks if the tool is chisel or trowel
        {
            ci.cancel(); //if it's chisel or trowel then don't drop xp
        }
    }
}
