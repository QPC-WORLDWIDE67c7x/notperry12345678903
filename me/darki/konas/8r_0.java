/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import me.darki.konas.8q_0;
import me.darki.konas.8x_0;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8r
 */
public class 8r_0 {
    public static Minecraft c = Minecraft.getMinecraft();

    public static BlockPos 6(BlockPos blockPos) {
        if (!(8r_0.c.world.getBlockState(blockPos.down()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.down()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.west()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.west()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.south()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.south()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.north()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.north()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.up()).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.up(2)).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.east().down()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.east().down()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.east(2)).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.east(2)).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.east().south()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.east().south()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.east().north()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.east().north()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.east()).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.east().up()).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.east().up(2)).getMaterial() != Material.AIR)) {
            return 8r_0.3(blockPos) == null ? new BlockPos(1, 0, 0) : null;
        }
        if (!(8r_0.c.world.getBlockState(blockPos.down()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.down()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.west()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.west()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.east()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.east()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.north()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.north()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.up()).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.up(2)).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.south().down()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.south().down()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.south(2)).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.south(2)).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.south().east()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.south().east()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.south().west()).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.south().west()).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.south()).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.south().up()).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.south().up(2)).getMaterial() != Material.AIR)) {
            return 8r_0.3(blockPos) == null ? new BlockPos(0, 0, 1) : null;
        }
        return null;
    }

    public static void c(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl) {
        if (bl) {
            float f2 = (float)(vec3d.x - (double)blockPos.getX());
            float f3 = (float)(vec3d.y - (double)blockPos.getY());
            float f4 = (float)(vec3d.z - (double)blockPos.getZ());
            8r_0.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f2, f3, f4));
            8r_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(enumHand));
        } else {
            8r_0.c.playerController.processRightClickBlock(8r_0.c.player, 8r_0.c.world, blockPos, enumFacing, vec3d, enumHand);
            8r_0.c.player.swingArm(enumHand);
        }
    }

    public static Optional<8q_0> 0(BlockPos blockPos) {
        return 8r_0.c(blockPos, false, false);
    }

    public static Optional<8q_0> c(BlockPos blockPos, boolean bl) {
        return 8r_0.c(blockPos, bl, false);
    }

    public static double[] c(BlockPos blockPos, EnumFacing enumFacing, EntityPlayer entityPlayer) {
        return 8x_0.c((double)blockPos.getX() + 0.5 + (double)enumFacing.getDirectionVec().getX() * 0.5, (double)blockPos.getY() + 0.5 + (double)enumFacing.getDirectionVec().getY() * 0.5, (double)blockPos.getZ() + 0.5 + (double)enumFacing.getDirectionVec().getZ() * 0.5, entityPlayer);
    }

    public static BlockPos c(Vec3d vec3d) {
        return new BlockPos(vec3d);
    }

    public static boolean 5(BlockPos blockPos) {
        return 8r_0.c.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.add(0, 1, 0)).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.add(0, 2, 0)).getMaterial() == Material.AIR;
    }

    public static boolean c(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (8r_0.c.world.getBlockState(blockPos2).getMaterial().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static List<BlockPos> c(BlockPos blockPos, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        for (int i2 = n3 - n2; i2 <= n3 + n2; ++i2) {
            for (int i3 = n5 - n2; i3 <= n5 + n2; ++i3) {
                for (int i4 = n4 - n2; i4 < n4 + n2; ++i4) {
                    double d2 = (n3 - i2) * (n3 - i2) + (n5 - i3) * (n5 - i3) + (n4 - i4) * (n4 - i4);
                    if (!(d2 < (double)(n2 * n2))) continue;
                    arrayList.add(new BlockPos(i2, i4, i3));
                }
            }
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean 7(BlockPos blockPos) {
        Block block = 8r_0.c.world.getBlockState(blockPos).getBlock();
        TileEntity tileEntity = null;
        for (TileEntity tileEntity2 : 8r_0.c.world.loadedTileEntityList) {
            if (!tileEntity2.getPos().equals((Object)blockPos)) continue;
            tileEntity = tileEntity2;
            break;
        }
        if (tileEntity != null) return true;
        if (block instanceof BlockBed) return true;
        if (block instanceof BlockContainer) return true;
        if (block instanceof BlockDoor) return true;
        if (block instanceof BlockTrapDoor) return true;
        if (block instanceof BlockFenceGate) return true;
        if (block instanceof BlockButton) return true;
        if (block instanceof BlockAnvil) return true;
        if (block instanceof BlockWorkbench) return true;
        if (block instanceof BlockCake) return true;
        if (!(block instanceof BlockRedstoneDiode)) return false;
        return true;
    }

    public static Vec3d 2(BlockPos blockPos) {
        return new Vec3d((Vec3i)blockPos);
    }

    public static Optional<8q_0> c(BlockPos blockPos, boolean bl, boolean bl2) {
        return 8r_0.c(blockPos, bl, false, false);
    }

    public static BlockPos 3(BlockPos blockPos) {
        if (8r_0.c.world.getBlockState(blockPos.down()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.west()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.south()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.north()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.up()).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.up(2)).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.east().down()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.east(2)).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.east().south()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.east().north()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.east()).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.east().up()).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.east().up(2)).getMaterial() == Material.AIR) {
            return new BlockPos(1, 0, 0);
        }
        if (8r_0.c.world.getBlockState(blockPos.down()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.west()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.east()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.north()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.up()).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.up(2)).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.south().down()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.south(2)).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.south().east()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.south().west()).getBlock() == Blocks.BEDROCK && 8r_0.c.world.getBlockState(blockPos.south()).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.south().up()).getMaterial() == Material.AIR && 8r_0.c.world.getBlockState(blockPos.south().up(2)).getMaterial() == Material.AIR) {
            return new BlockPos(0, 0, 1);
        }
        return null;
    }

    public static double[] c(double d2, double d3, double d4, EnumFacing enumFacing, EntityPlayer entityPlayer) {
        return 8x_0.c(d2 + 0.5 + (double)enumFacing.getDirectionVec().getX() * 0.5, d3 + 0.5 + (double)enumFacing.getDirectionVec().getY() * 0.5, d4 + 0.5 + (double)enumFacing.getDirectionVec().getZ() * 0.5, entityPlayer);
    }

    public static boolean 1(BlockPos blockPos) {
        return 8r_0.4(blockPos) || 8r_0.5(blockPos);
    }

    public static boolean 4(BlockPos blockPos) {
        return !(8r_0.5(blockPos) || 8r_0.c.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() != Blocks.OBSIDIAN && 8r_0.c.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK || 8r_0.c.world.getBlockState(blockPos).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.add(0, 1, 0)).getMaterial() != Material.AIR || 8r_0.c.world.getBlockState(blockPos.add(0, 2, 0)).getMaterial() != Material.AIR);
    }

    public static Optional<8q_0> c(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        BlockPos blockPos22;
        Block block = 8r_0.c.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return Optional.empty();
        }
        if (!bl) {
            for (BlockPos blockPos22 : 8r_0.c.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
                if (bl3 && blockPos22 instanceof EntityEnderCrystal || blockPos22 instanceof EntityItem || blockPos22 instanceof EntityXPOrb || blockPos22 instanceof EntityArrow) continue;
                return Optional.empty();
            }
        }
        EnumFacing enumFacing = null;
        for (EnumFacing enumFacing2 : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos3 = blockPos.offset(enumFacing2);
            if (bl2 && 8r_0.c.world.getBlockState(blockPos3).getBlock() == Blocks.PISTON || !8r_0.c.world.getBlockState(blockPos3).getBlock().canCollideCheck(8r_0.c.world.getBlockState(blockPos3), false) || (iBlockState = 8r_0.c.world.getBlockState(blockPos3)).getMaterial().isReplaceable()) continue;
            enumFacing = enumFacing2;
            break;
        }
        if (enumFacing == null) {
            return Optional.empty();
        }
        blockPos22 = blockPos.offset(enumFacing);
        EnumFacing enumFacing3 = enumFacing.getOpposite();
        if (!8r_0.c.world.getBlockState(blockPos22).getBlock().canCollideCheck(8r_0.c.world.getBlockState(blockPos22), false)) {
            return Optional.empty();
        }
        return Optional.of(new 8q_0(blockPos22, enumFacing3));
    }
}

