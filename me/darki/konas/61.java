/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketKeepAlive;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 61
extends 3E {
    public 8h_0<Integer> 1 = new 8h_0("ss", 200, 2000, 0, 1);
    public 9m c;
    public CPacketKeepAlive c = null;

    @Subscriber
    public void c(1b_0 b_02) {
        if (this.c.c((double)((Integer)this.1.6()).intValue()) && this.c != null) {
            61.c.player.connection.sendPacket((Packet)this.c);
            this.c = null;
        }
    }

    @Override
    public String 0() {
        return this.1.6() + "ms";
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketKeepAlive) || this.c == t.c() || (Integer)this.1.6() == 0) break block0;
            this.c = (CPacketKeepAlive)t.c();
            t.c();
            this.c.c();
        }
    }

    public 61() {
        super("PingSpoof", 3D.3, new String[0]);
    }
}

