/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.94;
import me.darki.konas.mixin.mixins.IInventoryPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2O
extends 2E {
    @Override
    public void 5() {
        super.5();
        int n2 = ((IInventoryPlayer)2O.c.player.inventory).getAllInventories().stream().mapToInt(2O::0).sum();
        int n3 = ((IInventoryPlayer)2O.c.player.inventory).getAllInventories().stream().mapToInt(2O::2).sum();
        int n4 = ((IInventoryPlayer)2O.c.player.inventory).getAllInventories().stream().mapToInt(2O::c).sum();
        int n5 = ((IInventoryPlayer)2O.c.player.inventory).getAllInventories().stream().mapToInt(2O::1).sum();
        this.c(new ItemStack(Items.END_CRYSTAL, n2), (int)this.9() + 2, (int)this.3() + 2);
        this.c(new ItemStack(Items.GOLDEN_APPLE, n3, 1), (int)this.9() + 22, (int)this.3() + 2);
        this.c(new ItemStack(Items.TOTEM_OF_UNDYING, n4), (int)this.9() + 2, (int)this.3() + 22);
        this.c(new ItemStack(Items.EXPERIENCE_BOTTLE, n5), (int)this.9() + 22, (int)this.3() + 22);
        94.c(this.9(), this.3(), 21.0f, 21.0f, 1.0f, ((89)this.0.6()).c());
        94.c(this.9() + 21.0f, this.3(), 21.0f, 21.0f, 1.0f, ((89)this.0.6()).c());
        94.c(this.9(), this.3() + 21.0f, 21.0f, 21.0f, 1.0f, ((89)this.0.6()).c());
        94.c(this.9() + 21.0f, this.3() + 21.0f, 21.0f, 21.0f, 1.0f, ((89)this.0.6()).c());
    }

    public 2O() {
        super("ItemGrid", 350.0f, 300.0f, 42.0f, 42.0f);
    }

    public static int 0(NonNullList nonNullList) {
        return nonNullList.stream().filter(2O::0).mapToInt(ItemStack::func_190916_E).sum();
    }

    public static int 2(NonNullList nonNullList) {
        return nonNullList.stream().filter(2O::1).mapToInt(ItemStack::func_190916_E).sum();
    }

    public static boolean 1(ItemStack itemStack) {
        return itemStack.getItem() == Items.GOLDEN_APPLE;
    }

    public static int c(NonNullList nonNullList) {
        return nonNullList.stream().filter(2O::2).mapToInt(ItemStack::func_190916_E).sum();
    }

    public static boolean 2(ItemStack itemStack) {
        return itemStack.getItem() == Items.TOTEM_OF_UNDYING;
    }

    public static int 1(NonNullList nonNullList) {
        return nonNullList.stream().filter(2O::c).mapToInt(ItemStack::func_190916_E).sum();
    }

    public void c(ItemStack itemStack, int n2, int n3) {
        GlStateManager.pushMatrix();
        GlStateManager.enableDepth();
        RenderHelper.enableGUIStandardItemLighting();
        c.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n2, n3);
        c.getRenderItem().renderItemOverlays(2O.c.fontRenderer, itemStack, n2, n3);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
    }

    public static boolean c(ItemStack itemStack) {
        return itemStack.getItem() == Items.EXPERIENCE_BOTTLE;
    }

    public static boolean 0(ItemStack itemStack) {
        return itemStack.getItem() == Items.END_CRYSTAL;
    }
}

