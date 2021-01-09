/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.3p_0;
import me.darki.konas.3t_0;
import me.darki.konas.9d;
import me.darki.konas.i_0;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

/*
 * Renamed from me.darki.konas.3s
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3s_0 {
    public static 9d c = new 9d(i_0.2, 16.0f);
    public static 9d 0 = new 9d(i_0.2, 18.0f);

    public static void c(3t_0 t_02, 3p_0 p_02, float f2) {
        Vector2f[] vector2fArray = t_02.7();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GlStateManager.glLineWidth((float)f2);
        GL11.glEnable((int)2848);
        bufferBuilder.begin(t_02.3() ? 2 : 3, DefaultVertexFormats.POSITION_COLOR);
        for (Vector2f vector2f : vector2fArray) {
            Color color = p_02.c(t_02, vector2f.x, vector2f.y);
            bufferBuilder.pos((double)vector2f.x, (double)vector2f.y, 0.0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        }
        tessellator.draw();
        GL11.glDisable((int)2848);
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.shadeModel((int)7424);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void c(3t_0 t_02, 3p_0 p_02) {
        Vector2f[] vector2fArray = t_02.7();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        bufferBuilder.begin(9, DefaultVertexFormats.POSITION_COLOR);
        for (Vector2f vector2f : vector2fArray) {
            Color color = p_02.c(t_02, vector2f.x, vector2f.y);
            bufferBuilder.pos((double)vector2f.x, (double)vector2f.y, 0.0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        }
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}

