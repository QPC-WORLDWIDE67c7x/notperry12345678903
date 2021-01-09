/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

/*
 * Renamed from me.darki.konas.8y
 */
public class 8y_0 {
    public static Minecraft c = Minecraft.getMinecraft();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean c(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = 8y_0.c.player.isSneaking();
        try {
            Vec3d vec3d;
            vec3d(8y_0.c.player.posX, 8y_0.c.player.posY + (double)8y_0.c.player.getEyeHeight(), 8y_0.c.player.posZ);
            Vec3d vec3d2 = vec3d;
            for (EnumFacing enumFacing : EnumFacing.values()) {
                Vec3d vec3d3;
                Vec3d vec3d4;
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                EnumFacing enumFacing2 = enumFacing.getOpposite();
                if (8y_0.c.world.getBlockState(blockPos2).getBlock() == Blocks.AIR) continue;
                if (8y_0.c.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid) continue;
                vec3d4((Vec3i)blockPos2);
                vec3d3(enumFacing2.getDirectionVec());
                Vec3d vec3d5 = vec3d4.add(0.5, 0.5, 0.5).add(vec3d3.scale(0.5));
                if (vec3d2.squareDistanceTo(vec3d5) > 18.0625) continue;
                if (bl3) {
                    CPacketPlayer.Rotation rotation;
                    double d2 = vec3d5.x - vec3d2.x;
                    double d3 = vec3d5.y - vec3d2.y;
                    double d4 = vec3d5.z - vec3d2.z;
                    double d5 = Math.sqrt(d2 * d2 + d4 * d4);
                    float f2 = (float)Math.toDegrees(Math.atan2(d4, d2)) - 90.0f;
                    float f3 = (float)(-Math.toDegrees(Math.atan2(d3, d5)));
                    float[] fArray = new float[2];
                    fArray[0] = 8y_0.c.player.rotationYaw + MathHelper.wrapDegrees((float)(f2 - 8y_0.c.player.rotationYaw));
                    fArray[1] = 8y_0.c.player.rotationPitch + MathHelper.wrapDegrees((float)(f3 - 8y_0.c.player.rotationPitch));
                    float[] fArray2 = fArray;
                    rotation(fArray2[0], fArray2[1], 8y_0.c.player.onGround);
                    8y_0.c.player.connection.sendPacket((Packet)rotation);
                }
                if (bl) {
                    CPacketEntityAction cPacketEntityAction;
                    8y_0.c.player.setSneaking(true);
                    cPacketEntityAction((Entity)8y_0.c.player, CPacketEntityAction.Action.START_SNEAKING);
                    8y_0.c.player.connection.sendPacket((Packet)cPacketEntityAction);
                }
                boolean bl5 = false;
                8y_0.c.playerController.updateController();
                if (8y_0.c.playerController.processRightClickBlock(8y_0.c.player, 8y_0.c.world, blockPos2, enumFacing2, vec3d5, EnumHand.MAIN_HAND) != EnumActionResult.FAIL) {
                    if (bl2) {
                        8y_0.c.player.swingArm(EnumHand.MAIN_HAND);
                    }
                    bl5 = true;
                }
                if (bl) {
                    CPacketEntityAction cPacketEntityAction;
                    cPacketEntityAction((Entity)8y_0.c.player, CPacketEntityAction.Action.STOP_SNEAKING);
                    8y_0.c.player.connection.sendPacket((Packet)cPacketEntityAction);
                }
                if (!bl5) continue;
                boolean bl6 = true;
                return bl6;
            }
            boolean bl7 = false;
            return bl7;
        }
        finally {
            8y_0.c.player.setSneaking(bl4);
        }
    }

    public static boolean c(BlockPos blockPos, Block block, boolean bl) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            Block block2 = 8y_0.c.world.getBlockState(blockPos2).getBlock();
            if (block2 == Blocks.AIR || block2 instanceof BlockLiquid || !block.canPlaceBlockAt((World)8y_0.c.world, blockPos)) continue;
            if (bl) {
                if (!8y_0.c.world.checkNoEntityCollision(new AxisAlignedBB(blockPos))) continue;
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean c(BlockPos blockPos) {
        return 8y_0.c(blockPos, true, true, true);
    }

    public static void c(BlockPos blockPos, EnumFacing enumFacing) {
        Vec3d vec3d = new Vec3d(8y_0.c.player.posX, 8y_0.c.player.posY + (double)8y_0.c.player.getEyeHeight(), 8y_0.c.player.posZ);
        for (EnumFacing enumFacing2 : EnumFacing.values()) {
            Vec3d vec3d2;
            BlockPos blockPos2 = blockPos.offset(enumFacing2);
            EnumFacing enumFacing3 = enumFacing2.getOpposite();
            if (8y_0.c.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || 8y_0.c.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid || vec3d.squareDistanceTo(vec3d2 = new Vec3d((Vec3i)blockPos2).add(0.9, 0.9, 0.9).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5))) > 18.0625) continue;
            double d2 = vec3d2.x - vec3d.x;
            double d3 = vec3d2.y - vec3d.y;
            double d4 = vec3d2.z - vec3d.z;
            double d5 = Math.sqrt(d2 * d2 + d4 * d4);
            float f2 = (float)Math.toDegrees(Math.atan2(d4, d2)) - 90.0f;
            float f3 = (float)(-Math.toDegrees(Math.atan2(d3, d5)));
            float[] fArray = new float[]{8y_0.c.player.rotationYaw + MathHelper.wrapDegrees((float)(f2 - 8y_0.c.player.rotationYaw)), 8y_0.c.player.rotationPitch + MathHelper.wrapDegrees((float)(f3 - 8y_0.c.player.rotationPitch))};
            8y_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(fArray[0], fArray[1], 8y_0.c.player.onGround));
            8y_0.c.player.setSneaking(true);
            if (8y_0.c.playerController.processRightClickBlock(8y_0.c.player, 8y_0.c.world, blockPos2, enumFacing, vec3d2, EnumHand.MAIN_HAND) != EnumActionResult.FAIL) {
                8y_0.c.player.swingArm(EnumHand.MAIN_HAND);
            }
            8y_0.c.player.setSneaking(false);
            return;
        }
    }
}

