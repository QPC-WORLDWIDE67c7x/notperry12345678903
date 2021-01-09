/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.util.Collection;
import java.util.Collections;
import me.darki.konas.9c;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 96 {
    public static Minecraft c = Minecraft.getMinecraft();
    public static Frustum c = new Frustum();

    public static void c(Entity entity, int n2, float f2) {
        block0: {
            IRenderManager iRenderManager = (IRenderManager)c.getRenderManager();
            double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2 - iRenderManager.getRenderPosX();
            double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2 - iRenderManager.getRenderPosY();
            double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2 - iRenderManager.getRenderPosZ();
            AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
            AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity.posX + d2, axisAlignedBB.minY - entity.posY + d3, axisAlignedBB.minZ - entity.posZ + d4, axisAlignedBB.maxX - entity.posX + d2, axisAlignedBB.maxY - entity.posY + d3, axisAlignedBB.maxZ - entity.posZ + d4);
            if (entity == 96.c.player) break block0;
            float[] fArray = 9c.c(n2);
            96.c(axisAlignedBB2.grow((double)0.002f), fArray[0], fArray[1], fArray[2], fArray[3]);
        }
    }

    public static void 0(AxisAlignedBB axisAlignedBB, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
    }

    public static void 1(AxisAlignedBB axisAlignedBB, Color color) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-96.c.getRenderManager().viewerPosX, -96.c.getRenderManager().viewerPosY, -96.c.getRenderManager().viewerPosZ);
        96.0(axisAlignedBB2.grow((double)0.002f), color.getRed() * 255, color.getGreen() * 255, color.getBlue() * 255, color.getAlpha() * 255);
    }

    public static void c(double d2, double d3, double d4, float f2, int n2, int n3) {
        Sphere sphere = new Sphere();
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.2f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        sphere.setDrawStyle(100013);
        double d5 = ((IRenderManager)c.getRenderManager()).getRenderPosX();
        double d6 = ((IRenderManager)c.getRenderManager()).getRenderPosY();
        double d7 = ((IRenderManager)c.getRenderManager()).getRenderPosZ();
        GL11.glTranslated((double)(d2 - d5), (double)(d3 - d6), (double)(d4 - d7));
        sphere.draw(f2, n2, n3);
        GL11.glLineWidth((float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void c() {
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
    }

    public static void 0(int n2) {
        float f2 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n2 & 0xFF) / 255.0f;
        GlStateManager.color((float)f3, (float)f4, (float)f5, (float)f2);
    }

    public static void 0(AxisAlignedBB axisAlignedBB, int n2) {
        96.1(axisAlignedBB, new Color(n2));
    }

    public static void c(AxisAlignedBB axisAlignedBB, Color color) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-96.c.getRenderManager().viewerPosX, -96.c.getRenderManager().viewerPosY, -96.c.getRenderManager().viewerPosZ);
        96.c(color);
        96.0(axisAlignedBB2);
    }

    public static float c(EntityLivingBase entityLivingBase) {
        return 96.c(entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ);
    }

    public static void 1(AxisAlignedBB axisAlignedBB, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
    }

    public static void 2(AxisAlignedBB axisAlignedBB, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
    }

    public static Minecraft 0() {
        return c;
    }

    public static boolean c(AxisAlignedBB axisAlignedBB) {
        Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
        c.setPosition(entity.posX, entity.posY, entity.posZ);
        return c.isBoundingBoxInFrustum(axisAlignedBB);
    }

    public static void c(float f2, float f3, float f4, float f5, float f6, boolean bl, float f7, int n2) {
        boolean bl2 = GL11.glIsEnabled((int)3042);
        float f8 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glPushMatrix();
        96.c(n2);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)f2, (double)f3);
        GL11.glVertex2d((double)(f2 - f4 / f5), (double)(f3 + f4));
        GL11.glVertex2d((double)f2, (double)(f3 + f4 / f6));
        GL11.glVertex2d((double)(f2 + f4 / f5), (double)(f3 + f4));
        GL11.glVertex2d((double)f2, (double)f3);
        GL11.glEnd();
        if (bl) {
            GL11.glLineWidth((float)f7);
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)f8);
            GL11.glBegin((int)2);
            GL11.glVertex2d((double)f2, (double)f3);
            GL11.glVertex2d((double)(f2 - f4 / f5), (double)(f3 + f4));
            GL11.glVertex2d((double)f2, (double)(f3 + f4 / f6));
            GL11.glVertex2d((double)(f2 + f4 / f5), (double)(f3 + f4));
            GL11.glVertex2d((double)f2, (double)f3);
            GL11.glEnd();
        }
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        if (!bl2) {
            GL11.glDisable((int)3042);
        }
        GL11.glDisable((int)2848);
    }

    public static void c(AxisAlignedBB axisAlignedBB, int n2) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-96.c.getRenderManager().viewerPosX, -96.c.getRenderManager().viewerPosY, -96.c.getRenderManager().viewerPosZ);
        96.0(n2);
        96.0(axisAlignedBB2);
    }

    public static void c(BlockPos blockPos, int n2, double d2, double d3) {
        float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n2 & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        96.c(Collections.singleton(blockPos), f2, f3, f4, f5, d2, d3);
    }

    public static void c(Collection<BlockPos> collection, float f2, float f3, float f4, float f5, double d2, double d3) {
        96.1();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean)false);
        double d4 = ((IRenderManager)c.getRenderManager()).getRenderPosX();
        double d5 = ((IRenderManager)c.getRenderManager()).getRenderPosY();
        double d6 = ((IRenderManager)c.getRenderManager()).getRenderPosZ();
        GL11.glColor4d((double)f2, (double)f3, (double)f4, (double)f5);
        for (BlockPos blockPos : collection) {
            GlStateManager.pushMatrix();
            double d7 = (double)blockPos.getX() - d4;
            double d8 = (double)blockPos.getY() - d5;
            double d9 = (double)blockPos.getZ() - d6;
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d7, d8, d9, d7 + d3, d8 + 1.0, d9 + d2);
            96.1(axisAlignedBB, f2, f3, f4, f5);
            GlStateManager.popMatrix();
        }
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableAlpha();
        96.c();
    }

    public static void c(RayTraceResult rayTraceResult, int n2, float f2) {
        block1: {
            if (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) break block1;
            float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
            float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
            float f5 = (float)(n2 & 0xFF) / 255.0f;
            float f6 = (float)(n2 >> 24 & 0xFF) / 255.0f;
            96.1();
            GlStateManager.glLineWidth((float)2.0f);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            BlockPos blockPos = rayTraceResult.getBlockPos();
            IBlockState iBlockState = 96.c.world.getBlockState(blockPos);
            if (iBlockState.getMaterial() != Material.AIR && 96.c.world.getWorldBorder().contains(blockPos)) {
                double d2 = 96.c.player.lastTickPosX + (96.c.player.posX - 96.c.player.lastTickPosX) * (double)f2;
                double d3 = 96.c.player.lastTickPosY + (96.c.player.posY - 96.c.player.lastTickPosY) * (double)f2;
                double d4 = 96.c.player.lastTickPosZ + (96.c.player.posZ - 96.c.player.lastTickPosZ) * (double)f2;
                96.c(iBlockState.getSelectedBoundingBox((World)96.c.world, blockPos).grow((double)0.002f).offset(-d2, -d3, -d4), f3, f4, f5, f6);
            }
            96.c();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
        }
    }

    public static void c(float f2, float f3, float f4, float f5, int n2, int n3) {
        float f6 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n2 & 0xFF) / 255.0f;
        float f10 = (float)(n3 >> 24 & 0xFF) / 255.0f;
        float f11 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f12 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f13 = (float)(n3 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f4, (double)f3, 0.0).color(f11, f12, f13, f10).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f2, (double)f5, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, 0.0).color(f11, f12, f13, f10).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void c(int n2) {
        float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n2 & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f((float)f2, (float)f3, (float)f4, (float)f5);
    }

    public static void c(float f2, float f3, float f4, float f5, int n2, int n3, int n4, int n5) {
        float f6 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n2 & 0xFF) / 255.0f;
        float f10 = (float)(n4 >> 24 & 0xFF) / 255.0f;
        float f11 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f12 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f13 = (float)(n4 & 0xFF) / 255.0f;
        float f14 = (float)(n3 >> 24 & 0xFF) / 255.0f;
        float f15 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f16 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f17 = (float)(n3 & 0xFF) / 255.0f;
        float f18 = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f19 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f20 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f21 = (float)(n5 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f4, (double)f3, 0.0).color(f19, f20, f21, f18).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).color(f15, f16, f17, f14).endVertex();
        bufferBuilder.pos((double)f2, (double)f5, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, 0.0).color(f11, f12, f13, f10).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void c(int n2, int n3, int n4, int n5, float f2, int n6) {
        int n7;
        if (n2 < n4) {
            n7 = n2;
            n2 = n4;
            n4 = n7;
        }
        if (n3 < n5) {
            n7 = n3;
            n3 = n5;
            n5 = n7;
        }
        float f3 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f4 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n6 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)f4, (float)f5, (float)f6, (float)f3);
        GL11.glEnable((int)2848);
        GlStateManager.glLineWidth((float)f2);
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)n2, (double)n3, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n3, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n3, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n2, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n2, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n2, (double)n3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glDisable((int)2848);
    }

    public static void c(Vec3d vec3d, Vec3d vec3d2, Color color) {
        double d2 = ((IRenderManager)c.getRenderManager()).getRenderPosX();
        double d3 = ((IRenderManager)c.getRenderManager()).getRenderPosY();
        double d4 = ((IRenderManager)c.getRenderManager()).getRenderPosZ();
        Vec3d vec3d3 = vec3d.add(-d2, -d3, -d4);
        Vec3d vec3d4 = vec3d2.add(-d2, -d3, -d4);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(vec3d3.x, vec3d3.y, vec3d3.z).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(vec3d4.x, vec3d4.y, vec3d4.z).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        tessellator.draw();
    }

    public static void c(Entity entity, int n2, double d2) {
        IRenderManager iRenderManager = (IRenderManager)c.getRenderManager();
        double d3 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * d2 - iRenderManager.getRenderPosX();
        double d4 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * d2 - iRenderManager.getRenderPosY();
        double d5 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * d2 - iRenderManager.getRenderPosZ();
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity.posX + d3, axisAlignedBB.minY - entity.posY + d4, axisAlignedBB.minZ - entity.posZ + d5, axisAlignedBB.maxX - entity.posX + d3, axisAlignedBB.maxY - entity.posY + d4, axisAlignedBB.maxZ - entity.posZ + d5);
        GL11.glBlendFunc((int)770, (int)771);
        float[] fArray = 9c.c(n2);
        GL11.glColor4f((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
        96.0(axisAlignedBB2);
    }

    public static void 1(AxisAlignedBB axisAlignedBB, int n2) {
        96.0(axisAlignedBB, new Color(n2));
    }

    public static float c(double d2, double d3, double d4) {
        ScaledResolution scaledResolution = new ScaledResolution(c);
        double d5 = (double)scaledResolution.getScaleFactor() / Math.pow(scaledResolution.getScaleFactor(), 2.0);
        return (float)d5 + (float)96.c.player.getDistance(d2, d3, d4) / 7.0f;
    }

    public static void c(AxisAlignedBB axisAlignedBB, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        tessellator.draw();
    }

    public static void c(Color color) {
        float f2 = (float)color.getRed() / 255.0f;
        float f3 = (float)color.getGreen() / 255.0f;
        float f4 = (float)color.getBlue() / 255.0f;
        float f5 = (float)color.getAlpha() / 255.0f;
        GlStateManager.color((float)f2, (float)f3, (float)f4, (float)f5);
    }

    public static void 0(AxisAlignedBB axisAlignedBB, Color color) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-96.c.getRenderManager().viewerPosX, -96.c.getRenderManager().viewerPosY, -96.c.getRenderManager().viewerPosZ);
        96.c(axisAlignedBB2.grow((double)0.002f), color.getRed() * 255, color.getGreen() * 255, color.getBlue() * 255, color.getAlpha() * 255);
    }

    public static void 0(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
    }

    public static void c(double d2, double d3, double d4, double d5, Color color) {
        double d6 = d2 - ((IRenderManager)c.getRenderManager()).getRenderPosX();
        double d7 = d3 - ((IRenderManager)c.getRenderManager()).getRenderPosY();
        double d8 = d4 - ((IRenderManager)c.getRenderManager()).getRenderPosZ();
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        GL11.glBegin((int)1);
        for (int i2 = 0; i2 <= 360; ++i2) {
            GL11.glVertex3d((double)(d6 + Math.sin((double)i2 * Math.PI / 180.0) * d5), (double)d7, (double)(d8 + Math.cos((double)i2 * Math.PI / 180.0) * d5));
        }
        GL11.glEnd();
    }

    public static boolean c(Entity entity) {
        return 96.c(entity.getEntityBoundingBox()) || entity.ignoreFrustumCheck;
    }

    public static void 1() {
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
    }
}

