/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.List;
import me.darki.konas.01;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class V
extends 01 {
    public static V c = new V();
    public Block c;
    public IBlockState c;
    public World c;
    public BlockPos c;
    public AxisAlignedBB c;
    public List<AxisAlignedBB> c;
    public Entity c;
    public boolean c;

    public BlockPos 4() {
        return this.c;
    }

    public boolean 5() {
        return this.c;
    }

    public World c() {
        return this.c;
    }

    public static V c(Block block, IBlockState iBlockState, World world, BlockPos blockPos, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, Entity entity, boolean bl) {
        c.c(false);
        V.c.c = block;
        V.c.c = iBlockState;
        V.c.c = world;
        V.c.c = blockPos;
        V.c.c = axisAlignedBB;
        V.c.c = list;
        V.c.c = entity;
        V.c.c = bl;
        return c;
    }

    public void c(AxisAlignedBB axisAlignedBB) {
        this.c = axisAlignedBB;
    }

    public AxisAlignedBB 3() {
        return this.c;
    }

    public Entity 0() {
        return this.c;
    }

    public List<AxisAlignedBB> 1() {
        return this.c;
    }

    public Block 2() {
        return this.c;
    }

    public IBlockState 6() {
        return this.c;
    }
}

