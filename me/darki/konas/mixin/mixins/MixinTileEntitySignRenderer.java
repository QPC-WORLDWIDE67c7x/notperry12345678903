/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1y_0;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TileEntitySignRenderer.class})
public class MixinTileEntitySignRenderer {
    public ITextComponent[] cache = null;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    public void renderHead(TileEntitySign te, double x, double y, double z, float partialTicks, int destroyStage, float alpha, CallbackInfo ci) {
        1y_0 event = new 1y_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            this.cache = new ITextComponent[te.signText.length];
            for (int i2 = 0; i2 < te.signText.length; ++i2) {
                this.cache[i2] = te.signText[i2];
                te.signText[i2] = null;
            }
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    public void renderTail(TileEntitySign te, double x, double y, double z, float partialTicks, int destroyStage, float alpha, CallbackInfo ci) {
        1y_0 event = new 1y_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            System.arraycopy(this.cache, 0, te.signText, 0, te.signText.length);
            this.cache = null;
        }
    }
}

