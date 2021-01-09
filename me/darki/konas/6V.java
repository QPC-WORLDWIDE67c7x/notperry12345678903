/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0c_0;
import me.darki.konas.3D;
import me.darki.konas.3E;

public class 6V
extends 3E {
    public 6V() {
        super("BreakTweaks", "Lets you pause breaking blocks", 3D.1, "StickyBreak");
    }

    @Subscriber
    public void c(0c_0 c_02) {
        c_02.c();
    }
}

