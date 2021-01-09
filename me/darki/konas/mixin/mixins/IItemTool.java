/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.item.ItemTool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ItemTool.class})
public interface IItemTool {
    @Accessor(value="attackDamage")
    public float getAttackDamage();
}

