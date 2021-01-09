/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.util.EnumFacing;

/*
 * Renamed from me.darki.konas.4l
 */
public class 4l_0 {
    public static int[] c = new int[EnumFacing.values().length];

    static {
        try {
            4l_0.c[EnumFacing.DOWN.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4l_0.c[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4l_0.c[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4l_0.c[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4l_0.c[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

