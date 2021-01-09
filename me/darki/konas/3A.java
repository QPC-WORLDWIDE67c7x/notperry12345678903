/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.Iterator;
import java.util.List;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IGuiDisconnected;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3A
extends GuiScreen {
    public String c;
    public ITextComponent c;
    public List<String> c;
    public GuiScreen c;
    public int c;
    public ServerData c;
    public 9m c;
    public int 0;

    public void c() {
        this.mc.displayGuiScreen((GuiScreen)new GuiConnecting(this.c, this.mc, this.c == null ? this.mc.getCurrentServerData() : this.c));
    }

    public void initGui() {
        this.buttonList.clear();
        this.c = this.fontRenderer.listFormattedStringToWidth(this.c.getFormattedText(), this.width - 50);
        this.c = this.c.size() * this.fontRenderer.FONT_HEIGHT;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, Math.min(this.height / 2 + this.c / 2 + this.fontRenderer.FONT_HEIGHT, this.height - 30), I18n.format((String)"gui.toMenu", (Object[])new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, (int)Math.min((double)this.height / 1.85 + (double)this.c / 1.85 + (double)this.fontRenderer.FONT_HEIGHT, (double)(this.height + 80)), "Reconnect"));
    }

    public void keyTyped(char c2, int n2) {
    }

    public void actionPerformed(GuiButton guiButton) {
        switch (guiButton.id) {
            case 0: {
                this.mc.displayGuiScreen(this.c);
                break;
            }
            case 1: {
                this.c();
                break;
            }
        }
    }

    public void drawScreen(int n2, int n3, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.c, this.width / 2, this.height / 2 - this.c / 2 - this.fontRenderer.FONT_HEIGHT * 2, 0xAAAAAA);
        int n4 = this.height / 2 - this.c / 2;
        if (this.c != null) {
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                this.drawCenteredString(this.fontRenderer, string, this.width / 2, n4, 0xFFFFFF);
                n4 += this.fontRenderer.FONT_HEIGHT;
            }
        }
        if (this.c.c((double)(this.0 * 1000))) {
            this.c();
        }
        float f3 = (float)this.0 - (float)(System.currentTimeMillis() - this.c.0()) / 1000.0f;
        ((GuiButton)this.buttonList.get((int)1)).displayString = "Reconnecting: " + Math.round(f3);
        super.drawScreen(n2, n3, f2);
    }

    public 3A(GuiDisconnected guiDisconnected, ServerData serverData, int n2) {
        this.c = ((IGuiDisconnected)guiDisconnected).getParentScreen();
        this.c = ((IGuiDisconnected)guiDisconnected).getReason();
        this.c = ((IGuiDisconnected)guiDisconnected).getMessage();
        this.c = serverData;
        this.c = new 9m();
        this.0 = n2;
    }
}

