/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3E;
import me.darki.konas.71;
import me.darki.konas.8b_0;

public class 70
implements 8b_0 {
    public 71 c;

    public 70(71 var1_1) {
        this.c = var1_1;
    }

    public void c(Boolean bl) {
        if (bl.booleanValue()) {
            if (!71.c(this.c).contains(3E.c.gameSettings.keyBindSneak)) {
                71.c(this.c).add(3E.c.gameSettings.keyBindSneak);
            }
        } else {
            71.c(this.c).remove(3E.c.gameSettings.keyBindSneak);
        }
    }

    public void c(Object object) {
        this.c((Boolean)object);
    }
}

