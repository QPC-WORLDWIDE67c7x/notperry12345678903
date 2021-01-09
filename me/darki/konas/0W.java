/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.01;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 0W
extends 01 {
    public EntityPlayer c;
    public World c;
    public BlockPos c;
    public EnumFacing c;
    public float c;
    public float 0;
    public float 1;

    public World 0() {
        return this.c;
    }

    public BlockPos c() {
        return this.c;
    }

    public EnumFacing 4() {
        return this.c;
    }

    public float 3() {
        return this.0;
    }

    public EntityPlayer 2() {
        return this.c;
    }

    public float 1() {
        return this.1;
    }

    public 0W(EntityPlayer entityPlayer, World world, BlockPos blockPos, EnumFacing enumFacing, float f2, float f3, float f4) {
        this.c = entityPlayer;
        this.c = world;
        this.c = blockPos;
        this.c = enumFacing;
        this.c = f2;
        this.0 = f3;
        this.1 = f4;
    }

    public float 5() {
        return this.c;
    }
}

