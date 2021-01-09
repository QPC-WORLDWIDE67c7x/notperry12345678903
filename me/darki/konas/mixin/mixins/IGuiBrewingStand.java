/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.inventory.IInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiBrewingStand.class})
public interface IGuiBrewingStand {
    @Accessor(value="tileBrewingStand")
    public IInventory getTileBrewingStand();
}

