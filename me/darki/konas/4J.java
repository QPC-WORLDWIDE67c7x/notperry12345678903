/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.11;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ISPacketPlayerPosLook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4J
extends 3E {
    public 8h_0<Boolean> 1;
    public boolean 1 = true;
    public 9m c = new 9m();

    /*
     * Enabled aggressive block sorting
     */
    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)4J.c).player == null) return;
        if (((Minecraft)4J.c).world == null) {
            return;
        }
        if (8x_0.2() && 4J.c.player.posY <= 1.0) {
            if (!this.1) return;
            if (!this.c.c(1000.0)) return;
            this.1 = false;
            4J.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4J.c.player.posX, 4J.c.player.posY + 0.1, 4J.c.player.posZ, false));
            return;
        }
        this.1 = true;
    }

    public 4J() {
        super("AntiVoid", 3D.4, "NoVoid");
    }

    @Subscriber
    public void c(11 var1_1) {
        block0: {
            if (!((Boolean)this.1.6()).booleanValue() || !8x_0.2() || !(4J.c.player.posY <= 1.0)) break block0;
            var1_1.0(-0.01);
        }
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketPlayerPosLook && !(((Minecraft)4J.c).currentScreen instanceof GuiDownloadTerrain)) {
            SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)s.c();
            ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setYaw(4J.c.player.rotationYaw);
            ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setPitch(4J.c.player.rotationPitch);
            sPacketPlayerPosLook.getFlags().remove(SPacketPlayerPosLook.EnumFlags.X_ROT);
            sPacketPlayerPosLook.getFlags().remove(SPacketPlayerPosLook.EnumFlags.Y_ROT);
        }
    }
}

