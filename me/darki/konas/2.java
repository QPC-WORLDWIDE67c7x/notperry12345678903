/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.Collections;
import me.darki.konas.command.SyntaxChunk;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class 2 {
    public String c;
    public String 0;
    public String[] c;
    public ArrayList<SyntaxChunk> c = new ArrayList();
    public static String 1 = ".";
    public static char c = (char)167;
    public static Minecraft c = Minecraft.getMinecraft();

    public String c() {
        return this.c;
    }

    public String 3() {
        return this.0;
    }

    public boolean 0(String string) {
        if (this.c.equalsIgnoreCase(string)) {
            return true;
        }
        for (String string2 : this.c) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    public 2(String string, String string2, SyntaxChunk ... syntaxChunkArray) {
        this.c = string;
        this.0 = string2;
        this.c = new String[0];
        Collections.addAll(this.c, syntaxChunkArray);
    }

    public 2(String string, String string2, String[] stringArray, SyntaxChunk ... syntaxChunkArray) {
        this.c = string;
        this.0 = string2;
        this.c = stringArray;
        Collections.addAll(this.c, syntaxChunkArray);
    }

    public ArrayList<SyntaxChunk> 2() {
        return this.c;
    }

    public static String 1() {
        return 1;
    }

    public String 0() {
        StringBuilder stringBuilder = new StringBuilder();
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> 2.c(stringBuilder, arg_0));
        return stringBuilder.toString();
    }

    public void c(String[] stringArray) {
    }

    public String[] 4() {
        return this.c;
    }

    public static void c(StringBuilder stringBuilder, SyntaxChunk syntaxChunk) {
        stringBuilder.append(syntaxChunk.getName() + " ");
    }

    public void 0(String[] stringArray) {
        this.c = stringArray;
    }

    public void 2(String string) {
        this.0 = string;
    }

    public static void 3(String string) {
        1 = string;
    }

    public void 1(String string) {
        this.c = string;
    }

    public String c(String string) {
        if (this.c.toLowerCase().startsWith(string)) {
            return this.c;
        }
        for (String string2 : this.c) {
            if (!string2.toLowerCase().startsWith(string)) continue;
            return string2;
        }
        return null;
    }
}

