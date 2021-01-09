/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import me.darki.konas.2;
import me.darki.konas.6;
import me.darki.konas.8p_0;
import me.darki.konas.a_0;

/*
 * Renamed from me.darki.konas.B
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class b_0
extends 2 {
    public static ArrayList<String> 0 = new ArrayList();

    @Override
    public void c(String[] stringArray) {
        block13: {
            block12: {
                if (stringArray.length == 2) {
                    if (stringArray[1].equalsIgnoreCase("list")) {
                        if (!0.isEmpty()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\nParty List:\n");
                            0.stream().forEach(arg_0 -> b_0.c(stringBuilder, arg_0));
                            8p_0.1(stringBuilder.toString());
                        } else {
                            8p_0.1("There is no one in your party");
                        }
                    } else if (stringArray[1].equalsIgnoreCase("clear")) {
                        if (!0.isEmpty()) {
                            0.clear();
                            8p_0.1("Cleared your party!");
                        } else {
                            8p_0.c("Your party is already empty!");
                        }
                    } else {
                        8p_0.c("Invalid Argument. Check syntax");
                    }
                    return;
                }
                if (stringArray.length != this.2().size() + 1) {
                    8p_0.1(this.0());
                    return;
                }
                if (!stringArray[1].equalsIgnoreCase("add")) break block12;
                for (String string : 0) {
                    if (!string.equalsIgnoreCase(stringArray[2])) continue;
                    8p_0.c("Player \u00c2\u00a7b" + stringArray[2] + "\u00c2\u00a7r is already in your party!");
                    return;
                }
                0.add(stringArray[2]);
                8p_0.1("Added \u00c2\u00a7b" + stringArray[2] + "\u00c2\u00a7r to your party!");
                break block13;
            }
            if (!stringArray[1].equalsIgnoreCase("del")) break block13;
            for (String string : 0) {
                if (!string.equalsIgnoreCase(stringArray[2])) continue;
                0.remove(string);
                8p_0.1("Deleted \u00c2\u00a7b" + stringArray[2] + "\u00c2\u00a7r from your party");
                return;
            }
            8p_0.c("Player \u00c2\u00a7b" + stringArray[2] + "\u00c2\u00a7r is not in your party!");
        }
    }

    public b_0() {
        super("party", "Add or Remove People to/from your party", new a_0("<add/del/clear/list>"), new 6("[name]"));
    }

    public static void c(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string + "\n");
    }
}

