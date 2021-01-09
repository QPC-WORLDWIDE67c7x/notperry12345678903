/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.6G;

public class 6F {
    public static int[] c = new int[6G.values().length];

    static {
        try {
            6F.c[6G.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            6F.c[6G.0.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

