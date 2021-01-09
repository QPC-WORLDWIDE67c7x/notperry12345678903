/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.11;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4S
extends 3E {
    public 9m c = new 9m();
    public int 1 = 0;

    @Override
    public void c() {
        if (((Minecraft)4S.c).player == null || ((Minecraft)4S.c).world == null) {
            this.d();
            return;
        }
        this.1 = 0;
        4S.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4S.c.player.posX, 4S.c.player.posY + 3.0, 4S.c.player.posZ, 4S.c.player.onGround));
    }

    @Subscriber
    public void c(11 var1_1) {
        block1: {
            if (this.1 == 0) break block1;
            var1_1.c(true);
            if (this.c.c(2850.0)) {
                this.d();
            }
        }
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketConfirmTeleport)) break block0;
            this.1 = ((CPacketConfirmTeleport)t.c()).getTeleportId();
            this.c.c();
            t.c(true);
        }
    }

    public 4S() {
        super("Freeze", "Rubberbands you and gives you temporary godmode on some servers", 3D.4, new String[0]);
    }

    @Override
    public void 7() {
        if (((Minecraft)4S.c).player == null || ((Minecraft)4S.c).world == null) {
            return;
        }
        4S.c.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(this.1));
    }
}

