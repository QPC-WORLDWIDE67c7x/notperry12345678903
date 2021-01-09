/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2E;
import me.darki.konas.2P;
import me.darki.konas.8h_0;
import me.darki.konas.96;
import me.darki.konas.9c;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2Q
extends 2E {
    public 8h_0<2P> 1 = new 8h_0("Background", 2P.c);

    @Override
    public void 5() {
        int n2;
        int n3;
        int n4;
        int n5;
        super.5();
        if (this.1.6() == 2P.c) {
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            c.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/generic_54.png"));
            2Q.c.ingameGUI.drawTexturedModalRect(this.9(), this.3(), 7, 17, 162, 54);
        }
        GlStateManager.clear((int)256);
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 9; ++n4) {
                n3 = (int)(this.9() + 1.0f + (float)(n4 * 18));
                n2 = (int)(this.3() + 1.0f + (float)(n5 * 18));
                if (this.1.6() != 2P.0) continue;
                Gui.drawRect((int)(n3 - 1), (int)(n2 - 1), (int)(n3 - 1 + 18), (int)(n2 - 1 + 18), (int)new Color(26, 26, 26, 40).hashCode());
                96.c(n3 - 1, n2 - 1, n3 - 1 + 18, n2 - 1 + 18, 2.0f, 9c.c(300, new float[]{1.0f, 1.0f, 1.0f}));
            }
        }
        n5 = 2Q.c.player.inventory.mainInventory.size();
        for (n4 = 9; n4 < n5; ++n4) {
            n3 = (int)(this.9() + 1.0f + (float)(n4 % 9 * 18));
            n2 = (int)(this.3() + 1.0f + (float)((n4 / 9 - 1) * 18));
            GlStateManager.pushMatrix();
            GlStateManager.enableDepth();
            RenderHelper.enableGUIStandardItemLighting();
            c.getRenderItem().renderItemAndEffectIntoGUI((ItemStack)2Q.c.player.inventory.mainInventory.get(n4), n3, n2);
            c.getRenderItem().renderItemOverlays(2Q.c.fontRenderer, (ItemStack)2Q.c.player.inventory.mainInventory.get(n4), n3, n2);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableDepth();
            GlStateManager.popMatrix();
        }
    }

    public 2Q() {
        super("Inventory", 400.0f, 400.0f, 162.0f, 54.0f);
    }
}

