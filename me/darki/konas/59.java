/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import net.minecraft.network.play.client.CPacketConfirmTeleport;

public class 59
extends 3E {
    public 59() {
        super("PortalGodmode", 3D.4, new String[0]);
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketConfirmTeleport)) break block0;
            t.c(true);
        }
    }
}

