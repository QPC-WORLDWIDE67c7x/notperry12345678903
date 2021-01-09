/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 90 {
    public static void c(float[] fArray, Color color, boolean bl) {
        90.c();
        if (bl) {
            GL11.glEnable((int)2848);
        } else {
            GL11.glDisable((int)2848);
        }
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        GL11.glBegin((int)9);
        for (int i2 = 0; i2 < fArray.length; i2 += 2) {
            GL11.glVertex2f((float)fArray[i2], (float)fArray[i2 + 1]);
        }
        GL11.glEnd();
        90.0();
    }

    public static void c(float f2, float f3, float f4, float f5, float f6, Color color, boolean bl) {
        90.c(new float[]{f2, f3, f4, f3, f4, f3, f4, f5, f2, f5, f4, f5, f2, f3, f2, f5}, f6, color, bl);
    }

    public static void c(String string, int n2, int n3, Color color) {
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        Minecraft.getMinecraft().fontRenderer.drawString(string, n2, n3, 0);
    }

    public static void 0() {
        GL11.glEnable((int)3553);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void c(float f2, float f3, float f4, int n2, int n3, float f5, Color color, boolean bl) {
        90.c();
        if (n2 > n3) {
            int n4 = n2;
            n2 = n3;
            n3 = n4;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > 360) {
            n3 = 360;
        }
        if (bl) {
            GL11.glEnable((int)2848);
        } else {
            GL11.glDisable((int)2848);
        }
        GL11.glLineWidth((float)f5);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        GL11.glBegin((int)3);
        float f6 = 0.01745328f;
        for (int i2 = n2; i2 <= n3; ++i2) {
            float f7 = (float)(i2 - 90) * f6;
            GL11.glVertex2f((float)(f2 + (float)Math.cos(f7) * f4), (float)(f3 + (float)Math.sin(f7) * f4));
        }
        GL11.glEnd();
        90.0();
    }

    public static void 0(float f2, float f3, float f4, float f5, float f6, Color color, boolean bl) {
        90.c(new float[]{f2, f3, f4, f5}, f6, color, bl);
    }

    public static void c(float[] fArray, float f2, Color color, boolean bl) {
        90.c();
        if (bl) {
            GL11.glEnable((int)2848);
        } else {
            GL11.glDisable((int)2848);
        }
        GL11.glLineWidth((float)f2);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        GL11.glBegin((int)1);
        for (int i2 = 0; i2 < fArray.length; i2 += 2) {
            GL11.glVertex2f((float)fArray[i2], (float)fArray[i2 + 1]);
        }
        GL11.glEnd();
        90.0();
    }

    public static void c(float f2, float f3, float f4, float f5, Color color, boolean bl) {
        90.c(new float[]{f2, f3, f2, f5, f4, f5, f4, f3}, color, bl);
    }

    public static void c() {
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
    }
}

