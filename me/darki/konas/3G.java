/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3H;
import me.darki.konas.8b_0;
import me.darki.konas.9b;
import me.darki.konas.9e;

public class 3G
implements 8b_0 {
    public 3H c;

    public void c(Boolean bl) {
        block1: {
            block0: {
                if (!bl.booleanValue()) break block0;
                if (9b.c() == 3H.c) break block1;
                9b.c(3H.c);
                break block1;
            }
            if (9b.c() == 9e.c) break block1;
            9b.c(9e.c);
        }
    }

    public void c(Object object) {
        this.c((Boolean)object);
    }

    public 3G(3H h2) {
        this.c = h2;
    }
}

