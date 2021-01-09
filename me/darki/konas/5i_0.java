/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.util.EnumFacing;

/*
 * Renamed from me.darki.konas.5i
 */
public class 5i_0 {
    public static int[] c = new int[EnumFacing.values().length];

    static {
        try {
            5i_0.c[EnumFacing.EAST.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5i_0.c[EnumFacing.NORTH.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5i_0.c[EnumFacing.WEST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            5i_0.c[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

