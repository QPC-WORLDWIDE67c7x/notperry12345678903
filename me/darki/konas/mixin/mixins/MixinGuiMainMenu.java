/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import me.darki.konas.8k_0;
import me.darki.konas.mixin.mixins.IGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiMainMenu.class})
public abstract class MixinGuiMainMenu
extends GuiScreen {
    @Shadow
    private GuiButton realmsButton;
    @Shadow
    private GuiButton modButton;

    @Inject(method={"actionPerformed"}, at={@At(value="RETURN")})
    public void displayAltManager(GuiButton button, CallbackInfo ci) {
        if (button.id == 8) {
            8k_0.c.c.c(this);
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)8k_0.c.c);
        } else if (button.id == 69420 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://discord.gg/gpVZ4Y6cpq"));
            }
            catch (IOException | URISyntaxException exception) {
                // empty catch block
            }
        }
    }

    @Inject(method={"addSingleplayerMultiplayerButtons"}, at={@At(value="HEAD")}, cancellable=true)
    public void addAllButtons(int p_73969_1_, int p_73969_2_, CallbackInfo ci) {
        IGuiScreen screen = (IGuiScreen)((Object)this);
        List<GuiButton> buttonList = screen.getButtonList();
        buttonList.add(new GuiButton(1, ((GuiScreen)this).width / 2 - 100, p_73969_1_, 98, 20, I18n.format((String)"menu.singleplayer", (Object[])new Object[0])));
        buttonList.add(new GuiButton(69420, ((GuiScreen)this).width / 2 + 2, p_73969_1_, 98, 20, "Discord"));
        buttonList.add(new GuiButton(2, ((GuiScreen)this).width / 2 - 100, p_73969_1_ + p_73969_2_, 98, 20, I18n.format((String)"menu.multiplayer", (Object[])new Object[0])));
        buttonList.add(new GuiButton(8, ((GuiScreen)this).width / 2 + 2, p_73969_1_ + p_73969_2_, 98, 20, "Alt Manager"));
        this.realmsButton = new GuiButton(14, ((GuiScreen)this).width / 2 + 2, p_73969_1_ + p_73969_2_ * 2, 98, 20, I18n.format((String)"menu.online", (Object[])new Object[0]).replace("Minecraft", "").trim());
        buttonList.add(this.realmsButton);
        this.modButton = new GuiButton(6, ((GuiScreen)this).width / 2 - 100, p_73969_1_ + p_73969_2_ * 2, 98, 20, I18n.format((String)"fml.menu.mods", (Object[])new Object[0]));
        buttonList.add(this.modButton);
        screen.setButtonList(buttonList);
        ci.cancel();
    }
}

