/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IRenderManager;
import me.darki.konas.util.math.Interpolation;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/*
 * Renamed from me.darki.konas.7d
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7d_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Diagonals", true);
    public static 8h_0<Boolean> 2 = new 8h_0("Render", true);
    public static 8h_0<Boolean> 3 = new 8h_0("Entities", false);
    public static 8h_0<Float> 4 = new 8h_0("Speed", Float.valueOf(0.1f), Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public int 1 = 0;
    public float c = 0.0f;

    @Subscriber
    public void c(1b_0 b_02) {
        block11: {
            if (7d_0.c.player == null) {
                return;
            }
            if (7d_0.c.mouseHelper.deltaX != 0 || 7d_0.c.mouseHelper.deltaY != 0 || this.c()) {
                this.1 = 4;
            } else {
                float f2 = 360.0f / ((Boolean)1.6() != false ? 8.0f : 4.0f);
                if (this.1 <= 0) {
                    float f3 = 7d_0.c.player.rotationYaw + 180.0f;
                    f3 = (float)Math.round(f3 / f2) * f2;
                    7d_0.c.player.prevRotationYaw = 7d_0.c.player.rotationYaw;
                    7d_0.c.player.rotationYaw = Interpolation.finterpTo(7d_0.c.player.rotationYaw, f3 -= 180.0f, c.getRenderPartialTicks(), ((Float)4.6()).floatValue());
                    if (((Boolean)3.6()).booleanValue() && 7d_0.c.player.isRiding()) {
                        7d_0.c.player.getRidingEntity().prevRotationYaw = 7d_0.c.player.getRidingEntity().rotationYaw;
                        7d_0.c.player.getRidingEntity().rotationYaw = 7d_0.c.player.rotationYaw;
                    }
                } else {
                    --this.1;
                }
            }
            if (!((Boolean)2.6()).booleanValue() || this.1 <= 0 && !(this.c > 0.0f)) break block11;
            double d2 = 300.0;
            Vec3d vec3d = 7d_0.c.player.getPositionVector();
            Vec3d[] vec3dArray = (Boolean)1.6() != false ? new Vec3d[]{vec3d.add(d2, 0.0, 0.0), vec3d.add(d2 / 2.0, 0.0, d2 / 2.0), vec3d.add(0.0, 0.0, d2), vec3d.add(-d2 / 2.0, 0.0, d2 / 2.0), vec3d.add(-d2, 0.0, 0.0), vec3d.add(-d2 / 2.0, 0.0, -d2 / 2.0), vec3d.add(0.0, 0.0, -d2), vec3d.add(d2 / 2.0, 0.0, -d2 / 2.0)} : new Vec3d[]{vec3d.add(d2, 0.0, 0.0), vec3d.add(0.0, 0.0, d2), vec3d.add(-d2, 0.0, 0.0), vec3d.add(0.0, 0.0, -d2)};
            if (this.1 > 0) {
                this.c = Interpolation.finterpTo(this.c, 255.0f, c.getRenderPartialTicks(), ((Float)4.6()).floatValue());
            } else if (this.c > 0.0f) {
                this.c = Interpolation.finterpTo(this.c, 0.0f, c.getRenderPartialTicks(), ((Float)4.6()).floatValue());
            }
            if (this.c != 0.0f) {
                GlStateManager.pushMatrix();
                GlStateManager.blendFunc((int)770, (int)771);
                GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                GlStateManager.enableBlend();
                GlStateManager.disableLighting();
                GlStateManager.disableCull();
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.disableDepth();
                GlStateManager.depthMask((boolean)false);
                GlStateManager.shadeModel((int)7425);
                GlStateManager.glLineWidth((float)2.0f);
                GlStateManager.disableTexture2D();
                GL11.glEnable((int)2848);
                GL11.glHint((int)3154, (int)4354);
                double d3 = ((IRenderManager)c.getRenderManager()).getRenderPosX();
                double d4 = ((IRenderManager)c.getRenderManager()).getRenderPosY();
                double d5 = ((IRenderManager)c.getRenderManager()).getRenderPosZ();
                GlStateManager.translate((double)(-d3), (double)(-d4), (double)(-d5));
                for (Vec3d vec3d2 : vec3dArray) {
                    7d_0.c(vec3d2.subtract(0.0, (double)this.c, 0.0), vec3d2.add(0.0, (double)this.c, 0.0), 0.96f, 0.19f, 0.19f, this.c / 255.0f / 2.0f + 127.5f);
                }
                GlStateManager.shadeModel((int)7424);
                GL11.glDisable((int)2848);
                GlStateManager.enableDepth();
                GlStateManager.depthMask((boolean)true);
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.enableCull();
                GlStateManager.enableLighting();
                GlStateManager.disableBlend();
                GlStateManager.enableTexture2D();
                GlStateManager.popMatrix();
            }
        }
    }

    public static void c(Vec3d vec3d, Vec3d vec3d2, int n2, boolean bl, float f2) {
        7d_0.c(vec3d, vec3d2, n2);
    }

    public 7d_0() {
        super("YawLock", "Lock your yaw rotation", 3D.1, new String[0]);
    }

    public static void c(Vec3d vec3d, Vec3d vec3d2, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(vec3d.x, vec3d.y, vec3d.z).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
    }

    public boolean c() {
        for (int i2 = 0; i2 < Mouse.getButtonCount(); ++i2) {
            if (!Mouse.isButtonDown((int)i2)) continue;
            return true;
        }
        return false;
    }

    public static void c(Vec3d vec3d, Vec3d vec3d2, int n2) {
        float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n2 & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        7d_0.c(vec3d, vec3d2, f2, f3, f4, f5);
    }
}

