/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.primitives.Ints;
import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import me.darki.konas.1a_0;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7Y;
import me.darki.konas.89;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.96;
import me.darki.konas.97;
import me.darki.konas.mixin.mixins.IEntityRenderer;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7Z
extends 3E {
    public static 8h_0<7Y> 1 = new 8h_0("Mode", 7Y.c);
    public static 8h_0<Boolean> 2 = new 8h_0("ShowTargets", true);
    public static 8h_0<Boolean> 3 = new 8h_0("ShowDistanceColor", true);
    public static 8h_0<Boolean> 4 = new 8h_0("ShowFriends", true);
    public static 8h_0<89> 5 = new 8h_0("Color", new 89(-1));
    public static 8h_0<Boolean> 6 = new 8h_0("Visible", false).c(7Z::0);
    public static 8h_0<Boolean> 7 = new 8h_0("Fade", false).c(7Z::c);
    public static 8h_0<Integer> 8 = new 8h_0("Distance", 100, 200, 50, 1).c(7Z::1);
    public static 8h_0<Integer> 9 = new 8h_0("Radius", 30, 200, 10, 1);
    public static 8h_0<Float> a = new 8h_0("Width", Float.valueOf(2.0f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.5f));
    public static 8h_0<Float> b = new 8h_0("Range", Float.valueOf(220.0f), Float.valueOf(500.0f), Float.valueOf(1.0f), Float.valueOf(1.0f));

    public static boolean 1() {
        return 1.6() == 7Y.0 && (Boolean)7.6() != false;
    }

    public static boolean c() {
        return 1.6() == 7Y.0;
    }

    public static boolean 0() {
        return 1.6() == 7Y.0;
    }

    @Subscriber
    public void c(1a_0 a_02) {
        if (7Z.c.world == null || 7Z.c.player == null) {
            return;
        }
        if (1.6() == 7Y.c) {
            return;
        }
        for (Entity entity : 7Z.c.world.loadedEntityList) {
            int n2;
            Vec3d vec3d;
            Vec3d vec3d2;
            if (!(entity instanceof EntityPlayer) || entity == 7Z.c.player || !(7Z.c.player.getDistance(entity) <= ((Float)b.6()).floatValue()) || (vec3d2 = 8k_0.c.c.c(vec3d = new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)c.getRenderPartialTicks(), entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)c.getRenderPartialTicks(), entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)c.getRenderPartialTicks()).add(0.0, (double)entity.getEyeHeight(), 0.0))) == null || this.c(vec3d2) || 96.c(entity) && !((Boolean)6.6()).booleanValue()) continue;
            GL11.glPushMatrix();
            int n3 = -1;
            if (((Boolean)2.6()).booleanValue() && 8k_0.c.c.c(entity)) {
                n2 = 8k_0.c.c.2(entity);
                n3 = new Color(255, n2, n2).hashCode();
            } else {
                n3 = 8J.1(entity.getName()) && (Boolean)4.6() != false ? Color.CYAN.hashCode() : ((Boolean)3.6() != false ? this.c(entity.getDistance((Entity)7Z.c.player)) : ((89)5.6()).c());
            }
            n2 = n3 >> 24 & 0xFF;
            int n4 = n3 >> 16 & 0xFF;
            int n5 = n3 >> 8 & 0xFF;
            int n6 = n3 & 0xFF;
            Color color = new Color(n4, n5, n6, (int)((Boolean)7.6() != false ? MathHelper.clamp((float)(255.0f - 255.0f / (float)((Integer)8.6()).intValue() * 7Z.c.player.getDistance(entity)), (float)100.0f, (float)255.0f) : (float)n2));
            int n7 = Display.getWidth() / 2 / (7Z.c.gameSettings.guiScale == 0 ? 1 : 7Z.c.gameSettings.guiScale);
            int n8 = Display.getHeight() / 2 / (7Z.c.gameSettings.guiScale == 0 ? 1 : 7Z.c.gameSettings.guiScale);
            float f2 = this.c(entity) - 7Z.c.player.rotationYaw;
            GL11.glTranslatef((float)n7, (float)n8, (float)0.0f);
            GL11.glRotatef((float)f2, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)(-n7), (float)(-n8), (float)0.0f);
            96.c((float)n7, (float)(n8 - (Integer)9.6()), ((Float)a.6()).floatValue() * 5.0f, 2.0f, 1.0f, false, 1.0f, color.getRGB());
            GL11.glTranslatef((float)n7, (float)n8, (float)0.0f);
            GL11.glRotatef((float)(-f2), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)(-n7), (float)(-n8), (float)0.0f);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c(Vec3d vec3d) {
        if (!(vec3d.x > -1.0)) return false;
        if (!(vec3d.y < 1.0)) return false;
        int n2 = 7Z.c.gameSettings.guiScale == 0 ? 1 : 7Z.c.gameSettings.guiScale;
        if (!(vec3d.x / (double)n2 >= 0.0)) return false;
        int n3 = 7Z.c.gameSettings.guiScale == 0 ? 1 : 7Z.c.gameSettings.guiScale;
        if (!(vec3d.x / (double)n3 <= (double)Display.getWidth())) return false;
        int n4 = 7Z.c.gameSettings.guiScale == 0 ? 1 : 7Z.c.gameSettings.guiScale;
        if (!(vec3d.y / (double)n4 >= 0.0)) return false;
        int n5 = 7Z.c.gameSettings.guiScale == 0 ? 1 : 7Z.c.gameSettings.guiScale;
        if (!(vec3d.y / (double)n5 <= (double)Display.getHeight())) return false;
        return true;
    }

    public int c(float f2) {
        int n2 = Ints.constrainToRange((int)((int)f2 * 4), (int)0, (int)255);
        return new Color(Ints.constrainToRange((int)(255 - n2), (int)0, (int)255), Ints.constrainToRange((int)n2, (int)0, (int)255), 0).hashCode();
    }

    public float c(Entity entity) {
        double d2 = entity.posX - 7Z.c.player.posX;
        double d3 = entity.posZ - 7Z.c.player.posZ;
        return (float)(-(Math.atan2(d2, d3) * 57.29577951308232));
    }

    public 7Z() {
        super("Tracers", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1b_0 b_02) {
        if (7Z.c.world == null || 7Z.c.player == null) {
            return;
        }
        if (1.6() == 7Y.0) {
            return;
        }
        for (Entity entity : 7Z.c.world.loadedEntityList) {
            int n2;
            if (!(entity instanceof EntityPlayer) || entity == 7Z.c.player || !(7Z.c.player.getDistance(entity) <= ((Float)b.6()).floatValue())) continue;
            Vec3d vec3d = 97.0(entity, b_02.c()).subtract(((IRenderManager)c.getRenderManager()).getRenderPosX(), ((IRenderManager)c.getRenderManager()).getRenderPosY(), ((IRenderManager)c.getRenderManager()).getRenderPosZ());
            GL11.glBlendFunc((int)770, (int)771);
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth((float)((Float)a.6()).floatValue());
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
            boolean bl = 7Z.c.gameSettings.viewBobbing;
            7Z.c.gameSettings.viewBobbing = false;
            ((IEntityRenderer)7Z.c.entityRenderer).iSetupCameraTransform(b_02.c(), 0);
            Vec3d vec3d2 = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float)Math.toRadians(7Z.c.player.rotationPitch))).rotateYaw(-((float)Math.toRadians(7Z.c.player.rotationYaw)));
            if (((Boolean)2.6()).booleanValue() && 8k_0.c.c.c(entity)) {
                int n3 = 8k_0.c.c.2(entity);
                n2 = new Color(255, n3, n3).hashCode();
            } else {
                n2 = 8J.1(entity.getName()) && (Boolean)4.6() != false ? Color.CYAN.hashCode() : ((Boolean)3.6() != false ? this.c(entity.getDistance((Entity)7Z.c.player)) : ((89)5.6()).c());
            }
            97.c((float)vec3d2.x, (float)vec3d2.y + 7Z.c.player.getEyeHeight(), (float)vec3d2.z, (float)vec3d.x, (float)vec3d.y, (float)vec3d.z, ((Float)a.6()).floatValue(), n2);
            97.c((float)vec3d.x, (float)vec3d.y, (float)vec3d.z, (float)vec3d.x, (float)vec3d.y + entity.getEyeHeight(), (float)vec3d.z, ((Float)a.6()).floatValue(), n2);
            7Z.c.gameSettings.viewBobbing = bl;
            ((IEntityRenderer)7Z.c.entityRenderer).iSetupCameraTransform(b_02.c(), 0);
            GlStateManager.enableCull();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.enableDepth();
        }
    }
}

