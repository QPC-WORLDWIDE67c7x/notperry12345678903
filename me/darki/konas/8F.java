/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import me.darki.konas.8E;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class 8F {
    public static Minecraft c = Minecraft.getMinecraft();

    public static boolean c(Entity entity) {
        BlockPos blockPos = new BlockPos(entity);
        return !8F.c(blockPos).isEmpty();
    }

    public static ArrayList<BlockPos> c(BlockPos blockPos) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        if (!(8F.c.world.getBlockState(blockPos).getBlock() instanceof BlockAir)) {
            return arrayList;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            if (8F.c.world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockAir) {
                return new ArrayList<BlockPos>();
            }
            if (!(8F.c.world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockObsidian)) continue;
            if (8E.0(blockPos.offset(enumFacing, 2).down()) && 8F.c.world.getBlockState(blockPos.offset(enumFacing)).getBlock() != Blocks.AIR) {
                arrayList.add(blockPos.offset(enumFacing));
                continue;
            }
            if (!8E.0(blockPos.offset(enumFacing)) || 8F.c.world.getBlockState(blockPos.offset(enumFacing)).getBlock() == Blocks.AIR || 8F.c.world.getBlockState(blockPos.offset(enumFacing).down()).getBlock() != Blocks.BEDROCK && 8F.c.world.getBlockState(blockPos.offset(enumFacing).down()).getBlock() != Blocks.OBSIDIAN) continue;
            arrayList.add(blockPos.offset(enumFacing));
        }
        return arrayList;
    }
}

