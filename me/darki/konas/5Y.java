/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.5Z;

public class 5Y {
    public static int[] c = new int[5Z.values().length];

    static {
        try {
            5Y.c[5Z.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5Y.c[5Z.0.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

