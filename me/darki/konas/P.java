/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.KonasMod;
import me.darki.konas.command.SyntaxChunk;

public class P
extends 2 {
    public P() {
        super("watermark", "Change the watermark", new SyntaxChunk("<watermark>"));
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.1(this.0());
            return;
        }
        KonasMod.WATERMARK = stringArray[1];
        8p_0.1("Set Watermark to &b" + stringArray[1]);
    }
}

