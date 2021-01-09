/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3N;
import me.darki.konas.8b_0;
import me.darki.konas.9e;
import me.darki.konas.9f;

public class 3J
implements 8b_0 {
    public 3N c;

    public void c(Object object) {
        this.c((Boolean)object);
    }

    public void c(Boolean bl) {
        block1: {
            block0: {
                if (!bl.booleanValue()) break block0;
                if (9f.0() == 3N.c) break block1;
                9f.c(3N.c);
                break block1;
            }
            if (9f.0() == 9e.c) break block1;
            9f.c(9e.c);
        }
    }

    public 3J(3N n2) {
        this.c = n2;
    }
}

