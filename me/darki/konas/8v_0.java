/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.util.math.MathHelper;

/*
 * Renamed from me.darki.konas.8v
 */
public class 8v_0 {
    public static float c(float f2, float f3, float f4, float f5) {
        if (f5 <= 0.0f) {
            return f3;
        }
        float f6 = f3 - f2;
        if (Math.pow(f6, 2.0) < 20.0) {
            return f3;
        }
        float f7 = f6 * MathHelper.clamp((float)(f4 * f5), (float)0.0f, (float)1.0f);
        return f2 + f7;
    }
}

