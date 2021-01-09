/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.mixin.mixins.ISPacketPlayerPosLook;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

public class 74
extends 3E {
    public 74() {
        super("NoRotate", "Cancels server to client rotations", 3D.1, new String[0]);
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketPlayerPosLook && !(74.c.currentScreen instanceof GuiDownloadTerrain)) {
            SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)s.c();
            ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setYaw(74.c.player.rotationYaw);
            ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setPitch(74.c.player.rotationPitch);
            sPacketPlayerPosLook.getFlags().remove(SPacketPlayerPosLook.EnumFlags.X_ROT);
            sPacketPlayerPosLook.getFlags().remove(SPacketPlayerPosLook.EnumFlags.Y_ROT);
        }
    }
}

