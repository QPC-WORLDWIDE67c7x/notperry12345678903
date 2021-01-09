/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.3F;
import me.darki.konas.7n_0;
import me.darki.konas.7q_0;
import me.darki.konas.89;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderItem.class})
public class MixinRenderItem {
    @Inject(method={"renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void onRenderItemFixed(ItemStack stack, ItemCameraTransforms.TransformType cameraTransformType, CallbackInfo ci) {
        if (7q_0.2) {
            ci.cancel();
        }
    }

    @Inject(method={"renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;Z)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void onRenderItem(ItemStack stack, EntityLivingBase entitylivingbaseIn, ItemCameraTransforms.TransformType transform, boolean leftHanded, CallbackInfo ci) {
        if (7q_0.2) {
            ci.cancel();
        }
    }

    @ModifyArg(method={"renderEffect"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderItem;renderModel(Lnet/minecraft/client/renderer/block/model/IBakedModel;I)V"), index=1)
    public int changeColor(int in) {
        if (3F.c(7n_0.class).f()) {
            return ((89)7n_0.1.6()).c();
        }
        return in;
    }
}

