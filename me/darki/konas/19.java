/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.01;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 19
extends 01 {
    public EntityPlayerSP c;
    public WorldClient c;
    public BlockPos c;
    public EnumFacing c;
    public Vec3d c;
    public EnumHand c;

    public 19(EntityPlayerSP entityPlayerSP, WorldClient worldClient, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, EnumHand enumHand) {
        this.c = entityPlayerSP;
        this.c = worldClient;
        this.c = blockPos;
        this.c = enumFacing;
        this.c = vec3d;
        this.c = enumHand;
    }

    public EnumFacing 1() {
        return this.c;
    }

    public BlockPos 4() {
        return this.c;
    }

    public Vec3d c() {
        return this.c;
    }

    public WorldClient 2() {
        return this.c;
    }

    public EntityPlayerSP 3() {
        return this.c;
    }

    public EnumHand 0() {
        return this.c;
    }
}

