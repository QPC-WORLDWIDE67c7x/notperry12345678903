/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.6X;
import me.darki.konas.88;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.h
 */
public class h_0
extends 2 {
    public static void c(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string + "\n");
    }

    public h_0() {
        super("fastplace", "Add and remove blocks from fastplace whitelist", new SyntaxChunk("<add/del/list>"), new SyntaxChunk("[block]"));
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length == 2) {
            if (stringArray[1].equalsIgnoreCase("list")) {
                if (!((88)6X.a.6()).c().isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\n");
                    ((88)6X.a.6()).c().forEach(arg_0 -> h_0.c(stringBuilder, arg_0));
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
            ((88)6X.a.6()).0(stringArray[2]);
        } else if (stringArray[1].equalsIgnoreCase("del")) {
            ((88)6X.a.6()).1(stringArray[2]);
        } else {
            8p_0.1(this.0());
        }
        ((88)6X.a.6()).1();
    }
}

