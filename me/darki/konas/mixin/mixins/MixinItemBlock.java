/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.0W;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ItemBlock.class})
public abstract class MixinItemBlock {
    @Shadow
    protected abstract Block getBlockRaw();

    @Inject(method={"onItemUse"}, at={@At(value="INVOKE")}, cancellable=true)
    public void onPlaceBlock(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ, CallbackInfoReturnable<EnumActionResult> cir) {
        0W event = new 0W(player, worldIn, pos, facing, hitX, hitY, hitZ);
        if (event.0()) {
            ItemStack itemstack;
            if (!this.getBlockRaw().isReplaceable((IBlockAccess)worldIn, pos)) {
                pos = pos.offset(facing);
            }
            if (!(itemstack = player.getHeldItem(hand)).isEmpty() && player.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(this.getBlockRaw(), pos, false, facing, (Entity)player)) {
                cir.setReturnValue((Object)EnumActionResult.SUCCESS);
            } else {
                cir.setReturnValue((Object)EnumActionResult.FAIL);
            }
        }
    }
}

