/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.util.EnumFacing;

public class 5M {
    public static int[] c = new int[EnumFacing.values().length];

    static {
        try {
            5M.c[EnumFacing.SOUTH.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5M.c[EnumFacing.WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5M.c[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5M.c[EnumFacing.EAST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

