/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.util.EnumFacing;

/*
 * Renamed from me.darki.konas.7e
 */
public class 7e_0 {
    public static int[] c = new int[EnumFacing.values().length];

    static {
        try {
            7e_0.c[EnumFacing.DOWN.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7e_0.c[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7e_0.c[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7e_0.c[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7e_0.c[EnumFacing.EAST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7e_0.c[EnumFacing.WEST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

