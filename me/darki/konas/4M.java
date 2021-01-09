/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.4N;

public class 4M {
    public static int[] c = new int[4N.values().length];

    static {
        try {
            4M.c[4N.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4M.c[4N.0.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

