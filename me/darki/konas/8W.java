/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class 8W
extends BlockPos {
    public boolean c;

    public 8W(BlockPos blockPos, boolean bl) {
        super((Vec3i)blockPos);
        this.c = bl;
    }

    public 8W(BlockPos blockPos) {
        super((Vec3i)blockPos);
        this.c = false;
    }

    public boolean c() {
        return this.c;
    }
}

