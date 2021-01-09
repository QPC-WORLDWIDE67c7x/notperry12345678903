/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import io.netty.buffer.Unpooled;
import me.darki.konas.0O;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4K
extends 3E {
    public static int 1 = 1;
    public boolean 1 = true;

    @Subscriber
    public void c(0T t) {
        if (4K.c.world == null || 4K.c.player == null) {
            return;
        }
        if (t.c() instanceof CPacketCustomPayload && ((CPacketCustomPayload)t.c()).getChannelName().equals("MC|Beacon")) {
            if (this.1) {
                this.1 = false;
                CPacketCustomPayload cPacketCustomPayload = (CPacketCustomPayload)t.c();
                PacketBuffer packetBuffer = cPacketCustomPayload.getBufferData();
                int n2 = packetBuffer.readInt();
                int n3 = packetBuffer.readInt();
                t.c(true);
                PacketBuffer packetBuffer2 = new PacketBuffer(Unpooled.buffer());
                packetBuffer2.writeInt(1);
                packetBuffer2.writeInt(n3);
                4K.c.player.connection.sendPacket((Packet)new CPacketCustomPayload("MC|Beacon", packetBuffer2));
                this.1 = true;
            }
        }
    }

    public 4K() {
        super("BeaconSelector", "Allows you to change beacon effect", 3D.4, "BeaconBypass");
    }

    @Subscriber
    public void c(0O o2) {
        o2.c();
    }
}

