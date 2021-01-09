/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.l
 */
public class l_0
extends SyntaxChunk {
    public String c(String string) {
        if (string.toLowerCase().startsWith("f")) {
            return "future";
        }
        if (string.toLowerCase().startsWith("p")) {
            return "pyro";
        }
        if (string.toLowerCase().startsWith("r")) {
            return "rusherhack";
        }
        return string;
    }

    public l_0(String string) {
        super(string);
    }
}

