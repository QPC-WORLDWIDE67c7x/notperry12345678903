/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7E;
import me.darki.konas.7F;
import me.darki.konas.7J;
import me.darki.konas.89;
import me.darki.konas.8Z;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.97;
import me.darki.konas.99;
import me.darki.konas.mixin.mixins.IDestroyBlockProgress;
import me.darki.konas.mixin.mixins.IEntityRenderer;
import me.darki.konas.mixin.mixins.IPlayerControllerMP;
import me.darki.konas.mixin.mixins.IRenderGlobal;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7G
extends 3E {
    public static 8h_0<8f_0> 1 = new 8h_0("Breaking", new 8f_0(false));
    public 8h_0<7F> 2 = new 8h_0("BRenderMove", 7F.c).c(1);
    public 8h_0<Float> 3 = new 8h_0("BRange", Float.valueOf(15.0f), Float.valueOf(255.0f), Float.valueOf(5.0f), Float.valueOf(5.0f)).c(1);
    public 8h_0<Boolean> 4 = new 8h_0("BOutline", true).c(1);
    public 8h_0<Boolean> 5 = new 8h_0("BWireframe", false).c(1);
    public 8h_0<Float> 6 = new 8h_0("BWidth", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).c(1);
    public 8h_0<89> 7 = new 8h_0("BOutlineColor", new 89(-65536)).c(1);
    public 8h_0<89> 8 = new 8h_0("BCrossOutlineColor", new 89(-65536)).c(1).c(this::5);
    public 8h_0<Boolean> 9 = new 8h_0("BFill", true).c(1);
    public 8h_0<89> a = new 8h_0("BFillColor", new 89(0x66FF0000)).c(1);
    public 8h_0<89> b = new 8h_0("BCrossFillColor", new 89(0x66FF0000)).c(1).c(this::c);
    public 8h_0<Boolean> d = new 8h_0("DynamicColor", true).c(1);
    public 8h_0<Boolean> e = new 8h_0("BTracer", false).c(1);
    public 8h_0<89> f = new 8h_0("BTracerColor", new 89(-65536)).c(1);
    public 8h_0<Boolean> g = new 8h_0("ShowName", false).c(1);
    public static 8h_0<8f_0> h = new 8h_0("Placing", new 8f_0(false));
    public 8h_0<Boolean> i = new 8h_0("POutline", true).c(h);
    public 8h_0<Boolean> j = new 8h_0("PWireframe", false).c(h);
    public 8h_0<Float> k = new 8h_0("PWidth", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).c(h);
    public 8h_0<89> l = new 8h_0("POutlineColor", new 89(-16776961)).c(h);
    public 8h_0<Boolean> m = new 8h_0("PFill", true).c(h);
    public 8h_0<89> n = new 8h_0("PFillColor", new 89(0x660000FF)).c(h);

    public static Color c(Color color, Color color2, double d2, int n2) {
        double d3 = 7G.c(color.getRed(), color2.getRed(), d2);
        double d4 = 7G.c(color.getGreen(), color2.getGreen(), d2);
        double d5 = 7G.c(color.getBlue(), color2.getBlue(), d2);
        return new Color((int)Math.round(d3), (int)Math.round(d4), (int)Math.round(d5), n2);
    }

    @Override
    public boolean 5() {
        return this.2.6() == 7F.1;
    }

    public boolean c() {
        return this.2.6() == 7F.1;
    }

    public void c(double d2, double d3, double d4, double d5, double d6, double d7, int n2) {
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.5f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4f((float)((float)(n2 >> 16 & 0xFF) / 255.0f), (float)((float)(n2 >> 8 & 0xFF) / 255.0f), (float)((float)(n2 & 0xFF) / 255.0f), (float)((float)(n2 >> 24 & 0xFF) / 255.0f));
        GlStateManager.disableLighting();
        GL11.glLoadIdentity();
        ((IEntityRenderer)7G.c.entityRenderer).iOrientCamera(c.getRenderPartialTicks());
        GL11.glEnable((int)2848);
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)d2, (double)d3, (double)d4);
        GL11.glVertex3d((double)d5, (double)d6, (double)d7);
        GL11.glVertex3d((double)d5, (double)d6, (double)d7);
        GL11.glEnd();
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glColor3d((double)1.0, (double)1.0, (double)1.0);
        GlStateManager.enableLighting();
    }

    public static double c(double d2, double d3, double d4) {
        return d2 + (d3 - d2) * d4;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        if (7G.c.player == null || 7G.c.world == null) {
            return;
        }
        if (7G.c.playerController.getIsHittingBlock()) {
            float f2 = ((IPlayerControllerMP)7G.c.playerController).getCurBlockDamageMP();
            BlockPos blockPos = ((IPlayerControllerMP)7G.c.playerController).getCurrentBlock();
            AxisAlignedBB axisAlignedBB = 7G.c.world.getBlockState(blockPos).getBoundingBox((IBlockAccess)7G.c.world, blockPos).offset(blockPos);
            switch (7E.c[((7F)((Object)this.2.6())).ordinal()]) {
                case 1: {
                    this.c(axisAlignedBB.shrink(0.5 - (double)f2 * 0.5), (89)this.a.6(), (89)this.7.6(), f2);
                    break;
                }
                case 2: {
                    this.c(axisAlignedBB.shrink((double)f2 * 0.5), (89)this.a.6(), (89)this.7.6(), f2);
                    break;
                }
                case 3: {
                    this.c(axisAlignedBB.shrink(0.5 - (double)f2 * 0.5), (89)this.a.6(), (89)this.7.6(), f2);
                    this.c(axisAlignedBB.shrink((double)f2 * 0.5), (89)this.b.6(), (89)this.8.6(), f2);
                    break;
                }
                default: {
                    this.c(axisAlignedBB, (89)this.a.6(), (89)this.7.6(), f2);
                    break;
                }
            }
            if (((Boolean)this.e.6()).booleanValue()) {
                Vec3d vec3d = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float)Math.toRadians(7G.c.player.rotationPitch))).rotateYaw(-((float)Math.toRadians(7G.c.player.rotationYaw)));
                this.c(vec3d.x, vec3d.y + (double)7G.c.player.getEyeHeight(), vec3d.z, (double)blockPos.getX() - ((IRenderManager)c.getRenderManager()).getRenderPosX() + 0.5, (double)blockPos.getY() - ((IRenderManager)c.getRenderManager()).getRenderPosY() + 0.5, (double)blockPos.getZ() - ((IRenderManager)c.getRenderManager()).getRenderPosZ() + 0.5, ((89)this.f.6()).c());
            }
        }
        ((IRenderGlobal)7G.c.renderGlobal).getDamagedBlocks().forEach(this::c);
    }

    public void c(Integer n2, DestroyBlockProgress destroyBlockProgress) {
        this.c(destroyBlockProgress);
    }

    public void c(AxisAlignedBB axisAlignedBB) {
        block3: {
            if (((Boolean)this.m.6()).booleanValue()) {
                99.c();
                99.c(axisAlignedBB, (89)this.n.6());
                99.0();
            }
            if (!((Boolean)this.i.6()).booleanValue()) break block3;
            99.c();
            if (((Boolean)this.j.6()).booleanValue()) {
                8Z.c(axisAlignedBB.offset(-((IRenderManager)3E.c.getRenderManager()).getRenderPosX(), -((IRenderManager)3E.c.getRenderManager()).getRenderPosY(), -((IRenderManager)3E.c.getRenderManager()).getRenderPosZ()), ((89)this.l.6()).c(), ((Float)this.k.6()).floatValue());
            } else {
                99.c(axisAlignedBB, ((Float)this.k.6()).floatValue(), (89)this.l.6());
            }
            99.0();
        }
    }

    public void c(AxisAlignedBB axisAlignedBB, 89 var2_2, 89 var3_3, float f2) {
        block4: {
            if (((Boolean)this.d.6()).booleanValue()) {
                var2_2 = new 89(7G.c(f2, var2_2.1()).getRGB());
                var3_3 = var2_2.1(var3_3.1());
            }
            if (((Boolean)this.9.6()).booleanValue()) {
                99.c();
                99.c(axisAlignedBB, var2_2);
                99.0();
            }
            if (!((Boolean)this.4.6()).booleanValue()) break block4;
            99.c();
            if (((Boolean)this.5.6()).booleanValue()) {
                8Z.c(axisAlignedBB.offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ()), var3_3.c(), ((Float)this.6.6()).floatValue());
            } else {
                99.c(axisAlignedBB, ((Float)this.6.6()).floatValue(), var3_3);
            }
            99.0();
        }
    }

    public 7G() {
        super("Interactions", "Render interactions with the world", 3D.2, new String[0]);
    }

    public static Color c(float f2, int n2) {
        if ((double)f2 < 0.5) {
            return 7G.c(Color.RED, Color.YELLOW, (double)f2 / 0.5, n2);
        }
        return 7G.c(Color.YELLOW, Color.GREEN, ((double)f2 - 0.5) / 0.5, n2);
    }

    public void c(DestroyBlockProgress destroyBlockProgress) {
        block19: {
            if (destroyBlockProgress == null) break block19;
            BlockPos blockPos = destroyBlockProgress.getPosition();
            if (7G.c.playerController.getIsHittingBlock() && ((IPlayerControllerMP)7G.c.playerController).getCurrentBlock().equals((Object)blockPos)) {
                return;
            }
            if (7G.c.player.getDistance((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5) > (double)((Float)this.3.6()).floatValue()) {
                return;
            }
            float f2 = Math.min(1.0f, (float)destroyBlockProgress.getPartialBlockDamage() / 8.0f);
            AxisAlignedBB axisAlignedBB = 7G.c.world.getBlockState(blockPos).getBoundingBox((IBlockAccess)7G.c.world, blockPos).offset(blockPos);
            switch (7E.c[((7F)((Object)this.2.6())).ordinal()]) {
                case 1: {
                    this.c(axisAlignedBB.shrink(0.5 - (double)f2 * 0.5), (89)this.a.6(), (89)this.7.6(), f2);
                    break;
                }
                case 2: {
                    this.c(axisAlignedBB.shrink((double)f2 * 0.5), (89)this.a.6(), (89)this.7.6(), f2);
                    break;
                }
                case 3: {
                    this.c(axisAlignedBB.shrink(0.5 - (double)f2 * 0.5), (89)this.a.6(), (89)this.7.6(), f2);
                    this.c(axisAlignedBB.shrink((double)f2 * 0.5), (89)this.b.6(), (89)this.8.6(), f2);
                    break;
                }
                default: {
                    this.c(axisAlignedBB, (89)this.a.6(), (89)this.7.6(), f2);
                    break;
                }
            }
            if (((Boolean)this.e.6()).booleanValue()) {
                Vec3d vec3d = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float)Math.toRadians(7G.c.player.rotationPitch))).rotateYaw(-((float)Math.toRadians(7G.c.player.rotationYaw)));
                this.c(vec3d.x, vec3d.y + (double)7G.c.player.getEyeHeight(), vec3d.z, (double)blockPos.getX() - ((IRenderManager)c.getRenderManager()).getRenderPosX() + 0.5, (double)blockPos.getY() - ((IRenderManager)c.getRenderManager()).getRenderPosY() + 0.5, (double)blockPos.getZ() - ((IRenderManager)c.getRenderManager()).getRenderPosZ() + 0.5, ((89)this.f.6()).c());
            }
            if (((Boolean)this.g.6()).booleanValue()) {
                int n2 = ((IDestroyBlockProgress)destroyBlockProgress).getMiningPlayerEntId();
                Entity entity = 7G.c.world.getEntityByID(n2);
                if (entity == null || entity == 7G.c.player) {
                    return;
                }
                String string = entity.getName();
                GlStateManager.pushMatrix();
                BlockPos blockPos2 = blockPos;
                int n3 = blockPos2.getX();
                float f3 = (float)n3 + 0.5f;
                BlockPos blockPos3 = blockPos;
                int n4 = blockPos3.getY();
                float f4 = (float)n4 + 0.5f;
                BlockPos blockPos4 = blockPos;
                int n5 = blockPos4.getZ();
                float f5 = (float)n5 + 0.5f;
                EntityPlayerSP entityPlayerSP = 7G.c.player;
                float f6 = 1.0f;
                try {
                    97.c(f3, f4, f5, (EntityPlayer)entityPlayerSP, f6);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                GlStateManager.disableLighting();
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.scale((double)0.15, (double)0.15, (double)1.0);
                7J.0.0(string, (float)(-((double)7J.0.0(string) / 2.0)), (int)(-7J.0.c(string) / 2.0f), -1);
                GlStateManager.scale((double)6.666666666666667, (double)6.666666666666667, (double)1.0);
                GlStateManager.enableLighting();
                GlStateManager.enableTexture2D();
                GlStateManager.enableDepth();
                GlStateManager.popMatrix();
            }
        }
    }
}

