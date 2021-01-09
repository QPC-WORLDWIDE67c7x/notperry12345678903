/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1h_0;
import net.minecraft.client.renderer.tileentity.TileEntityEnchantmentTableRenderer;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TileEntityEnchantmentTableRenderer.class})
public class MixinTileEntityEnchantmentTableRenderer {
    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderBook(TileEntityEnchantmentTable te, double x, double y, double z, float partialTicks, int destroyStage, float alpha, CallbackInfo ci) {
        1h_0 event = new 1h_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }
}

