/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.01;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 0G
extends 01 {
    public EntityPlayer c;
    public BlockPos c;
    public EnumFacing c;
    public Vec3d c;

    public 0G(EntityPlayer entityPlayer, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d) {
        this.c = entityPlayer;
        this.c = blockPos;
        this.c = enumFacing;
        this.c = vec3d;
    }

    public Vec3d 0() {
        return this.c;
    }

    public BlockPos 2() {
        return this.c;
    }

    public EnumFacing 1() {
        return this.c;
    }

    public void c(Vec3d vec3d) {
        this.c = vec3d;
    }

    public void c(EnumFacing enumFacing) {
        this.c = enumFacing;
    }

    public EntityPlayer c() {
        return this.c;
    }

    public void c(BlockPos blockPos) {
        this.c = blockPos;
    }
}

