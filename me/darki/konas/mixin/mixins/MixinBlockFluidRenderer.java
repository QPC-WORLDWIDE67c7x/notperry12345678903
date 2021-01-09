/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1V;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockFluidRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockFluidRenderer.class})
public class MixinBlockFluidRenderer {
    @Inject(method={"renderFluid"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderFluidHook(IBlockAccess blockAccess, IBlockState blockState, BlockPos blockPos, BufferBuilder bufferBuilder, CallbackInfoReturnable<Boolean> info) {
        1V event = new 1V(blockState.getBlock());
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            info.setReturnValue((Object)false);
            info.cancel();
        }
    }
}

