/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1A;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.util.EnumHand;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4G
extends 3E {
    public static 8h_0<Integer> 1 = new 8h_0("Delay", 0, 20, 0, 1);
    public static 8h_0<Boolean> 2 = new 8h_0("CancelMotion", false);
    public 9m c = new 9m();
    public boolean 1 = false;

    @Subscriber
    public void c(1A a2) {
        if (!this.1) {
            this.c.c();
        }
        if (((Minecraft)4G.c).player == null || ((Minecraft)4G.c).world == null) {
            return;
        }
        if (!(((Minecraft)4G.c).currentScreen instanceof GuiContainer && !(((Minecraft)4G.c).currentScreen instanceof GuiInventory) || ((Minecraft)4G.c).player.getHeldItem(EnumHand.OFF_HAND).getItem() == Items.TOTEM_OF_UNDYING || ((Minecraft)4G.c).player.isCreative())) {
            for (int i2 = 44; i2 >= 9; --i2) {
                if (4G.c.player.inventoryContainer.getSlot(i2).getStack().getItem() != Items.TOTEM_OF_UNDYING) continue;
                this.1 = true;
                if (this.c.c((float)((Integer)1.6()).intValue() * 100.0f) && 4G.c.player.inventory.getItemStack().getItem() != Items.TOTEM_OF_UNDYING) {
                    if (((Boolean)2.6()).booleanValue() && 4G.c.player.motionX * 4G.c.player.motionX + 4G.c.player.motionY * 4G.c.player.motionY + 4G.c.player.motionZ * 4G.c.player.motionZ >= 9.0E-4) {
                        4G.c.player.motionX = 0.0;
                        4G.c.player.motionY = 0.0;
                        4G.c.player.motionZ = 0.0;
                        return;
                    }
                    ((Minecraft)4G.c).playerController.windowClick(0, i2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4G.c).player);
                }
                if (this.c.c((float)((Integer)1.6()).intValue() * 200.0f) && 4G.c.player.inventory.getItemStack().getItem() == Items.TOTEM_OF_UNDYING) {
                    if (((Boolean)2.6()).booleanValue() && 4G.c.player.motionX * 4G.c.player.motionX + 4G.c.player.motionY * 4G.c.player.motionY + 4G.c.player.motionZ * 4G.c.player.motionZ >= 9.0E-4) {
                        4G.c.player.motionX = 0.0;
                        4G.c.player.motionY = 0.0;
                        4G.c.player.motionZ = 0.0;
                        return;
                    }
                    ((Minecraft)4G.c).playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4G.c).player);
                    if (4G.c.player.inventory.getItemStack().isEmpty()) {
                        this.1 = false;
                        return;
                    }
                }
                if (!this.c.c((float)((Integer)1.6()).intValue() * 300.0f) || 4G.c.player.inventory.getItemStack().isEmpty() || ((Minecraft)4G.c).player.getHeldItem(EnumHand.OFF_HAND).getItem() != Items.TOTEM_OF_UNDYING) continue;
                if (((Boolean)2.6()).booleanValue() && 4G.c.player.motionX * 4G.c.player.motionX + 4G.c.player.motionY * 4G.c.player.motionY + 4G.c.player.motionZ * 4G.c.player.motionZ >= 9.0E-4) {
                    4G.c.player.motionX = 0.0;
                    4G.c.player.motionY = 0.0;
                    4G.c.player.motionZ = 0.0;
                    return;
                }
                ((Minecraft)4G.c).playerController.windowClick(0, i2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4G.c).player);
                this.1 = false;
                return;
            }
        }
    }

    public 4G() {
        super("StrictTotem", "Forces totem into offhand", 3D.c, new String[0]);
        this.c(315, 1000);
    }

    @Override
    public void c() {
        this.1 = false;
    }
}

