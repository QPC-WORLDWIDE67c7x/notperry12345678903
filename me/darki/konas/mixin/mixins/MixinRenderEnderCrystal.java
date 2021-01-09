/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.3F;
import me.darki.konas.7k_0;
import me.darki.konas.7l_0;
import me.darki.konas.7q_0;
import me.darki.konas.89;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEnderCrystal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderEnderCrystal.class}, priority=1069)
public abstract class MixinRenderEnderCrystal
extends Render {
    @Shadow
    public ModelBase modelEnderCrystal;
    @Shadow
    public ModelBase modelEnderCrystalNoBase;
    @Final
    @Shadow
    private static ResourceLocation ENDER_CRYSTAL_TEXTURES;

    protected MixinRenderEnderCrystal(RenderManager renderManager) {
        super(renderManager);
    }

    @Shadow
    public abstract void doRender(EntityEnderCrystal var1, double var2, double var4, double var6, float var8, float var9);

    @Redirect(method={"doRender(Lnet/minecraft/entity/item/EntityEnderCrystal;DDDFF)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/model/ModelBase;render(Lnet/minecraft/entity/Entity;FFFFFF)V"))
    private void bottomRenderRedirect(ModelBase modelBase, Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (3F.c(7l_0.class).f() && !7q_0.2 && ((Boolean)7l_0.p.6()).booleanValue()) {
            if (((Boolean)7l_0.p.6()).booleanValue() && ((Boolean)7l_0.q.6()).booleanValue()) {
                GL11.glScalef((float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue());
                if (!((Boolean)7l_0.r.6()).booleanValue()) {
                    GL11.glPushAttrib((int)1048575);
                    GL11.glDepthMask((boolean)false);
                    GL11.glDisable((int)2929);
                }
                modelBase.render(entityIn, limbSwing, limbSwingAmount * ((Float)7l_0.G.6()).floatValue(), ageInTicks * ((Float)7l_0.H.6()).floatValue(), netHeadYaw, headPitch, scale);
                if (!((Boolean)7l_0.r.6()).booleanValue()) {
                    GL11.glEnable((int)2929);
                    GL11.glDepthMask((boolean)true);
                    GL11.glPopAttrib();
                }
                GL11.glScalef((float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()));
            } else if (!((Boolean)7l_0.p.6()).booleanValue()) {
                modelBase.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            }
        } else if (3F.c(7l_0.class).f() && 7q_0.2 && ((Boolean)7l_0.p.6()).booleanValue()) {
            GL11.glScalef((float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue());
            modelBase.render(entityIn, limbSwing, limbSwingAmount * ((Float)7l_0.G.6()).floatValue(), ageInTicks * ((Float)7l_0.H.6()).floatValue(), netHeadYaw, headPitch, scale);
            GL11.glScalef((float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()));
        } else {
            modelBase.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    @Inject(method={"doRender(Lnet/minecraft/entity/item/EntityEnderCrystal;DDDFF)V"}, at={@At(value="RETURN")}, cancellable=true)
    public void doRenderCrystal(EntityEnderCrystal entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (3F.c(7l_0.class).f() && !7q_0.2 && ((Boolean)7l_0.p.6()).booleanValue()) {
            float f4;
            float f3;
            if (((Boolean)7l_0.x.6()).booleanValue()) {
                f3 = (float)entity.innerRotation + partialTicks;
                GlStateManager.pushMatrix();
                GlStateManager.translate((double)x, (double)y, (double)z);
                Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(ENDER_CRYSTAL_TEXTURES);
                f4 = MathHelper.sin((float)(f3 * 0.2f)) / 2.0f + 0.5f;
                f4 += f4 * f4;
                GL11.glPushAttrib((int)1048575);
                GL11.glPolygonMode((int)1032, (int)6914);
                GL11.glDisable((int)3553);
                if (((Boolean)7l_0.z.6()).booleanValue()) {
                    GL11.glEnable((int)2896);
                } else {
                    GL11.glDisable((int)2896);
                }
                GL11.glDisable((int)2929);
                GL11.glEnable((int)2848);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glColor4f((float)((float)((89)7l_0.A.6()).6() / 255.0f), (float)((float)((89)7l_0.A.6()).5() / 255.0f), (float)((float)((89)7l_0.A.6()).2() / 255.0f), (float)((float)((89)7l_0.A.6()).1() / 255.0f));
                GL11.glScalef((float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue());
                if (((Boolean)7l_0.y.6()).booleanValue()) {
                    GL11.glDepthMask((boolean)true);
                    GL11.glEnable((int)2929);
                }
                if (entity.shouldShowBottom()) {
                    this.modelEnderCrystal.render((Entity)entity, 0.0f, f3 * 3.0f * ((Float)7l_0.G.6()).floatValue(), f4 * 0.2f * ((Float)7l_0.H.6()).floatValue(), 0.0f, 0.0f, 0.0625f);
                } else {
                    this.modelEnderCrystalNoBase.render((Entity)entity, 0.0f, f3 * 3.0f * ((Float)7l_0.G.6()).floatValue(), f4 * 0.2f * ((Float)7l_0.H.6()).floatValue(), 0.0f, 0.0f, 0.0625f);
                }
                if (((Boolean)7l_0.y.6()).booleanValue()) {
                    GL11.glDisable((int)2929);
                    GL11.glDepthMask((boolean)false);
                }
                GL11.glScalef((float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()));
                GL11.glPopAttrib();
                GL11.glPopMatrix();
            }
            if (((Boolean)7l_0.B.6()).booleanValue()) {
                f3 = (float)entity.innerRotation + partialTicks;
                GlStateManager.pushMatrix();
                GlStateManager.translate((double)x, (double)y, (double)z);
                Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(ENDER_CRYSTAL_TEXTURES);
                f4 = MathHelper.sin((float)(f3 * 0.2f)) / 2.0f + 0.5f;
                f4 += f4 * f4;
                GL11.glPushAttrib((int)1048575);
                GL11.glPolygonMode((int)1032, (int)6913);
                GL11.glDisable((int)3553);
                GL11.glDisable((int)2896);
                GL11.glDisable((int)2929);
                GL11.glEnable((int)2848);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glLineWidth((float)((Float)7l_0.D.6()).floatValue());
                GL11.glColor4f((float)((float)((89)7l_0.E.6()).6() / 255.0f), (float)((float)((89)7l_0.E.6()).5() / 255.0f), (float)((float)((89)7l_0.E.6()).2() / 255.0f), (float)((float)((89)7l_0.E.6()).1() / 255.0f));
                GL11.glScalef((float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue());
                if (((Boolean)7l_0.C.6()).booleanValue()) {
                    GL11.glDepthMask((boolean)true);
                    GL11.glEnable((int)2929);
                }
                if (entity.shouldShowBottom()) {
                    this.modelEnderCrystal.render((Entity)entity, 0.0f, f3 * 3.0f * ((Float)7l_0.G.6()).floatValue(), f4 * 0.2f * ((Float)7l_0.H.6()).floatValue(), 0.0f, 0.0f, 0.0625f);
                } else {
                    this.modelEnderCrystalNoBase.render((Entity)entity, 0.0f, f3 * 3.0f * ((Float)7l_0.G.6()).floatValue(), f4 * 0.2f * ((Float)7l_0.H.6()).floatValue(), 0.0f, 0.0f, 0.0625f);
                }
                if (((Boolean)7l_0.C.6()).booleanValue()) {
                    GL11.glDisable((int)2929);
                    GL11.glDepthMask((boolean)false);
                }
                GL11.glScalef((float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()));
                GL11.glPopAttrib();
                GL11.glPopMatrix();
            }
            if (7l_0.s.6() != 7k_0.c) {
                f3 = (float)entity.innerRotation + partialTicks;
                GlStateManager.pushMatrix();
                GlStateManager.translate((double)x, (double)y, (double)z);
                Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(7l_0.s.6() == 7k_0.1 ? 7l_0.0 : 7l_0.c);
                f4 = MathHelper.sin((float)(f3 * 0.2f)) / 2.0f + 0.5f;
                f4 += f4 * f4;
                GL11.glPushAttrib((int)1048575);
                GL11.glPolygonMode((int)1032, (int)6914);
                GL11.glDisable((int)2896);
                GL11.glDisable((int)2929);
                GL11.glEnable((int)3042);
                GL11.glColor4f((float)((float)((89)7l_0.w.6()).6() / 255.0f), (float)((float)((89)7l_0.w.6()).5() / 255.0f), (float)((float)((89)7l_0.w.6()).2() / 255.0f), (float)((float)((89)7l_0.w.6()).1() / 255.0f));
                GL11.glScalef((float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue(), (float)((Float)7l_0.F.6()).floatValue());
                GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_COLOR, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE);
                for (int i2 = 0; i2 < 2; ++i2) {
                    GlStateManager.matrixMode((int)5890);
                    GlStateManager.loadIdentity();
                    float tScale = 0.33333334f * ((Float)7l_0.v.6()).floatValue();
                    GlStateManager.scale((float)tScale, (float)tScale, (float)tScale);
                    GlStateManager.rotate((float)(30.0f - (float)i2 * 60.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                    GlStateManager.translate((float)0.0f, (float)(((float)entity.ticksExisted + partialTicks) * (0.001f + (float)i2 * 0.003f) * ((Float)7l_0.u.6()).floatValue()), (float)0.0f);
                    GlStateManager.matrixMode((int)5888);
                    if (((Boolean)7l_0.t.6()).booleanValue()) {
                        GL11.glDepthMask((boolean)true);
                        GL11.glEnable((int)2929);
                    }
                    if (entity.shouldShowBottom()) {
                        this.modelEnderCrystal.render((Entity)entity, 0.0f, f3 * 3.0f * ((Float)7l_0.G.6()).floatValue(), f4 * 0.2f * ((Float)7l_0.H.6()).floatValue(), 0.0f, 0.0f, 0.0625f);
                    } else {
                        this.modelEnderCrystalNoBase.render((Entity)entity, 0.0f, f3 * 3.0f * ((Float)7l_0.G.6()).floatValue(), f4 * 0.2f * ((Float)7l_0.H.6()).floatValue(), 0.0f, 0.0f, 0.0625f);
                    }
                    if (!((Boolean)7l_0.t.6()).booleanValue()) continue;
                    GL11.glDisable((int)2929);
                    GL11.glDepthMask((boolean)false);
                }
                GlStateManager.matrixMode((int)5890);
                GlStateManager.loadIdentity();
                GlStateManager.matrixMode((int)5888);
                GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                GL11.glScalef((float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()), (float)(1.0f / ((Float)7l_0.F.6()).floatValue()));
                GL11.glPopAttrib();
                GL11.glPopMatrix();
            }
        }
    }
}

