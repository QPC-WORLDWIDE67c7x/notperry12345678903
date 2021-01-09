/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.File;
import me.darki.konas.2;
import me.darki.konas.3F;
import me.darki.konas.5;
import me.darki.konas.8t_0;
import me.darki.konas.T;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.t
 */
public class t_0
extends 2 {
    public t_0() {
        super("moduleconfig", "Load or save specific modules", new String[]{"mc"}, new SyntaxChunk("<load/save>"), new 5("<module/friends>"), new SyntaxChunk("<config/default>"));
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8t_0.1(this.0(), new Object[0]);
            return;
        }
        File file = new File(T.1, stringArray[3] + ".json");
        if (stringArray[3].equalsIgnoreCase("default")) {
            file = T.0;
        }
        switch (stringArray[1].toLowerCase()) {
            case "save": {
                if (!file.exists()) {
                    8t_0.1("Config (h)%s(r) doesn't exist!", stringArray[3]);
                    return;
                }
                if (stringArray[2].equalsIgnoreCase("friends")) {
                    T.c(file);
                    8t_0.0("Saved Friends to Config (h)%s", stringArray[3]);
                    break;
                }
                if (3F.c(stringArray[2]) == null) {
                    8t_0.1("Module (h)%s(r) is invalid!", stringArray[2]);
                }
                T.c(3F.c(stringArray[2]), file);
                8t_0.0("Saved Module (h)%s(r) to Config (h)%s", stringArray[2], stringArray[3]);
                break;
            }
            case "load": {
                if (!file.exists()) {
                    8t_0.1("Config (h)%s(r) doesn't exist!", stringArray[3]);
                    return;
                }
                if (stringArray[2].equalsIgnoreCase("friends")) {
                    T.4(file);
                    8t_0.0("Loaded Friends from Config (h)%s", stringArray[3]);
                    break;
                }
                if (3F.c(stringArray[2]) == null) {
                    8t_0.1("Module (h)%s(r) is invalid", stringArray[2]);
                }
                T.0(3F.c(stringArray[2]), file);
                8t_0.0("Loaded Module (h)%s(r) from Config (h)%s", stringArray[2], stringArray[3]);
                break;
            }
            default: {
                8t_0.1(this.0(), new Object[0]);
                break;
            }
        }
    }
}

