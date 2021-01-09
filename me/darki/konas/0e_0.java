/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.0e
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 0e_0 {
    public ItemStack c;
    public EntityPlayer c;

    public void c(ItemStack itemStack) {
        this.c = itemStack;
    }

    public ItemStack 0() {
        return this.c;
    }

    public 0e_0(ItemStack itemStack, EntityPlayer entityPlayer) {
        this.c = itemStack;
        this.c = entityPlayer;
    }

    public void c(EntityPlayer entityPlayer) {
        this.c = entityPlayer;
    }

    public EntityPlayer c() {
        return this.c;
    }
}

