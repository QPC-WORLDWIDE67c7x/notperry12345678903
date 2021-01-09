/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.07;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.0x_0;
import me.darki.konas.14;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6t_0;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import me.darki.konas.mixin.mixins.ICPacketVehicleMove;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.6u
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6u_0
extends 3E {
    public static 8h_0<6t_0> 1 = new 8h_0("Mode", 6t_0.c);
    public static 8h_0<Boolean> 2 = new 8h_0("Glide", false);
    public static 8h_0<Boolean> 3 = new 8h_0("EntityJesus", true);
    public static 8h_0<Boolean> 4 = new 8h_0("Strict", false);
    public static 8h_0<Boolean> 5 = new 8h_0("Boost", false);
    public boolean 1;
    public int 1 = 0;
    public float c;

    public static IBlockState c(Class<? extends Block> clazz, int n2) {
        for (int i2 = MathHelper.floor((double)6u_0.c.player.getEntityBoundingBox().minX); i2 < MathHelper.ceil((double)6u_0.c.player.getEntityBoundingBox().maxX); ++i2) {
            for (int i3 = MathHelper.floor((double)6u_0.c.player.getEntityBoundingBox().minZ); i3 < MathHelper.ceil((double)6u_0.c.player.getEntityBoundingBox().maxZ); ++i3) {
                IBlockState iBlockState = 6u_0.c.world.getBlockState(new BlockPos(i2, n2, i3));
                if (!clazz.isInstance(iBlockState.getBlock())) continue;
                return iBlockState;
            }
        }
        return null;
    }

    public static boolean 0() {
        if (6u_0.c.player.fallDistance >= 3.0f) {
            return false;
        }
        AxisAlignedBB axisAlignedBB = 6u_0.c.player.getRidingEntity() != null ? 6u_0.c.player.getRidingEntity().getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, (double)-0.05f, 0.0) : 6u_0.c.player.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, (double)-0.05f, 0.0);
        boolean bl = false;
        int n2 = (int)axisAlignedBB.minY;
        for (int i2 = MathHelper.floor((double)axisAlignedBB.minX); i2 < MathHelper.floor((double)(axisAlignedBB.maxX + 1.0)); ++i2) {
            for (int i3 = MathHelper.floor((double)axisAlignedBB.minZ); i3 < MathHelper.floor((double)(axisAlignedBB.maxZ + 1.0)); ++i3) {
                Block block = 6u_0.c.world.getBlockState(new BlockPos(i2, n2, i3)).getBlock();
                if (block == Blocks.AIR) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    @Subscriber
    public void c(1P p2) {
        if (1.6() == 6t_0.0) {
            boolean bl;
            int n2 = MathHelper.floor((double)(6u_0.c.player.getEntityBoundingBox().minY - 0.2));
            boolean bl2 = bl = 6u_0.c(BlockLiquid.class, n2) != null;
            if (bl && !6u_0.c.player.isSneaking()) {
                6u_0.c.player.onGround = false;
            }
            Block block = 6u_0.c.world.getBlockState(new BlockPos((int)Math.floor(6u_0.c.player.posX), (int)Math.floor(6u_0.c.player.posY), (int)Math.floor(6u_0.c.player.posZ))).getBlock();
            if (this.1 && !6u_0.c.player.capabilities.isFlying && !6u_0.c.player.isInWater()) {
                if (6u_0.c.player.motionY < -0.3 || 6u_0.c.player.onGround || 6u_0.c.player.isOnLadder()) {
                    this.1 = false;
                    return;
                }
                6u_0.c.player.motionY = 6u_0.c.player.motionY / (double)0.98f + 0.08;
                6u_0.c.player.motionY -= 0.03120000000005;
            }
            if (6u_0.c.player.isInWater() || 6u_0.c.player.isInLava()) {
                6u_0.c.player.motionY = 0.1;
            }
            if (!6u_0.c.player.isInLava() && (!6u_0.c.player.isInWater() || ((Boolean)5.6()).booleanValue()) && block instanceof BlockLiquid && 6u_0.c.player.motionY < 0.2) {
                6u_0.c.player.motionY = 0.5;
                this.1 = true;
            }
        }
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketPlayerPosLook) {
            this.1 = 0;
        }
    }

    public boolean 1() {
        if (6u_0.c.player.isSneaking()) {
            return false;
        }
        if (6u_0.c.player.getRidingEntity() != null && 6u_0.c.player.getRidingEntity().fallDistance >= 3.0f) {
            return false;
        }
        return 6u_0.c.player.fallDistance <= 3.0f;
    }

    public static boolean c() {
        if (6u_0.c.player.fallDistance >= 3.0f) {
            return false;
        }
        boolean bl = false;
        AxisAlignedBB axisAlignedBB = 6u_0.c.player.getRidingEntity() != null ? 6u_0.c.player.getRidingEntity().getEntityBoundingBox() : 6u_0.c.player.getEntityBoundingBox();
        int n2 = (int)axisAlignedBB.minY;
        for (int i2 = MathHelper.floor((double)axisAlignedBB.minX); i2 < MathHelper.floor((double)axisAlignedBB.maxX) + 1; ++i2) {
            for (int i3 = MathHelper.floor((double)axisAlignedBB.minZ); i3 < MathHelper.floor((double)axisAlignedBB.maxZ) + 1; ++i3) {
                Block block = 6u_0.c.world.getBlockState(new BlockPos(i2, n2, i3)).getBlock();
                if (block instanceof BlockAir) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    @Subscriber
    public void c(0x_0 x_02) {
        block0: {
            if (!6u_0.c.player.isInWater() && !6u_0.c.player.isInLava() || 6u_0.c.player.motionY != 0.1 && 6u_0.c.player.motionY != 0.5) break block0;
            x_02.c(true);
        }
    }

    @Subscriber
    public void c(0T t) {
        block17: {
            block18: {
                if (6u_0.c.world == null || 6u_0.c.player == null) {
                    return;
                }
                if (1.6() != 6t_0.c) break block17;
                if (!(t.c() instanceof CPacketPlayer) || 6u_0.c.player.ticksExisted <= 20 || !((6t_0)((Object)1.6())).equals((Object)6t_0.c) || 6u_0.c.player.getRidingEntity() != null || 6u_0.c.gameSettings.keyBindJump.isKeyDown() || !(6u_0.c.player.fallDistance < 3.0f)) break block18;
                CPacketPlayer cPacketPlayer = (CPacketPlayer)t.c();
                if (!6u_0.0() || 6u_0.c()) break block17;
                ((ICPacketPlayer)cPacketPlayer).setOnGround(false);
                if (((Boolean)4.6()).booleanValue()) {
                    this.c += 0.12f;
                    if (this.c > 0.4f) {
                        this.c = 0.2f;
                    }
                    ((ICPacketPlayer)cPacketPlayer).setY(cPacketPlayer.getY(6u_0.c.player.posY) - (double)this.c);
                } else {
                    ((ICPacketPlayer)cPacketPlayer).setY(6u_0.c.player.ticksExisted % 2 == 0 ? cPacketPlayer.getY(6u_0.c.player.posY) - 0.05 : cPacketPlayer.getY(6u_0.c.player.posY));
                }
                break block17;
            }
            if (!(t.c() instanceof CPacketVehicleMove) || !((Boolean)4.6()).booleanValue() || !((Boolean)3.6()).booleanValue()) break block17;
            CPacketVehicleMove cPacketVehicleMove = (CPacketVehicleMove)t.c();
            if (6u_0.0() && 6u_0.c.player.fallDistance < 3.0f && !6u_0.c.player.movementInput.jump && !6u_0.c() && !6u_0.c.player.isSneaking()) {
                double d2 = cPacketVehicleMove.getY();
                if (6u_0.c.player.ticksExisted % 3 == 0) {
                    ((ICPacketVehicleMove)cPacketVehicleMove).setY(cPacketVehicleMove.getY() - 0.48);
                } else if (6u_0.c.player.ticksExisted % 4 == 0) {
                    ((ICPacketVehicleMove)cPacketVehicleMove).setY(cPacketVehicleMove.getY() - 0.33);
                } else if (6u_0.c.player.ticksExisted % 5 == 0) {
                    ((ICPacketVehicleMove)cPacketVehicleMove).setY(cPacketVehicleMove.getY() - 0.73);
                } else if (6u_0.c.player.ticksExisted % 6 == 0) {
                    ((ICPacketVehicleMove)cPacketVehicleMove).setY(cPacketVehicleMove.getY() - 0.63);
                } else if (6u_0.c.player.ticksExisted % 7 == 0) {
                    ((ICPacketVehicleMove)cPacketVehicleMove).setY(cPacketVehicleMove.getY() - 0.42);
                } else if (6u_0.c.player.ticksExisted % 8 == 0) {
                    ((ICPacketVehicleMove)cPacketVehicleMove).setY(cPacketVehicleMove.getY() - 0.52);
                }
                if (cPacketVehicleMove.getY() == d2) {
                    ((ICPacketVehicleMove)cPacketVehicleMove).setY(cPacketVehicleMove.getY() - 0.3);
                }
            }
        }
    }

    @Subscriber
    public void c(07 var1_1) {
        block0: {
            if (!(var1_1.1() instanceof BlockLiquid) || var1_1.0() != 6u_0.c.player || !((double)var1_1.2().getY() <= 6u_0.c.player.posY) || 6u_0.c(BlockLiquid.class, MathHelper.floor((double)(6u_0.c.player.getEntityBoundingBox().minY + 0.01))) == null || 6u_0.c(BlockLiquid.class, MathHelper.floor((double)(6u_0.c.player.getEntityBoundingBox().minY - 0.02))) == null || !(6u_0.c.player.fallDistance < 3.0f) || 6u_0.c.player.isSneaking()) break block0;
            var1_1.c(Block.FULL_BLOCK_AABB);
        }
    }

    public 6u_0() {
        super("Jesus", 3D.0, new String[0]);
    }

    @Subscriber
    public void c(14 var1_1) {
        if (1.6() == 6t_0.0) {
            return;
        }
        if (!6u_0.c.player.movementInput.sneak && !6u_0.c.player.movementInput.jump && 6u_0.c()) {
            6u_0.c.player.motionY = 0.1;
        }
        if (6u_0.0() && 6u_0.c.player.fallDistance < 3.0f && !6u_0.c.player.movementInput.jump && !6u_0.c() && !6u_0.c.player.isSneaking() && ((Boolean)2.6()).booleanValue()) {
            switch (this.1) {
                case 0: {
                    6u_0.c.player.motionX *= 1.1;
                    6u_0.c.player.motionZ *= 1.1;
                    break;
                }
                case 1: {
                    6u_0.c.player.motionX *= 1.27;
                    6u_0.c.player.motionZ *= 1.27;
                    break;
                }
                case 2: {
                    6u_0.c.player.motionX *= 1.51;
                    6u_0.c.player.motionZ *= 1.51;
                    break;
                }
                case 3: {
                    6u_0.c.player.motionX *= 1.15;
                    6u_0.c.player.motionZ *= 1.15;
                    break;
                }
                case 4: {
                    6u_0.c.player.motionX *= 1.23;
                    6u_0.c.player.motionZ *= 1.23;
                }
            }
            ++this.1;
            if (this.1 > 4) {
                this.1 = 0;
            }
        }
    }
}

