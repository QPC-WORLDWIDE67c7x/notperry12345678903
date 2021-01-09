/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1s_0;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.world.storage.MapData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MapItemRenderer.class})
public class MixinMapItemRenderer {
    @Inject(method={"renderMap"}, at={@At(value="HEAD")}, cancellable=true)
    public void onRenderMap(MapData mapdataIn, boolean noOverlayRendering, CallbackInfo ci) {
        1s_0 event = new 1s_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }
}

