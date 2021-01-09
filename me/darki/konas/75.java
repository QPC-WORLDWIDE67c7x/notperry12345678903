/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.Y;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 75
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Reach", Float.valueOf(4.0f), Float.valueOf(10.0f), Float.valueOf(0.5f), Float.valueOf(0.5f));

    @Subscriber
    public void c(Y y) {
        y.c(((Float)1.6()).floatValue());
    }

    public 75() {
        super("Reach", "Increaces your block reach range", 3D.1, new String[0]);
    }
}

