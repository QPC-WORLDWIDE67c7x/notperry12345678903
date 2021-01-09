/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ConcurrentModificationException;
import me.darki.konas.23;
import me.darki.konas.3P;
import me.darki.konas.8l_0;
import me.darki.konas.8m_0;
import me.darki.konas.8n_0;
import me.darki.konas.8o_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.text.ITextComponent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8p
 */
@Deprecated
public class 8p_0 {
    public static String c = "&7[&5Konas&7]&f ";

    public static void c(String string, int n2) {
        StringBuilder stringBuilder;
        8o_0 o_02;
        block26: {
            block25: {
                if (Minecraft.getMinecraft().world == null) break block25;
                if (Minecraft.getMinecraft().player != null) break block26;
            }
            return;
        }
        Minecraft minecraft = Minecraft.getMinecraft();
        GuiIngame guiIngame = minecraft.ingameGUI;
        GuiNewChat guiNewChat = guiIngame.getChatGUI();
        8o_0 o_03 = o_02;
        8o_0 o_04 = o_02;
        StringBuilder stringBuilder2 = stringBuilder;
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder2();
        String string2 = "&7[&5Konas&7]&f ";
        StringBuilder stringBuilder4 = stringBuilder3.append(string2);
        String string3 = string;
        String string4 = "\u00c2\u00a7";
        String string5 = "\u00a7";
        String string6 = string3.replaceAll(string4, string5);
        StringBuilder stringBuilder5 = stringBuilder4.append(string6);
        String string7 = stringBuilder5.toString();
        o_03(string7);
        int n3 = n2;
        try {
            guiNewChat.printChatMessageWithOptionalDeletion((ITextComponent)o_04, n3);
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            Minecraft.getMinecraft().player.sendMessage((ITextComponent)new 8m_0("&7[&5Konas&7]&f " + string.replaceAll("\u00c2\u00a7", "\u00a7")));
        }
    }

    public static void 1(String string) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            return;
        }
        if (23.c && ((Boolean)3P.1.6()).booleanValue()) {
            8p_0.c(string, 4444);
            return;
        }
        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new 8l_0("&7[&5Konas&7]&f " + string.replaceAll("\u00c2\u00a7", "\u00a7")));
    }

    public static void c(String string) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            return;
        }
        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new 8n_0("&7[&5Konas&7]&f &c" + string.replaceAll("\u00c2\u00a7", "\u00a7")));
    }

    public static void 0(String string) {
        8p_0.c(string, 69420);
    }
}

