/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.Arrays;
import me.darki.konas.2;
import me.darki.konas.3B;
import me.darki.konas.3C;
import me.darki.konas.4;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;
import org.lwjgl.input.Keyboard;

/*
 * Renamed from me.darki.konas.s
 */
public class s_0
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length == 2) {
            if (stringArray[1].equals("list")) {
                8p_0.1("&bMacros:");
                8p_0.1(" ");
                3C.0().forEach(s_0::c);
            } else {
                8p_0.1(this.0());
            }
        } else if (stringArray.length == 3) {
            if (stringArray[1].equals("remove")) {
                if (3C.c(stringArray[2]) != null) {
                    3B b2 = 3C.c(stringArray[2]);
                    3C.c(b2);
                    8p_0.1("Removed Macro &b" + b2.2());
                } else {
                    8p_0.c("Couldnt find Macro &b" + stringArray[2]);
                }
            } else {
                8p_0.1(this.0());
            }
        } else if (stringArray.length >= 5) {
            if (stringArray[1].equals("add")) {
                String string = stringArray[2];
                String string2 = stringArray[3].toUpperCase();
                String string3 = String.join((CharSequence)" ", Arrays.copyOfRange(stringArray, 4, stringArray.length));
                if (Keyboard.getKeyIndex((String)string2) == 0) {
                    8p_0.c("Please specify a valid keybind!");
                    return;
                }
                3B b3 = new 3B(string, string3, Keyboard.getKeyIndex((String)string2));
                3C.0(b3);
                8p_0.1("Added Macro &b" + string + " &fwith Bind &b" + Keyboard.getKeyName((int)b3.c()));
            } else {
                8p_0.1(this.0());
            }
        } else {
            8p_0.1(this.0());
        }
    }

    public s_0() {
        super("macro", "Macro", new SyntaxChunk("<add/remove/list>"), new SyntaxChunk("<name>"), new 4("[bind]"), new SyntaxChunk("[text]"));
    }

    public static void c(3B b2) {
        8p_0.1(b2.2() + (b2.c() != 0 ? " [&b" + Keyboard.getKeyName((int)b2.c()) + "&f]" : "") + " {&b" + b2.1() + "&f}");
    }
}

