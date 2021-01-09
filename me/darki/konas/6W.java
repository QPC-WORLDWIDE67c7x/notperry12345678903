/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Random;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Slot;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6W
extends 3E {
    public 8h_0<Integer> 1 = new 8h_0("Delay", 100, 1000, 1, 1);
    public 8h_0<Boolean> 2 = new 8h_0("Random", false);
    public 9m c = new 9m();

    public boolean c(Container container) {
        int n2;
        boolean bl = true;
        int n3 = n2 = container.inventorySlots.size() == 90 ? 54 : 27;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!container.getSlot(i2).getHasStack()) continue;
            bl = false;
        }
        return bl;
    }

    @Subscriber
    public void c(1N n2) {
        block2: {
            if (!(((Minecraft)6W.c).currentScreen instanceof GuiChest)) break block2;
            GuiChest guiChest = (GuiChest)((Minecraft)6W.c).currentScreen;
            ContainerChest containerChest = (ContainerChest)6W.c.player.openContainer;
            for (int i2 = 0; i2 < containerChest.getLowerChestInventory().getSizeInventory(); ++i2) {
                Slot slot = guiChest.inventorySlots.getSlot(i2);
                if (!slot.getHasStack()) continue;
                Random random = new Random();
                if (!this.c.c((double)((Integer)this.1.6() + ((Boolean)this.2.6() != false ? random.nextInt((Integer)this.1.6()) : 0)))) continue;
                ((Minecraft)6W.c).playerController.windowClick(containerChest.windowId, i2, 0, ClickType.QUICK_MOVE, (EntityPlayer)((Minecraft)6W.c).player);
                this.c.c();
            }
            if (this.c((Container)containerChest)) {
                ((Minecraft)6W.c).player.closeScreen();
            }
        }
    }

    public 6W() {
        super("ChestStealer", "Automatically takes items out of chests", 3D.1, "Looter", "ChestLooter");
    }
}

