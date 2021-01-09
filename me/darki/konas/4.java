/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.command.SyntaxChunk;
import org.lwjgl.input.Keyboard;

public class 4
extends SyntaxChunk {
    public String c(String string) {
        for (int i2 = 0; i2 < 84; ++i2) {
            int n2 = i2;
            String string2 = Keyboard.getKeyName((int)n2);
            String string3 = string2.toLowerCase();
            String string4 = string;
            String string5 = string4.toLowerCase();
            boolean bl = string3.startsWith(string5);
            if (!bl) continue;
            int n3 = i2;
            try {
                return Keyboard.getKeyName((int)n3);
            }
            catch (NullPointerException nullPointerException) {
                nullPointerException.printStackTrace();
            }
        }
        return string;
    }

    public 4(String string) {
        super(string);
    }
}

