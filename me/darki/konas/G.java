/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.command.SyntaxChunk;

public class G
extends 2 {
    public static boolean c = false;

    public G() {
        super("seizure", "Gives you a seizure", new SyntaxChunk[0]);
    }

    @Override
    public void c(String[] stringArray) {
        c = true;
    }
}

