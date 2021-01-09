/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0P;
import me.darki.konas.0Q;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;

/*
 * Renamed from me.darki.konas.7i
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7i_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Offset", false);
    public static 8h_0<Float> 2 = new 8h_0("Distance", Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(-10.0f), Float.valueOf(0.5f)).c(1::6);

    @Subscriber
    public void c(0P p2) {
        p2.c();
        if (((Boolean)1.6()).booleanValue()) {
            p2.c(((Float)2.6()).floatValue());
        } else {
            p2.c(4.0);
        }
    }

    public 7i_0() {
        super("CameraClip", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(0Q q) {
        block0: {
            if (!((Boolean)1.6()).booleanValue()) break block0;
            q.c(((Float)2.6()).floatValue());
            q.c();
        }
    }
}

