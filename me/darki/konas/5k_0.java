/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import net.minecraft.network.play.client.CPacketCloseWindow;

/*
 * Renamed from me.darki.konas.5k
 */
public class 5k_0
extends 3E {
    public 5k_0() {
        super("XCarry", 3D.4, "MoreInventory");
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketCloseWindow)) break block0;
            t.c(true);
        }
    }
}

