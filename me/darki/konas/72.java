/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.util.EnumHand;

public class 72 {
    public static int[] c = new int[EnumHand.values().length];

    static {
        try {
            72.c[EnumHand.MAIN_HAND.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            72.c[EnumHand.OFF_HAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

