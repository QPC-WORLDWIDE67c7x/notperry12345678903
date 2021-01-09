/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import java.util.stream.Stream;
import me.darki.konas.0I;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.54;
import me.darki.konas.8J;
import me.darki.konas.8K;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.8u_0;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 44
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("PressurePlates", true);
    public static 8h_0<Integer> 2 = new 8h_0("MinHeight", 2, 5, 2, 1);
    public static 8h_0<Integer> 3 = new 8h_0("Range", 2, 5, 1, 1);
    public static 8h_0<Integer> 4 = new 8h_0("Interval", 0, 20, 0, 1);
    public static 8h_0<Double> 5 = new 8h_0("Range", 4.0, 6.0, 1.0, 0.1);
    public int 1 = 0;
    public 8K c = null;
    public int 2 = -1;

    public 44() {
        super("AutoAnvil", "Automatically places anvils above people's heads to break their helmet", 3D.c, new String[0]);
    }

    @Subscriber(priority=8)
    public void c(1O o2) {
        block2: {
            if (this.2 == -1 || this.c == null) break block2;
            boolean bl = 44.c.player.inventory.currentItem != this.2;
            int n2 = 44.c.player.inventory.currentItem;
            if (bl) {
                44.c.player.inventory.currentItem = this.2;
                44.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
            }
            8L.0(this.c, EnumHand.MAIN_HAND, true);
            this.1 = 0;
            if (bl) {
                44.c.player.inventory.currentItem = n2;
                44.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
            }
        }
    }

    @Override
    public void c() {
        this.c = null;
        this.2 = -1;
        this.1 = (Integer)4.6();
    }

    public static boolean 2(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    @Subscriber(priority=40)
    public void c(1P p2) {
        this.c = null;
        this.2 = -1;
        if (p2.0() || !8L.c()) {
            return;
        }
        if (3F.c(54.class).f()) {
            return;
        }
        if (this.1 < (Integer)4.6()) {
            ++this.1;
        }
        if (this.1 < (Integer)4.6()) {
            return;
        }
        EntityPlayer entityPlayer = this.1();
        if (entityPlayer == null) {
            return;
        }
        if (((Boolean)1.6()).booleanValue() && !(((Minecraft)44.c).world.getBlockState(new BlockPos((Entity)entityPlayer)).getBlock() instanceof BlockPressurePlate)) {
            this.c = 8L.0(new BlockPos((Entity)entityPlayer), true);
            if (this.c != null) {
                int n2 = this.c();
                if (n2 == -1) {
                    this.c = null;
                    this.d();
                    8p_0.1("No pressure plates found!");
                    return;
                }
                this.2 = n2;
                return;
            }
        }
        for (int i2 = 0; i2 < (Integer)3.6(); ++i2) {
            this.c = 8L.0(new BlockPos((Entity)entityPlayer).up((Integer)2.6() + i2), true);
            if (this.c == null) continue;
            int n3 = this.0();
            if (n3 == -1) {
                this.c = null;
                this.d();
                8p_0.1("No anvils found!");
                return;
            }
            this.2 = n3;
            return;
        }
    }

    public int c() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            Item item = 44.c.player.inventory.getStackInSlot(i2).getItem();
            Block block = Block.getBlockFromItem((Item)item);
            if (!(block instanceof BlockPressurePlate)) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public boolean c(EntityPlayer entityPlayer) {
        BlockPos blockPos = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ).down();
        Block block = ((Minecraft)44.c).world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockAir) && !(block instanceof BlockLiquid);
    }

    public static boolean 4(EntityPlayer entityPlayer) {
        return (double)((Minecraft)44.c).player.getDistance((Entity)entityPlayer) < (Double)5.6();
    }

    public static boolean 3(EntityPlayer entityPlayer) {
        return !8J.2(entityPlayer.getUniqueID().toString());
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)44.c).player && entityPlayer != c.getRenderViewEntity();
    }

    public int 0() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            Item item = 44.c.player.inventory.getStackInSlot(i2).getItem();
            Block block = Block.getBlockFromItem((Item)item);
            if (!(block instanceof BlockAnvil)) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    @Subscriber
    public void c(0I i2) {
        block0: {
            if (!(i2.c() instanceof GuiRepair)) break block0;
            i2.c(true);
        }
    }

    public static Float 1(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)44.c).player.getDistance((Entity)entityPlayer));
    }

    public EntityPlayer 1() {
        Stream stream = 44.c.world.playerEntities.stream();
        return stream.filter(44::2).filter(44::0).filter(44::3).filter(44::4).filter(this::c).min(Comparator.comparing(44::1)).orElse(null);
    }
}

