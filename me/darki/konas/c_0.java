/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.C
 */
public class c_0
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.1(this.0());
            return;
        }
        2.3(stringArray[1]);
        8p_0.1("Set Prefix to &b" + c_0.1());
    }

    public c_0() {
        super("prefix", "Set the command prefix", new SyntaxChunk("<prefix>"));
    }
}

