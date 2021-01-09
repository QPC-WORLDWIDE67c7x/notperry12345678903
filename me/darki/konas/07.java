/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 07 {
    public static 07 c = new 07();
    public Block c;
    public BlockPos c;
    public AxisAlignedBB c;
    public List<AxisAlignedBB> c;
    public Entity c;

    public void c(AxisAlignedBB axisAlignedBB) {
        this.c = axisAlignedBB;
    }

    public static 07 c(Block block, BlockPos blockPos, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, Entity entity) {
        07.c.c = block;
        07.c.c = blockPos;
        07.c.c = axisAlignedBB;
        07.c.c = list;
        07.c.c = entity;
        return c;
    }

    public List<AxisAlignedBB> c() {
        return this.c;
    }

    public AxisAlignedBB 3() {
        return this.c;
    }

    public Entity 0() {
        return this.c;
    }

    public BlockPos 2() {
        return this.c;
    }

    public Block 1() {
        return this.c;
    }
}

