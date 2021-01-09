/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.67;
import me.darki.konas.8i_0;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

public class J
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length == this.2().size()) {
            if (stringArray[1].equalsIgnoreCase("list")) {
                if (((8i_0)67.2.6()).c().isEmpty()) {
                    8p_0.1("You don't have any spammer files loaded");
                } else {
                    8p_0.1("Spammer Files:");
                    for (String string : ((8i_0)67.2.6()).c()) {
                        8p_0.1(string);
                    }
                }
                return;
            }
        }
        if (stringArray.length != this.2().size() + 1) {
            8p_0.c(this.0());
            return;
        }
        if (stringArray[1].equalsIgnoreCase("add")) {
            String string = stringArray[2].replaceAll(".txt", "") + ".txt";
            if (((8i_0)67.2.6()).c().contains(string)) {
                8p_0.1("This Spammer File has already been added!");
                return;
            }
            ((8i_0)67.2.6()).c(string);
            8p_0.1("Added Spammer File: \u00c2\u00a7b" + string);
        } else if (stringArray[1].equalsIgnoreCase("del")) {
            String string = stringArray[2].replaceAll(".txt", "") + ".txt";
            if (!((8i_0)67.2.6()).c().contains(string)) {
                8p_0.1("Couldn't find this Spammer File!");
                return;
            }
            ((8i_0)67.2.6()).0(string);
            8p_0.1("Deleted Spammer File: \u00c2\u00a7b" + string);
        } else {
            8p_0.c(this.0());
        }
    }

    public J() {
        super("spammer", "Load spammer files", new SyntaxChunk("<add/del/list>"), new SyntaxChunk("<name>"));
    }
}

