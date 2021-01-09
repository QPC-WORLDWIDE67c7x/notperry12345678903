/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.IOException;
import me.darki.konas.29;
import me.darki.konas.2e_0;
import me.darki.konas.2g_0;
import me.darki.konas.2i_0;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

/*
 * Renamed from me.darki.konas.2f
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2f_0
extends GuiScreen {
    public 2e_0 c;
    public GuiTextField c;
    public 2i_0 c;
    public boolean c;

    public void mouseClicked(int n2, int n3, int n4) throws IOException {
        super.mouseClicked(n2, n3, n4);
        this.c.mouseClicked(n2, n3, n4);
        this.c.c(n2, n3, n4);
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

    public void updateScreen() {
        this.c.updateCursorCounter();
        this.c.b();
    }

    public void drawScreen(int n2, int n3, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Direct Login", this.width / 2, 17, 0xFFFFFF);
        this.drawString(this.fontRenderer, "Username", this.width / 2 - 100, 53, 0xA0A0A0);
        this.drawString(this.fontRenderer, "Password", this.width / 2 - 100, 94, 0xA0A0A0);
        if (this.c) {
            this.drawCenteredString(this.fontRenderer, TextFormatting.DARK_RED + "Invalid Credentials", this.width / 2, this.height / 4 + 96, 0xFFFFFF);
        }
        this.c.drawTextBox();
        this.c.c();
        super.drawScreen(n2, n3, f2);
    }

    public 2f_0(2e_0 e_02) {
        this.c = e_02;
    }

    public void actionPerformed(GuiButton guiButton) {
        block4: {
            block5: {
                if (!guiButton.enabled) break block4;
                if (guiButton.id != 1) break block5;
                this.mc.displayGuiScreen((GuiScreen)this.c);
                break block4;
            }
            if (guiButton.id != 0) break block4;
            if (this.c.getText().isEmpty()) {
                return;
            }
            if (this.c.d().isEmpty()) {
                29 var2_2 = new 29(this.c.getText().trim(), this.c.d().trim(), false, false);
                2g_0 g_02 = new 2g_0(var2_2);
                g_02.3();
            } else {
                29 var2_3 = new 29(this.c.getText().trim(), this.c.d().trim(), true, false);
                2g_0 g_03 = new 2g_0(var2_3);
                if (!g_03.c()) {
                    this.c = true;
                    return;
                }
                g_03.4();
            }
            this.mc.displayGuiScreen((GuiScreen)this.c);
        }
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public void initGui() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 18, "Login"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 18, "Cancel"));
        this.c = new GuiTextField(2, this.fontRenderer, this.width / 2 - 100, 66, 200, 20);
        this.c = new 2i_0(3, this.fontRenderer, this.width / 2 - 100, 106, 200, 20);
        this.c.setFocused(true);
    }
}

