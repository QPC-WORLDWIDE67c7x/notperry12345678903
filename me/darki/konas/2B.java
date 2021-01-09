/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2C;
import me.darki.konas.94;
import me.darki.konas.9b;

public class 2B
extends 2C {
    public static String c = null;

    public 2B() {
        super("Description", 0.0f, 0.0f, 0.0f, 0.0f);
        this.0(false);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        block0: {
            super.c(n2, n3, f2);
            if (c == null || c.isEmpty()) break block0;
            float f3 = 9b.0(c) + 4.0f;
            float f4 = 9b.c(c) + 4.0f;
            this.3(n2);
            this.0((float)n3 - f4);
            this.1(f3);
            this.4(f4);
            94.c(n2, (float)n3 - f4, f3, f4, Color.BLACK.hashCode());
            9b.1(c, n2 + 2, (float)n3 - f4 + 2.0f, Color.WHITE.hashCode());
        }
    }
}

