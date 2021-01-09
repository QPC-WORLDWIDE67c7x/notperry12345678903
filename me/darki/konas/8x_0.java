/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.text.DecimalFormat;
import me.darki.konas.7q_0;
import me.darki.konas.mixin.mixins.IEntity;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8x
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8x_0 {
    public static Minecraft c = Minecraft.getMinecraft();
    public static double[] c = null;

    public static float[] c(Vec3d vec3d, Vec3d vec3d2) {
        double d2 = vec3d2.x - vec3d.x;
        double d3 = (vec3d2.y - vec3d.y) * -1.0;
        double d4 = vec3d2.z - vec3d.z;
        double d5 = MathHelper.sqrt((double)(d2 * d2 + d4 * d4));
        return new float[]{(float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(d4, d2)) - 90.0)), (float)MathHelper.wrapDegrees((double)Math.toDegrees(Math.atan2(d3, d5)))};
    }

    public static double[] c(double d2, EntityPlayerSP entityPlayerSP) {
        Minecraft minecraft = Minecraft.getMinecraft();
        float f2 = entityPlayerSP.movementInput.moveForward;
        float f3 = entityPlayerSP.movementInput.moveStrafe;
        float f4 = entityPlayerSP.prevRotationYaw + (entityPlayerSP.rotationYaw - entityPlayerSP.prevRotationYaw) * minecraft.getRenderPartialTicks();
        if (f2 != 0.0f) {
            if (f3 > 0.0f) {
                f4 += (float)(f2 > 0.0f ? -45 : 45);
            } else if (f3 < 0.0f) {
                f4 += (float)(f2 > 0.0f ? 45 : -45);
            }
            f3 = 0.0f;
            if (f2 > 0.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = -1.0f;
            }
        }
        double d3 = Math.sin(Math.toRadians(f4 + 90.0f));
        double d4 = Math.cos(Math.toRadians(f4 + 90.0f));
        double d5 = (double)f2 * d2 * d4 + (double)f3 * d2 * d3;
        double d6 = (double)f2 * d2 * d3 - (double)f3 * d2 * d4;
        return new double[]{d5, d6};
    }

    public static Vec3d 0(Vec3d vec3d) {
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        double d2 = Double.parseDouble(decimalFormat.format(vec3d.x));
        double d3 = Double.parseDouble(decimalFormat.format(vec3d.y));
        double d4 = Double.parseDouble(decimalFormat.format(vec3d.z));
        return new Vec3d(d2, d3, d4);
    }

    public static Vec3d 0() {
        return new Vec3d(8x_0.c.player.posX, 8x_0.c.player.posY + (double)8x_0.c.player.getEyeHeight(), 8x_0.c.player.posZ);
    }

    public static boolean 3() {
        return 8x_0.c.gameSettings.keyBindForward.isKeyDown() && !8x_0.c.player.isSneaking();
    }

    public static boolean c() {
        return 8x_0.c.gameSettings.keyBindForward.isKeyDown() || 8x_0.c.gameSettings.keyBindBack.isKeyDown() || 8x_0.c.gameSettings.keyBindRight.isKeyDown() || 8x_0.c.gameSettings.keyBindLeft.isKeyDown();
    }

    public static void c(Vec3d vec3d) {
        float[] fArray = 8x_0.1(vec3d);
        8x_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(fArray[0], (float)MathHelper.normalizeAngle((int)((int)fArray[1]), (int)360), 8x_0.c.player.onGround));
        ((IEntityPlayerSP)8x_0.c.player).setLastReportedYaw(fArray[0]);
        ((IEntityPlayerSP)8x_0.c.player).setLastReportedPitch(MathHelper.normalizeAngle((int)((int)fArray[1]), (int)360));
    }

    public static double 0(float f2) {
        return (double)f2 * (Math.PI / 180);
    }

    public static void 1() {
        double d2 = Math.floor(8x_0.c.player.posX) + 0.5;
        double d3 = Math.floor(8x_0.c.player.posZ) + 0.5;
        8x_0.c.player.setPosition(d2, 8x_0.c.player.posY, d3);
        8x_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(d2, 8x_0.c.player.posY, d3, 8x_0.c.player.onGround));
    }

    public static boolean 2() {
        boolean bl = false;
        if (8x_0.c.player.posY <= 0.0) {
            return true;
        }
        int n2 = 1;
        while ((double)n2 < 8x_0.c.player.posY) {
            BlockPos blockPos = new BlockPos(8x_0.c.player.posX, (double)n2, 8x_0.c.player.posZ);
            if (!(8x_0.c.world.getBlockState(blockPos).getBlock() instanceof BlockAir)) {
                bl = false;
                break;
            }
            bl = true;
            ++n2;
        }
        return bl;
    }

    public static float[] 1(Vec3d vec3d) {
        Vec3d vec3d2 = 8x_0.0();
        double d2 = vec3d.x - vec3d2.x;
        double d3 = vec3d.y - vec3d2.y;
        double d4 = vec3d.z - vec3d2.z;
        double d5 = Math.sqrt(d2 * d2 + d4 * d4);
        float f2 = (float)Math.toDegrees(Math.atan2(d4, d2)) - 90.0f;
        float f3 = (float)(-Math.toDegrees(Math.atan2(d3, d5)));
        float[] fArray = new float[]{8x_0.c.player.rotationYaw + MathHelper.wrapDegrees((float)(f2 - 8x_0.c.player.rotationYaw)), 8x_0.c.player.rotationPitch + MathHelper.wrapDegrees((float)(f3 - 8x_0.c.player.rotationPitch))};
        return fArray;
    }

    public static double[] c(double d2) {
        float f2 = 8x_0.c.player.movementInput.moveForward;
        float f3 = 8x_0.c.player.movementInput.moveStrafe;
        float f4 = 8x_0.c.player.prevRotationYaw + (8x_0.c.player.rotationYaw - 8x_0.c.player.prevRotationYaw) * c.getRenderPartialTicks();
        if (f2 != 0.0f) {
            if (f3 > 0.0f) {
                f4 += (float)(f2 > 0.0f ? -45 : 45);
            } else if (f3 < 0.0f) {
                f4 += (float)(f2 > 0.0f ? 45 : -45);
            }
            f3 = 0.0f;
            if (f2 > 0.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = -1.0f;
            }
        }
        double d3 = Math.sin(Math.toRadians(f4 + 90.0f));
        double d4 = Math.cos(Math.toRadians(f4 + 90.0f));
        double d5 = (double)f2 * d2 * d4 + (double)f3 * d2 * d3;
        double d6 = (double)f2 * d2 * d3 - (double)f3 * d2 * d4;
        return new double[]{d5, d6};
    }

    public static boolean c(int n2) {
        if (n2 != 0 && n2 < 256) {
            return n2 < 0 ? Mouse.isButtonDown((int)(n2 + 100)) : Keyboard.isKeyDown((int)n2);
        }
        return false;
    }

    public static double[] c(double d2, double d3, double d4, EntityPlayer entityPlayer) {
        double d5 = entityPlayer.posX - d2;
        double d6 = entityPlayer.posY - d3;
        double d7 = entityPlayer.posZ - d4;
        double d8 = Math.sqrt(d5 * d5 + d6 * d6 + d7 * d7);
        double d9 = Math.asin(d6 /= d8);
        double d10 = Math.atan2(d7 /= d8, d5 /= d8);
        d9 = d9 * 180.0 / Math.PI;
        d10 = d10 * 180.0 / Math.PI;
        return new double[]{d10 += 90.0, d9};
    }

    public static double[] c(float f2) {
        double d2 = 8x_0.0(f2);
        double d3 = Math.sin(d2);
        double d4 = Math.cos(d2);
        return new double[]{d3, d4};
    }

    public static void c(int n2, int n3, int n4, float f2, float f3, EntityPlayer entityPlayer, boolean bl, boolean bl2) {
        7q_0.1 = true;
        GlStateManager.pushMatrix();
        GlStateManager.enableDepth();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)n2, (float)n3, (float)50.0f);
        GlStateManager.scale((float)(-n4), (float)n4, (float)n4);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f4 = entityPlayer.renderYawOffset;
        float f5 = entityPlayer.rotationYaw;
        float f6 = entityPlayer.rotationPitch;
        float f7 = entityPlayer.prevRotationYawHead;
        float f8 = entityPlayer.rotationYawHead;
        GlStateManager.rotate((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        f2 = bl ? entityPlayer.rotationYaw * -1.0f : f2;
        f3 = bl2 ? entityPlayer.rotationPitch * -1.0f : f3;
        GlStateManager.rotate((float)(-((float)Math.atan(f3 / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        if (!bl) {
            entityPlayer.renderYawOffset = (float)Math.atan(f2 / 40.0f) * 20.0f;
            entityPlayer.rotationYawHead = entityPlayer.rotationYaw = (float)Math.atan(f2 / 40.0f) * 40.0f;
            entityPlayer.prevRotationYawHead = entityPlayer.rotationYaw;
        }
        if (!bl2) {
            entityPlayer.rotationPitch = -((float)Math.atan(f3 / 40.0f)) * 20.0f;
        }
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.0f);
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        renderManager.setPlayerViewY(180.0f);
        renderManager.setRenderShadow(false);
        renderManager.renderEntity((Entity)entityPlayer, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        renderManager.setRenderShadow(true);
        if (!bl) {
            entityPlayer.renderYawOffset = f4;
            entityPlayer.rotationYaw = f5;
            entityPlayer.prevRotationYawHead = f7;
            entityPlayer.rotationYawHead = f8;
        }
        if (!bl2) {
            entityPlayer.rotationPitch = f6;
        }
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
        7q_0.1 = false;
    }

    public static void c(boolean bl) {
        ((IEntity)8x_0.c.player).invokeSetFlag(7, bl);
    }
}

