/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0n_0;
import me.darki.konas.18;
import me.darki.konas.1e_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiIngame.class})
public class MixinGuiIngame {
    @Inject(method={"renderGameOverlay"}, at={@At(value="TAIL")}, cancellable=true)
    public void renderIngameOverlay(float partialTicks, CallbackInfo info) {
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Konas", 3.0f, 5.0f, 0xFFFFFF);
    }

    @Inject(method={"renderPotionEffects"}, at={@At(value="HEAD")}, cancellable=true)
    protected void renderPotionEffectsHook(ScaledResolution scaledRes, CallbackInfo info) {
        18 event = new 18();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            info.cancel();
        }
    }

    @Inject(method={"renderAttackIndicator"}, at={@At(value="HEAD")}, cancellable=true)
    public void onRenderAttackIndicator(float partialTicks, ScaledResolution p_184045_2_, CallbackInfo ci) {
        1e_0 event = new 1e_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Redirect(method={"renderGameOverlay"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;player:Lnet/minecraft/client/entity/EntityPlayerSP;"))
    private EntityPlayerSP redirectOverlayPlayer(Minecraft mc) {
        0n_0 event = new 0n_0((Entity)mc.player);
        EventDispatcher.Companion.dispatch(event);
        if (event.c() instanceof EntityPlayerSP) {
            return (EntityPlayerSP)event.c();
        }
        return mc.player;
    }

    @Redirect(method={"renderPotionEffects"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;player:Lnet/minecraft/client/entity/EntityPlayerSP;"))
    private EntityPlayerSP redirectPotionPlayer(Minecraft mc) {
        0n_0 event = new 0n_0((Entity)mc.player);
        EventDispatcher.Companion.dispatch(event);
        if (event.c() instanceof EntityPlayerSP) {
            return (EntityPlayerSP)event.c();
        }
        return mc.player;
    }
}

