/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import io.netty.buffer.Unpooled;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.mixin.mixins.ICPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;

public class 3Q
extends 3E {
    @Subscriber
    public void c(0T t) {
        block0: {
            block1: {
                if (c.isIntegratedServerRunning()) break block0;
                if (!t.c().getClass().getName().equals("net.minecraftforge.fml.common.network.internal.FMLProxyPacket")) break block1;
                t.c(true);
                break block0;
            }
            if (!(t.c() instanceof CPacketCustomPayload) || !((CPacketCustomPayload)t.c()).getChannelName().equalsIgnoreCase("MC|Brand")) break block0;
            ((ICPacketCustomPayload)t.c()).setData(new PacketBuffer(Unpooled.buffer()).writeString("vanilla"));
        }
    }

    public 3Q() {
        super("NoForge", "Prevents client from sending forge signature", 3D.5, new String[0]);
    }
}

