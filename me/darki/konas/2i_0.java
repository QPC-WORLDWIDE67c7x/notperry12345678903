/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2i
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2i_0
extends Gui {
    public int c;
    public FontRenderer c;
    public int 0;
    public int 1;
    public int 2;
    public int 3;
    public String c;
    public int 4 = 256;
    public int 5;
    public boolean c;
    public boolean 0 = true;
    public boolean 1;
    public boolean 2 = true;
    public int 6;
    public int 7;
    public int 8;
    public int 9 = 0xE0E0E0;
    public int a = 0x707070;
    public boolean 3 = true;
    public GuiPageButtonList.GuiResponder c;
    public Predicate<String> c = (int)Predicates.alwaysTrue();

    public boolean a() {
        return this.c;
    }

    public void 0(int n2) {
        this.c(this.8 + n2);
    }

    public boolean 4() {
        return this.1;
    }

    public int c(int n2, int n3, boolean bl) {
        int n4 = n3;
        boolean bl2 = n2 < 0;
        int n5 = Math.abs(n2);
        for (int i2 = 0; i2 < n5; ++i2) {
            if (!bl2) {
                int n6 = this.c.length();
                if ((n4 = this.c.indexOf(32, n4)) == -1) {
                    n4 = n6;
                    continue;
                }
                while (bl && n4 < n6 && this.c.charAt(n4) == ' ') {
                    ++n4;
                }
                continue;
            }
            while (bl && n4 > 0 && this.c.charAt(n4 - 1) == ' ') {
                --n4;
            }
            while (n4 > 0 && this.c.charAt(n4 - 1) != ' ') {
                --n4;
            }
        }
        return n4;
    }

    public void 6(int n2) {
        this.9 = n2;
    }

    public boolean c(int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = bl = n2 >= this.0 && n2 < this.0 + this.2 && n3 >= this.1 && n3 < this.1 + this.3;
        if (this.0) {
            this.1(bl);
        }
        if (this.1 && bl && n4 == 0) {
            int n5 = n2 - this.0;
            if (this.c) {
                n5 -= 4;
            }
            String string = this.c.trimStringToWidth(this.c.substring(this.6), this.0());
            this.c(this.c.trimStringToWidth(string, n5).length() + this.6);
            return true;
        }
        return false;
    }

    public void 0(String string) {
        block4: {
            int n2;
            String string2 = "";
            String string3 = ChatAllowedCharacters.filterAllowedCharacters((String)string);
            int n3 = this.7 < this.8 ? this.7 : this.8;
            int n4 = this.7 < this.8 ? this.8 : this.7;
            int n5 = this.4 - this.c.length() - (n3 - n4);
            if (!this.c.isEmpty()) {
                string2 = string2 + this.c.substring(0, n3);
            }
            if (n5 < string3.length()) {
                string2 = string2 + string3.substring(0, n5);
                n2 = n5;
            } else {
                string2 = string2 + string3;
                n2 = string3.length();
            }
            if (!this.c.isEmpty() && n4 < this.c.length()) {
                string2 = string2 + this.c.substring(n4);
            }
            if (!this.c.apply((Object)string2)) break block4;
            this.c = string2;
            this.0(n3 - this.8 + n2);
            this.c(this.c, this.c);
        }
    }

    public void 1(boolean bl) {
        block1: {
            if (bl && !this.1) {
                this.5 = 0;
            }
            this.1 = bl;
            if (Minecraft.getMinecraft().currentScreen == null) break block1;
            Minecraft.getMinecraft().currentScreen.setFocused(bl);
        }
    }

    public void 7() {
        this.c(0);
    }

    public int 3() {
        return this.4;
    }

    public 2i_0(int n2, FontRenderer fontRenderer, int n3, int n4, int n5, int n6) {
        this.c = n2;
        this.c = fontRenderer;
        this.0 = n3;
        this.1 = n4;
        this.2 = n5;
        this.3 = n6;
    }

    public int c(int n2, int n3) {
        return this.c(n2, n3, true);
    }

    public void b() {
        ++this.5;
    }

    public int 1(int n2) {
        return this.c(n2, this.6());
    }

    public void c(String string) {
        block0: {
            if (!this.c.apply((Object)string)) break block0;
            this.c = string.length() > this.4 ? string.substring(0, this.4) : string;
            this.1();
        }
    }

    public void 2(int n2) {
        block2: {
            if (this.c.isEmpty()) break block2;
            if (this.8 != this.7) {
                this.0("");
            } else {
                this.5(this.1(n2) - this.7);
            }
        }
    }

    public int 5() {
        return this.c;
    }

    public void 7(int n2) {
        this.4 = n2;
        if (this.c.length() > n2) {
            this.c = this.c.substring(0, n2);
        }
    }

    public void 0(boolean bl) {
        this.2 = bl;
    }

    public void c(int n2, String string) {
        block0: {
            if (this.c == null) break block0;
            this.c.setEntryValue(n2, string);
        }
    }

    public boolean c(char c2, int n2) {
        if (!this.1) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA((int)n2)) {
            this.1();
            this.3(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC((int)n2)) {
            GuiScreen.setClipboardString((String)this.9());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV((int)n2)) {
            if (this.2) {
                this.0(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX((int)n2)) {
            GuiScreen.setClipboardString((String)this.9());
            if (this.2) {
                this.0("");
            }
            return true;
        }
        switch (n2) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.2) {
                        this.2(-1);
                    }
                } else if (this.2) {
                    this.5(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.3(0);
                } else {
                    this.7();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.3(this.c(-1, this.2()));
                    } else {
                        this.3(this.2() - 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.c(this.1(-1));
                } else {
                    this.0(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.3(this.c(1, this.2()));
                    } else {
                        this.3(this.2() + 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.c(this.1(1));
                } else {
                    this.0(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.3(this.c.length());
                } else {
                    this.1();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.2) {
                        this.2(1);
                    }
                } else if (this.2) {
                    this.5(1);
                }
                return true;
            }
        }
        if (ChatAllowedCharacters.isAllowedCharacter((char)c2)) {
            if (this.2) {
                this.0(Character.toString(c2));
            }
            return true;
        }
        return false;
    }

    public void 2(boolean bl) {
        this.3 = bl;
    }

    public String 9() {
        int n2 = this.7 < this.8 ? this.7 : this.8;
        int n3 = this.7 < this.8 ? this.8 : this.7;
        return this.c.substring(n2, n3);
    }

    public String d() {
        return this.c;
    }

    public void c(int n2, int n3, int n4, int n5) {
        int n6;
        if (n2 < n4) {
            n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        if (n3 < n5) {
            n6 = n3;
            n3 = n5;
            n5 = n6;
        }
        if (n4 > this.0 + this.2) {
            n4 = this.0 + this.2;
        }
        if (n2 > this.0 + this.2) {
            n2 = this.0 + this.2;
        }
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.color((float)0.0f, (float)0.0f, (float)255.0f, (float)255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp((GlStateManager.LogicOp)GlStateManager.LogicOp.OR_REVERSE);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)n2, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n3, 0.0).endVertex();
        bufferBuilder.pos((double)n2, (double)n3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }

    public int 0() {
        return this.a() ? this.2 - 8 : this.2;
    }

    public int 6() {
        return this.7;
    }

    public void c(GuiPageButtonList.GuiResponder guiResponder) {
        this.c = guiResponder;
    }

    public void c(Predicate<String> predicate) {
        this.c = (int)predicate;
    }

    public int 2() {
        return this.8;
    }

    public void c(int n2) {
        this.7 = n2;
        int n3 = this.c.length();
        this.7 = MathHelper.clamp((int)this.7, (int)0, (int)n3);
        this.3(this.7);
    }

    public void 5(int n2) {
        block3: {
            block4: {
                if (this.c.isEmpty()) break block3;
                if (this.8 == this.7) break block4;
                this.0("");
                break block3;
            }
            boolean bl = n2 < 0;
            int n3 = bl ? this.7 + n2 : this.7;
            int n4 = bl ? this.7 : this.7 + n2;
            String string = "";
            if (n3 >= 0) {
                string = this.c.substring(0, n3);
            }
            if (n4 < this.c.length()) {
                string = string + this.c.substring(n4);
            }
            if (!this.c.apply((Object)string)) break block3;
            this.c = string;
            if (bl) {
                this.0(n2);
            }
            this.c(this.c, this.c);
        }
    }

    public void 3(boolean bl) {
        this.c = bl;
    }

    public void c() {
        block11: {
            if (!this.8()) break block11;
            if (this.a()) {
                2i_0.drawRect((int)(this.0 - 1), (int)(this.1 - 1), (int)(this.0 + this.2 + 1), (int)(this.1 + this.3 + 1), (int)-6250336);
                2i_0.drawRect((int)this.0, (int)this.1, (int)(this.0 + this.2), (int)(this.1 + this.3), (int)-16777216);
            }
            int n2 = this.2 ? this.9 : this.a;
            int n3 = this.7 - this.6;
            int n4 = this.8 - this.6;
            String string = this.c.trimStringToWidth(this.c.substring(this.6), this.0());
            boolean bl = n3 >= 0 && n3 <= string.length();
            boolean bl2 = this.1 && this.5 / 6 % 2 == 0 && bl;
            int n5 = this.c ? this.0 + 4 : this.0;
            int n6 = this.c ? this.1 + (this.3 - 8) / 2 : this.1;
            int n7 = n5;
            if (n4 > string.length()) {
                n4 = string.length();
            }
            if (!string.isEmpty()) {
                String string2 = bl ? string.substring(0, n3) : string;
                n7 = this.c.drawStringWithShadow(string2.replaceAll(".", "*"), (float)n5, (float)n6, n2);
            }
            boolean bl3 = this.7 < this.c.length() || this.c.length() >= this.3();
            int n8 = n7;
            if (!bl) {
                n8 = n3 > 0 ? n5 + this.2 : n5;
            } else if (bl3) {
                n8 = n7 - 1;
                --n7;
            }
            if (!string.isEmpty() && bl && n3 < string.length()) {
                n7 = this.c.drawStringWithShadow(string.replaceAll(".", "*").substring(n3), (float)n7, (float)n6, n2);
            }
            if (bl2) {
                if (bl3) {
                    Gui.drawRect((int)n8, (int)(n6 - 1), (int)(n8 + 1), (int)(n6 + 1 + this.c.FONT_HEIGHT), (int)-3092272);
                } else {
                    this.c.drawStringWithShadow("_", (float)n8, (float)n6, n2);
                }
            }
            if (n4 != n3) {
                int n9 = n5 + this.c.getStringWidth(string.replaceAll(".", "*").substring(0, n4));
                this.c(n8, n6 - 1, n9 - 1, n6 + 1 + this.c.FONT_HEIGHT);
            }
        }
    }

    public boolean 8() {
        return this.3;
    }

    public void 3(int n2) {
        int n3 = this.c.length();
        if (n2 > n3) {
            n2 = n3;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        this.8 = n2;
        if (this.c != null) {
            if (this.6 > n3) {
                this.6 = n3;
            }
            int n4 = this.0();
            String string = this.c.trimStringToWidth(this.c.substring(this.6), n4);
            int n5 = string.length() + this.6;
            if (n2 == this.6) {
                this.6 -= this.c.trimStringToWidth(this.c, n4, true).length();
            }
            if (n2 > n5) {
                this.6 += n2 - n5;
            } else if (n2 <= this.6) {
                this.6 -= this.6 - n2;
            }
            this.6 = MathHelper.clamp((int)this.6, (int)0, (int)n3);
        }
    }

    public void c(boolean bl) {
        this.0 = bl;
    }

    public void 4(int n2) {
        this.a = n2;
    }

    public void 1() {
        this.c(this.c.length());
    }
}

