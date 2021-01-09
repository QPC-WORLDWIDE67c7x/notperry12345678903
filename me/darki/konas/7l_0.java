/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1d_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7k_0;
import me.darki.konas.89;
import me.darki.konas.8f_0;
import me.darki.konas.8g_0;
import me.darki.konas.8h_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7l
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7l_0
extends 3E {
    public static 8h_0<8f_0> 1 = new 8h_0("Living", new 8f_0(false));
    public static 8h_0<8g_0> 2 = new 8h_0("Preview", new 8g_0(false, true)).c(1);
    public static 8h_0<Boolean> 3 = new 8h_0("Render", false).c(1);
    public static 8h_0<Boolean> 4 = new 8h_0("RenderDepth", false).c(1);
    public static 8h_0<7k_0> 5 = new 8h_0("Glint", 7k_0.c).c(1);
    public static 8h_0<Boolean> 6 = new 8h_0("GlintDepth", false).c(1);
    public static 8h_0<Float> 7 = new 8h_0("GlintSpeed", Float.valueOf(5.0f), Float.valueOf(20.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(1);
    public static 8h_0<Float> 8 = new 8h_0("GlintScale", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(1);
    public static 8h_0<89> 9 = new 8h_0("GlintColor", new 89(0x7700FFFF)).c(1);
    public static 8h_0<Boolean> a = new 8h_0("Fill", false).c(1);
    public static 8h_0<Boolean> b = new 8h_0("FillDepth", false).c(1);
    public static 8h_0<Boolean> d = new 8h_0("Lighting", false).c(1);
    public static 8h_0<89> e = new 8h_0("FillColor", new 89(0x7700FFFF)).c(1);
    public static 8h_0<Boolean> f = new 8h_0("Outline", false).c(1);
    public static 8h_0<Boolean> g = new 8h_0("OutlineDepth", false).c(1);
    public static 8h_0<Float> h = new 8h_0("Width", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(1);
    public static 8h_0<89> i = new 8h_0("GOutlineColor", new 89(-16711681)).c(1);
    public static 8h_0<Boolean> j = new 8h_0("Players", true).c(1);
    public static 8h_0<Boolean> k = new 8h_0("Self", true).c(1);
    public static 8h_0<Boolean> l = new 8h_0("Animals", true).c(1);
    public static 8h_0<Boolean> m = new 8h_0("Monsters", true).c(1);
    public static 8h_0<Boolean> n = new 8h_0("Invis", true).c(1);
    public static 8h_0<8f_0> o = new 8h_0("Crystal", new 8f_0(false));
    public static 8h_0<Boolean> p = new 8h_0("Crystals", true).c(o);
    public static 8h_0<Boolean> q = new 8h_0("CRender", false).c(o);
    public static 8h_0<Boolean> r = new 8h_0("CRenderDepth", false).c(o);
    public static 8h_0<7k_0> s = new 8h_0("CGlint", 7k_0.c).c(o);
    public static 8h_0<Boolean> t = new 8h_0("CGlintDepth", false).c(o);
    public static 8h_0<Float> u = new 8h_0("CGlintSpeed", Float.valueOf(5.0f), Float.valueOf(20.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(o);
    public static 8h_0<Float> v = new 8h_0("CGlintScale", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(o);
    public static 8h_0<89> w = new 8h_0("CGlintColor", new 89(0x770000FF)).c(o);
    public static 8h_0<Boolean> x = new 8h_0("CFill", false).c(o);
    public static 8h_0<Boolean> y = new 8h_0("CFillDepth", false).c(o);
    public static 8h_0<Boolean> z = new 8h_0("CLighting", false).c(o);
    public static 8h_0<89> A = new 8h_0("CFillColor", new 89(0x770000FF)).c(o);
    public static 8h_0<Boolean> B = new 8h_0("COutline", false).c(o);
    public static 8h_0<Boolean> C = new 8h_0("COutlineDepth", false).c(o);
    public static 8h_0<Float> D = new 8h_0("CWidth", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(o);
    public static 8h_0<89> E = new 8h_0("CGOutlineColor", new 89(-16776961)).c(o);
    public static 8h_0<Float> F = new 8h_0("Scale", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(o);
    public static 8h_0<Float> G = new 8h_0("SpinSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(o);
    public static 8h_0<Float> H = new 8h_0("Bounciness", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(o);
    public static 8h_0<8f_0> I = new 8h_0("Hand", new 8f_0(false));
    public static 8h_0<Boolean> J = new 8h_0("Hands", true).c(I);
    public static 8h_0<89> K = new 8h_0("HandColor", new 89(469762303)).c(J::6).c(I);
    public static 8h_0<7k_0> L = new 8h_0("HGlint", 7k_0.c).c(I);
    public static 8h_0<Float> M = new 8h_0("HGlintSpeed", Float.valueOf(5.0f), Float.valueOf(20.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(I);
    public static 8h_0<Float> N = new 8h_0("HGlintScale", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(I);
    public static 8h_0<89> O = new 8h_0("HGlintColor", new 89(0x770000FF)).c(I);
    public static ResourceLocation c = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public static ResourceLocation 0 = new ResourceLocation("konas/textures/enchant_glint.png");
    public static boolean 1 = false;

    public static boolean 0(Entity entity) {
        if (entity == null) {
            return false;
        }
        if (entity.isInvisible() && !((Boolean)n.6()).booleanValue()) {
            return false;
        }
        if (entity.equals((Object)7l_0.c.player) && !((Boolean)k.6()).booleanValue()) {
            return false;
        }
        if (entity instanceof EntityPlayer && !((Boolean)j.6()).booleanValue()) {
            return false;
        }
        if (7l_0.c(entity) && !((Boolean)l.6()).booleanValue()) {
            return false;
        }
        return 7l_0.c(entity) || entity instanceof EntityPlayer || (Boolean)m.6() != false;
    }

    public static void c(89 var0, ModelBase modelBase, Entity entity, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glPolygonMode((int)1032, (int)6914);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(5.6() == 7k_0.1 ? 0 : c);
        GL11.glPolygonMode((int)1032, (int)6914);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glColor4f((float)((float)var0.6() / 255.0f), (float)((float)var0.5() / 255.0f), (float)((float)var0.2() / 255.0f), (float)((float)var0.1() / 255.0f));
        GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_COLOR, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE);
        for (int i2 = 0; i2 < 2; ++i2) {
            GlStateManager.matrixMode((int)5890);
            GlStateManager.loadIdentity();
            float f9 = 0.33333334f * ((Float)8.6()).floatValue();
            GlStateManager.scale((float)f9, (float)f9, (float)f9);
            GlStateManager.rotate((float)(30.0f - (float)i2 * 60.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.translate((float)0.0f, (float)(((float)entity.ticksExisted + c.getRenderPartialTicks()) * (0.001f + (float)i2 * 0.003f) * ((Float)7.6()).floatValue()), (float)0.0f);
            GlStateManager.matrixMode((int)5888);
            GL11.glTranslatef((float)f8, (float)f8, (float)f8);
            GlStateManager.color((float)((float)var0.6() / 255.0f), (float)((float)var0.5() / 255.0f), (float)((float)var0.2() / 255.0f), (float)((float)var0.1() / 255.0f));
            if (((Boolean)6.6()).booleanValue()) {
                GL11.glDepthMask((boolean)true);
                GL11.glEnable((int)2929);
            }
            modelBase.render(entity, f2, f3, f4, f5, f6, f7);
            if (!((Boolean)6.6()).booleanValue()) continue;
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
        }
        GlStateManager.matrixMode((int)5890);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode((int)5888);
        GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    @Subscriber
    public void c(1d_0 d_02) {
        block0: {
            if (!((Boolean)J.6()).booleanValue()) break block0;
            d_02.0(((89)K.6()).6());
            d_02.1(((89)K.6()).5());
            d_02.2(((89)K.6()).2());
            d_02.c(((89)K.6()).1());
            d_02.c(true);
        }
    }

    public static void 0(89 var0, ModelBase modelBase, Entity entity, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glPolygonMode((int)1032, (int)6914);
        GL11.glDisable((int)3553);
        if (((Boolean)d.6()).booleanValue()) {
            GL11.glEnable((int)2896);
        } else {
            GL11.glDisable((int)2896);
        }
        GL11.glDisable((int)2929);
        GL11.glEnable((int)2848);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glTranslatef((float)f8, (float)f8, (float)f8);
        GlStateManager.color((float)((float)var0.6() / 255.0f), (float)((float)var0.5() / 255.0f), (float)((float)var0.2() / 255.0f), (float)((float)var0.1() / 255.0f));
        if (((Boolean)b.6()).booleanValue()) {
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
        }
        modelBase.render(entity, f2, f3, f4, f5, f6, f7);
        if (((Boolean)b.6()).booleanValue()) {
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
        }
        GlStateManager.resetColor();
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static void c(89 var0, float f2, ModelBase modelBase, Entity entity, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glPolygonMode((int)1032, (int)6913);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)2848);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glTranslatef((float)f9, (float)f9, (float)f9);
        GlStateManager.color((float)((float)var0.6() / 255.0f), (float)((float)var0.5() / 255.0f), (float)((float)var0.2() / 255.0f), (float)((float)var0.1() / 255.0f));
        GlStateManager.glLineWidth((float)f2);
        if (((Boolean)g.6()).booleanValue()) {
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
        }
        modelBase.render(entity, f3, f4, f5, f6, f7, f8);
        if (((Boolean)g.6()).booleanValue()) {
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
        }
        GlStateManager.resetColor();
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static boolean c(ModelBase modelBase, Entity entity, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!7l_0.0(entity)) {
            return false;
        }
        boolean bl = 7l_0.c.gameSettings.fancyGraphics;
        7l_0.c.gameSettings.fancyGraphics = false;
        if (((Boolean)3.6()).booleanValue()) {
            if (!((Boolean)4.6()).booleanValue()) {
                OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
                GL11.glEnable((int)32823);
                GL11.glPolygonOffset((float)1.0f, (float)-1100000.0f);
            }
            modelBase.render(entity, f2, f3, f4, f5, f6, f7);
            if (!((Boolean)4.6()).booleanValue()) {
                GL11.glDisable((int)32823);
                GL11.glPolygonOffset((float)1.0f, (float)1100000.0f);
            }
        }
        float f8 = 7l_0.c.gameSettings.gammaSetting;
        7l_0.c.gameSettings.gammaSetting = 10000.0f;
        if (((Boolean)a.6()).booleanValue()) {
            7l_0.0((89)e.6(), modelBase, entity, f2, f3, f4, f5, f6, f7, 0.0f);
        }
        if (((Boolean)f.6()).booleanValue()) {
            7l_0.c((89)i.6(), ((Float)h.6()).floatValue(), modelBase, entity, f2, f3, f4, f5, f6, f7, 0.0f);
        }
        if (5.6() != 7k_0.c) {
            7l_0.c((89)9.6(), modelBase, entity, f2, f3, f4, f5, f6, f7, 0.0f);
        }
        try {
            7l_0.c.gameSettings.fancyGraphics = bl;
            7l_0.c.gameSettings.gammaSetting = f8;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return true;
    }

    public 7l_0() {
        super("Chams", "Makes you see entities through walls", 3D.2, new String[0]);
    }

    public static boolean c(Entity entity) {
        if (entity instanceof EntityWolf) {
            return !((EntityWolf)entity).isAngry();
        }
        if (entity instanceof EntityAgeable || entity instanceof EntityTameable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid) {
            return true;
        }
        if (entity instanceof EntityIronGolem) {
            return ((EntityIronGolem)entity).getRevengeTarget() == null;
        }
        return false;
    }
}

