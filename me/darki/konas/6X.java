/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.1C;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.88;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IMinecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemFood;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.math.BlockPos;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6X
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("FastXP", true);
    public static 8h_0<Boolean> 2 = new 8h_0("GhostFix", false);
    public static 8h_0<Boolean> 3 = new 8h_0("Strict", false);
    public static 8h_0<Boolean> 4 = new 8h_0("PacketEat", false);
    public static 8h_0<Boolean> 5 = new 8h_0("FastBow", false);
    public static 8h_0<Boolean> 6 = new 8h_0("BowBomb", false).c(5::6);
    public static 8h_0<Boolean> 7 = new 8h_0("FastPlace", false);
    public static 8h_0<Boolean> 8 = new 8h_0("NoCrystalPlace", false);
    public static 8h_0<Boolean> 9 = new 8h_0("PlaceWhitelist", false);
    public static 8h_0<88> a = new 8h_0("Whitelist", new 88(new String[0]));
    public static boolean 1 = false;

    public boolean c() {
        Item item = 6X.c.player.getHeldItemMainhand().getItem();
        Item item2 = 6X.c.player.getHeldItemOffhand().getItem();
        if (((Boolean)1.6()).booleanValue() && (item instanceof ItemExpBottle || item2 instanceof ItemExpBottle)) {
            return true;
        }
        if (((Boolean)7.6()).booleanValue()) {
            if (item instanceof ItemBlock && (((88)a.6()).0().contains(((ItemBlock)item).getBlock()) || !((Boolean)9.6()).booleanValue())) {
                ((IMinecraft)c).setRightClickDelayTimer(0);
                return true;
            }
            if (item2 instanceof ItemBlock && (((88)a.6()).0().contains(((ItemBlock)item2).getBlock()) || !((Boolean)9.6()).booleanValue())) {
                ((IMinecraft)c).setRightClickDelayTimer(0);
                return true;
            }
        }
        if (item instanceof ItemFood) {
            ((IMinecraft)c).setRightClickDelayTimer(0);
            return true;
        }
        return false;
    }

    @Subscriber
    public void c(0T t) {
        block4: {
            block3: {
                if (6X.c.player == null || 6X.c.world == null) {
                    return;
                }
                if (!((Boolean)2.6()).booleanValue() || !(6X.c.player.getHeldItemMainhand().getItem() instanceof ItemExpBottle) && !(6X.c.player.getHeldItemMainhand().getItem() instanceof ItemBoat)) break block3;
                if (!(t.c() instanceof CPacketPlayerTryUseItemOnBlock)) break block4;
                t.c();
                break block4;
            }
            if (!((Boolean)8.6()).booleanValue() || !(t.c() instanceof CPacketPlayerTryUseItemOnBlock) || !(6X.c.player.getHeldItem(((CPacketPlayerTryUseItemOnBlock)t.c()).getHand()).getItem() instanceof ItemEndCrystal)) break block4;
            if (1) {
                1 = false;
            } else {
                t.c(true);
            }
        }
    }

    public 6X() {
        super("FastUse", "Removes item use delay", 3D.1, "FastXP", "FastBow", "FastPlace");
    }

    @Subscriber
    public void c(1N n2) {
        block4: {
            if (6X.c.world == null || 6X.c.player == null) {
                return;
            }
            if (((Boolean)3.6()).booleanValue() && 6X.c.player.ticksExisted % 2 == 0) {
                return;
            }
            if (((Boolean)5.6()).booleanValue() && 6X.c.player.inventory.getCurrentItem().getItem() instanceof ItemBow && 6X.c.player.isHandActive() && 6X.c.player.getItemInUseMaxCount() >= 3) {
                6X.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, 6X.c.player.getHorizontalFacing()));
                if (((Boolean)6.6()).booleanValue() && 6X.c.gameSettings.keyBindUseItem.isKeyDown()) {
                    6X.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(6X.c.player.posX, 6X.c.player.posY - 0.1, 6X.c.player.posZ, 6X.c.player.rotationYaw, 6X.c.player.rotationPitch, false));
                    6X.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(6X.c.player.posX, 6X.c.player.posY - 999.0, 6X.c.player.posZ, 6X.c.player.rotationYaw, 6X.c.player.rotationPitch, true));
                }
                6X.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(6X.c.player.getActiveHand()));
                6X.c.player.stopActiveHand();
                return;
            }
            if (!this.c() || ((IMinecraft)c).getRightClickDelayTimer() == 0) break block4;
            ((IMinecraft)c).setRightClickDelayTimer(0);
        }
    }

    @Subscriber
    public void c(1C c2) {
        block0: {
            if (!(6X.c.player.getHeldItem(6X.c.player.getActiveHand()).getItem() instanceof ItemFood) || !((Boolean)4.6()).booleanValue()) break block0;
            c2.c(true);
        }
    }
}

