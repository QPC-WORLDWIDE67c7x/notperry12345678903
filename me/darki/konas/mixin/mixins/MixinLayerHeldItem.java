/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.7q_0;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LayerHeldItem.class})
public class MixinLayerHeldItem {
    @Inject(method={"doRenderLayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void onDoRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, CallbackInfo ci) {
        if (7q_0.2) {
            ci.cancel();
        }
    }
}

