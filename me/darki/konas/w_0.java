/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.6;
import me.darki.konas.8Q;
import me.darki.konas.8p_0;
import me.darki.konas.v_0;

/*
 * Renamed from me.darki.konas.w
 */
public class w_0
extends 2 {
    public w_0() {
        super("mute", "Mute or unmute people", new v_0("<add/del/clear/list>"), new 6("[name]"));
    }

    public static void c(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string + "\n");
    }

    @Override
    public void c(String[] stringArray) {
        block13: {
            block12: {
                if (stringArray.length == 2) {
                    if (stringArray[1].equalsIgnoreCase("list")) {
                        if (!8Q.c().isEmpty()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\nMute List:\n");
                            8Q.c().stream().forEach(arg_0 -> w_0.c(stringBuilder, arg_0));
                            8p_0.1(stringBuilder.toString());
                        } else {
                            8p_0.1("You don't have anyone muted");
                        }
                    } else if (stringArray[1].equalsIgnoreCase("clear")) {
                        if (!8Q.c().isEmpty()) {
                            8Q.0();
                            8p_0.1("Cleared your muted list!");
                        } else {
                            8p_0.c("Your muted list is already clear!");
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
                for (String string : 8Q.c()) {
                    if (!string.equalsIgnoreCase(stringArray[2])) continue;
                    8p_0.c("Player \u00c2\u00a7b" + stringArray[2] + "\u00c2\u00a7r is already muted!");
                    return;
                }
                8Q.0(stringArray[2]);
                8p_0.1("Muted \u00c2\u00a7b" + stringArray[2]);
                break block13;
            }
            if (!stringArray[1].equalsIgnoreCase("del")) break block13;
            for (String string : 8Q.c()) {
                if (!string.equalsIgnoreCase(stringArray[2])) continue;
                8Q.1(string);
                8p_0.1("Unmuted \u00c2\u00a7b" + stringArray[2]);
                return;
            }
            8p_0.c("Player \u00c2\u00a7b" + stringArray[2] + "\u00c2\u00a7r is not muted!");
        }
    }
}

