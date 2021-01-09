/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.A
 */
public class a_0
extends SyntaxChunk {
    public String c(String string) {
        if (string.toLowerCase().startsWith("a")) {
            return "add";
        }
        if (string.toLowerCase().startsWith("d")) {
            return "del";
        }
        if (string.toLowerCase().startsWith("c")) {
            return "clear";
        }
        if (string.toLowerCase().startsWith("l")) {
            return "list";
        }
        return string;
    }

    public a_0(String string) {
        super(string);
    }
}

