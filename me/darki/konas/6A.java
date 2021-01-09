/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0N;
import me.darki.konas.0T;
import me.darki.konas.11;
import me.darki.konas.15;
import me.darki.konas.1N;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6z_0;
import me.darki.konas.8h_0;
import me.darki.konas.8z_0;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import me.darki.konas.mixin.mixins.IEntity;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6A
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Glide", false);
    public static 8h_0<Boolean> 2 = new 8h_0("Strict", false);
    public static 8h_0<Boolean> 3 = new 8h_0("AirStrict", false);
    public static 8h_0<Boolean> 4 = new 8h_0("NCP", false).c(4, 47);
    public static 8h_0<6z_0> 5 = new 8h_0("Webs", 6z_0.c);
    public static 8h_0<Integer> 6 = new 8h_0("ShiftTicks", 1, 10, 1, 1).c(6A::c);
    public boolean 1;
    public boolean 2;
    public boolean 3;

    @Subscriber
    public void c(1N n2) {
        if (6A.c.player == null || 6A.c.world == null) {
            return;
        }
        Item item = 6A.c.player.getActiveItemStack().getItem();
        if (!6A.c.player.isHandActive() && item instanceof ItemFood || item instanceof ItemBow || item instanceof ItemPotion || !(item instanceof ItemFood) || !(item instanceof ItemBow) || !(item instanceof ItemPotion)) {
            if (this.1 && ((Boolean)2.6()).booleanValue()) {
                6A.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6A.c.player, CPacketEntityAction.Action.STOP_SNEAKING));
                this.1 = false;
            }
            if (this.2) {
                this.2 = false;
            }
        }
    }

    @Subscriber
    public void c(1P p2) {
        block2: {
            if (6A.c.world == null || 6A.c.player == null) {
                return;
            }
            if (6A.c.player.getActiveItemStack().getItem() instanceof ItemBow) {
                return;
            }
            if (!((Boolean)4.6()).booleanValue() || !(6A.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemSword) || !4.2()) break block2;
            6A.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
        }
    }

    @Subscriber
    public void c(0N n2) {
        if (6A.c.player.isHandActive() && !6A.c.player.isRiding()) {
            n2.c().moveStrafe *= 5.0f;
            n2.c().moveForward *= 5.0f;
        }
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketPlayer) || !this.2) break block0;
            ((ICPacketPlayer)t.c()).setOnGround(false);
        }
    }

    public 6A() {
        super("NoSlow", "Makes you not slow down while i. e. eating", 3D.0, new String[0]);
    }

    public static boolean c() {
        return 5.6() == 6z_0.1;
    }

    @Subscriber
    public void c(11 var1_1) {
        block2: {
            block3: {
                if (this.3) {
                    return;
                }
                if (5.6() == 6z_0.c) break block2;
                if (5.6() != 6z_0.1 || 6A.c.world.getBlockState(new BlockPos((Entity)6A.c.player)).getBlock() != Blocks.WEB) break block3;
                if (!(var1_1.0() < 0.0)) break block2;
                for (int i2 = 0; i2 < (Integer)6.6(); ++i2) {
                    this.3 = true;
                    6A.c.player.move(var1_1.c(), 0.0, var1_1.0(), 0.0);
                    8z_0.c(6A.c.player.rotationYaw, 6A.c.player.rotationPitch);
                    this.3 = false;
                }
                break block2;
            }
            ((IEntity)6A.c.player).setIsInWeb(false);
        }
    }

    @Subscriber
    public void c(15 var1_1) {
        block6: {
            block7: {
                if (6A.c.player.getActiveItemStack().getItem() instanceof ItemBow) {
                    return;
                }
                if (((Boolean)1.6()).booleanValue()) {
                    if (!this.2) {
                        6A.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(6A.c.player.rotationYaw, 6A.c.player.rotationPitch, false));
                    }
                    this.2 = true;
                }
                if (this.1 || !((Boolean)2.6()).booleanValue()) break block6;
                if (!((Boolean)3.6()).booleanValue() || !6A.c.player.onGround) break block7;
                if (!((Boolean)1.6()).booleanValue()) break block6;
            }
            6A.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6A.c.player, CPacketEntityAction.Action.START_SNEAKING));
            this.1 = true;
        }
    }

    @Subscriber
    public void c(1O o2) {
        block2: {
            if (6A.c.world == null || 6A.c.player == null) {
                return;
            }
            if (6A.c.player.getActiveItemStack().getItem() instanceof ItemBow) {
                return;
            }
            if (!((Boolean)4.6()).booleanValue() || !(6A.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemSword) || !4.2()) break block2;
            6A.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(new BlockPos(-1, -1, -1), EnumFacing.DOWN, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
        }
    }
}

