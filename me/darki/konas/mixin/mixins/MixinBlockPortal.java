/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0q_0;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockPortal.class})
public class MixinBlockPortal {
    private static final AxisAlignedBB EMPTY_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

    @Inject(method={"getBoundingBox"}, at={@At(value="HEAD")}, cancellable=true)
    private void injectBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos, CallbackInfoReturnable<AxisAlignedBB> cir) {
        0q_0 event = new 0q_0(state, source, pos);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            cir.setReturnValue((Object)EMPTY_AABB);
        }
    }
}

