/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.5Q;

public class 5O {
    public static int[] c = new int[5Q.values().length];

    static {
        try {
            5O.c[5Q.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5O.c[5Q.0.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

