/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3V;
import me.darki.konas.8b_0;
import me.darki.konas.8k_0;
import me.darki.konas.8p_0;

public class 3T
implements 8b_0 {
    public 3V c;

    public 3T(3V v) {
        this.c = v;
    }

    public void c(Object object) {
        this.c((Boolean)object);
    }

    public void c(Boolean bl) {
        if (8k_0.c.c == null) {
            return;
        }
        if (!3V.1 && !3V.1(this.c).c(10000.0)) {
            8p_0.1("Please wait another " + Math.abs((System.currentTimeMillis() - 3V.1(this.c).0()) / 1000L - 10L) + " seconds, before you enable this setting again!");
            3V.c(this.c).c();
        } else {
            8k_0.c.c.0(bl);
            3V.1(this.c).c();
        }
    }
}

