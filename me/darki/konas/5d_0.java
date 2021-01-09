/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5a_0;
import me.darki.konas.5b_0;
import me.darki.konas.88;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import me.darki.konas.X;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import me.darki.konas.mixin.mixins.ISPacketPlayerPosLook;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.5d
 */
public class 5d_0
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Rotate", true);
    public 8h_0<Boolean> 2 = new 8h_0("Swing", true);
    public 8h_0<Boolean> 3 = new 8h_0("Strict", false);
    public 8h_0<Boolean> 4 = new 8h_0("Skulls", true);
    public static 8h_0<88> 5 = new 8h_0("CustomBlocks", new 88(new String[0]));
    public static 8h_0<5a_0> 6 = new 8h_0("Filter", 5a_0.c);
    public 5b_0 c;
    public 9m c = new 9m();

    @Subscriber
    public void c(X x) {
        x.c(true);
    }

    @Override
    public void c() {
        if (((Minecraft)5d_0.c).player == null || ((Minecraft)5d_0.c).world == null) {
            this.d();
            return;
        }
        if (!5d_0.c.player.onGround) {
            this.d();
            return;
        }
        this.c = 5b_0.c;
    }

    @Subscriber
    public void c(0S s) {
        block1: {
            if (((Minecraft)5d_0.c).currentScreen instanceof GuiDownloadTerrain) {
                this.d();
                return;
            }
            if (!(s.c() instanceof SPacketPlayerPosLook) || ((Boolean)this.3.6()).booleanValue()) break block1;
            ((ISPacketPlayerPosLook)s.c()).setYaw(5d_0.c.player.rotationYaw);
            ((ISPacketPlayerPosLook)s.c()).setPitch(5d_0.c.player.rotationPitch);
        }
    }

    public 5d_0() {
        super("RubberFill", "Fills your own hole", 3D.4, "Burrow", "SelfFill");
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)5d_0.c).player == null || ((Minecraft)5d_0.c).world == null) {
            return;
        }
        if (this.c == 5b_0.0) {
            if (this.c.c(500.0)) {
                this.d();
            }
            return;
        }
        if (!5d_0.c.player.onGround) {
            this.d();
            return;
        }
        if (((Minecraft)5d_0.c).world.getBlockState(new BlockPos((Entity)((Minecraft)5d_0.c).player)).getBlock() == Blocks.AIR) {
            if (((Boolean)this.4.6()).booleanValue() && ((Minecraft)5d_0.c).world.getBlockState(new BlockPos((Entity)((Minecraft)5d_0.c).player).up(2)).getBlock() != Blocks.AIR) {
                if (this.1() == -1) {
                    this.d();
                    return;
                }
                BlockPos blockPos = new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY, 5d_0.c.player.posZ);
                BlockPos blockPos2 = blockPos.down();
                EnumFacing enumFacing = EnumFacing.UP;
                Vec3d vec3d = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                if (((Boolean)this.1.6()).booleanValue()) {
                    if (((IEntityPlayerSP)((Minecraft)5d_0.c).player).getLastReportedPitch() < 0.0f) {
                        5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(5d_0.c.player.rotationYaw, 0.0f, true));
                    }
                    5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(5d_0.c.player.posX, 5d_0.c.player.posY, 5d_0.c.player.posZ, 5d_0.c.player.rotationYaw, 90.0f, true));
                    ((IEntityPlayerSP)((Minecraft)5d_0.c).player).setLastReportedPosY(5d_0.c.player.posY + 1.16);
                    ((IEntityPlayerSP)((Minecraft)5d_0.c).player).setLastReportedPitch(90.0f);
                }
                float f2 = (float)(vec3d.x - (double)blockPos.getX());
                float f3 = (float)(vec3d.y - (double)blockPos.getY());
                float f4 = (float)(vec3d.z - (double)blockPos.getZ());
                boolean bl = 5d_0.c.player.inventory.currentItem != this.1();
                int n3 = 5d_0.c.player.inventory.currentItem;
                if (bl) {
                    5d_0.c.player.inventory.currentItem = this.1();
                    5d_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1()));
                }
                5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos2, enumFacing, EnumHand.MAIN_HAND, f2, f3, f4));
                if (((Boolean)this.2.6()).booleanValue()) {
                    5d_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                }
                if (bl) {
                    5d_0.c.player.inventory.currentItem = n3;
                    5d_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
                }
                this.c.c();
                this.c = 5b_0.0;
                return;
            }
            if (this.c() == -1) {
                this.d();
                return;
            }
            BlockPos blockPos = new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY, 5d_0.c.player.posZ);
            BlockPos blockPos3 = blockPos.down();
            EnumFacing enumFacing = EnumFacing.UP;
            Vec3d vec3d = new Vec3d((Vec3i)blockPos3).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
            if (((Boolean)this.1.6()).booleanValue()) {
                if (((IEntityPlayerSP)((Minecraft)5d_0.c).player).getLastReportedPitch() < 0.0f) {
                    5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(5d_0.c.player.rotationYaw, 0.0f, true));
                }
                5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(5d_0.c.player.posX, 5d_0.c.player.posY, 5d_0.c.player.posZ, 5d_0.c.player.rotationYaw, 90.0f, true));
                ((IEntityPlayerSP)((Minecraft)5d_0.c).player).setLastReportedPosY(5d_0.c.player.posY + 1.16);
                ((IEntityPlayerSP)((Minecraft)5d_0.c).player).setLastReportedPitch(90.0f);
            }
            5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(5d_0.c.player.posX, 5d_0.c.player.posY + 0.42, 5d_0.c.player.posZ, false));
            5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(5d_0.c.player.posX, 5d_0.c.player.posY + 0.75, 5d_0.c.player.posZ, false));
            5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(5d_0.c.player.posX, 5d_0.c.player.posY + 1.01, 5d_0.c.player.posZ, false));
            5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(5d_0.c.player.posX, 5d_0.c.player.posY + 1.16, 5d_0.c.player.posZ, false));
            if (c.getCurrentServerData() != null && 5d_0.c.getCurrentServerData().serverIP.toLowerCase().contains("crystalpvp")) {
                5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(5d_0.c.player.posX, 5d_0.c.player.posY + 1.16, 5d_0.c.player.posZ, false));
                5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(5d_0.c.player.posX, 5d_0.c.player.posY + 1.24, 5d_0.c.player.posZ, false));
            }
            float f5 = (float)(vec3d.x - (double)blockPos.getX());
            float f6 = (float)(vec3d.y - (double)blockPos.getY());
            float f7 = (float)(vec3d.z - (double)blockPos.getZ());
            boolean bl = 5d_0.c.player.inventory.currentItem != this.c();
            int n4 = 5d_0.c.player.inventory.currentItem;
            if (bl) {
                5d_0.c.player.inventory.currentItem = this.c();
                5d_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.c()));
            }
            5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos3, enumFacing, EnumHand.MAIN_HAND, f5, f6, f7));
            if (((Boolean)this.2.6()).booleanValue()) {
                5d_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            }
            if (bl) {
                5d_0.c.player.inventory.currentItem = n4;
                5d_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n4));
            }
            5d_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(5d_0.c.player.posX, this.0(), 5d_0.c.player.posZ, false));
            this.c.c();
            this.c = 5b_0.0;
        } else {
            this.d();
        }
    }

    public double 0() {
        BlockPos blockPos;
        if (c.getCurrentServerData() != null) {
            if (5d_0.c.getCurrentServerData().serverIP.toLowerCase().contains("crystalpvp") || 5d_0.c.getCurrentServerData().serverIP.toLowerCase().contains("2b2t")) {
                blockPos = new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY + 2.34, 5d_0.c.player.posZ);
                if (((Minecraft)5d_0.c).world.getBlockState(blockPos).getBlock() instanceof BlockAir && ((Minecraft)5d_0.c).world.getBlockState(blockPos.up()).getBlock() instanceof BlockAir) {
                    return 5d_0.c.player.posY + 2.34;
                }
            } else {
                if (5d_0.c.getCurrentServerData().serverIP.toLowerCase().contains("endcrystal")) {
                    if (((Minecraft)5d_0.c).world.getBlockState(new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY + 4.0, 5d_0.c.player.posZ)).getBlock() instanceof BlockAir) {
                        return 5d_0.c.player.posY + 4.0;
                    }
                    return 5d_0.c.player.posY + 3.0;
                }
                if (5d_0.c.getCurrentServerData().serverIP.toLowerCase().contains("netheranarchy")) {
                    if (((Minecraft)5d_0.c).world.getBlockState(new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY + 8.5, 5d_0.c.player.posZ)).getBlock() instanceof BlockAir) {
                        return 5d_0.c.player.posY + 8.5;
                    }
                    return 5d_0.c.player.posY + 9.5;
                }
                if (5d_0.c.getCurrentServerData().serverIP.toLowerCase().contains("9b9t")) {
                    BlockPos blockPos2 = new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY + 9.0, 5d_0.c.player.posZ);
                    if (((Minecraft)5d_0.c).world.getBlockState(blockPos2).getBlock() instanceof BlockAir && ((Minecraft)5d_0.c).world.getBlockState(blockPos2.up()).getBlock() instanceof BlockAir) {
                        return 5d_0.c.player.posY + 9.0;
                    }
                    for (int i2 = 10; i2 < 20; ++i2) {
                        BlockPos blockPos3 = new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY + (double)i2, 5d_0.c.player.posZ);
                        if (!(((Minecraft)5d_0.c).world.getBlockState(blockPos3).getBlock() instanceof BlockAir) || !(((Minecraft)5d_0.c).world.getBlockState(blockPos3.up()).getBlock() instanceof BlockAir)) continue;
                        return 5d_0.c.player.posY + (double)i2;
                    }
                    return 5d_0.c.player.posY + 20.0;
                }
            }
        }
        if (((Minecraft)5d_0.c).world.getBlockState(blockPos = new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY - 9.0, 5d_0.c.player.posZ)).getBlock() instanceof BlockAir && ((Minecraft)5d_0.c).world.getBlockState(blockPos.up()).getBlock() instanceof BlockAir) {
            return 5d_0.c.player.posY - 9.0;
        }
        for (int i3 = -10; i3 > -20; --i3) {
            BlockPos blockPos4 = new BlockPos(5d_0.c.player.posX, 5d_0.c.player.posY - (double)i3, 5d_0.c.player.posZ);
            if (!(((Minecraft)5d_0.c).world.getBlockState(blockPos4).getBlock() instanceof BlockAir) || !(((Minecraft)5d_0.c).world.getBlockState(blockPos4.up()).getBlock() instanceof BlockAir)) continue;
            return 5d_0.c.player.posY - (double)i3;
        }
        return 5d_0.c.player.posY - 24.0;
    }

    public int c() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemStack itemStack = 5d_0.c.player.inventory.getStackInSlot(i2);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock)) continue;
            Block block = ((ItemBlock)itemStack.getItem()).getBlock();
            if (6.6() == 5a_0.1 ? ((88)5.6()).0().contains(block) : 6.6() == 5a_0.0 && !((88)5.6()).0().contains(block)) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public int 1() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemStack itemStack = 5d_0.c.player.inventory.getStackInSlot(i2);
            if (!(itemStack.getItem() instanceof ItemSkull)) continue;
            n2 = i2;
            break;
        }
        return n2;
    }
}

