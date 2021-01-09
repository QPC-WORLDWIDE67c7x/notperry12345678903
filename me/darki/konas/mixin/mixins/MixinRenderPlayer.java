/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0o_0;
import me.darki.konas.1d_0;
import me.darki.konas.3F;
import me.darki.konas.7P;
import me.darki.konas.7k_0;
import me.darki.konas.7l_0;
import me.darki.konas.89;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderPlayer.class})
public abstract class MixinRenderPlayer {
    private float renderPitch;
    private float renderYaw;
    private float renderHeadYaw;
    private float prevRenderHeadYaw;
    private float lastRenderHeadYaw = 0.0f;
    private float prevRenderPitch;
    private float lastRenderPitch = 0.0f;
    private boolean preCancelled = false;

    @Shadow
    public abstract ModelPlayer getMainModel();

    @Shadow
    protected abstract void setModelVisibilities(AbstractClientPlayer var1);

    @Inject(method={"doRender"}, at={@At(value="HEAD")})
    private void rotateBegin(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (3F.c(7P.class).f() && entity == Minecraft.getMinecraft().player) {
            this.prevRenderHeadYaw = entity.prevRotationYawHead;
            this.prevRenderPitch = entity.prevRotationPitch;
            this.renderPitch = entity.rotationPitch;
            this.renderYaw = entity.rotationYaw;
            this.renderHeadYaw = entity.rotationYawHead;
            entity.rotationPitch = 7P.0();
            entity.prevRotationPitch = this.lastRenderPitch;
            entity.rotationYaw = 7P.c();
            entity.rotationYawHead = 7P.c();
            entity.prevRotationYawHead = this.lastRenderHeadYaw;
        }
    }

    @Inject(method={"doRender"}, at={@At(value="RETURN")})
    private void rotateEnd(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (3F.c(7P.class).f() && entity == Minecraft.getMinecraft().player) {
            this.lastRenderHeadYaw = entity.rotationYawHead;
            this.lastRenderPitch = entity.rotationPitch;
            entity.rotationPitch = this.renderPitch;
            entity.rotationYaw = this.renderYaw;
            entity.rotationYawHead = this.renderHeadYaw;
            entity.prevRotationYawHead = this.prevRenderHeadYaw;
            entity.prevRotationPitch = this.prevRenderPitch;
        }
    }

