/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.command.SyntaxChunk;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class e
extends 2 {
    public e() {
        super("disconnect", "Kick yourself from a server", new SyntaxChunk[0]);
    }

    @Override
    public void c(String[] stringArray) {
        block0: {
            if (e.c.player == null) break block0;
            e.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(69420));
        }
    }
}

