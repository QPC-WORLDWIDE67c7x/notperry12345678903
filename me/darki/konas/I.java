/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import me.darki.konas.2;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.5;
import me.darki.konas.87;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.8j_0;
import me.darki.konas.8p_0;
import org.lwjgl.input.Keyboard;

public class I
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.1(this.0());
            return;
        }
        if (3F.c(stringArray[1]) == null) {
            8p_0.1("Module not found");
            return;
        }
        3E e2 = 3F.c(stringArray[1]);
        if (3F.1(e2) == null) {
            8p_0.c(e2.b() + " does not have any settings");
            return;
        }
        8p_0.1(e2.b() + "'s Settings:");
        8p_0.1(" ");
        for (8h_0 h_02 : 3F.1(e2)) {
            if (h_02.6() instanceof Enum) {
                ArrayList<String> arrayList = new ArrayList<String>();
                for (Object obj : h_02.6().getClass().getEnumConstants()) {
                    arrayList.add(obj.toString());
                }
                8p_0.1(h_02.c() + " [&b" + h_02.6() + "&f] &b" + arrayList + "&f");
                continue;
            }
            if (h_02.6() instanceof 87) {
                8p_0.1(h_02.c() + " [&b" + Keyboard.getKeyName((int)((87)h_02.6()).c()) + "&f]");
                continue;
            }
            if (h_02.6() instanceof 8j_0) {
                8p_0.1(h_02.c() + " [&b" + Keyboard.getKeyName((int)((8j_0)h_02.6()).c()) + "&f]");
                continue;
            }
            if (h_02.6() instanceof 89) {
                8p_0.1(h_02.c() + " [&b" + ((89)h_02.6()).0() + ", " + ((89)h_02.6()).7() + "&f]");
                continue;
            }
            8p_0.1(h_02.c() + " [&b" + h_02.6() + "&f]" + (h_02.8() != null && h_02.7() != null ? " Min:&b " + h_02.8() + "&f Max:&b " + h_02.7() : ""));
        }
    }

    public I() {
        super("settings", "Shows you a modules settings", new 5("<module>"));
    }
}

