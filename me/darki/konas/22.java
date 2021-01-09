/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.0X;
import me.darki.konas.0Y;
import net.minecraft.network.play.server.SPacketPlayerListItem;

public class 22 {
    public static 22 c = new 22();

    @Subscriber
    public void c(0S s) {
        block2: {
            SPacketPlayerListItem sPacketPlayerListItem;
            block3: {
                if (!(s.c() instanceof SPacketPlayerListItem)) break block2;
                sPacketPlayerListItem = (SPacketPlayerListItem)s.c();
                if (sPacketPlayerListItem.getAction() != SPacketPlayerListItem.Action.ADD_PLAYER) break block3;
                for (SPacketPlayerListItem.AddPlayerData addPlayerData : sPacketPlayerListItem.getEntries()) {
                    0X x = new 0X(addPlayerData.getProfile().getName(), addPlayerData.getProfile().getId());
                    EventDispatcher.Companion.dispatch(x);
                }
                break block2;
            }
            if (sPacketPlayerListItem.getAction() != SPacketPlayerListItem.Action.REMOVE_PLAYER) break block2;
            for (SPacketPlayerListItem.AddPlayerData addPlayerData : sPacketPlayerListItem.getEntries()) {
                0Y y = new 0Y(addPlayerData.getProfile().getName(), addPlayerData.getProfile().getId());
                EventDispatcher.Companion.dispatch(y);
            }
        }
    }
}

