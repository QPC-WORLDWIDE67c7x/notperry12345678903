/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.HashMap;
import net.minecraft.util.EnumFacing;

public class 93 {
    public static HashMap<EnumFacing, Integer> c = new HashMap();

    static {
        c.put(EnumFacing.DOWN, 1);
        c.put(EnumFacing.WEST, 16);
        c.put(EnumFacing.NORTH, 4);
        c.put(EnumFacing.SOUTH, 8);
        c.put(EnumFacing.EAST, 32);
        c.put(EnumFacing.UP, 2);
    }
}

