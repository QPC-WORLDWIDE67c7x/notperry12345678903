/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.01;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 08
extends 01 {
    public static 08 c = new 08();
    public BlockPos c;
    public EnumFacing c;
    public int c;
    public float c;

    public void c(BlockPos blockPos) {
        this.c = blockPos;
    }

    public EnumFacing 0() {
        return this.c;
    }

    public float 1() {
        return this.c;
    }

    public void c(float f2) {
        this.c = f2;
    }

    public void c(EnumFacing enumFacing) {
        this.c = enumFacing;
    }

    public int c() {
        return this.c;
    }

    public static 08 c(BlockPos blockPos, EnumFacing enumFacing, int n2, float f2) {
        c.c(false);
        08.c.c = blockPos;
        08.c.c = enumFacing;
        08.c.c = n2;
        08.c.c = f2;
        return c;
    }

    public BlockPos 2() {
        return this.c;
    }

    public void c(int n2) {
        this.c = n2;
    }
}

