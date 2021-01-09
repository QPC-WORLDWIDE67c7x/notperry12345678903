/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.5V;
import me.darki.konas.8d_0;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.y
 */
public class y_0
extends 2 {
    public static void c(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string + "\n");
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length == 2) {
            if (stringArray[1].equalsIgnoreCase("list")) {
                if (!((8d_0)5V.8.6()).c().isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\n");
                    ((8d_0)5V.8.6()).c().forEach(arg_0 -> y_0.c(stringBuilder, arg_0));
                    8p_0.1(stringBuilder.toString());
                } else {
                    8p_0.1("You dont have any items added :(");
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
            ((8d_0)5V.8.6()).c(stringArray[2]);
        } else if (stringArray[1].equalsIgnoreCase("del")) {
            ((8d_0)5V.8.6()).0(stringArray[2]);
        } else {
            8p_0.1(this.0());
        }
    }

    public y_0() {
        super("nodesync", "Add and remove items from nodesync use whitelist", new SyntaxChunk("<add/del/list>"), new SyntaxChunk("[item]"));
    }
}

