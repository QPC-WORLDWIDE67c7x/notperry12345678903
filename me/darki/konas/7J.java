/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.mojang.realmsclient.gui.ChatFormatting;
import cookiedragon.eventsystem.Subscriber;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.darki.konas.1a_0;
import me.darki.konas.1t_0;
import me.darki.konas.2;
import me.darki.konas.26;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4c_0;
import me.darki.konas.7H;
import me.darki.konas.7I;
import me.darki.konas.86;
import me.darki.konas.89;
import me.darki.konas.8J;
import me.darki.konas.8e_0;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8u_0;
import me.darki.konas.9d;
import me.darki.konas.9e;
import me.darki.konas.9g;
import me.darki.konas.9h;
import me.darki.konas.9p;
import me.darki.konas.i_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7J
extends 3E {
    public static 8h_0<8f_0> 1 = new 8h_0("Targets", new 8f_0(false));
    public static 8h_0<Boolean> 2 = new 8h_0("Animals", false).c(1);
    public static 8h_0<Boolean> 3 = new 8h_0("Mobs", false).c(1);
    public static 8h_0<Boolean> 4 = new 8h_0("Players", true).c(1);
    public static 8h_0<Boolean> 5 = new 8h_0("Waypoints", true).c(1);
    public static 8h_0<Boolean> 6 = new 8h_0("Coords", true).c(1).c(5::6);
    public static 8h_0<Boolean> 7 = new 8h_0("Dist", false).c(1).c(5::6);
    public static 8h_0<8f_0> 8 = new 8h_0("Name", new 8f_0(false));
    public static 8h_0<Double> 9 = new 8h_0("NameRange", 150.0, 256.0, 5.0, 0.5).c(8);
    public static 8h_0<Boolean> a = new 8h_0("Gamemode", false).c(8);
    public static 8h_0<Boolean> b = new 8h_0("Ping", false).c(8);
    public static 8h_0<Boolean> d = new 8h_0("Health", true).c(8);
    public static 8h_0<Boolean> e = new 8h_0("Pops", false).c(8);
    public static 8h_0<Boolean> f = new 8h_0("Friends", true).c(8);
    public static 8h_0<Boolean> g = new 8h_0("Fill", true).c(8);
    public static 8h_0<Boolean> h = new 8h_0("Outline", true).c(8);
    public static 8h_0<Float> i = new 8h_0("LineWidth", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(8).c(h::6);
    public static 8h_0<8f_0> j = new 8h_0("Colors", new 8f_0(false));
    public static 8h_0<89> k = new 8h_0("FillColorA", new 89(Integer.MIN_VALUE)).c(j);
    public static 8h_0<89> l = new 8h_0("FillColorB", new 89(Integer.MIN_VALUE)).c(j);
    public static 8h_0<89> m = new 8h_0("FillColorC", new 89(Integer.MIN_VALUE)).c(j);
    public static 8h_0<89> n = new 8h_0("FillColorD", new 89(Integer.MIN_VALUE)).c(j);
    public static 8h_0<89> o = new 8h_0("OutlineColorA", new 89(-805306368)).c(j);
    public static 8h_0<89> p = new 8h_0("OutlineColorB", new 89(-805306368)).c(j);
    public static 8h_0<89> q = new 8h_0("OutlineColorC", new 89(-805306368)).c(j);
    public static 8h_0<89> r = new 8h_0("OutlineColorD", new 89(-805306368)).c(j);
    public static 8h_0<8f_0> s = new 8h_0("Info", new 8f_0(false));
    public static 8h_0<Double> t = new 8h_0("ArmorRange", 30.0, 256.0, 5.0, 0.5).c(s);
    public static 8h_0<Boolean> u = new 8h_0("Armor", true).c(s);
    public static 8h_0<Boolean> v = new 8h_0("Stacks", true).c(s);
    public static 8h_0<Boolean> w = new 8h_0("Durability", true).c(s);
    public static 8h_0<Boolean> x = new 8h_0("Enchants", true).c(s);
    public static 8h_0<8f_0> y = new 8h_0("Scaling", new 8f_0(false));
    public static 8h_0<Boolean> z = new 8h_0("FrustumCheck", true).c(y);
    public static 8h_0<Double> A = new 8h_0("ZoomFactor", 3.0, 10.0, 0.0, 0.1).c(y);
    public static 8h_0<Double> B = new 8h_0("Scale", 1.0, 5.0, 0.0, 0.1).c(y);
    public static 8h_0<Double> C = new 8h_0("ScaleFactor", 2.0, 5.0, 0.0, 0.1).c(y);
    public static 8h_0<Double> D = new 8h_0("ScaleLimit", 3.0, 10.0, 0.0, 0.1).c(y);
    public static 8h_0<Integer> E = new 8h_0("ArmorSpacing", 42, 70, 0, 1).c(y);
    public static 8h_0<Integer> F = new 8h_0("EnchantSpacing", 70, 100, -30, 5).c(y);
    public static 8h_0<Double> G = new 8h_0("EnchantScale", 1.0, 2.5, 0.5, 0.05).c(y);
    public static 8h_0<Double> H = new 8h_0("YOffset", 0.2, 1.0, 0.0, 0.05).c(y);
    public static 8h_0<8f_0> I = new 8h_0("Misc", new 8f_0(false));
    public static 8h_0<Boolean> J = new 8h_0("SelfNametag", false).c(I);
    public static 8h_0<7I> K = new 8e_0("Font", 7I.c, new 7H());
    public DecimalFormat c = new DecimalFormat("#.##");
    public static ICamera c = new Frustum();
    public static 9g c = new 9d(i_0.2, 20.0f);
    public static 9g 0 = new 9d(i_0.2, 60.0f);

    public void c(EntityPlayer entityPlayer, ItemStack itemStack, double d2, double d3) {
        GL11.glPushMatrix();
        GL11.glDepthMask((boolean)true);
        GlStateManager.clear((int)256);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        7J.c.getRenderItem().zLevel = -100.0f;
        GlStateManager.scale((double)3.0, (double)3.0, (double)0.01f);
        c.getRenderItem().renderItemAndEffectIntoGUI(itemStack, (int)(d2 / 3.0), (int)(d3 / 3.0));
        this.c(itemStack, d2 / 3.0, d3 / 3.0);
        7J.c.getRenderItem().zLevel = 0.0f;
        GlStateManager.scale((float)1.0f, (float)1.0f, (float)1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.enableDepth();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    @Subscriber
    public void c(1t_0 t_02) {
        block0: {
            if (!this.1((Entity)t_02.c())) break block0;
            t_02.c(true);
        }
    }

    public static void c(float f2, float f3, float f4, float f5, 89 var4_4, 89 var5_5, 89 var6_6, 89 var7_7, boolean bl) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        bufferBuilder.begin(bl ? 2 : 7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f2, (double)f5, 0.0).color((float)var4_4.6() / 255.0f, (float)var4_4.5() / 255.0f, (float)var4_4.2() / 255.0f, (float)var4_4.1() / 255.0f).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, 0.0).color((float)var5_5.6() / 255.0f, (float)var5_5.5() / 255.0f, (float)var5_5.2() / 255.0f, (float)var5_5.1() / 255.0f).endVertex();
        bufferBuilder.pos((double)f4, (double)f3, 0.0).color((float)var6_6.6() / 255.0f, (float)var6_6.5() / 255.0f, (float)var6_6.2() / 255.0f, (float)var6_6.1() / 255.0f).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).color((float)var7_7.6() / 255.0f, (float)var7_7.5() / 255.0f, (float)var7_7.2() / 255.0f, (float)var7_7.1() / 255.0f).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void c(float f2, float f3, float f4, float f5, int n2, boolean bl) {
        float f6 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        bufferBuilder.begin(bl ? 2 : 7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f2, (double)f5, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f4, (double)f3, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).color(f7, f8, f9, f6).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static boolean c(Entity entity) {
        return (Boolean)z.6() == false || c.isBoundingBoxInFrustum(entity.getEntityBoundingBox().grow(2.0));
    }

    public void c(String string, Vec3d vec3d, Vec3d vec3d2, Vec3d vec3d3) {
        GL11.glPushMatrix();
        double d2 = MathHelper.clamp((double)vec3d2.distanceTo(vec3d3), (double)0.0, (double)((Double)D.6() * 10.0)) * 0.2;
        d2 = 1.0 / (d2 * (Double)C.6() + 1.0);
        double d3 = (Double)B.6() * d2;
        if (K.6() != 7I.1) {
            d3 *= 3.0;
        }
        GL11.glTranslated((double)vec3d.x, (double)vec3d.y, (double)0.0);
        GL11.glScaled((double)d3, (double)d3, (double)1.0);
        float f2 = 9h.c(string);
        float f3 = 9h.0(string);
        if (((Boolean)g.6()).booleanValue()) {
            7J.c(-(f2 / 2.0f) * 1.05f, -f3, f2 / 2.0f * 1.05f, f3 * 0.1f, (89)k.6(), (89)l.6(), (89)m.6(), (89)n.6(), false);
        }
        if (((Boolean)h.6()).booleanValue()) {
            GL11.glLineWidth((float)((Float)i.6()).floatValue());
            7J.c(-(f2 / 2.0f) * 1.05f, -f3, f2 / 2.0f * 1.05f, f3 * 0.1f, (89)o.6(), (89)p.6(), (89)q.6(), (89)r.6(), true);
        }
        9h.c(string, -(f2 / 2.0f), -f3, -1);
        GL11.glPopMatrix();
    }

    public void c(Vec3d vec3d, Entity entity) {
        Vec3d vec3d2 = new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)c.getRenderPartialTicks(), entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)c.getRenderPartialTicks(), entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)c.getRenderPartialTicks()).add(0.0, (double)entity.height + (Double)H.6(), 0.0);
        Vec3d vec3d3 = 8k_0.c.c.c(vec3d2);
        this.c(entity, vec3d3, vec3d, vec3d2);
    }

    public 7J() {
        super("Nametags", 3D.2, new String[0]);
    }

    public static void c(7I i2) {
        if (i2 == 7I.1) {
            9h.c(0);
        } else if (i2 == 7I.0) {
            9h.c(c);
        } else {
            9h.c(9e.c);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void c(ItemStack var1_1, double var2_2, double var4_3) {
        block11: {
            if (var1_1.isEmpty()) break block11;
            if (var1_1.getCount() != 1 && ((Boolean)7J.v.6()).booleanValue()) {
                var6_4 = String.valueOf(var1_1.getCount());
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableBlend();
                GlStateManager.translate((double)(var2_2 + 15.0), (double)(var4_3 + 13.0), (double)0.0);
                var7_7 = 0.13;
                if (7J.K.6() != 7I.1) {
                    var7_7 *= 3.0;
                }
                GlStateManager.scale((double)var7_7, (double)var7_7, (double)1.0);
                9h.c(var6_4, -9h.c(var6_4), 0.0f, -1);
                GlStateManager.scale((double)(1.0 / var7_7), (double)(1.0 / var7_7), (double)1.0);
                GlStateManager.translate((double)(-(var2_2 + 15.0)), (double)(-(var4_3 + 13.0)), (double)0.0);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
                GlStateManager.enableBlend();
            }
            if (var1_1.getItem().showDurabilityBar(var1_1) && ((Boolean)7J.w.6()).booleanValue()) {
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                GlStateManager.disableAlpha();
                GlStateManager.disableBlend();
                var6_5 = var1_1.getItem().getDurabilityForDisplay(var1_1);
                var8_8 = var1_1.getItem().getRGBDurabilityForDisplay(var1_1);
                GlStateManager.translate((double)(var2_2 + 3.5), (double)(var4_3 + 15.0), (double)0.0);
                GlStateManager.scale((double)0.75, (double)0.75, (double)1.0);
                7J.c(0.0f, 0.0f, 12.0f, 2.0f, -16777216, false);
                7J.c(0.0f, 0.0f, Math.round(12.0f - (float)var6_5 * 12.0f), 1.0f, var8_8 | -16777216, false);
                GlStateManager.scale((double)1.3333333333333333, (double)1.3333333333333333, (double)1.0);
                GlStateManager.translate((double)(-(var2_2 + 3.5)), (double)(-(var4_3 + 15.0)), (double)0.0);
                GlStateManager.enableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
            if (!((Boolean)7J.x.6()).booleanValue()) break block11;
            var6_6 = ((Integer)7J.F.6()).intValue();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            GlStateManager.disableBlend();
            GlStateManager.translate((double)(var2_2 + 5.0), (double)(var4_3 + 10.0), (double)0.0);
            var7_7 = 0.13 * (Double)7J.G.6();
            if (7J.K.6() != 7I.1) {
                var7_7 *= 3.0;
                var6_6 /= 3.0f;
            }
            GlStateManager.scale((double)var7_7, (double)var7_7, (double)1.0);
            var9_9 = var1_1.getEnchantmentTagList();
            for (var10_10 = 0; var10_10 < var9_9.tagCount(); ++var10_10) {
                block12: {
                    var11_11 = var9_9.getCompoundTagAt(var10_10).getShort("id");
                    var12_12 = var9_9.getCompoundTagAt(var10_10).getShort("lvl");
                    var13_13 = Enchantment.getEnchantmentByID((int)var11_11);
                    if (var13_13 == null) continue;
                    v0 = var13_13;
                    if (!v0.isCurse()) break block12;
                    v1 = var13_13.getTranslatedName((int)var12_12).substring(11).substring(0, 1).toLowerCase();
                    ** GOTO lbl69
                }
                v2 = var13_13.getTranslatedName((int)var12_12);
                v3 = 0;
                v4 = 1;
                v5 = v2.substring(v3, v4);
                v1 = v5.toLowerCase();
lbl69:
                // 2 sources

                var14_14 = v1;
                v6 = v7;
                v8 = v7;
                try {
                    v6();
                    var14_14 = v8.append(var14_14).append(var12_12).toString();
                    9h.1(var14_14, 0.0f, -(var6_6 += 9h.0(var14_14)), -1);
                    continue;
                }
                catch (IndexOutOfBoundsException var14_15) {
                    // empty catch block
                }
            }
            GlStateManager.scale((double)(1.0 / var7_7), (double)(1.0 / var7_7), (double)1.0);
            GlStateManager.translate((double)(-(var2_2 + 15.0)), (double)(-(var4_3 + 10.0)), (double)0.0);
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            GlStateManager.enableBlend();
        }
    }

    public static boolean 0(Entity entity) {
        return entity instanceof EntityLivingBase;
    }

    @Subscriber
    public void c(1a_0 a_02) {
        4c_0 c_02;
        Vec3d vec3d = new Vec3d(7J.c.getRenderViewEntity().lastTickPosX + (7J.c.getRenderViewEntity().posX - 7J.c.getRenderViewEntity().lastTickPosX) * (double)c.getRenderPartialTicks(), 7J.c.getRenderViewEntity().lastTickPosY + (7J.c.getRenderViewEntity().posY - 7J.c.getRenderViewEntity().lastTickPosY) * (double)c.getRenderPartialTicks(), 7J.c.getRenderViewEntity().lastTickPosZ + (7J.c.getRenderViewEntity().posZ - 7J.c.getRenderViewEntity().lastTickPosZ) * (double)c.getRenderPartialTicks()).add(0.0, 2.0, 0.0);
        if (((Boolean)z.6()).booleanValue()) {
            c.setPosition(7J.c.getRenderViewEntity().posX, 7J.c.getRenderViewEntity().posY, 7J.c.getRenderViewEntity().posZ);
        }
        7J.c.world.loadedEntityList.stream().filter(7J::0).filter(this::1).filter(7J::c).forEach(arg_0 -> this.c(vec3d, arg_0));
        if (((Boolean)5.6()).booleanValue() && (c_02 = (4c_0)3F.c(4c_0.class)) != null && c_02.f()) {
            EntityPlayer entityPlayer;
            for (9p object : 8k_0.c.c.c()) {
                entityPlayer = new Vec3d(object.4(), object.c(), object.5()).add(0.5, 2.2, 0.5);
                Vec3d vec3d2 = 8k_0.c.c.c((Vec3d)entityPlayer);
                String string = object.3();
                if (((Boolean)6.6()).booleanValue()) {
                    DecimalFormat decimalFormat = new DecimalFormat("#.#");
                    double d2 = Double.parseDouble(decimalFormat.format(object.4()));
                    double d3 = Double.parseDouble(decimalFormat.format(object.c()));
                    double d4 = Double.parseDouble(decimalFormat.format(object.5()));
                    string = string + " " + d2 + ", " + d3 + ", " + d4;
                }
                if (((Boolean)7.6()).booleanValue()) {
                    string = string + " " + (int)entityPlayer.distanceTo(vec3d);
                }
                this.c(string, vec3d2, vec3d, (Vec3d)entityPlayer);
            }
            for (Map.Entry entry : c_02.c().entrySet()) {
                entityPlayer = (EntityPlayer)entry.getKey();
                if (entityPlayer == ((Minecraft)7J.c).player) continue;
                double d5 = Double.parseDouble(this.c.format(entityPlayer.posX));
                double d6 = Double.parseDouble(this.c.format(entityPlayer.posY));
                double d7 = Double.parseDouble(this.c.format(entityPlayer.posZ));
                Vec3d vec3d3 = new Vec3d(d5, d6, d7).add(0.0, (double)entityPlayer.height + (Double)H.6(), 0.0);
                Vec3d vec3d4 = 8k_0.c.c.c(vec3d3);
                String string = entityPlayer.getName();
                if (((Boolean)6.6()).booleanValue()) {
                    string = string + " " + d5 + ", " + d6 + ", " + d7;
                }
                if (((Boolean)7.6()).booleanValue()) {
                    string = string + " " + (int)vec3d3.distanceTo(vec3d);
                }
                this.c(string, vec3d4, vec3d, vec3d3);
            }
        }
    }

    public static float c(float f2, int n2) {
        BigDecimal bigDecimal = new BigDecimal(f2);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }

    public boolean 1(Entity entity) {
        if ((double)entity.getDistance((Entity)((Minecraft)7J.c).player) > (Double)9.6()) {
            return false;
        }
        if (((Boolean)2.6()).booleanValue() && entity instanceof EntityAnimal) {
            return true;
        }
        if (((Boolean)3.6()).booleanValue() && entity instanceof IMob) {
            return true;
        }
        if (((Boolean)4.6()).booleanValue() && entity instanceof EntityPlayer && !8u_0.c(entity)) {
            return (Boolean)J.6() != false || !(entity instanceof EntityPlayerSP);
        }
        return false;
    }

    public void c(Entity entity, Vec3d vec3d, Vec3d vec3d2, Vec3d vec3d3) {
        String string;
        float f2;
        int n2;
        GL11.glPushMatrix();
        double d2 = MathHelper.clamp((double)vec3d2.distanceTo(vec3d3), (double)0.0, (double)((Double)D.6() * 10.0)) * 0.2;
        d2 = 1.0 / (d2 * (Double)C.6() + 1.0);
        double d3 = (Double)B.6() * d2;
        if (3F.c(86.class).f()) {
            d3 *= (double)((Float)86.c.6()).floatValue() * (Double)A.6();
        }
        if (K.6() != 7I.1) {
            d3 *= 3.0;
        }
        GL11.glTranslated((double)vec3d.x, (double)vec3d.y, (double)0.0);
        GL11.glScaled((double)d3, (double)d3, (double)1.0);
        String string2 = entity.getName();
        if (string2.equalsIgnoreCase("antiflame")) {
            string2 = "god";
        }
        if (entity instanceof EntityPlayer) {
            if (((Boolean)a.6()).booleanValue()) {
                string2 = string2 + (((EntityPlayer)entity).isCreative() ? " [C]" : " [S]");
            }
            if (((Boolean)b.6()).booleanValue() && c.getConnection() != null && c.getConnection().getPlayerInfo(entity.getUniqueID()) != null) {
                n2 = c.getConnection().getPlayerInfo(entity.getUniqueID()).getResponseTime();
                string2 = string2 + " " + n2 + "ms";
            }
        }
        if (((Boolean)d.6()).booleanValue() && entity instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            f2 = 7J.c(entityLivingBase.getHealth() + entityLivingBase.getAbsorptionAmount(), 1);
            if (entity.getName().equalsIgnoreCase("antiflame")) {
                f2 = 420.0f;
            }
            string = f2 < 5.0f ? ChatFormatting.RED.toString() + f2 : (f2 < 20.0f ? ChatFormatting.YELLOW.toString() + f2 : ChatFormatting.GREEN.toString() + f2);
            string = string.replace(".0", "");
            string2 = string2 + " " + string + ChatFormatting.RESET.toString();
        }
        if (((Boolean)e.6()).booleanValue()) {
            n2 = 0;
            if (((HashMap)26.c).containsKey(entity.getName())) {
                n2 = (Integer)((HashMap)26.c).get(entity.getName());
            }
            string2 = string2 + " " + n2;
        }
        float f3 = 9h.c(string2);
        f2 = 9h.0(string2);
        if (((Boolean)g.6()).booleanValue()) {
            7J.c(-(f3 / 2.0f) * 1.05f, -f2, f3 / 2.0f * 1.05f, f2 * 0.1f, (89)k.6(), (89)l.6(), (89)m.6(), (89)n.6(), false);
        }
        if (((Boolean)h.6()).booleanValue()) {
            GL11.glLineWidth((float)((Float)i.6()).floatValue());
            7J.c(-(f3 / 2.0f) * 1.05f, -f2, f3 / 2.0f * 1.05f, f2 * 0.1f, (89)o.6(), (89)p.6(), (89)q.6(), (89)r.6(), true);
        }
        if (K.6() == 7I.c) {
            f2 += 0.5f;
        }
        9h.c((((Boolean)f.6()).booleanValue() ? (8J.2(entity.getUniqueID().toString()) ? me.darki.konas.2.c + "b" : "") : "") + string2, -(f3 / 2.0f), K.6() == 7I.c ? -f2 + 2.0f : -f2, -1);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (K.6() != 7I.1) {
            GL11.glScaled((double)(1.0 / d3), (double)(1.0 / d3), (double)1.0);
            d3 = (Double)B.6() * d2;
            if (3F.c(86.class).f()) {
                d3 *= (double)((Float)86.c.6()).floatValue() * (Double)A.6();
            }
            GL11.glScaled((double)d3, (double)d3, (double)1.0);
            f2 *= 3.0f;
        }
        if (((Boolean)u.6()).booleanValue() && entity instanceof EntityPlayer) {
            string = (EntityPlayer)entity;
            if ((double)entity.getDistance((Entity)((Minecraft)7J.c).player) <= (Double)t.6()) {
                double d4 = 0.0;
                for (ItemStack itemStack : string.inventory.armorInventory) {
                    if (itemStack == null) continue;
                    d4 -= (double)((Integer)E.6()).intValue() / 2.0;
                }
                if (string.getHeldItemMainhand() != null) {
                    Iterator iterator = string.getHeldItemMainhand().copy();
                    this.c((EntityPlayer)string, (ItemStack)iterator, d4 -= (double)((Integer)E.6()).intValue(), -((double)f2 + 55.0));
                    d4 += (double)((Integer)E.6()).intValue();
                }
                for (int i2 = 3; i2 >= 0; --i2) {
                    ItemStack itemStack;
                    itemStack = (ItemStack)string.inventory.armorInventory.get(i2);
                    if (itemStack == null) continue;
                    this.c((EntityPlayer)string, itemStack, d4, -((double)f2 + 55.0));
                    d4 += (double)((Integer)E.6()).intValue();
                }
                if (string.getHeldItemOffhand() != null) {
                    ItemStack itemStack = string.getHeldItemOffhand().copy();
                    this.c((EntityPlayer)string, itemStack, d4, -((double)f2 + 55.0));
                }
            }
        }
        GL11.glPopMatrix();
    }
}

