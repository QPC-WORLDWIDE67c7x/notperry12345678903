/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.19;
import me.darki.konas.1N;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5Z;
import me.darki.konas.6c_0;
import me.darki.konas.88;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 60
extends 3E {
    public 8h_0<5Z> 1 = new 8h_0("Mode", 5Z.c);
    public 8h_0<6c_0> 2 = new 8h_0("Timing", 6c_0.c);
    public 8h_0<Float> 3 = new 8h_0("Range", Float.valueOf(3.5f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.5f));
    public 8h_0<Boolean> 4 = new 8h_0("Below", false);
    public 8h_0<Boolean> 5 = new 8h_0("Rotate", true);
    public 8h_0<Boolean> 6 = new 8h_0("Filter", false);
    public static 8h_0<88> 7 = new 8h_0("ValidBlocks", new 88(new String[0]));
    public Block c;
    public float c;
    public float 0;
    public 9m c;
    public BlockPos c = null;

    public void 0(BlockPos blockPos) {
        block4: {
            Vec3d vec3d = null;
            double[] dArray = null;
            for (double d2 = 0.1; d2 < 0.9; d2 += 0.1) {
                for (double d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                    for (double d4 = 0.1; d4 < 0.9; d4 += 0.1) {
                        Vec3d vec3d2 = new Vec3d(60.c.player.posX, 60.c.player.getEntityBoundingBox().minY + (double)60.c.player.getEyeHeight(), 60.c.player.posZ);
                        Vec3d vec3d3 = new Vec3d((Vec3i)blockPos).add(d2, d3, d4);
                        double d5 = vec3d2.distanceTo(vec3d3);
                        double d6 = vec3d3.x - vec3d2.x;
                        double d7 = vec3d3.y - vec3d2.y;
                        double d8 = vec3d3.z - vec3d2.z;
                        double d9 = MathHelper.sqrt((double)(d6 * d6 + d8 * d8));
                        double[] dArray2 = new double[]{MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d8, d6)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d7, d9)))))};
                        float f2 = MathHelper.cos((float)((float)(-dArray2[0] * 0.01745329238474369 - 3.1415927410125732)));
                        float f3 = MathHelper.sin((float)((float)(-dArray2[0] * 0.01745329238474369 - 3.1415927410125732)));
                        float f4 = -MathHelper.cos((float)((float)(-dArray2[1] * 0.01745329238474369)));
                        float f5 = MathHelper.sin((float)((float)(-dArray2[1] * 0.01745329238474369)));
                        Vec3d vec3d4 = new Vec3d((double)(f3 * f4), (double)f5, (double)(f2 * f4));
                        Vec3d vec3d5 = vec3d2.add(vec3d4.x * d5, vec3d4.y * d5, vec3d4.z * d5);
                        RayTraceResult rayTraceResult = 60.c.world.rayTraceBlocks(vec3d2, vec3d5, false, false, true);
                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                        Vec3d vec3d6 = vec3d3;
                        double[] dArray3 = dArray2;
                        if (vec3d != null && dArray != null) {
                            if (!(Math.hypot(((dArray3[0] - (double)((IEntityPlayerSP)60.c.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, dArray3[1] - (double)((IEntityPlayerSP)60.c.player).getLastReportedPitch()) < Math.hypot(((dArray[0] - (double)((IEntityPlayerSP)60.c.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, dArray[1] - (double)((IEntityPlayerSP)60.c.player).getLastReportedPitch()))) continue;
                            vec3d = vec3d6;
                            dArray = dArray3;
                            continue;
                        }
                        vec3d = vec3d6;
                        dArray = dArray3;
                    }
                }
            }
            if (dArray == null) break block4;
            this.c = (float)dArray[0];
            this.0 = (float)dArray[1];
            this.c.c();
        }
    }

    public BlockPos c(boolean bl) {
        float f2;
        BlockPos blockPos = null;
        for (float f3 = f2 = ((Float)this.3.6()).floatValue(); f3 >= -f2; f3 -= 1.0f) {
            for (float f4 = f2; f4 >= -f2; f4 -= 1.0f) {
                for (float f5 = f2; f5 >= -f2; f5 -= 1.0f) {
                    double d2;
                    BlockPos blockPos2 = new BlockPos(60.c.player.posX + (double)f3, 60.c.player.posY + (double)f4, 60.c.player.posZ + (double)f5);
                    IBlockState iBlockState = 60.c.world.getBlockState(blockPos2);
                    if (((Boolean)this.6.6()).booleanValue() && !((88)7.6()).0().contains(iBlockState.getBlock()) || !((d2 = 60.c.player.getDistance((double)blockPos2.getX(), (double)blockPos2.getY(), (double)blockPos2.getZ())) <= (double)f2) || 60.c.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || iBlockState.getBlock() instanceof BlockLiquid || !this.c(blockPos2) || bl && (this.c == null || !60.c.world.getBlockState(blockPos2).getBlock().equals(this.c)) || (double)blockPos2.getY() < 60.c.player.posY && !((Boolean)this.4.6()).booleanValue()) continue;
                    f2 = (float)d2;
                    blockPos = blockPos2;
                }
            }
        }
        return blockPos;
    }

    @Subscriber
    public void c(1N n2) {
        block8: {
            if (n2.c() == TickEvent.Phase.END) {
                return;
            }
            if (this.2.6() != 6c_0.0) {
                return;
            }
            if (60.c.player == null || 60.c.world == null) {
                return;
            }
            BlockPos blockPos = null;
            switch ((5Z)((Object)this.1.6())) {
                case c: {
                    blockPos = this.c(false);
                    break;
                }
                case 0: {
                    blockPos = this.c(true);
                }
            }
            if (((Boolean)this.5.6()).booleanValue() && blockPos != null) {
                this.0(blockPos);
            }
            if (blockPos == null || !this.c(blockPos)) break block8;
            60.c.playerController.onPlayerDamageBlock(blockPos, 60.c.player.getHorizontalFacing());
            60.c.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    @Subscriber
    public void c(0T t) {
        block3: {
            if (60.c.world == null || 60.c.player == null) {
                return;
            }
            if (!(t.c() instanceof CPacketPlayer) || this.c.c(350.0) || !((Boolean)this.5.6()).booleanValue() || this.2.6() != 6c_0.0) break block3;
            CPacketPlayer cPacketPlayer = (CPacketPlayer)t.c();
            if (t.c() instanceof CPacketPlayer.Position) {
                t.c(true);
                60.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(cPacketPlayer.getX(60.c.player.posX), cPacketPlayer.getY(60.c.player.posY), cPacketPlayer.getZ(60.c.player.posZ), this.c, this.0, cPacketPlayer.isOnGround()));
            } else {
                ((ICPacketPlayer)cPacketPlayer).setYaw(this.c);
                ((ICPacketPlayer)cPacketPlayer).setPitch(this.0);
            }
        }
    }

    public boolean c(BlockPos blockPos) {
        IBlockState iBlockState = 60.c.world.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.getBlockHardness(iBlockState, (World)60.c.world, blockPos) != -1.0f;
    }

    @Subscriber(priority=18)
    public void c(1O o2) {
        block1: {
            if (this.2.6() != 6c_0.c) {
                return;
            }
            if (this.c == null || !this.c(this.c)) break block1;
            60.c.playerController.onPlayerDamageBlock(this.c, 60.c.player.getHorizontalFacing());
            60.c.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    @Subscriber(priority=10)
    public void c(1P p2) {
        block7: {
            this.c = null;
            if (this.2.6() != 6c_0.c) {
                return;
            }
            switch ((5Z)((Object)this.1.6())) {
                case c: {
                    this.c = this.c(false);
                    break;
                }
                case 0: {
                    this.c = this.c(true);
                }
            }
            if (((Boolean)this.5.6()).booleanValue() && this.c != null) {
                this.0(this.c);
            }
            if (this.c.c(350.0)) break block7;
            if (((Boolean)this.5.6()).booleanValue()) {
                8k_0.c.c.c(this.c, this.0);
            }
        }
    }

    @Override
    public void c() {
        this.c = null;
    }

    @Subscriber
    public void c(19 var1_1) {
        block0: {
            Block block;
            if (this.1.6() != 5Z.0 || (block = 60.c.world.getBlockState(var1_1.4()).getBlock()) == this.c) break block0;
            this.c = block;
            var1_1.c(true);
        }
    }

    public 60() {
        super("Nuker", "Automatically mines blocks around you", 3D.3, "AutoDig");
    }
}

