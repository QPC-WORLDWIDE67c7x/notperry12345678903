/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4X
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Boolean> 4;
    public 8h_0<Boolean> 5;
    public int 1 = 0;

    public void 0() {
        block0: {
            if (4X.c.player != null && 4X.c.world != null) break block0;
            this.d();
        }
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!((Boolean)this.1.6() != false && t.c() instanceof CPacketInput || (Boolean)this.2.6() != false && t.c() instanceof CPacketPlayer && 4X.c.player.getRidingEntity() == null || (Boolean)this.3.6() != false && t.c() instanceof CPacketEntityAction || (Boolean)this.4.6() != false && t.c() instanceof CPacketUseEntity) && (!((Boolean)this.5.6()).booleanValue() || !(t.c() instanceof CPacketVehicleMove))) break block0;
            t.c();
            ++this.1;
            this.0(Integer.toString(this.1));
        }
    }

    public 4X() {
        super("PacketCanceller", 3D.4, new String[0]);
        this.2 = new 8h_0("CPacketPlayer", false);
        this.3 = new 8h_0("CPacketEntityAction", false);
        this.4 = new 8h_0("CPacketUseEntity", false);
        this.5 = new 8h_0("CPacketVehicleMove", false);
    }

    @Override
    public void c() {
        this.1 = 0;
    }
}

