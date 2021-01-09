/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiTextField.class})
public interface IGuiTextField {
    @Accessor(value="fontRenderer")
    public FontRenderer getFontRenderer();

    @Accessor(value="maxStringLength")
    public void setMaxStringLength(int var1);
}

