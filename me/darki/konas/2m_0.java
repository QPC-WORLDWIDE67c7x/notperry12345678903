/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.IOException;
import java.util.ArrayList;
import me.darki.konas.2;
import me.darki.konas.3;
import me.darki.konas.command.SyntaxChunk;
import me.darki.konas.mixin.mixins.IGuiTextField;
import net.minecraft.client.gui.GuiChat;
import org.lwjgl.opengl.GL11;

/*
 * Renamed from me.darki.konas.2m
 */
public class 2m_0
extends GuiChat {
    public boolean c = true;

    public void drawScreen(int n2, int n3, float f2) {
        block2: {
            2m_0.drawRect((int)2, (int)(this.height - 14), (int)(this.width - 2), (int)(this.height - 2), (int)Integer.MIN_VALUE);
            int n4 = ((IGuiTextField)this.inputField).getFontRenderer().getStringWidth(this.inputField.getText() + "") + 4;
            int n5 = this.inputField.getEnableBackgroundDrawing() ? this.inputField.y + (this.inputField.height - 8) / 2 : this.inputField.y;
            ((IGuiTextField)this.inputField).getFontRenderer().drawStringWithShadow(this.c(this.inputField.getText()), (float)n4, (float)n5, 0x606060);
            this.inputField.drawTextBox();
            if (!this.c) {
                return;
            }
            boolean bl = GL11.glIsEnabled((int)3042);
            boolean bl2 = GL11.glIsEnabled((int)3553);
            GL11.glDisable((int)3042);
            GL11.glDisable((int)3553);
            GL11.glColor3f((float)1.0f, (float)0.33333334f, (float)1.0f);
            GL11.glLineWidth((float)2.0f);
            GL11.glBegin((int)1);
            int n6 = this.inputField.x - 2;
            int n7 = this.inputField.y - 2;
            int n8 = this.inputField.width;
            int n9 = this.inputField.height;
            GL11.glVertex2d((double)n6, (double)n7);
            GL11.glVertex2d((double)(n6 + n8), (double)n7);
            GL11.glVertex2d((double)(n6 + n8), (double)n7);
            GL11.glVertex2d((double)(n6 + n8), (double)(n7 + n9));
            GL11.glVertex2d((double)(n6 + n8), (double)(n7 + n9));
            GL11.glVertex2d((double)n6, (double)(n7 + n9));
            GL11.glVertex2d((double)n6, (double)(n7 + n9));
            GL11.glVertex2d((double)n6, (double)n7);
            GL11.glEnd();
            if (bl) {
                GL11.glEnable((int)3042);
            }
            if (!bl2) break block2;
            GL11.glEnable((int)3553);
        }
    }

    public 2m_0(String string) {
        super(string);
    }

    public String c(String string) {
        if (this.inputField.getText().length() < 1) {
            return "";
        }
        if (!string.startsWith(2.1())) {
            return "";
        }
        String[] stringArray = this.inputField.getText().split(" ");
        if (stringArray.length > 1 || this.inputField.getText().length() > 2 && this.inputField.getText().endsWith(" ")) {
            2 var3_3 = 3.c(stringArray[0]);
            if (var3_3 != null) {
                ArrayList<SyntaxChunk> arrayList = var3_3.2();
                StringBuilder stringBuilder = new StringBuilder();
                int n2 = 0;
                for (SyntaxChunk syntaxChunk : arrayList) {
                    if (n2 == stringArray.length - 2) {
                        String string2 = syntaxChunk.predict(stringArray[n2 + 1]);
                        int n3 = stringArray[n2 + 1].length();
                        String string3 = string2;
                        int n4 = n3;
                        int n5 = 0;
                        int n6 = Math.max(n4, n5);
                        String string4 = string3.substring(n6);
                        try {
                            string2 = string4;
                        }
                        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                            stringIndexOutOfBoundsException.printStackTrace();
                        }
                        stringBuilder.append(string2);
                    } else if (n2 >= stringArray.length - 1) {
                        stringBuilder.append(" " + syntaxChunk.getName());
                    }
                    ++n2;
                }
                return stringBuilder.toString();
            }
        } else if (stringArray.length == 1) {
            for (2 var4_6 : 3.c()) {
                if (!var4_6.c().toLowerCase().startsWith(stringArray[0].substring(1).toLowerCase())) continue;
                String string5 = var4_6.c();
                string5 = string5.substring(stringArray[0].substring(1).length());
                return string5;
            }
        }
        return "";
    }

    public void keyTyped(char c2, int n2) throws IOException {
        if (n2 == 1) {
            this.mc.displayGuiScreen(null);
        } else if (n2 != 28 && n2 != 156) {
            if (n2 == 200) {
                this.getSentHistory(-1);
            } else if (n2 == 208) {
                this.getSentHistory(1);
            } else if (n2 == 201) {
                this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
            } else if (n2 == 209) {
                this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
            } else if (n2 == 15) {
                if (this.inputField.getText().length() > 1) {
                    String[] stringArray = this.inputField.getText().replaceAll("([\\s])\\1+", "$1").split(" ");
                    System.out.println(stringArray.length);
                    if (stringArray.length > 1) {
                        SyntaxChunk syntaxChunk;
                        2 var4_5 = 3.c(stringArray[0]);
                        if (var4_5 != null && stringArray.length - 2 <= var4_5.2().size() - 1 && (syntaxChunk = var4_5.2().get(stringArray.length - 2)) != null) {
                            String string = stringArray[stringArray.length - 1];
                            String string2 = syntaxChunk.predict(string);
                            String string3 = this.inputField.getText();
                            string3 = string3.substring(0, string3.length() - string.length());
                            string3 = string3.concat(string2);
                            this.inputField.setText(string3);
                        }
                    } else if (stringArray.length == 1) {
                        for (2 var5_8 : 3.c()) {
                            String string = var5_8.c(stringArray[0].substring(1).toLowerCase());
                            if (string == null) continue;
                            this.inputField.setText(2.1() + string);
                            break;
                        }
                    }
                }
            } else {
                this.inputField.textboxKeyTyped(c2, n2);
            }
        } else {
            String string = this.inputField.getText().trim();
            if (!string.isEmpty()) {
                this.sendChatMessage(string);
                this.mc.ingameGUI.getChatGUI().addToSentMessages(string);
            }
            this.mc.displayGuiScreen(null);
        }
        this.c = this.inputField.getText().replaceAll(" ", "").startsWith(2.1());
    }
}

