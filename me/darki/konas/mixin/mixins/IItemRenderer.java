/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ItemRenderer.class}, priority=0x7FFFFFFF)
public interface IItemRenderer {
    @Accessor(value="equippedProgressMainHand")
    public void settEquippedProgressMainHand(float var1);

    @Accessor(value="equippedProgressMainHand")
    public float gettEquippedProgressMainHand();

    @Accessor(value="equippedProgressOffHand")
    public void settEquippedProgressOffHand(float var1);

    @Accessor(value="equippedProgressOffHand")
    public float gettEquippedProgressOffHand();

    @Accessor(value="prevEquippedProgressMainHand")
    public void settPrevEquippedProgressMainHand(float var1);

    @Accessor(value="prevEquippedProgressMainHand")
    public float gettPrevEquippedProgressMainHand();

    @Accessor(value="prevEquippedProgressOffHand")
    public void settPrevEquippedProgressOffHand(float var1);

    @Accessor(value="prevEquippedProgressOffHand")
    public float gettPrevEquippedProgressOffHand();

    @Accessor(value="itemStackMainHand")
    public void settItemStackMainHand(ItemStack var1);

    @Accessor(value="itemStackMainHand")
    public ItemStack gettItemStackMainHand();

    @Accessor(value="itemStackOffHand")
    public void settItemStackOffHand(ItemStack var1);

    @Accessor(value="itemStackOffHand")
    public ItemStack gettItemStackOffHand();
}

