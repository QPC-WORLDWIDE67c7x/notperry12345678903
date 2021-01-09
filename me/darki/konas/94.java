/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class 94 {
    public static void c(float f2, float f3, float f4, float f5, float f6, int n2) {
        float f7 = f2 + f4;
        float f8 = f3 + f5;
        float f9 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f10 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f11 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f12 = (float)(n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)f10, (float)f11, (float)f12, (float)f9);
        GL11.glEnable((int)2848);
        GlStateManager.glLineWidth((float)f6);
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)f2, (double)f8, 0.0).endVertex();
        bufferBuilder.pos((double)f7, (double)f8, 0.0).endVertex();
        bufferBuilder.pos((double)f7, (double)f8, 0.0).endVertex();
        bufferBuilder.pos((double)f7, (double)f3, 0.0).endVertex();
        bufferBuilder.pos((double)f7, (double)f3, 0.0).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).endVertex();
        bufferBuilder.pos((double)f2, (double)f8, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void c(float f2, float f3, float f4, float f5, int n2, int n3) {
        94.c(f2, f3, f4, f5, n3);
        94.c(f2, f3, f4, f5, 1.0f, n2);
    }

    public static void c(float f2, float f3, float f4, float f5, int n2) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        float f8 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f9 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f10 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f11 = (float)(n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)f9, (float)f10, (float)f11, (float)f8);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)f2, (double)f7, 0.0).endVertex();
        bufferBuilder.pos((double)f6, (double)f7, 0.0).endVertex();
        bufferBuilder.pos((double)f6, (double)f3, 0.0).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void c(ScaledResolution scaledResolution, float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        int n2 = scaledResolution.getScaleFactor();
        GL11.glScissor((int)((int)(f2 * (float)n2)), (int)((int)(((float)scaledResolution.getScaledHeight() - f7) * (float)n2)), (int)((int)((f6 - f2) * (float)n2)), (int)((int)((f7 - f3) * (float)n2)));
    }
}

