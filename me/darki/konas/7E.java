/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.7F;

public class 7E {
    public static int[] c = new int[7F.values().length];

    static {
        try {
            7E.c[7F.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7E.c[7F.0.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7E.c[7F.1.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

