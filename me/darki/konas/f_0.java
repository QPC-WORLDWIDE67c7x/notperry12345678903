/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.5;
import me.darki.konas.8p_0;

/*
 * Renamed from me.darki.konas.f
 */
public class f_0
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.c(this.0());
            return;
        }
        3E e2 = 3F.c(stringArray[1]);
        if (e2 != null) {
            e2.c(!e2.a());
            8p_0.1("Drawn Module &b" + e2.b());
        } else {
            8p_0.c("Unknown Module &b" + stringArray[1]);
        }
    }

    public f_0() {
        super("draw", "Makes Modules Visible or Invisible on the ArrayList", new 5("<Module>"));
    }
}

