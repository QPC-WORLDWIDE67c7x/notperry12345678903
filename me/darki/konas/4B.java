/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.4D;
import net.minecraft.util.EnumFacing;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4B {
    public static int[] c;
    public static int[] 0;

    static {
        0 = new int[EnumFacing.values().length];
        try {
            4B.0[EnumFacing.NORTH.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4B.0[EnumFacing.SOUTH.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4B.0[EnumFacing.EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4B.0[EnumFacing.WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        c = new int[4D.values().length];
        try {
            4B.c[4D.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4B.c[4D.0.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4B.c[4D.1.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            4B.c[4D.2.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

