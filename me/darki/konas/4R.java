/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0j_0;
import me.darki.konas.0y_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4R
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("OnlyTamed", false);

    @Subscriber
    public void c(0j_0 j_02) {
        block0: {
            if (!j_02.c().isTame() && ((Boolean)this.1.6()).booleanValue()) break block0;
            j_02.c();
        }
    }

    public 4R() {
        super("EntityControl", 3D.4, "FakeSaddle");
    }

    @Subscriber
    public void c(0y_0 y_02) {
        block0: {
            if (!y_02.c().isTame() && ((Boolean)this.1.6()).booleanValue()) break block0;
            y_02.c();
        }
    }
}

