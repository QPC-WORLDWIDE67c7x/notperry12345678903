/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2j_0;
import me.darki.konas.2l_0;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2k
 * Duplicate member names - consider using --renamedupmembers true
 */
@SideOnly(value=Side.CLIENT)
public class 2k_0
extends 2j_0 {
    public Potion c;
    public int 1;
    public 2l_0 c;

    public 2k_0(2l_0 l_02, int n2, int n3, int n4, Potion potion, int n5) {
        this.c = l_02;
        super(n2, n3, n4, GuiContainer.INVENTORY_BACKGROUND, potion.getStatusIconIndex() % 8 * 18, 198 + potion.getStatusIconIndex() / 8 * 18);
        this.c = potion;
        this.1 = n5;
    }

    public void drawButtonForegroundLayer(int n2, int n3) {
        String string = I18n.format((String)this.c.getName(), (Object[])new Object[0]);
        if (this.1 >= 3 && this.c != MobEffects.REGENERATION) {
            string = string + " II";
        }
        this.c.drawHoveringText(string, n2, n3);
    }

    public static int c(2k_0 k_02) {
        return k_02.1;
    }

    public static Potion 0(2k_0 k_02) {
        return k_02.c;
    }
}

