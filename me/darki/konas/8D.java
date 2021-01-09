/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.item.ItemStack;

public class 8D {
    public static float c(ItemStack itemStack) {
        float f2 = itemStack.getMaxDamage() - itemStack.getItemDamage();
        return f2 / (float)itemStack.getMaxDamage() * 100.0f;
    }
}

