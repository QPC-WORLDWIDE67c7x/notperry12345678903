/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.mojang.authlib.GameProfile;
import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5K;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IInventoryPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5L
extends 3E {
    public static 8h_0<5K> 1 = new 8h_0("SpawnMode", 5K.0);
    public static 8h_0<Boolean> 2 = new 8h_0("CopyInventory", false);
    public List<Integer> c = null;
    public static String[][] c = new String[][]{{"66666666-6666-6666-6666-666666666600", "soulbond", "-3", "0"}, {"66666666-6666-6666-6666-666666666601", "derp1", "0", "-3"}, {"66666666-6666-6666-6666-666666666602", "derp2", "3", "0"}, {"66666666-6666-6666-6666-666666666603", "derp3", "0", "3"}, {"66666666-6666-6666-6666-666666666604", "derp4", "-6", "0"}, {"66666666-6666-6666-6666-666666666605", "derp5", "0", "-6"}, {"66666666-6666-6666-6666-666666666606", "derp6", "6", "0"}, {"66666666-6666-6666-6666-666666666607", "derp7", "0", "6"}, {"66666666-6666-6666-6666-666666666608", "derp8", "-9", "0"}, {"66666666-6666-6666-6666-666666666609", "derp9", "0", "-9"}, {"66666666-6666-6666-6666-666666666610", "derp10", "9", "0"}, {"66666666-6666-6666-6666-666666666611", "derp11", "0", "9"}};

    public void c(String string, String string2, int n2, int n3, int n4) {
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP((World)((Minecraft)5L.c).world, new GameProfile(UUID.fromString(string), string2));
        entityOtherPlayerMP.copyLocationAndAnglesFrom((Entity)((Minecraft)5L.c).player);
        entityOtherPlayerMP.posX += (double)n3;
        entityOtherPlayerMP.posZ += (double)n4;
        if (((Boolean)2.6()).booleanValue()) {
            ((IInventoryPlayer)entityOtherPlayerMP.inventory).setArmorInventory((NonNullList<ItemStack>)5L.c.player.inventory.armorInventory);
            ((IInventoryPlayer)entityOtherPlayerMP.inventory).setMainInventory((NonNullList<ItemStack>)5L.c.player.inventory.mainInventory);
            entityOtherPlayerMP.inventory.currentItem = 5L.c.player.inventory.currentItem;
            entityOtherPlayerMP.setHeldItem(EnumHand.MAIN_HAND, ((Minecraft)5L.c).player.getHeldItemMainhand());
            entityOtherPlayerMP.setHeldItem(EnumHand.OFF_HAND, ((Minecraft)5L.c).player.getHeldItemOffhand());
        }
        ((Minecraft)5L.c).world.addEntityToWorld(n2, (Entity)entityOtherPlayerMP);
        this.c.add(n2);
    }

    public 5L() {
        super("FakePlayer", 3D.3, "Ghosts");
    }

    @Subscriber
    public void c(1N n2) {
        block0: {
            if (this.c != null && !this.c.isEmpty()) break block0;
            this.d();
        }
    }

    @Override
    public void c() {
        if (((Minecraft)5L.c).player == null || ((Minecraft)5L.c).world == null) {
            this.d();
            return;
        }
        this.c = new ArrayList<Integer>();
        int n2 = -101;
        for (String[] stringArray : c) {
            if (((5K)((Object)1.6())).equals((Object)5K.c)) {
                this.c(stringArray[0], stringArray[1], n2, 0, 0);
                break;
            }
            this.c(stringArray[0], stringArray[1], n2, Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3]));
            --n2;
        }
    }

    @Override
    public void 7() {
        if (((Minecraft)5L.c).player == null || ((Minecraft)5L.c).world == null) {
            return;
        }
        if (this.c != null) {
            for (int n2 : this.c) {
                ((Minecraft)5L.c).world.removeEntityFromWorld(n2);
            }
        }
    }
}

