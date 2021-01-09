/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 97 {
    public static Minecraft c = Minecraft.getMinecraft();

    public static Vec3d c(Vec3d vec3d) {
        return new Vec3d(vec3d.x, vec3d.y, vec3d.z).subtract(((IRenderManager)c.getRenderManager()).getRenderPosX(), ((IRenderManager)c.getRenderManager()).getRenderPosY(), ((IRenderManager)c.getRenderManager()).getRenderPosZ());
    }

    public static void c(BlockPos blockPos, Float f2, Float f3, Float f4, Float f5, Float f6) {
        97.c(new Vec3d((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ()), f2, f3, f4, f5, 1.0, 1.0, 1.0, f6);
    }

    public static void 0(float f2, float f3, float f4, float f5, int n2) {
        97.c(f2, f3, f4, f5, n2, 7);
    }

    public static void 2() {
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.resetColor();
    }

    public static Vec3d 0(Entity entity, float f2) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2);
    }

    public static void c(float f2, float f3, float f4, float f5, int n2, int n3) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        97.c(n2);
        bufferBuilder.begin(n3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)f2, (double)f5, 0.0).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, 0.0).endVertex();
        bufferBuilder.pos((double)f4, (double)f3, 0.0).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void c(float f2, float f3, float f4, EntityPlayer entityPlayer, float f5) {
        97.c(f2, f3, f4);
        int n2 = (int)entityPlayer.getDistance((double)f2, (double)f3, (double)f4);
        float f6 = (float)n2 / 2.0f / (2.0f + (2.0f - f5));
        if (f6 < 1.0f) {
            f6 = 1.0f;
        }
        GlStateManager.scale((float)f6, (float)f6, (float)f6);
    }

    public static Vec3d c(Entity entity, double d2) {
        return 97.c(entity, d2, d2, d2);
    }

    public static Float[] 0(int n2) {
        float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n2 & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        return new Float[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
    }

    public static void c(Vec3d vec3d, int n2, int n3, int n4, int n5, double d2, double d3, double d4, float f2) {
        double d5 = vec3d.x - (97.c.player.lastTickPosX + (97.c.player.posX - 97.c.player.lastTickPosX) * (double)f2);
        double d6 = vec3d.y - (97.c.player.lastTickPosY + (97.c.player.posY - 97.c.player.lastTickPosY) * (double)f2);
        double d7 = vec3d.z - (97.c.player.lastTickPosZ + (97.c.player.posZ - 97.c.player.lastTickPosZ) * (double)f2);
        GlStateManager.color((float)((float)n2 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n4 / 255.0f), (float)((float)n5 / 255.0f));
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d5, d6, d7, d5 + d2, d6 + d3, d7 + d4);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
    }

    public static void c() {
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.resetColor();
    }

    public static Vec3d c(Entity entity, float f2) {
        return 97.1(entity, f2).subtract(((IRenderManager)c.getRenderManager()).getRenderPosX(), ((IRenderManager)c.getRenderManager()).getRenderPosY(), ((IRenderManager)c.getRenderManager()).getRenderPosZ());
    }

    public static void c(float f2, float f3, float f4, float f5, int n2) {
        97.c(f2, f3, f4, f5, n2, 2);
    }

    public static Vec3d c(Entity entity, double d2, double d3, double d4) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d2, (entity.posY - entity.lastTickPosY) * d3, (entity.posZ - entity.lastTickPosZ) * d4);
    }

    public static void c(TileEntity tileEntity, int n2) {
        float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n2 & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        97.0();
        GlStateManager.enableBlend();
        GlStateManager.glLineWidth((float)3.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        BlockPos blockPos = tileEntity.getPos();
        IBlockState iBlockState = 97.c.world.getBlockState(blockPos);
        AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World)97.c.world, blockPos).offset(-97.c.getRenderManager().viewerPosX, -97.c.getRenderManager().viewerPosY, -97.c.getRenderManager().viewerPosZ);
        97.c(axisAlignedBB.grow((double)0.002f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
        GlStateManager.resetColor();
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        97.2();
        GlStateManager.popMatrix();
    }

    public static Vec3d 1(Entity entity, float f2) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(97.c(entity, (double)f2));
    }

    public static void c(float f2, float f3, float f4) {
        float f5 = 0.02666667f;
        GlStateManager.translate((double)((double)f2 - ((IRenderManager)c.getRenderManager()).getRenderPosX()), (double)((double)f3 - ((IRenderManager)c.getRenderManager()).getRenderPosY()), (double)((double)f4 - ((IRenderManager)c.getRenderManager()).getRenderPosZ()));
        GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-Minecraft.getMinecraft().player.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)Minecraft.getMinecraft().player.rotationPitch, (float)(Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)(-f5), (float)(-f5), (float)f5);
    }

    public static void 1() {
        GlStateManager.resetColor();
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
    }

    public static void c(BlockPos blockPos, int n2, int n3, int n4, int n5, double d2, double d3, double d4, float f2) {
        double d5 = (double)blockPos.getX() - (97.c.player.lastTickPosX + (97.c.player.posX - 97.c.player.lastTickPosX) * (double)f2);
        double d6 = (double)blockPos.getY() - (97.c.player.lastTickPosY + (97.c.player.posY - 97.c.player.lastTickPosY) * (double)f2);
        double d7 = (double)blockPos.getZ() - (97.c.player.lastTickPosZ + (97.c.player.posZ - 97.c.player.lastTickPosZ) * (double)f2);
        GlStateManager.color((float)((float)n2 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n4 / 255.0f), (float)((float)n5 / 255.0f));
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d5, d6, d7, d5 + d2, d6 + d3, d7 + d4);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
    }

    public static void c(float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n2) {
        Float[] floatArray = 97.0(n2);
        GL11.glLineWidth((float)f8);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f2, (double)f3, (double)f4).color(floatArray[0].floatValue(), floatArray[1].floatValue(), floatArray[2].floatValue(), floatArray[3].floatValue()).endVertex();
        bufferBuilder.pos((double)f5, (double)f6, (double)f7).color(floatArray[0].floatValue(), floatArray[1].floatValue(), floatArray[2].floatValue(), floatArray[3].floatValue()).endVertex();
        bufferBuilder.pos((double)f5, (double)f6, (double)f7).color(floatArray[0].floatValue(), floatArray[1].floatValue(), floatArray[2].floatValue(), floatArray[3].floatValue()).endVertex();
        tessellator.draw();
        GL11.glDisable((int)2848);
    }

    public static void c(int n2) {
        float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n2 & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)f2, (float)f3, (float)f4, (float)f5);
    }

    public static void c(Vec3d vec3d, Float f2, Float f3, Float f4, Float f5, double d2, double d3, double d4, Float f6) {
        double d5 = 97.c.player.lastTickPosX + (97.c.player.posX - 97.c.player.lastTickPosX) * (double)f6.floatValue();
        double d6 = 97.c.player.lastTickPosY + (97.c.player.posY - 97.c.player.lastTickPosY) * (double)f6.floatValue();
        double d7 = 97.c.player.lastTickPosZ + (97.c.player.posZ - 97.c.player.lastTickPosZ) * (double)f6.floatValue();
        Vec3d vec3d2 = vec3d.add(-d5, -d6, -d7);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d3, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y + d3, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y + d3, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d3, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d3, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d3, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y + d3, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y, vec3d2.z + d4).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y + d3, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d2, vec3d2.y, vec3d2.z).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        tessellator.draw();
    }

    public static void c(AxisAlignedBB axisAlignedBB, Float f2, Float f3, Float f4, Float f5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2.floatValue(), f3.floatValue(), f4.floatValue(), 0.0f).endVertex();
        tessellator.draw();
    }

    public static void c(Entity entity, int n2, Float f2) {
        float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n2 & 0xFF) / 255.0f;
        float f6 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean)false);
        if (entity != 97.c.player) {
            double d2 = 97.c.player.lastTickPosX + (97.c.player.posX - 97.c.player.lastTickPosX) * (double)f2.floatValue();
            double d3 = 97.c.player.lastTickPosY + (97.c.player.posY - 97.c.player.lastTickPosY) * (double)f2.floatValue();
            double d4 = 97.c.player.lastTickPosZ + (97.c.player.posZ - 97.c.player.lastTickPosZ) * (double)f2.floatValue();
            97.c(entity.getEntityBoundingBox().offset(-d2, -d3, -d4), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6));
        }
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void 0() {
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)10.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.resetColor();
    }

    public static void c(AxisAlignedBB axisAlignedBB, int n2, int n3) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(n2, DefaultVertexFormats.POSITION_COLOR);
        float f2 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n3 & 0xFF) / 255.0f;
        float f5 = (float)(n3 >> 24 & 0xFF) / 255.0f;
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
}

