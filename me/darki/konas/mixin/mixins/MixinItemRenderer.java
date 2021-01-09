/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0C;
import me.darki.konas.0D;
import me.darki.konas.0n_0;
import me.darki.konas.0o_0;
import me.darki.konas.1H;
import me.darki.konas.1M;
import me.darki.konas.1q_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ItemRenderer.class})
public abstract class MixinItemRenderer {
    @Shadow
    protected abstract void transformFirstPerson(EnumHandSide var1, float var2);

    @Shadow
    protected abstract void transformSideFirstPerson(EnumHandSide var1, float var2);

    @Inject(method={"transformSideFirstPerson"}, at={@At(value="HEAD")}, cancellable=true)
    public void transformInject(EnumHandSide hand, float y, CallbackInfo ci) {
        int i2 = hand == EnumHandSide.RIGHT ? 1 : -1;
        0D event = new 0D((float)i2 * 0.56f, -0.52f + y * -0.6f, -0.72f, 1.0f, 1.0f, 1.0f, hand == EnumHandSide.LEFT ? 0C.0 : 0C.c);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
            GlStateManager.translate((float)event.8(), (float)event.3(), (float)event.1());
            GlStateManager.scale((float)event.2(), (float)event.0(), (float)event.7());
            GlStateManager.rotate((float)event.6(), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)event.5(), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)event.4(), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    @Inject(method={"updateEquippedItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void onUpdateEquippedItem(CallbackInfo ci) {
        1M event = new 1M();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Inject(method={"transformEatFirstPerson"}, at={@At(value="HEAD")}, cancellable=true)
    public void transformEatFirstPerson(float p_187454_1_, EnumHandSide hand, ItemStack stack, CallbackInfo ci) {
        1H event = new 1H(p_187454_1_, hand, stack);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderItemInFirstPerson(F)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderItemInFirstPerson(float partialTicks, CallbackInfo ci) {
        1q_0 event = new 1q_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Redirect(method={"setLightmap"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;player:Lnet/minecraft/client/entity/EntityPlayerSP;"))
    private EntityPlayerSP redirectLightmapPlayer(Minecraft mc) {
        0n_0 event = new 0n_0((Entity)mc.player);
        EventDispatcher.Companion.dispatch(event);
        return (EntityPlayerSP)event.c();
    }

    @Redirect(method={"rotateArm"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;player:Lnet/minecraft/client/entity/EntityPlayerSP;"))
    private EntityPlayerSP rotateArmPlayer(Minecraft mc) {
        0n_0 event = new 0n_0((Entity)mc.player);
        EventDispatcher.Companion.dispatch(event);
        return (EntityPlayerSP)event.c();
    }

    @Redirect(method={"renderItemInFirstPerson(F)V"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;player:Lnet/minecraft/client/entity/EntityPlayerSP;"))
    private EntityPlayerSP redirectPlayer(Minecraft mc) {
        0n_0 event = new 0n_0((Entity)mc.player);
        EventDispatcher.Companion.dispatch(event);
        return (EntityPlayerSP)event.c();
    }

    @Inject(method={"renderOverlays"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderOverlaysInject(float partialTicks, CallbackInfo ci) {
        0o_0 event = new 0o_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Redirect(method={"renderOverlays"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;player:Lnet/minecraft/client/entity/EntityPlayerSP;"))
    private EntityPlayerSP renderOverlaysPlayer(Minecraft mc) {
        0n_0 event = new 0n_0((Entity)mc.player);
        EventDispatcher.Companion.dispatch(event);
        return (EntityPlayerSP)event.c();
    }
}

