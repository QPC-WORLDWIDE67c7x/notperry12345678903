/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.85;
import me.darki.konas.88;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

public class R
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length == 2) {
            if (stringArray[1].equalsIgnoreCase("list")) {
                if (!((88)85.1.6()).c().isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\n");
                    ((88)85.1.6()).c().forEach(arg_0 -> R.c(stringBuilder, arg_0));
                    8p_0.1(stringBuilder.toString());
                } else {
                    8p_0.1("You dont have any blocks added :(");
                }
            } else {
                8p_0.1(this.0());
            }
            return;
        }
        if (stringArray.length != this.2().size() + 1) {
            8p_0.1(this.0());
            return;
        }
        if (stringArray[1].equalsIgnoreCase("add")) {
            if (((88)85.1.6()).0(stringArray[2])) {
                8p_0.1("Added Block &b" + stringArray[2]);
                R.c.renderGlobal.loadRenderers();
            } else {
                8p_0.c("Couldn't find block &b" + stringArray[2]);
            }
        } else if (stringArray[1].equalsIgnoreCase("del")) {
            if (((88)85.1.6()).1(stringArray[2])) {
                8p_0.1("Removed Block &b" + stringArray[2]);
                R.c.renderGlobal.loadRenderers();
            } else {
                8p_0.c("Couldn't find block &b" + stringArray[2]);
            }
        } else {
            8p_0.1(this.0());
        }
        ((88)85.1.6()).1();
    }

    public static void c(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string + "\n");
    }

    public R() {
        super("xray", "Add and remove blocks from xray", new SyntaxChunk("<add/del/list>"), new SyntaxChunk("[block]"));
    }
}

