/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.command.SyntaxChunk;

public class 5
extends SyntaxChunk {
    public 5(String string) {
        super(string);
    }

    public String c(String string) {
        for (3E e2 : 3F.2()) {
            if (e2.b().toLowerCase().startsWith(string.toLowerCase())) {
                return e2.b();
            }
            for (String string2 : e2.1()) {
                if (!string2.toLowerCase().startsWith(string.toLowerCase())) continue;
                return string2;
            }
        }
        return string;
    }
}

