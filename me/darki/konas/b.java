/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.3;
import me.darki.konas.8t_0;
import me.darki.konas.command.SyntaxChunk;

public class b
extends 2 {
    public static void c(2 var0) {
        8t_0.0("%s (h)%s(r)" + (var0.3() != null ? "() -> %s" : ""), var0.c(), var0.0(), var0.3());
    }

    @Override
    public void c(String[] stringArray) {
        8t_0.0("(b)Commands:", new Object[0]);
        8t_0.c();
        3.c().forEach(b::c);
    }

    public b() {
        super("commands", "List all commands", new SyntaxChunk[0]);
    }
}

