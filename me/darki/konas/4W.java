/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.11;
import me.darki.konas.14;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.4U;
import me.darki.konas.4V;
import me.darki.konas.54;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import me.darki.konas.mixin.mixins.ISPacketPlayerPosLook;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4W
extends 3E {
    public static 8h_0<Integer> 1 = new 8h_0("FallDistance", 3, 30, 1, 1);
    public static 8h_0<4V> 2 = new 8h_0("Mode", 4V.c);
    public double c = 256.0;
    public int 1;
    public ArrayList<CPacketPlayer> 0 = new ArrayList();

    @Override
    public void c() {
        this.c = 256.0;
    }

    @Subscriber
    public void c(0T t) {
        if (t.c() instanceof CPacketPlayer) {
            switch (4U.c[((4V)((Object)2.6())).ordinal()]) {
                case 3: {
                    if (!(4W.c.player.fallDistance > Math.min(3.0f, (float)((Integer)1.6()).intValue()))) break;
                    if (((CPacketPlayer)t.c()).getY(4W.c.player.posY) < this.c) {
                        ((ICPacketPlayer)t.c()).setY(4W.c.player.posY + (double)Math.min(3.0f, (float)((Integer)1.6()).intValue()));
                        this.c = ((CPacketPlayer)t.c()).getY(4W.c.player.posY);
                        break;
                    }
                    this.c = 256.0;
                    4W.c.player.fallDistance = 0.0f;
                    break;
                }
                case 4: {
                    if (!(4W.c.player.fallDistance > (float)((Integer)1.6()).intValue())) break;
                    ((ICPacketPlayer)t.c()).setOnGround(true);
                    break;
                }
            }
        }
    }

    @Subscriber
    public void c(11 var1_1) {
        block2: {
            if (4W.c.player == null || 4W.c.world == null) {
                return;
            }
            if (2.6() != 4V.c) break block2;
            if (4W.c.player.fallDistance > (float)((Integer)1.6()).intValue() && !4W.c.player.onGround) {
                var1_1.1(0.0);
                var1_1.0(-0.062);
                var1_1.c(0.0);
            }
        }
    }

    @Subscriber
    public void c(14 var1_1) {
        if (4W.c.player == null || 4W.c.world == null) {
            return;
        }
        switch (4U.c[((4V)((Object)2.6())).ordinal()]) {
            case 1: {
                if (!(4W.c.player.fallDistance > (float)((Integer)1.6()).intValue())) break;
                if (this.1 <= 0) {
                    CPacketPlayer.Position position = new CPacketPlayer.Position(54.7(), 1.0, 54.7(), 4W.c.player.onGround);
                    this.0.add((CPacketPlayer)position);
                    4W.c.player.connection.sendPacket((Packet)position);
                    break;
                }
                CPacketPlayer.Position position = new CPacketPlayer.Position(4W.c.player.posX, 4W.c.player.posY - 0.062, 4W.c.player.posZ, 4W.c.player.onGround);
                this.0.add((CPacketPlayer)position);
                4W.c.player.connection.sendPacket((Packet)position);
                CPacketPlayer.Position position2 = new CPacketPlayer.Position(4W.c.player.posX, 1.0, 4W.c.player.posZ, 4W.c.player.onGround);
                this.0.add((CPacketPlayer)position2);
                4W.c.player.connection.sendPacket((Packet)position2);
                ++this.1;
                4W.c.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(this.1 - 1));
                4W.c.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(this.1));
                4W.c.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(this.1 + 1));
                break;
            }
            case 2: {
                if (!(4W.c.player.fallDistance > (float)((Integer)1.6()).intValue())) break;
                4W.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4W.c.player.posX, 10000.0, 4W.c.player.posZ, 4W.c.player.onGround));
                break;
            }
        }
    }

    public 4W() {
        super("NoFall", 3D.4, "AntiFall", "NoFallDamage");
    }

    @Subscriber
    public void c(0S s) {
        if (4W.c.player == null || 4W.c.world == null) {
            return;
        }
        if (2.6() == 4V.c && 4W.c.player.fallDistance > (float)((Integer)1.6()).intValue() && s.c() instanceof SPacketPlayerPosLook) {
            if (!(4W.c.currentScreen instanceof GuiDownloadTerrain)) {
                if (4W.c.player.isEntityAlive()) {
                    if (this.1 <= 0) {
                        this.1 = ((SPacketPlayerPosLook)s.c()).getTeleportId();
                    } else {
                        SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)s.c();
                        ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setYaw(4W.c.player.rotationYaw);
                        ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setPitch(4W.c.player.rotationPitch);
                    }
                }
            } else {
                this.1 = 0;
            }
        }
    }
}

