/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1f_0;
import net.minecraft.tileentity.TileEntityBeacon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={TileEntityBeacon.class})
public class MixinTileEntityBeacon {
    @Inject(method={"shouldBeamRender"}, at={@At(value="HEAD")}, cancellable=true)
    public void injectShouldBeamRender(CallbackInfoReturnable<Float> cir) {
        1f_0 event = new 1f_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            cir.setReturnValue((Object)Float.valueOf(0.0f));
        }
    }
}

