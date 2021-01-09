/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0H;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockLiquid.class}, priority=0x7FFFFFFF)
public class MixinBlockLiquid {
    @Inject(method={"canCollideCheck"}, at={@At(value="HEAD")}, cancellable=true)
    public void canCollideCheck(IBlockState state, boolean hitIfLiquid, CallbackInfoReturnable<Boolean> info) {
        0H liquidCanCollideCheckEvent = EventDispatcher.Companion.dispatch(new 0H());
        if (liquidCanCollideCheckEvent.0()) {
            info.setReturnValue((Object)true);
        }
    }
}

