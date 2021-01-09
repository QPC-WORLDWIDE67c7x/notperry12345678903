/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.72;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 73
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("ItemSaver", false);
    public static 8h_0<Boolean> 2 = new 8h_0("HandOnly", false);
    public 8h_0<Integer> 3 = new 8h_0("RefillThreshold", 36, 64, 1, 1);
    public 8h_0<Integer> 4 = new 8h_0("Delay", 1, 20, 1, 1);
    public static 8h_0<Boolean> 5 = new 8h_0("Crystals", true);
    public static 8h_0<Boolean> 6 = new 8h_0("EXp", true);
    public static 8h_0<Boolean> 7 = new 8h_0("Food", true);
    public static 8h_0<Boolean> 8 = new 8h_0("Others", false);
    public ConcurrentHashMap<ItemStack, Integer> c;
    public int 1 = 0;
    public 9m c = new 9m();

    @Subscriber
    public void c(1N n2) {
        int n3;
        if (((Minecraft)73.c).player == null || ((Minecraft)73.c).world == null || ((Minecraft)73.c).currentScreen instanceof GuiContainer || n2.c() == TickEvent.Phase.START) {
            return;
        }
        if (!this.c.c(350.0)) {
            return;
        }
        if (((Boolean)1.6()).booleanValue()) {
            n3 = 0;
            EnumHand[] enumHandArray = EnumHand.values();
            block4: for (int i2 = 0; i2 < enumHandArray.length; ++i2) {
                EnumHand enumHand = enumHandArray[i2];
                ItemStack itemStack = ((Minecraft)73.c).player.getHeldItem(enumHand);
                if (itemStack == null || itemStack.getItem() == null) continue;
                Item item = itemStack.getItem();
                if (!itemStack.isItemStackDamageable() || itemStack.getItemDamage() != item.getMaxDamage(itemStack)) continue;
                switch (72.c[enumHand.ordinal()]) {
                    case 1: {
                        ((Minecraft)73.c).playerController.windowClick(73.c.player.inventoryContainer.windowId, 73.c.player.inventory.currentItem + 36, 0, ClickType.QUICK_MOVE, (EntityPlayer)((Minecraft)73.c).player);
                        n3 = 1;
                        continue block4;
                    }
                    case 2: {
                        ((Minecraft)73.c).playerController.windowClick(73.c.player.inventoryContainer.windowId, 45, 1, ClickType.QUICK_MOVE, (EntityPlayer)((Minecraft)73.c).player);
                        n3 = 1;
                    }
                }
            }
            if (n3 != 0) {
                this.1 = 0;
                return;
            }
        }
        if (this.1 > (Integer)this.4.6() * 2) {
            if (!73.c.player.inventory.getItemStack().isEmpty()) {
                for (n3 = 44; n3 >= 9; --n3) {
                    if (!73.c.player.inventoryContainer.getSlot(n3).getStack().isEmpty()) continue;
                    ((Minecraft)73.c).playerController.windowClick(0, n3, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)73.c).player);
                    return;
                }
            }
            this.0();
            this.1();
            this.1 = 0;
        } else {
            ++this.1;
        }
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketClickWindow)) break block0;
            this.c.c();
        }
    }

    public boolean c() {
        for (int i2 = 0; i2 < 36; ++i2) {
            if (73.c.player.inventoryContainer.getSlot(i2).getHasStack()) continue;
            return true;
        }
        return false;
    }

    public void 1() {
        for (Map.Entry<ItemStack, Integer> entry : this.c.entrySet()) {
            ItemStack itemStack = entry.getKey();
            int n2 = entry.getValue();
            if (73.c.player.inventory.getSlotFor(itemStack) == -1) continue;
            int n3 = -1;
            for (int i2 = 9; i2 <= 35; ++i2) {
                ItemStack itemStack2 = 73.c.player.inventory.getStackInSlot(i2);
                if (!itemStack2.getItem().equals(itemStack.getItem())) continue;
                if (!itemStack2.getDisplayName().equals(itemStack.getDisplayName()) || itemStack2.getItemDamage() != itemStack.getItemDamage()) continue;
                n3 = i2;
                break;
            }
            if (n3 == -1) continue;
            ((Minecraft)73.c).playerController.windowClick(0, n3, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)73.c).player);
            ((Minecraft)73.c).playerController.windowClick(0, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)73.c).player);
            ((Minecraft)73.c).playerController.windowClick(0, n3, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)73.c).player);
            this.c.remove(itemStack);
        }
    }

    public void 0() {
        for (int i2 = 0; i2 <= 9; ++i2) {
            ItemStack itemStack;
            if (((Boolean)2.6()).booleanValue() && i2 != 73.c.player.inventory.currentItem || (itemStack = 73.c.player.inventory.getStackInSlot(i2)).isEmpty() || itemStack.getItem() == Items.AIR || !itemStack.isStackable() || itemStack.getCount() >= itemStack.getMaxStackSize() || itemStack.getCount() >= (Integer)this.3.6() || !((Boolean)8.6() != false || itemStack.getItem() instanceof ItemEndCrystal && (Boolean)5.6() != false || itemStack.getItem() instanceof ItemFood && (Boolean)7.6() != false) && (!(itemStack.getItem() instanceof ItemExpBottle) || !((Boolean)6.6()).booleanValue())) continue;
            this.c.put(itemStack, i2);
        }
    }

    public 73() {
        super("HotbarRefill", "Automatically refills your hotbar", 3D.1, new String[0]);
    }
}

