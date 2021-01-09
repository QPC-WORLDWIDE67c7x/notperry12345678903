/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import java.io.File;
import java.util.List;
import me.darki.konas.3z_0;
import me.darki.konas.mixin.mixins.IGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiMultiplayer.class})
public abstract class MixinGuiMultiplayer
extends GuiScreen {
    @Inject(method={"createButtons"}, at={@At(value="HEAD")}, cancellable=true)
    public void addAllButtons(CallbackInfo ci) {
        IGuiScreen screen = (IGuiScreen)((Object)this);
        List<GuiButton> buttonList = screen.getButtonList();
        if (!new File(Minecraft.getMinecraft().gameDir, "novia").exists()) {
            buttonList.add(new 3z_0(1200, this.width / 2 + 4 + 76 + 76, this.height - 28, 105, 20));
            screen.setButtonList(buttonList);
        }
    }
}

