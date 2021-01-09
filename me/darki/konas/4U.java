/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.4V;

public class 4U {
    public static int[] c = new int[4V.values().length];

    static {
        try {
            4U.c[4V.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4U.c[4V.2.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4U.c[4V.0.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4U.c[4V.1.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

