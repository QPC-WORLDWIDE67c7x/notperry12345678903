/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.j
 */
public class j_0
extends SyntaxChunk {
    public String c(String string) {
        if (string.toLowerCase().startsWith("a")) {
            return "add";
        }
        if (string.toLowerCase().startsWith("d")) {
            return "del";
        }
        if (string.toLowerCase().startsWith("l")) {
            return "list";
        }
        return string;
    }

    public j_0(String string) {
        super(string);
    }
}

