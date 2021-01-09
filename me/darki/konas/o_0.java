/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.o
 */
public class o_0
extends 2 {
    public o_0() {
        super("Grab", "Copies your current coords to your clipboard", new String[]{"Coords", "CopyCoords", "CopyPos", "CopyPosition"}, new SyntaxChunk[0]);
    }

    @Override
    public void c(String[] stringArray) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(Math.round(o_0.c.player.posX) + ", " + Math.round(o_0.c.player.posY) + ", " + Math.round(o_0.c.player.posZ));
        clipboard.setContents(stringSelection, null);
        8p_0.1("Copied coords to clipboard!");
    }
}

