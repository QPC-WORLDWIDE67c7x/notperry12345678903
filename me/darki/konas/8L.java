/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.darki.konas.4j_0;
import me.darki.konas.8K;
import me.darki.konas.8M;
import me.darki.konas.8k_0;
import me.darki.konas.8r_0;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import me.darki.konas.mixin.mixins.IMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 8L {
    public static Minecraft c = Minecraft.getMinecraft();

    public static void c(8K k2, EnumHand enumHand, boolean bl) {
        8L.c(k2.3(), k2.1(), enumHand, k2.c(), bl, true);
    }

    public static void 0(8K k2, EnumHand enumHand, boolean bl) {
        block3: {
            boolean bl2 = 8L.c.player.isSprinting();
            boolean bl3 = 8r_0.7(k2.3());
            if (bl2) {
                8L.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8L.c.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                8L.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8L.c.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            8L.c(k2, enumHand, bl);
            if (bl3) {
                8L.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8L.c.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (!bl2) break block3;
            8L.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8L.c.player, CPacketEntityAction.Action.START_SPRINTING));
        }
    }

    public static boolean c(boolean bl) {
        if (!bl) {
            return true;
        }
        return !8k_0.c.c.c();
    }

    public static boolean c(BlockPos blockPos) {
        return 8L.c.world.getBlockState(blockPos).getBlock().canCollideCheck(8L.c.world.getBlockState(blockPos), false) || ((ConcurrentHashMap)((Object)4j_0.c)).containsKey(blockPos);
    }

    public static 8K 1(BlockPos blockPos, boolean bl, boolean bl2) {
        return 8L.0(blockPos, bl, bl2, false);
    }

    public static 8K 0(BlockPos blockPos, boolean bl) {
        return 8L.1(blockPos, bl, false);
    }

    public static List<EnumFacing> 0(BlockPos blockPos, boolean bl, boolean bl2) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2;
            if (bl2) {
                blockPos2 = new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                iBlockState = 8L.c.world.rayTraceBlocks(8L.c.player.getPositionEyes(1.0f), (Vec3d)blockPos2);
                if (iBlockState != null && iBlockState.typeOfHit != RayTraceResult.Type.MISS) {
                    System.out.println("weary");
                    continue;
                }
            }
            blockPos2 = blockPos.offset(enumFacing);
            if (bl) {
                iBlockState = 8L.c.player.getPositionEyes(1.0f);
                Vec3d vec3d = new Vec3d((double)blockPos2.getX() + 0.5, (double)blockPos2.getY() + 0.5, (double)blockPos2.getZ() + 0.5);
                IBlockState iBlockState2 = 8L.c.world.getBlockState(blockPos2);
                boolean bl3 = iBlockState2.getBlock() == Blocks.AIR || iBlockState2.isFullBlock();
                ArrayList<EnumFacing> arrayList2 = new ArrayList<EnumFacing>();
                arrayList2.addAll(8L.c(iBlockState.x - vec3d.x, EnumFacing.WEST, EnumFacing.EAST, !bl3));
                arrayList2.addAll(8L.c(iBlockState.y - vec3d.y, EnumFacing.DOWN, EnumFacing.UP, true));
                arrayList2.addAll(8L.c(iBlockState.z - vec3d.z, EnumFacing.NORTH, EnumFacing.SOUTH, !bl3));
                if (!arrayList2.contains(enumFacing.getOpposite())) continue;
            }
            if (((iBlockState = 8L.c.world.getBlockState(blockPos2)) == null || !iBlockState.getBlock().canCollideCheck(iBlockState, false) || iBlockState.getMaterial().isReplaceable()) && !((ConcurrentHashMap)((Object)4j_0.c)).containsKey(blockPos2)) continue;
            arrayList.add(enumFacing);
        }
        return arrayList;
    }

    public static 8K c(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        BlockPos blockPos2;
        Object object;
        EnumFacing enumFacing3;
        Vec3d vec3d;
        block4: {
            EnumFacing enumFacing2 = null;
            vec3d = null;
            double d2 = 69420.0;
            for (EnumFacing enumFacing3 : 8L.0(blockPos, bl3, bl4)) {
                object = blockPos.offset(enumFacing3);
                Vec3d vec3d2 = new Vec3d((Vec3i)object).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5));
                if (!(8L.c.player.getPositionVector().add(0.0, (double)8L.c.player.getEyeHeight(), 0.0).distanceTo(vec3d2) < d2)) continue;
                enumFacing2 = enumFacing3;
                vec3d = vec3d2;
            }
            if (enumFacing2 == null) {
                return null;
            }
            blockPos2 = blockPos.offset(enumFacing2);
            enumFacing3 = enumFacing2.getOpposite();
            object = 8M.c(8L.c.player.getPositionEyes(c.getRenderPartialTicks()), vec3d);
            if (!bl) break block4;
            if (bl2) {
                8L.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation((float)object[0], (float)object[1], 8L.c.player.onGround));
                ((IEntityPlayerSP)8L.c.player).setLastReportedYaw((float)object[0]);
                ((IEntityPlayerSP)8L.c.player).setLastReportedPitch((float)object[1]);
            } else {
                8k_0.c.c.c((float)object[0], (float)object[1]);
            }
        }
        return new 8K(blockPos2, enumFacing3, vec3d, (float)object[0], (float)object[1]);
    }

    public static boolean c(BlockPos blockPos, boolean bl, boolean bl2) {
        return 8L.c(blockPos, bl, false, bl2);
    }

    public static boolean c() {
        return !8k_0.c.c.c();
    }

    public static boolean c(BlockPos blockPos, boolean bl) {
        return 8L.c(blockPos, bl, true);
    }

    public static 8K 0(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        return 8L.c(blockPos, bl, bl2, bl3, false);
    }

    public static void c(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl, boolean bl2) {
        if (bl) {
            float f2 = (float)(vec3d.x - (double)blockPos.getX());
            float f3 = (float)(vec3d.y - (double)blockPos.getY());
            float f4 = (float)(vec3d.z - (double)blockPos.getZ());
            8L.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f2, f3, f4));
        } else {
            8L.c.playerController.processRightClickBlock(8L.c.player, 8L.c.world, blockPos, enumFacing, vec3d, enumHand);
        }
        if (bl2) {
            8L.c.player.connection.sendPacket((Packet)new CPacketAnimation(enumHand));
        }
        ((IMinecraft)c).setRightClickDelayTimer(4);
    }

    public static boolean c(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        Block block = 8L.c.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir)) {
            if (!(block instanceof BlockLiquid || block instanceof BlockTallGrass || block instanceof BlockFire || block instanceof BlockDeadBush || block instanceof BlockSnow)) {
                return false;
            }
        }
        if (bl3) {
            for (EnumFacing enumFacing : 8L.c.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (enumFacing instanceof EntityItem || enumFacing instanceof EntityXPOrb) continue;
                return false;
            }
        }
        for (EnumFacing enumFacing : 8L.0(blockPos, bl, bl2)) {
            if (!8L.c(blockPos.offset(enumFacing))) continue;
            return true;
        }
        return false;
    }

    public static ArrayList<EnumFacing> c(double d2, EnumFacing enumFacing, EnumFacing enumFacing2, boolean bl) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        if (d2 < -0.5) {
            arrayList.add(enumFacing);
        }
        if (d2 > 0.5) {
            arrayList.add(enumFacing2);
        }
        if (bl) {
            if (!arrayList.contains(enumFacing)) {
                arrayList.add(enumFacing);
            }
            if (!arrayList.contains(enumFacing2)) {
                arrayList.add(enumFacing2);
            }
        }
        return arrayList;
    }

    public static boolean 0(BlockPos blockPos) {
        return 8L.c.world.rayTraceBlocks(new Vec3d(8L.c.player.posX, 8L.c.player.posY + (double)8L.c.player.getEyeHeight(), 8L.c.player.posZ), new Vec3d((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ()), false, true, false) == null;
    }
}

