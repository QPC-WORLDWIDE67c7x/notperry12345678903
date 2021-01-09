/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/*
 * Renamed from me.darki.konas.5t
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5t_0
extends 3E {
    public 8h_0<Float> 1;
    public 8h_0<Float> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Boolean> 4;
    public int 1;
    public boolean 1 = true;
    public boolean 2 = false;

    public int c() {
        int n2 = -1;
        float f2 = 0.0f;
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                ItemStack itemStack = 5t_0.c.player.inventory.getStackInSlot(i2);
                if (!(itemStack.getItem() instanceof ItemFood)) continue;
                if (((Boolean)this.4.6()).booleanValue() && itemStack.getItem() == Items.GOLDEN_APPLE) {
                    n2 = i2;
                    break;
                }
                float f3 = ((ItemFood)itemStack.getItem()).getHealAmount(itemStack);
                if (!(f3 > f2)) continue;
                f2 = f3;
                n2 = i2;
            }
        }
        return n2;
    }

    @Subscriber
    public void c(1N n2) {
        if (5t_0.c.player == null || 5t_0.c.world == null) {
            return;
        }
        if (5t_0.c.player.isCreative()) {
            return;
        }
        if (5t_0.c.player.getHealth() + 5t_0.c.player.getAbsorptionAmount() <= ((Float)this.1.6()).floatValue() || (float)5t_0.c.player.getFoodStats().getFoodLevel() <= ((Float)this.2.6()).floatValue()) {
            if (((Boolean)this.3.6()).booleanValue() && !(5t_0.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemFood) && !(5t_0.c.player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemFood)) {
                int n3 = this.c();
                if (this.1) {
                    this.1 = 5t_0.c.player.inventory.currentItem;
                    this.1 = false;
                }
                if (n3 != -1) {
                    5t_0.c.player.inventory.currentItem = n3;
                    5t_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
                }
            }
            if (5t_0.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemFood) {
                if (5t_0.c.currentScreen == null || 5t_0.c.currentScreen instanceof GuiInventory) {
                    KeyBinding.setKeyBindState((int)5t_0.c.gameSettings.keyBindUseItem.getKeyCode(), (boolean)true);
                    this.2 = true;
                } else {
                    5t_0.c.playerController.processRightClick((EntityPlayer)5t_0.c.player, (World)5t_0.c.world, EnumHand.MAIN_HAND);
                }
            } else if (5t_0.c.player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemFood) {
                if (5t_0.c.currentScreen == null || 5t_0.c.currentScreen instanceof GuiInventory) {
                    KeyBinding.setKeyBindState((int)5t_0.c.gameSettings.keyBindUseItem.getKeyCode(), (boolean)true);
                    this.2 = true;
                } else {
                    5t_0.c.playerController.processRightClick((EntityPlayer)5t_0.c.player, (World)5t_0.c.world, EnumHand.OFF_HAND);
                }
            } else if (5t_0.c.currentScreen == null || 5t_0.c.currentScreen instanceof GuiInventory) {
                KeyBinding.setKeyBindState((int)5t_0.c.gameSettings.keyBindUseItem.getKeyCode(), (boolean)GameSettings.isKeyDown((KeyBinding)5t_0.c.gameSettings.keyBindUseItem));
            }
        } else {
            if (this.2) {
                KeyBinding.setKeyBindState((int)5t_0.c.gameSettings.keyBindUseItem.getKeyCode(), (boolean)GameSettings.isKeyDown((KeyBinding)5t_0.c.gameSettings.keyBindUseItem));
                this.2 = false;
            }
            if (this.1 != -1) {
                5t_0.c.player.inventory.currentItem = this.1;
                5t_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
                this.1 = -1;
                this.1 = true;
            }
        }
    }

    public 5t_0() {
        super("AutoEat", 3D.3, "AutoFood");
        this.3 = new 8h_0("AutoSwitch", true);
        this.4 = new 8h_0("PreferGaps", false);
    }
}

