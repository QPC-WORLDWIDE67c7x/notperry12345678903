/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1l_0;
import me.darki.konas.1m_0;
import me.darki.konas.1t_0;
import me.darki.konas.3F;
import me.darki.konas.7l_0;
import me.darki.konas.7q_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderLivingBase.class}, priority=0x7FFFFFFF)
public abstract class MixinRenderLivingBase
extends Render {
    @Shadow
    protected ModelBase mainModel;

    protected MixinRenderLivingBase(RenderManager renderManager) {
        super(renderManager);
    }

    @Shadow
    protected abstract void renderModel(T var1, float var2, float var3, float var4, float var5, float var6, float var7);

    @Shadow
    protected abstract boolean isVisible(T var1);

    @Redirect(method={"doRender"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/entity/RenderLivingBase;renderModel(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V"))
    public void outlineRedirect(RenderLivingBase renderLivingBase, T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        1m_0 pre = new 1m_0(renderLivingBase.getMainModel(), (Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        if (!7q_0.2) {
            EventDispatcher.Companion.dispatch(pre);
        }
        if (!pre.0()) {
            if (3F.c(7l_0.class).f() || 3F.c(7q_0.class).f()) {
                boolean flag1;
                boolean flag = this.isVisible(entity);
                boolean bl = flag1 = !flag && !entity.isInvisibleToPlayer((EntityPlayer)Minecraft.getMinecraft().player);
                if (flag || flag1) {
                    if (!this.bindEntityTexture((Entity)entity)) {
                        if (!7q_0.2) {
                            1l_0 post = new 1l_0(renderLivingBase.getMainModel(), (Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
                            EventDispatcher.Companion.dispatch(post);
                        }
                        return;
                    }
                    if (flag1) {
                        GlStateManager.enableBlendProfile((GlStateManager.Profile)GlStateManager.Profile.TRANSPARENT_MODEL);
                    }
                    if ((3F.c(7l_0.class).f() || 7l_0.1) && !7q_0.2 && 7l_0.c(this.mainModel, entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor)) {
                        if (!7q_0.2) {
                            1l_0 post = new 1l_0(renderLivingBase.getMainModel(), (Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
                            EventDispatcher.Companion.dispatch(post);
                        }
                        return;
                    }
                    this.mainModel.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
                    if (flag1) {
                        GlStateManager.disableBlendProfile((GlStateManager.Profile)GlStateManager.Profile.TRANSPARENT_MODEL);
                    }
                }
            } else {
                this.renderModel(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
            }
        }
        if (!7q_0.2) {
            1l_0 post = new 1l_0(renderLivingBase.getMainModel(), (Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
            EventDispatcher.Companion.dispatch(post);
        }
    }

    @Inject(method={"doRender"}, at={@At(value="RETURN")})
    public void injectReturn(T entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (entity instanceof EntityPlayer) {
            7q_0.c((EntityPlayer)entity, (ModelPlayer)this.mainModel, partialTicks);
        }
    }

    @Inject(method={"renderName"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderName(EntityLivingBase entity, double x, double y, double z, CallbackInfo ci) {
        if (7q_0.2) {
            ci.cancel();
            return;
        }
        1t_0 event = new 1t_0(entity);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }
}

