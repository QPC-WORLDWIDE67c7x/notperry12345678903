/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraftforge.client.event.RenderBlockOverlayEvent;

public class 7L {
    public static int[] c = new int[RenderBlockOverlayEvent.OverlayType.values().length];

    static {
        try {
            7L.c[RenderBlockOverlayEvent.OverlayType.FIRE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7L.c[RenderBlockOverlayEvent.OverlayType.WATER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            7L.c[RenderBlockOverlayEvent.OverlayType.BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

