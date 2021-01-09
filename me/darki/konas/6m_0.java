/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8x_0;

/*
 * Renamed from me.darki.konas.6m
 */
public class 6m_0
extends 3E {
    @Subscriber
    public void c(1N n2) {
        if (6m_0.c.world == null || 6m_0.c.player == null) {
            return;
        }
        if (6m_0.c.player.isOnLadder() && 8x_0.c()) {
            6m_0.c.player.motionY = 0.169;
        }
    }

    public 6m_0() {
        super("FastLadder", 3D.0, new String[0]);
    }
}

