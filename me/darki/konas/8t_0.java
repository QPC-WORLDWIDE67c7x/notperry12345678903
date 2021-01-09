/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.darki.konas.8s_0;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8t
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8t_0 {
    public static Minecraft c = Minecraft.getMinecraft();
    public static String c = ChatFormatting.GRAY + "[" + ChatFormatting.DARK_PURPLE + "Konas" + ChatFormatting.GRAY + "] " + ChatFormatting.RESET;

    public static void c(String string, Object ... objectArray) {
        8t_0.0(0, ChatFormatting.YELLOW, string, objectArray);
    }

    public static String c(String string, ChatFormatting chatFormatting, Object ... objectArray) {
        String string2 = String.format(string, objectArray);
        string2 = string2.replaceAll("\\(h\\)", ChatFormatting.AQUA.toString());
        string2 = string2.replaceAll("\\(b\\)", ChatFormatting.BOLD.toString());
        string2 = string2.replaceAll("\\(ul\\)", ChatFormatting.UNDERLINE.toString());
        string2 = string2.replaceAll("\\(r\\)", chatFormatting.toString());
        return string2;
    }

    public static void c(ChatFormatting chatFormatting, String string, Object ... objectArray) {
        8t_0.c(0, chatFormatting, string, objectArray);
    }

    public static void c() {
        8t_0.0(0, ChatFormatting.WHITE, "", new Object[0]);
    }

    public static void 0(int n2, ChatFormatting chatFormatting, String string, Object ... objectArray) {
        if (8t_0.c.world == null) {
            return;
        }
        String string2 = c;
        if (chatFormatting != null) {
            string2 = string2 + chatFormatting.toString();
        }
        string2 = string2 + 8t_0.c(string, chatFormatting, objectArray);
        8t_0.c.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion((ITextComponent)new 8s_0(string2), n2);
    }

    public static void 0(String string, Object ... objectArray) {
        8t_0.0(0, ChatFormatting.WHITE, string, objectArray);
    }

    public static void 1(String string, Object ... objectArray) {
        8t_0.0(0, ChatFormatting.RED, string, objectArray);
    }

    public static void c(int n2, String string, Object ... objectArray) {
        8t_0.c(n2, ChatFormatting.WHITE, string, objectArray);
    }

    public static void c(int n2, ChatFormatting chatFormatting, String string, Object ... objectArray) {
        8t_0.0(n2, chatFormatting, string, objectArray);
    }
}

