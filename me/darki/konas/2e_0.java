/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.io.IOException;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import me.darki.konas.2a_0;
import me.darki.konas.2d_0;
import me.darki.konas.2f_0;
import me.darki.konas.2g_0;
import me.darki.konas.2h_0;
import me.darki.konas.8S;
import me.darki.konas.8w_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2e
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2e_0
extends GuiScreen {
    public GuiScreen c;
    public String c;
    public GuiButton c;
    public GuiButton 0;
    public LinkedHashSet<2g_0> c;
    public 2h_0 c;
    public String[] c;
    public boolean c = false;

    public void initGui() {
        this.mc = Minecraft.getMinecraft();
        if (this.c == null) {
            2h_0 h_02 = this.c = new 2h_0(this, this.mc, this.width, this.height, 52, this.height - 64, 36);
            ((Object)((Object)h_02)).getClass();
            this.c.forEach(h_02::c);
        }
        this.c.c().forEach(this::0);
        this.c.setDimensions(this.width, this.height, 52, this.height - 64);
        this.c.right = (int)((double)this.width - (double)this.width * 0.025);
        this.c.left = (int)((double)this.width * 0.025);
        this.1();
    }

    public void 0(2g_0 g_02) {
        block0: {
            if (!g_02.c.1() || this.mc.getSession().getProfile().getName().equals(g_02.c.c())) break block0;
            g_02.c.c(false);
        }
    }

    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.c.handleMouseInput();
    }

    public void 1() {
        this.addButton(new GuiButton(0, this.width / 2 + 82, this.height - 28, 72, 20, "Cancel"));
        this.addButton(this.addButton(new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, "Add Account")));
        this.c = this.addButton(new GuiButton(2, this.width / 2 - 154, this.height - 28, 150, 20, "Delete Account"));
        this.0 = this.addButton(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, "Login"));
        this.addButton(new GuiButton(5, this.width / 2 + 4, this.height - 28, 72, 20, "Direct"));
        this.0.enabled = false;
        this.c.enabled = false;
    }

    public void 0() {
        this.c = 8w_0.c();
        this.c = 8S.1();
    }

    public void actionPerformed(GuiButton guiButton) {
        block0: {
            block4: {
                2g_0 g_02;
                block3: {
                    block2: {
                        block1: {
                            if (!guiButton.enabled) break block0;
                            g_02 = this.c.1();
                            if (guiButton.id != 0) break block1;
                            this.mc.displayGuiScreen(this.c);
                            break block0;
                        }
                        if (guiButton.id != 1) break block2;
                        this.mc.displayGuiScreen((GuiScreen)new 2a_0());
                        break block0;
                    }
                    if (guiButton.id != 2) break block3;
                    if (g_02 == null) break block0;
                    g_02.5();
                    break block0;
                }
                if (guiButton.id != 3) break block4;
                if (g_02 == null) break block0;
                2d_0 d_02 = new 2d_0(this, null);
                d_02.start();
                break block0;
            }
            if (guiButton.id != 5) break block0;
            this.mc.displayGuiScreen((GuiScreen)new 2f_0(this));
        }
    }

    public 2h_0 c() {
        return this.c;
    }

    public 2e_0(GuiScreen guiScreen) {
        this.c = guiScreen;
    }

    public void mouseClicked(int n2, int n3, int n4) throws IOException {
        super.mouseClicked(n2, n3, n4);
        this.c.mouseClicked(n2, n3, n4);
    }

    public void c(GuiScreen guiScreen) {
        this.c = guiScreen;
    }

    public void c(@Nullable 2g_0 g_02) {
        boolean bl;
        this.0.enabled = bl = g_02 != null;
        this.c.enabled = bl;
    }

    public void drawScreen(int n2, int n3, float f2) {
        this.drawDefaultBackground();
        this.c.drawScreen(n2, n3, f2);
        this.drawCenteredString(this.fontRenderer, this.c, this.width / 2, 20, 0xFFFFFF);
        if (this.c != null && this.c.length != 0) {
            this.drawString(this.mc.fontRenderer, "Account Server: " + 8S.5(this.c[0]).getSecond() + (String)8S.5(this.c[0]).getFirst(), 2, 2, Color.WHITE.hashCode());
            this.drawString(this.mc.fontRenderer, "Auth Server: " + 8S.5(this.c[1]).getSecond() + (String)8S.5(this.c[1]).getFirst(), 2, this.mc.fontRenderer.FONT_HEIGHT + 2, Color.WHITE.hashCode());
            this.drawString(this.mc.fontRenderer, "Session Server: " + 8S.5(this.c[2]).getSecond() + (String)8S.5(this.c[2]).getFirst(), 2, this.mc.fontRenderer.FONT_HEIGHT * 2 + 2, Color.WHITE.hashCode());
        }
        super.drawScreen(n2, n3, f2);
    }

    public void mouseReleased(int n2, int n3, int n4) {
        super.mouseReleased(n2, n3, n4);
        this.c.mouseReleased(n2, n3, n4);
    }
}

