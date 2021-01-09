/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import me.darki.konas.8U;
import me.darki.konas.8W;
import me.darki.konas.8Y;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8V
implements 8U {
    public static int c;
    public static int 0;
    public static int 1;
    public Minecraft c;
    public 8W c;
    public 8W 0;
    public BlockPos c;
    public HashMap<8W, Float> c;
    public HashMap<8W, 8W> 0;
    public 8Y c;
    public ArrayList<8W> c;
    public int 2 = 0;
    public String c = (int)new HashMap();

    public boolean 4(BlockPos blockPos) {
        Block block = this.c.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockLadder) && !(block instanceof BlockVine)) {
            return false;
        }
        BlockPos blockPos2 = blockPos.up();
        return this.c(blockPos.north()) || this.c(blockPos.east()) || this.c(blockPos.south()) || this.c(blockPos.west()) || this.c(blockPos2.north()) || this.c(blockPos2.east()) || this.c(blockPos2.south()) || this.c(blockPos2.west());
    }

    public float 2(BlockPos blockPos) {
        float f2 = Math.abs(blockPos.getX() - ~this.c.getX() + 1);
        float f3 = Math.abs(blockPos.getY() - this.c.getY());
        float f4 = Math.abs(blockPos.getZ() - this.c.getZ());
        return 1.001f * (f2 + f3 + f4 - 0.58578646f * Math.min(f2, f4));
    }

    public boolean 3(BlockPos blockPos) {
        if (!this.c.world.isBlockLoaded(blockPos)) {
            return false;
        }
        Material material = this.c.world.getBlockState(blockPos).getMaterial();
        Block block = this.c.world.getBlockState(blockPos).getBlock();
        if (material.blocksMovement() && !(block instanceof BlockSign)) {
            return false;
        }
        if (block instanceof BlockTripWire || block instanceof BlockPressurePlate) {
            return false;
        }
        return material != Material.LAVA && material != Material.FIRE;
    }

    public float c(BlockPos blockPos, BlockPos blockPos2) {
        float[] fArray = new float[]{0.5f, 0.5f};
        BlockPos[] blockPosArray = new BlockPos[]{blockPos, blockPos2};
        for (int i2 = 0; i2 < blockPosArray.length; ++i2) {
            Material material = this.c.world.getBlockState(blockPosArray[i2]).getMaterial();
            if (material == Material.WATER) {
                int n2 = i2;
                fArray[n2] = fArray[n2] * 1.3164438f;
            } else if (material == Material.LAVA) {
                int n3 = i2;
                fArray[n3] = fArray[n3] * 4.5395155f;
            }
            if (!(this.c.world.getBlockState(blockPosArray[i2].down()).getBlock() instanceof BlockSoulSand)) continue;
            int n4 = i2;
            fArray[n4] = fArray[n4] * 2.5f;
        }
        float f2 = fArray[0] + fArray[1];
        if (blockPos.getX() != blockPos2.getX()) {
            if (blockPos.getZ() != blockPos2.getZ()) {
                f2 *= 1.4142135f;
            }
        }
        return f2;
    }

    public BlockPos c() {
        return this.c;
    }

    public boolean 5(BlockPos blockPos) {
        Material material = this.c.world.getBlockState(blockPos).getMaterial();
        if (!this.c(blockPos)) {
            return false;
        }
        return material != Material.CACTUS && material != Material.LAVA;
    }

    @Override
    public String c() {
        return this.c;
    }

    public boolean 1(BlockPos blockPos) {
        Block block = this.c.world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockFence) && !(block instanceof BlockWall) && !(block instanceof BlockFenceGate);
    }

    public ArrayList<8W> 2() {
        this.c = new 8W(new BlockPos(this.c.player.posX, this.c.player.onGround ? this.c.player.posY + 0.5 : this.c.player.posY, this.c.player.posZ));
        this.c.clear();
        this.0.clear();
        this.c.1();
        this.c.put(this.c, Float.valueOf(0.0f));
        this.c.c(this.c, this.2(this.c));
        for (int i2 = 0; i2 < 100000; ++i2) {
            ++this.2;
            if (this.c.0().isEmpty()) continue;
            this.0 = this.c.c();
            if (this.c.equals((Object)this.0)) {
                this.1();
                return this.c;
            }
            if (Math.abs(this.c.getX() - this.0.getX()) > 200 || Math.abs(this.c.getZ() - this.0.getZ()) > 200) {
                this.1();
                return this.c;
            }
            for (8W w : this.c(this.0)) {
                float f2 = ((Float)this.c.get((Object)this.0)).floatValue() + this.c(this.0, w);
                if (this.c.containsKey((Object)w) && ((Float)this.c.get((Object)w)).floatValue() <= f2) continue;
                this.c.put(w, Float.valueOf(f2));
                this.0.put(w, this.0);
                this.c.c(w, f2 + this.2(w));
            }
        }
        this.1();
        return this.c;
    }

    public boolean 0(8W w) {
        for (int i2 = 0; i2 <= 5; ++i2) {
            if (!this.5(w.down(i2))) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c(BlockPos blockPos, EnumFacing enumFacing, EnumFacing enumFacing2) {
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        BlockPos blockPos3 = blockPos.offset(enumFacing2);
        BlockPos blockPos4 = blockPos2.offset(enumFacing2);
        if (!this.0(blockPos2)) return false;
        if (!this.0(blockPos3)) return false;
        if (!this.0(blockPos, blockPos4)) return false;
        return true;
    }

    public ArrayList<8W> c(8W w) {
        ArrayList<8W> arrayList = new ArrayList<8W>();
        if (Math.abs(this.c.getX() - w.getX()) > 200 || Math.abs(this.c.getZ() - w.getZ()) > 200) {
            return arrayList;
        }
        BlockPos blockPos = w.north();
        BlockPos blockPos2 = w.east();
        BlockPos blockPos3 = w.south();
        BlockPos blockPos4 = w.west();
        BlockPos blockPos5 = blockPos.east();
        BlockPos blockPos6 = blockPos3.east();
        BlockPos blockPos7 = blockPos3.west();
        BlockPos blockPos8 = blockPos.west();
        BlockPos blockPos9 = w.up();
        BlockPos blockPos10 = w.down();
        boolean bl = this.c(blockPos10);
        if (bl || w.c()) {
            if (this.0(w, blockPos)) {
                arrayList.add(new 8W(blockPos));
            }
            if (this.0(w, blockPos2)) {
                arrayList.add(new 8W(blockPos2));
            }
            if (this.0(w, blockPos3)) {
                arrayList.add(new 8W(blockPos3));
            }
            if (this.0(w, blockPos4)) {
                arrayList.add(new 8W(blockPos4));
            }
            if (this.c(w, EnumFacing.NORTH, EnumFacing.EAST)) {
                arrayList.add(new 8W(blockPos5));
            }
            if (this.c(w, EnumFacing.SOUTH, EnumFacing.EAST)) {
                arrayList.add(new 8W(blockPos6));
            }
            if (this.c(w, EnumFacing.SOUTH, EnumFacing.WEST)) {
                arrayList.add(new 8W(blockPos7));
            }
            if (this.c(w, EnumFacing.NORTH, EnumFacing.WEST)) {
                arrayList.add(new 8W(blockPos8));
            }
        }
        if (w.getY() < 256 && this.3(blockPos9.up()) && (bl || this.4(w)) && (this.4(w) || this.c.equals((Object)blockPos9) || this.5(blockPos) || this.5(blockPos2) || this.5(blockPos3) || this.5(blockPos4))) {
            arrayList.add(new 8W(blockPos9, bl));
        }
        if (w.getY() > 0 && this.3(blockPos10) && this.1(blockPos10.down()) && this.0(w)) {
            arrayList.add(new 8W(blockPos10));
        }
        return arrayList;
    }

    public 8V(BlockPos blockPos, String string) {
        this.0 = (int)new HashMap();
        this.c = new 8Y();
        this.c = (int)new ArrayList();
        this.c = new 8W(new BlockPos(this.c.player.posX, this.c.player.onGround ? this.c.player.posY + 0.5 : this.c.player.posY, this.c.player.posZ));
        this.c = blockPos;
        this.c.put(this.c, Float.valueOf(0.0f));
        this.c.c(this.c, this.2(this.c));
        this.c = string;
    }

    static {
        1 = 5;
        0 = 200;
        c = 100000;
    }

    public boolean 0(BlockPos blockPos) {
        return this.3(blockPos) && this.3(blockPos.up()) && this.1(blockPos.down());
    }

    public void 1() {
        this.c.clear();
        8W w = this.c;
        for (8W w2 : this.0.keySet()) {
            if (!(this.2(w2) < this.2(w))) continue;
            w = w2;
        }
        while (w != null) {
            this.c.add(w);
            w = (8W)((Object)this.0.get((Object)w));
        }
        Collections.reverse(this.c);
    }

    public boolean c(BlockPos blockPos) {
        Material material = this.c.world.getBlockState(blockPos).getMaterial();
        Block block = this.c.world.getBlockState(blockPos).getBlock();
        return material.blocksMovement() && !(block instanceof BlockSign) || block instanceof BlockLadder;
    }

    public boolean 0(BlockPos blockPos, BlockPos blockPos2) {
        return this.0(blockPos2) && (this.3(blockPos2.down()) || this.5(blockPos2.down()));
    }

    public ArrayList<8W> 0() {
        return this.c;
    }
}

