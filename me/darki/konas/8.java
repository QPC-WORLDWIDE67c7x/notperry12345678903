/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4;
import me.darki.konas.5;
import me.darki.konas.8t_0;
import org.lwjgl.input.Keyboard;

public class 8
extends 2 {
    @Override
    public void c(String[] stringArray) {
        int n2;
        if (stringArray.length != this.2().size() + 1) {
            8t_0.1(this.0(), new Object[0]);
            return;
        }
        if (3F.c(stringArray[1]) == null) {
            8t_0.1("Module not found", new Object[0]);
            return;
        }
        3E e2 = 3F.c(stringArray[1]);
        if (Keyboard.getKeyIndex((String)stringArray[2].toUpperCase()) != 0) {
            n2 = Keyboard.getKeyIndex((String)stringArray[2].toUpperCase());
        } else if (stringArray[2].equalsIgnoreCase("none")) {
            n2 = 0;
        } else {
            8t_0.1("Invalid key", new Object[0]);
            return;
        }
        e2.c(n2);
        8t_0.0("Bound (h)%s(r) to (h)%s", e2.b(), Keyboard.getKeyName((int)n2));
    }

    public 8() {
        super("bind", "Bind key to module", new String[]{"b"}, new 5("<Module>"), new 4("<Bind>"));
    }
}

