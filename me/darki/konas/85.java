/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1V;
import me.darki.konas.1W;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.88;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 85
extends 3E {
    public static 8h_0<88> 1 = new 8h_0("Blocks", new 88(new String[0]));

    @Subscriber
    public void c(1V v) {
        block0: {
            if (((88)1.6()).0().contains(v.c())) break block0;
            v.c(true);
        }
    }

    @Subscriber
    public void c(1W w) {
        w.c(true);
    }

    @Override
    public void 7() {
        85.c.renderGlobal.loadRenderers();
    }

    public 85() {
        super("XRay", "Makes most blocks invisible so you can see ores", 3D.2, new String[0]);
    }

    @Override
    public void c() {
        85.c.renderGlobal.loadRenderers();
    }
}

