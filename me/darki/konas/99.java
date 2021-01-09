/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.89;
import me.darki.konas.98;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 99 {
    public static Minecraft c = Minecraft.getMinecraft();

    public static void c(double d2, double d3, double d4, double d5, double d6, double d7, 89 var12_6, int n2, int n3) {
        GlStateManager.disableAlpha();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        var12_6.c();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        99.c(new AxisAlignedBB(d2, d3, d4, d2 + d5, d3 + d6, d4 + d7), var12_6, n2, bufferBuilder, n3, false);
        tessellator.draw();
        GlStateManager.enableAlpha();
    }

    public static void c(double d2, double d3, double d4, double d5, double d6, double d7, 89 var12_6, float f2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float)f2);
        var12_6.c();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        99.c(d2, d3, d4, bufferBuilder);
        99.c(d5, d6, d7, bufferBuilder);
        tessellator.draw();
    }

    public static void c(BlockPos blockPos, int n2, 89 var2_2, int n3, int n4) {
        99.c(99.c(blockPos, 1.0, 1.0, 1.0), n2, var2_2, n3, n4);
    }

    public static void 0(AxisAlignedBB axisAlignedBB, double d2, 89 var3_2, int n2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float)((float)d2));
        var3_2.c();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, var3_2, n2, bufferBuilder);
        99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var3_2, n2, bufferBuilder);
        99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var3_2, n2, bufferBuilder);
        99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var3_2, n2, bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var3_2, n2, bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, var3_2, n2, bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, var3_2, var3_2.1(), bufferBuilder);
        99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, var3_2, n2, bufferBuilder);
        99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, var3_2, n2, bufferBuilder);
        tessellator.draw();
    }

    public static void c(AxisAlignedBB axisAlignedBB, boolean bl, double d2, 89 var4_3, int n2) {
        99.c(axisAlignedBB, bl, d2, var4_3, var4_3.1(), n2);
    }

    public static void c(double d2, double d3, double d4, 89 var6_3, int n2, BufferBuilder bufferBuilder) {
        bufferBuilder.pos(d2 - 99.c.getRenderManager().viewerPosX, d3 - 99.c.getRenderManager().viewerPosY, d4 - 99.c.getRenderManager().viewerPosZ).color(var6_3.6(), var6_3.5(), var6_3.2(), n2).endVertex();
    }

    public static void c(double d2, double d3, double d4, double d5, double d6, double d7, 89 var12_6) {
        99.c(d2, d3, d4, d5, d6, d7, var12_6, 1.0f);
    }

    public static void c(AxisAlignedBB axisAlignedBB, double d2, 89 var3_2) {
        99.0(axisAlignedBB, d2, var3_2, var3_2.1());
    }

    public static void c(double d2, double d3, double d4, BufferBuilder bufferBuilder) {
        bufferBuilder.pos(d2 - 99.c.getRenderManager().viewerPosX, d3 - 99.c.getRenderManager().viewerPosY, d4 - 99.c.getRenderManager().viewerPosZ).endVertex();
    }

    public static void c(AxisAlignedBB axisAlignedBB, double d2, 89 var3_2, int n2) {
        99.c(axisAlignedBB, false, d2, var3_2, var3_2.1(), n2);
    }

    public static void c(AxisAlignedBB axisAlignedBB, int n2, 89 var2_2, int n3, int n4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float)n2);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        99.c(axisAlignedBB, var2_2, n3, bufferBuilder, n4, true);
        tessellator.draw();
    }

    public static void c(98 var0, 89 var1_1, float f2) {
        int n2;
        for (n2 = 0; n2 < 4; ++n2) {
            99.c(var0.c(n2)[0], var0.1, var0.c(n2)[1], var0.c((n2 + 1) % 4)[0], var0.1, var0.c((n2 + 1) % 4)[1], var1_1, f2);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            99.c(var0.c(n2)[0], var0.2, var0.c(n2)[1], var0.c((n2 + 1) % 4)[0], var0.2, var0.c((n2 + 1) % 4)[1], var1_1, f2);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            99.c(var0.c(n2)[0], var0.1, var0.c(n2)[1], var0.c(n2)[0], var0.2, var0.c(n2)[1], var1_1, f2);
        }
    }

    public static void c(AxisAlignedBB axisAlignedBB, 89 var1_1) {
        99.c(axisAlignedBB, true, 1.0, var1_1, var1_1.1(), 63);
    }

    public static void c(AxisAlignedBB axisAlignedBB, int n2, 89 var2_2, int n3) {
        99.c(axisAlignedBB, n2, var2_2, var2_2.1(), n3);
    }

    public static void c(AxisAlignedBB axisAlignedBB, boolean bl, double d2, 89 var4_3, int n2, int n3) {
        if (bl) {
            99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, axisAlignedBB.maxY - axisAlignedBB.minY, axisAlignedBB.maxZ - axisAlignedBB.minZ, var4_3, n2, n3);
        } else {
            99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, d2, axisAlignedBB.maxZ - axisAlignedBB.minZ, var4_3, n2, n3);
        }
    }

    public static void c(BlockPos blockPos, double d2, 89 var3_2, int n2) {
        99.c(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0, d2, 1.0, var3_2, var3_2.1(), n2);
    }

    public static void c(AxisAlignedBB axisAlignedBB, 89 var1_1, int n2, BufferBuilder bufferBuilder, int n3, boolean bl) {
        block11: {
            if ((n3 & 0x20) != 0) {
                99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, var1_1, n2, bufferBuilder);
                99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var1_1, n2, bufferBuilder);
                if (bl) {
                    99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
                }
            }
            if ((n3 & 0x10) != 0) {
                99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var1_1, n2, bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, var1_1, n2, bufferBuilder);
                if (bl) {
                    99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
                }
            }
            if ((n3 & 4) != 0) {
                99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, var1_1, n2, bufferBuilder);
                99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, var1_1, n2, bufferBuilder);
                if (bl) {
                    99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
                }
            }
            if ((n3 & 8) != 0) {
                99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
                99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var1_1, n2, bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var1_1, n2, bufferBuilder);
                if (bl) {
                    99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
                }
            }
            if ((n3 & 2) != 0) {
                99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, var1_1, n2, bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, var1_1, n2, bufferBuilder);
                99.c(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var1_1, n2, bufferBuilder);
                99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, var1_1, n2, bufferBuilder);
                if (bl) {
                    99.c(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, var1_1, n2, bufferBuilder);
                }
            }
            if ((n3 & 1) == 0) break block11;
            99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
            99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
            99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, var1_1, var1_1.1(), bufferBuilder);
            99.c(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
            if (bl) {
                99.c(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, var1_1, var1_1.1(), bufferBuilder);
            }
        }
    }

    public static AxisAlignedBB c(BlockPos blockPos, double d2, double d3, double d4) {
        double d5 = blockPos.getX();
        double d6 = blockPos.getY();
        double d7 = blockPos.getZ();
        return new AxisAlignedBB(d5, d6, d7, d5 + d2, d6 + d3, d7 + d4);
    }

    public static void 0() {
        GL11.glDisable((int)34383);
        GL11.glDisable((int)2848);
        GlStateManager.enableAlpha();
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.shadeModel((int)7424);
        GL11.glHint((int)3154, (int)4352);
        GL11.glPopAttrib();
    }

    public static void c() {
        GL11.glPushAttrib((int)1048575);
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.shadeModel((int)7425);
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GL11.glEnable((int)2848);
        GL11.glEnable((int)34383);
    }

    public static void c(BlockPos blockPos, double d2, float f2, 89 var4_3) {
        99.0(99.c(blockPos, 1.0, d2, 1.0), f2, var4_3, var4_3.1());
    }

    public static void c(BlockPos blockPos, int n2, 89 var2_2, int n3) {
        99.c(99.c(blockPos, 1.0, 1.0, 1.0), n2, var2_2, var2_2.1(), n3);
    }
}

