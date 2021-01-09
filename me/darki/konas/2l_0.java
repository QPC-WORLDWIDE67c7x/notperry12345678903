/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.IOException;
import me.darki.konas.2k_0;
import me.darki.konas.4K;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.IInventory;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/*
 * Renamed from me.darki.konas.2l
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2l_0
extends GuiBeacon {
    public static ResourceLocation c = new ResourceLocation("textures/gui/container/beacon.png");
    public static Potion[][] c = new Potion[][]{{MobEffects.SPEED, MobEffects.HASTE}, {MobEffects.RESISTANCE, MobEffects.JUMP_BOOST}, {MobEffects.STRENGTH}, {MobEffects.REGENERATION}};
    public boolean c;

    public void initGui() {
        super.initGui();
        this.c = true;
    }

    public 2l_0(InventoryPlayer inventoryPlayer, IInventory iInventory) {
        super(inventoryPlayer, iInventory);
    }

    public void updateScreen() {
        super.updateScreen();
        if (this.c) {
            int n2 = 20;
            int n3 = this.guiTop;
            Potion[][] potionArray = c;
            int n4 = potionArray.length;
            for (int i2 = 0; i2 < n4; ++i2) {
                Potion[] potionArray2;
                for (Potion potion : potionArray2 = potionArray[i2]) {
                    2k_0 k_02 = new 2k_0(this, n2, this.guiLeft - 27, n3, potion, 0);
                    this.buttonList.add(k_02);
                    if (potion == Potion.getPotionById((int)4K.1)) {
                        k_02.c(true);
                    }
                    n3 += 27;
                    ++n2;
                }
            }
        }
    }

    public void actionPerformed(@NotNull GuiButton guiButton) throws IOException {
        block2: {
            super.actionPerformed(guiButton);
            if (!(guiButton instanceof 2k_0)) break block2;
            2k_0 k_02 = (2k_0)guiButton;
            if (k_02.c()) {
                return;
            }
            int n2 = Potion.getIdFromPotion((Potion)2k_0.0(k_02));
            if (2k_0.c(k_02) < 3) {
                4K.1 = n2;
            }
            this.buttonList.clear();
            this.initGui();
            this.updateScreen();
        }
    }

    public static ResourceLocation access$200() {
        return c;
    }
}

