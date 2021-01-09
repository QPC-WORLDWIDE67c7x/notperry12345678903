/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.3F;
import me.darki.konas.7n_0;
import me.darki.konas.7q_0;
import me.darki.konas.89;
import me.darki.konas.W;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LayerArmorBase.class})
public class MixinLayerArmorBase {
    @Inject(method={"renderArmorLayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void onRenderArmorLayer(EntityLivingBase entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, EntityEquipmentSlot slotIn, CallbackInfo ci) {
        if (7q_0.2) {
            ci.cancel();
            return;
        }
        W event = W.c(slotIn);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Redirect(method={"renderEnchantedGlint"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;color(FFFF)V"))
    private static void onRenderEnchantedGlint(float colorRed, float colorGreen, float colorBlue, float colorAlpha) {
        if (colorBlue == 0.608f && 3F.c(7n_0.class).f()) {
            GlStateManager.color((float)((float)((89)7n_0.1.6()).6() / 255.0f), (float)((float)((89)7n_0.1.6()).5() / 255.0f), (float)((float)((89)7n_0.1.6()).2() / 255.0f), (float)((float)((89)7n_0.1.6()).1() / 255.0f));
        } else {
            GlStateManager.color((float)colorRed, (float)colorGreen, (float)colorBlue, (float)colorAlpha);
        }
    }
}

