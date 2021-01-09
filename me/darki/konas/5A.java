/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.4g_0;
import me.darki.konas.8K;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.9m;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5A
extends 3E {
    public static 8h_0<Integer> 1 = new 8h_0("Range", 2, 3, 1, 1);
    public 9m c;
    public 9m 0;
    public 8K c = null;

    public boolean c() {
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemBlock itemBlock;
            ItemStack itemStack = 5A.c.player.inventory.getStackInSlot(i2);
            if (itemStack.isEmpty() || !(itemStack.getItem() instanceof ItemBlock) || (itemBlock = (ItemBlock)itemStack.getItem()).getBlock() != Blocks.ENDER_CHEST) continue;
            5A.c.player.inventory.currentItem = i2;
            5A.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(i2));
            return true;
        }
        return false;
    }

    @Subscriber(priority=5)
    public void c(1P p2) {
        this.c = null;
        if (p2.0() || !8L.c()) {
            return;
        }
        BlockPos blockPos = 4g_0.c(new BlockPos((Entity)((Minecraft)5A.c).player), ((Integer)1.6()).intValue(), (Integer)1.6(), false, true, 0).stream().filter(5A::c).min(Comparator.comparing(5A::0)).orElse(null);
        if (blockPos != null) {
            if (this.0.c(4000.0)) {
                boolean bl;
                boolean bl2 = bl = ((Minecraft)5A.c).player.getHeldItemMainhand().getItem() == Items.DIAMOND_PICKAXE;
                if (!bl) {
                    for (int i2 = 0; i2 < 9; ++i2) {
                        ItemStack itemStack = 5A.c.player.inventory.getStackInSlot(i2);
                        if (itemStack.isEmpty() || itemStack.getItem() != Items.DIAMOND_PICKAXE) continue;
                        bl = true;
                        5A.c.player.inventory.currentItem = i2;
                        5A.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(i2));
                        break;
                    }
                }
                if (!bl) {
                    return;
                }
                EnumFacing enumFacing = ((Minecraft)5A.c).player.getHorizontalFacing().getOpposite();
                8k_0.c.c.c(new Vec3d((double)blockPos.getX() + 0.5 + (double)enumFacing.getDirectionVec().getX() * 0.5, (double)blockPos.getY() + 0.5 + (double)enumFacing.getDirectionVec().getY() * 0.5, (double)blockPos.getZ() + 0.5 + (double)enumFacing.getDirectionVec().getZ() * 0.5));
                ((Minecraft)5A.c).player.swingArm(EnumHand.MAIN_HAND);
                5A.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, enumFacing));
                5A.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, enumFacing));
                this.0.c();
            }
        } else if (this.c.c(350.0)) {
            Object object;
            this.c.c();
            if (((Minecraft)5A.c).player.getHeldItemMainhand().getItem() instanceof ItemBlock ? (object = (ItemBlock)((Minecraft)5A.c).player.getHeldItemMainhand().getItem()).getBlock() != Blocks.ENDER_CHEST && !this.c() : !this.c()) {
                return;
            }
            for (BlockPos blockPos2 : 4g_0.c(new BlockPos((Entity)((Minecraft)5A.c).player), ((Integer)1.6()).intValue(), (Integer)1.6(), false, true, 0)) {
                8K k2 = 8L.0(blockPos2, true);
                if (k2 == null) continue;
                this.c = k2;
            }
        }
    }

    @Override
    public void c() {
        this.c = null;
        this.0.c(0L);
    }

    public static Double 0(BlockPos blockPos) {
        return ((Minecraft)5A.c).player.getDistance((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5);
    }

    public 5A() {
        super("AutoObsidian", "Automatically placed EChests and mines them", 3D.3, new String[0]);
        this.0 = new 9m();
    }

    @Subscriber(priority=5)
    public void c(1O o2) {
        block0: {
            if (this.c == null) break block0;
            8L.0(this.c, EnumHand.MAIN_HAND, false);
            this.0.c(0L);
        }
    }

    public static boolean c(BlockPos blockPos) {
        return ((Minecraft)5A.c).world.getBlockState(blockPos).getBlock() instanceof BlockEnderChest;
    }
}

