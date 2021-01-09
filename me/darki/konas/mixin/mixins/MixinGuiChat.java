/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.2;
import me.darki.konas.2m_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiChat.class})
public class MixinGuiChat {
    @Shadow
    protected GuiTextField inputField;

    @Inject(method={"keyTyped"}, at={@At(value="RETURN")})
    public void konasChatInject(char charTyped, int keyCode, CallbackInfo ci) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof GuiChat) || Minecraft.getMinecraft().currentScreen instanceof 2m_0) {
            return;
        }
        if (this.inputField.getText().replaceAll(" ", "").startsWith(2.1())) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new 2m_0(this.inputField.getText()));
        }
    }
}

