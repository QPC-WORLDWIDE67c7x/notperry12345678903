/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;

public class 9c {
    public static int c(int n2, float[] fArray, float f2, float f3, float f4) {
        double d2 = Math.sin((double)f2 * ((double)System.currentTimeMillis() / Math.pow(10.0, 2.0) * (double)(f3 / 10.0f) + (double)n2));
        return Color.getHSBColor(fArray[0], fArray[1], (float)(((d2 *= (double)f4) + 1.0) / 2.0) + (1.0f - f4) * 0.5f).getRGB();
    }

    public static float[] c(int n2) {
        float f2 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n2 & 0xFF) / 255.0f;
        return new float[]{f3, f4, f5, f2};
    }

    public static int c(int n2, float[] fArray) {
        double d2 = Math.ceil((double)(System.currentTimeMillis() + (long)n2) / 20.0);
        return Color.getHSBColor((float)((d2 %= 360.0) / 360.0), fArray[1], fArray[2]).getRGB();
    }
}

