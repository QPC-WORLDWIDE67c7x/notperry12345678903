/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.3F;
import me.darki.konas.5;
import me.darki.konas.8p_0;

public class M
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.c(this.0());
            return;
        }
        if (3F.c(stringArray[1]) != null) {
            3F.c(stringArray[1]).d();
        } else {
            8p_0.c("Invalid Module");
        }
    }

    public M() {
        super("toggle", "Toggle Modules", new String[]{"t"}, new 5("<module>"));
    }
}

