/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3Z;

public class 3Y {
    public static int[] c = new int[3Z.values().length];

    static {
        try {
            3Y.c[3Z.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            3Y.c[3Z.0.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            3Y.c[3Z.1.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

