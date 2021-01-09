/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import me.darki.konas.0b_0;
import me.darki.konas.1N;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7e_0;
import me.darki.konas.7f_0;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.99;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7g
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7g_0
extends 3E {
    public static 8h_0<7f_0> 1 = new 8h_0("Mode", 7f_0.c);
    public 8h_0<Boolean> 2 = new 8h_0("Facing", false);
    public static 8h_0<Boolean> 3 = new 8h_0("NotWhenTrajectories", true);
    public 8h_0<Boolean> 4 = new 8h_0("Depth", false);
    public 8h_0<Boolean> 5 = new 8h_0("Vanilla", false);
    public static 8h_0<Float> 6 = new 8h_0("Radius", Float.valueOf(0.1f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(7g_0::6);
    public static 8h_0<Integer> 7 = new 8h_0("Slices", 8, 24, 3, 1).c(7g_0::0);
    public static 8h_0<Float> 8 = new 8h_0("Scale", Float.valueOf(0.6f), Float.valueOf(4.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(7g_0::1);
    public static 8h_0<Double> 9 = new 8h_0("SpinSpeed", 15.0, 30.0, 0.0, 0.1).c(7g_0::c);
    public static 8h_0<Float> a = new 8h_0("Width", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public 8h_0<89> b = new 8h_0("Color", new 89(575714484));
    public RayTraceResult c;
    public static 9m c = new 9m();

    @Subscriber
    public void 0(1b_0 b_02) {
        block11: {
            RayTraceResult rayTraceResult;
            block12: {
                if (7g_0.c.world == null || 7g_0.c.player == null) {
                    return;
                }
                if (1.6() != 7f_0.1) {
                    if (1.6() != 7f_0.2) {
                        return;
                    }
                }
                if (((Boolean)3.6()).booleanValue() && !c.c(75.0)) {
                    return;
                }
                rayTraceResult = 7g_0.c.objectMouseOver;
                if (rayTraceResult == null) {
                    return;
                }
                if (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) break block11;
                if (1.6() != 7f_0.1) break block12;
                GlStateManager.pushMatrix();
                99.c();
                GlStateManager.glLineWidth((float)((Float)a.6()).floatValue());
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask((boolean)false);
                if (!((Boolean)this.4.6()).booleanValue()) {
                    GlStateManager.disableDepth();
                }
                GL11.glLineWidth((float)((Float)a.6()).floatValue());
                GL11.glColor4f((float)((float)((89)this.b.6()).6() / 255.0f), (float)((float)((89)this.b.6()).5() / 255.0f), (float)((float)((89)this.b.6()).2() / 255.0f), (float)((float)((89)this.b.6()).1() / 255.0f));
                GlStateManager.translate((double)(rayTraceResult.hitVec.x - ((IRenderManager)c.getRenderManager()).getRenderPosX()), (double)(rayTraceResult.hitVec.y - ((IRenderManager)c.getRenderManager()).getRenderPosY()), (double)(rayTraceResult.hitVec.z - ((IRenderManager)c.getRenderManager()).getRenderPosZ()));
                EnumFacing enumFacing = rayTraceResult.sideHit;
                switch (7e_0.c[enumFacing.ordinal()]) {
                    case 3: 
                    case 4: {
                        GlStateManager.rotate((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                        break;
                    }
                    case 5: 
                    case 6: {
                        GlStateManager.rotate((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                        break;
                    }
                }
                Cylinder cylinder = new Cylinder();
                GlStateManager.rotate((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                cylinder.setDrawStyle(100011);
                cylinder.draw(((Float)6.6()).floatValue() * 2.0f, ((Float)6.6()).floatValue(), 0.0f, ((Integer)7.6()).intValue(), 1);
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                if (!((Boolean)this.4.6()).booleanValue()) {
                    GlStateManager.enableDepth();
                }
                GlStateManager.depthMask((boolean)true);
                GlStateManager.enableTexture2D();
                99.0();
                GlStateManager.popMatrix();
                break block11;
            }
            if (1.6() != 7f_0.2) break block11;
            this.c(rayTraceResult, ((Float)8.6()).floatValue(), (Double)9.6(), ((89)this.b.6()).4());
        }
    }

    public static boolean 1() {
        return 1.6() == 7f_0.2;
    }

    public void c(@NotNull AxisAlignedBB axisAlignedBB) {
        if (7g_0.c.world == null || 7g_0.c.player == null) {
            return;
        }
        if (((Boolean)3.6()).booleanValue() && !c.c(75.0)) {
            return;
        }
        GlStateManager.pushMatrix();
        99.c();
        if (((Boolean)this.4.6()).booleanValue()) {
            GlStateManager.enableDepth();
            GlStateManager.depthMask((boolean)true);
        }
        if (1.6() == 7f_0.c) {
            99.c(axisAlignedBB, (89)this.b.6());
        }
        99.c(axisAlignedBB, ((Float)a.6()).floatValue(), ((89)this.b.6()).1(255));
        GlStateManager.resetColor();
        99.0();
        GlStateManager.popMatrix();
    }

    public void c(RayTraceResult rayTraceResult, float f2, double d2, Color color) {
        GL11.glPushAttrib((int)1048575);
        GL11.glPushMatrix();
        GL11.glDisable((int)3008);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glLineWidth((float)2.0f);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        GL11.glTranslated((double)(rayTraceResult.hitVec.x - ((IRenderManager)c.getRenderManager()).getRenderPosX()), (double)(rayTraceResult.hitVec.y - ((IRenderManager)c.getRenderManager()).getRenderPosY()), (double)(rayTraceResult.hitVec.z - ((IRenderManager)c.getRenderManager()).getRenderPosZ()));
        switch (7e_0.c[rayTraceResult.sideHit.ordinal()]) {
            case 6: {
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                break;
            }
            case 5: {
                GL11.glRotatef((float)-90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                break;
            }
            case 3: {
                GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                break;
            }
            case 2: {
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                break;
            }
            case 1: {
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                break;
            }
        }
        double d3 = Math.ceil((double)System.currentTimeMillis() / Math.abs(d2 - 30.1));
        d3 %= 360.0;
        if (d2 == 0.0) {
            d3 = 0.0;
        }
        GL11.glRotated((double)d3, (double)0.0, (double)0.0, (double)1.0);
        GL11.glScalef((float)(f2 * 0.5f), (float)(f2 * 0.5f), (float)(f2 * 0.5f));
        GL11.glBegin((int)3);
        GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
        GL11.glVertex3d((double)0.0, (double)1.0, (double)0.0);
        GL11.glVertex3d((double)1.0, (double)1.0, (double)0.0);
        GL11.glEnd();
        GL11.glBegin((int)3);
        GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
        GL11.glVertex3d((double)1.0, (double)0.0, (double)0.0);
        GL11.glVertex3d((double)1.0, (double)-1.0, (double)0.0);
        GL11.glEnd();
        GL11.glBegin((int)3);
        GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
        GL11.glVertex3d((double)0.0, (double)-1.0, (double)0.0);
        GL11.glVertex3d((double)-1.0, (double)-1.0, (double)0.0);
        GL11.glEnd();
        GL11.glBegin((int)3);
        GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
        GL11.glVertex3d((double)-1.0, (double)0.0, (double)0.0);
        GL11.glVertex3d((double)-1.0, (double)1.0, (double)0.0);
        GL11.glEnd();
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glPopMatrix();
        GL11.glPopAttrib();
    }

    public static boolean c() {
        return 1.6() == 7f_0.2;
    }

    public static boolean 6() {
        return 1.6() == 7f_0.1;
    }

    public static boolean 0() {
        return 1.6() == 7f_0.1;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block12: {
            if (7g_0.c.world == null || 7g_0.c.player == null) {
                return;
            }
            if (this.c == null) {
                return;
            }
            if (1.6() == 7f_0.1 || 1.6() == 7f_0.2) {
                return;
            }
            if (this.c.typeOfHit != RayTraceResult.Type.BLOCK) break block12;
            BlockPos blockPos = this.c.getBlockPos();
            IBlockState iBlockState = 7g_0.c.world.getBlockState(blockPos);
            AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World)7g_0.c.world, blockPos);
            if (((Boolean)this.2.6()).booleanValue()) {
                switch (7e_0.c[this.c.sideHit.ordinal()]) {
                    case 1: {
                        axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
                        break;
                    }
                    case 2: {
                        axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                        break;
                    }
                    case 3: {
                        axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
                        break;
                    }
                    case 4: {
                        axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                        break;
                    }
                    case 5: {
                        axisAlignedBB = new AxisAlignedBB(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                        break;
                    }
                    case 6: {
                        axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                    }
                }
            }
            this.c(axisAlignedBB);
        }
    }

    public 7g_0() {
        super("BlockHighlight", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(0b_0 b_02) {
        block0: {
            if (((Boolean)this.5.6()).booleanValue()) break block0;
            b_02.c(true);
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (7g_0.c.world == null || 7g_0.c.player == null) {
            return;
        }
        this.c = 7g_0.c.objectMouseOver;
    }
}

