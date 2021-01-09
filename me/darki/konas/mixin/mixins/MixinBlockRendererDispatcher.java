/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.Z;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockRendererDispatcher.class})
public class MixinBlockRendererDispatcher {
    @Inject(method={"renderBlock"}, at={@At(value="HEAD")})
    public void blockRenderInject(IBlockState iBlockState, BlockPos blockPos, IBlockAccess iBlockAccess, BufferBuilder bufferBuilder, CallbackInfoReturnable<Boolean> cir) {
        Z event = new Z(iBlockState.getBlock(), blockPos);
        EventDispatcher.Companion.dispatch(event);
    }
}