    @Inject(method={"renderRightArm"}, at={@At(value="FIELD", target="Lnet/minecraft/client/model/ModelPlayer;swingProgress:F", opcode=181)}, cancellable=true)
    public void renderRightArmBegin(AbstractClientPlayer clientPlayer, CallbackInfo ci) {
        if (clientPlayer == Minecraft.getMinecraft().player) {
            1d_0 event = new 1d_0();
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                GL11.glPushAttrib((int)1048575);
                GL11.glDisable((int)3008);
                GL11.glDisable((int)3553);
                GL11.glDisable((int)2896);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glLineWidth((float)1.5f);
                GL11.glEnable((int)2960);
                GL11.glEnable((int)10754);
                OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
                GL11.glColor4f((float)(event.2() / 255.0f), (float)(event.0() / 255.0f), (float)(event.c() / 255.0f), (float)(event.1() / 255.0f));
                this.preCancelled = true;
            }
        }
    }

    @Inject(method={"renderRightArm"}, at={@At(value="RETURN")}, cancellable=true)
    public void renderRightArmReturn(AbstractClientPlayer clientPlayer, CallbackInfo ci) {
        if (clientPlayer == Minecraft.getMinecraft().player && this.preCancelled) {
            GL11.glEnable((int)3042);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)3008);
            GL11.glPopAttrib();
            this.preCancelled = false;
        }
        if (7l_0.L.6() != 7k_0.c && 3F.c(7l_0.class).f()) {
            ModelPlayer modelplayer = this.getMainModel();
            this.setModelVisibilities(clientPlayer);
            GlStateManager.enableBlend();
            modelplayer.swingProgress = 0.0f;
            modelplayer.isSneak = false;
            modelplayer.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, (Entity)clientPlayer);
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(7l_0.L.6() == 7k_0.1 ? 7l_0.0 : 7l_0.c);
            GL11.glPushAttrib((int)1048575);
            GL11.glPolygonMode((int)1032, (int)6914);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            GL11.glEnable((int)3042);
            GL11.glColor4f((float)((float)((89)7l_0.O.6()).6() / 255.0f), (float)((float)((89)7l_0.O.6()).5() / 255.0f), (float)((float)((89)7l_0.O.6()).2() / 255.0f), (float)((float)((89)7l_0.O.6()).1() / 255.0f));
            GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_COLOR, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE);
            for (int i2 = 0; i2 < 2; ++i2) {
                GlStateManager.matrixMode((int)5890);
                GlStateManager.loadIdentity();
                float tScale = 0.33333334f * ((Float)7l_0.N.6()).floatValue();
                GlStateManager.scale((float)tScale, (float)tScale, (float)tScale);
                GlStateManager.rotate((float)(30.0f - (float)i2 * 60.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GlStateManager.translate((float)0.0f, (float)(((float)clientPlayer.ticksExisted + Minecraft.getMinecraft().getRenderPartialTicks()) * (0.001f + (float)i2 * 0.003f) * ((Float)7l_0.M.6()).floatValue()), (float)0.0f);
                GlStateManager.matrixMode((int)5888);
                modelplayer.bipedRightArm.rotateAngleX = 0.0f;
                modelplayer.bipedRightArm.render(0.0625f);
                modelplayer.bipedRightArmwear.rotateAngleX = 0.0f;
                modelplayer.bipedRightArmwear.render(0.0625f);
            }
            GlStateManager.matrixMode((int)5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode((int)5888);
            GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            GL11.glScalef((float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()));
            GL11.glPopAttrib();
            GL11.glPopMatrix();
            GlStateManager.disableBlend();
        }
    }

    @Inject(method={"renderLeftArm"}, at={@At(value="FIELD", target="Lnet/minecraft/client/model/ModelPlayer;swingProgress:F", opcode=181)}, cancellable=true)
    public void renderLeftArmBegin(AbstractClientPlayer clientPlayer, CallbackInfo ci) {
        if (clientPlayer == Minecraft.getMinecraft().player) {
            1d_0 event = new 1d_0();
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                GL11.glPushAttrib((int)1048575);
                GL11.glDisable((int)3008);
                GL11.glDisable((int)3553);
                GL11.glDisable((int)2896);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glLineWidth((float)1.5f);
                GL11.glEnable((int)2960);
                GL11.glEnable((int)10754);
                OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
                GL11.glColor4f((float)(event.2() / 255.0f), (float)(event.0() / 255.0f), (float)(event.c() / 255.0f), (float)(event.1() / 255.0f));
                this.preCancelled = true;
            }
        }
    }

    @Inject(method={"renderLeftArm"}, at={@At(value="RETURN")}, cancellable=true)
    public void renderLeftArmReturn(AbstractClientPlayer clientPlayer, CallbackInfo ci) {
        if (clientPlayer == Minecraft.getMinecraft().player && this.preCancelled) {
            GL11.glEnable((int)3042);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)3008);
            GL11.glPopAttrib();
            this.preCancelled = false;
        }
    }

    @Redirect(method={"doRender"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/AbstractClientPlayer;isUser()Z"))
    private boolean isUserRedirect(AbstractClientPlayer abstractClientPlayer) {
        Minecraft mc = Minecraft.getMinecraft();
        0o_0 event = new 0o_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return abstractClientPlayer.isUser() && abstractClientPlayer == mc.getRenderViewEntity();
        }
        return abstractClientPlayer.isUser();
    }
}

