/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import me.darki.konas.29;
import me.darki.konas.2g_0;
import me.darki.konas.2i_0;
import me.darki.konas.8k_0;
import me.darki.konas.mixin.mixins.IGuiTextField;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

/*
 * Renamed from me.darki.konas.2a
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2a_0
extends GuiScreen {
    public GuiTextField c;
    public 2i_0 c;
    public boolean c;
    public boolean 0;

    public void updateScreen() {
        this.c.updateCursorCounter();
        this.c.b();
    }

    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            if (guiButton.id == 1) {
                this.mc.displayGuiScreen((GuiScreen)8k_0.c.c);
            } else if (guiButton.id == 0) {
                2g_0 g_02;
                if (this.c.getText().isEmpty()) {
                    return;
                }
                if (this.c.d().isEmpty()) {
                    29 var2_2 = new 29(this.c.getText().trim(), this.c.d().trim(), false, false);
                    g_02 = new 2g_0(var2_2);
                    g_02.3();
                } else {
                    29 var2_3 = new 29(this.c.getText().trim(), this.c.d().trim(), true, false);
                    g_02 = new 2g_0(var2_3);
                    if (!g_02.c()) {
                        this.c = true;
                        return;
                    }
                    g_02.4();
                }
                8k_0.c.c.c().c(g_02);
                this.mc.displayGuiScreen((GuiScreen)8k_0.c.c);
            } else if (guiButton.id == 3) {
                if (this.c.getText().isEmpty()) {
                    return;
                }
                if (this.c.d().isEmpty()) {
                    this.c = true;
                } else {
                    29 var2_4 = new 29(this.c.getText().trim(), this.c.d().trim(), true, true);
                    2g_0 g_03 = new 2g_0(var2_4);
                    if (!g_03.0()) {
                        this.c = true;
                        this.0 = true;
                        return;
                    }
                    g_03.4();
                    8k_0.c.c.c().c(g_03);
                    this.mc.displayGuiScreen((GuiScreen)8k_0.c.c);
                }
            } else if (guiButton.id == 5 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                URI uRI;
                Desktop desktop = Desktop.getDesktop();
                URI uRI2 = uRI;
                URI uRI3 = uRI;
                String string = "https://login.live.com/oauth20_authorize.srf?redirect_uri=https://login.live.com/oauth20_desktop.srf&scope=service::user.auth.xboxlive.com::MBI_SSL&display=touch&response_type=code&locale=en&client_id=00000000402b5328";
                uRI2(string);
                try {
                    desktop.browse(uRI3);
                }
                catch (IOException | URISyntaxException exception) {
                    // empty catch block
                }
            }
        }
    }

    public void drawScreen(int n2, int n3, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Add Account", this.width / 2, 17, 0xFFFFFF);
        this.drawString(this.fontRenderer, "Username", this.width / 2 - 100, 53, 0xA0A0A0);
        this.drawString(this.fontRenderer, "Password", this.width / 2 - 100, 94, 0xA0A0A0);
        if (this.c) {
            this.drawCenteredString(this.fontRenderer, TextFormatting.DARK_RED + "Invalid Credentials", this.width / 2, this.height / 4 + 96, 0xFFFFFF);
        }
        if (this.0) {
            ((GuiButton)this.buttonList.get((int)3)).visible = true;
        }
        this.c.drawTextBox();
        this.c.c();
        super.drawScreen(n2, n3, f2);
    }

    public void keyTyped(char c2, int n2) {
        block3: {
            block2: {
                if (!this.c.isFocused()) break block2;
                this.c.textboxKeyTyped(c2, n2);
                if (n2 == 28 || n2 == 156) {
                    this.actionPerformed((GuiButton)this.buttonList.get(0));
                }
                if (n2 != 15) break block3;
                this.c.1(true);
                this.c.setFocused(false);
                break block3;
            }
            if (!this.c.4()) break block3;
            this.c.c(c2, n2);
            if (n2 == 28 || n2 == 156) {
                this.actionPerformed((GuiButton)this.buttonList.get(0));
            }
        }
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public void initGui() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 18, "Add"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 4 + 120 + 18, "Add through Microsoft"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 144 + 18, "Cancel"));
        this.buttonList.add(new GuiButton(5, this.width / 2 - 100, this.height / 4 + 168 + 18, "Login through browser"));
        ((GuiButton)this.buttonList.get((int)3)).visible = false;
        this.c = new GuiTextField(2, this.fontRenderer, this.width / 2 - 100, 66, 200, 20);
        ((IGuiTextField)this.c).setMaxStringLength(320);
        this.c = new 2i_0(3, this.fontRenderer, this.width / 2 - 100, 106, 200, 20);
        this.c.setFocused(true);
    }

    public void mouseClicked(int n2, int n3, int n4) throws IOException {
        super.mouseClicked(n2, n3, n4);
        this.c.mouseClicked(n2, n3, n4);
        this.c.c(n2, n3, n4);
    }
}

