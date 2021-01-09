/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3E;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 55 {
    public BlockPos c;
    public EnumFacing c;
    public IBlockState c;

    public EnumFacing c() {
        return this.c;
    }

    public IBlockState 0() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        55 var2_2 = (55)object;
        return this.c.equals((Object)var2_2.c);
    }

    public BlockPos 1() {
        return this.c;
    }

    public 55(BlockPos blockPos, EnumFacing enumFacing) {
        this.c = blockPos;
        this.c = enumFacing;
        this.c = 3E.c.world.getBlockState(blockPos);
    }
}

