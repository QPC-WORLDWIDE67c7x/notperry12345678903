/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.4M;
import me.darki.konas.4N;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.ICPacketUpdateSign;
import net.minecraft.network.play.client.CPacketUpdateSign;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4O
extends 3E {
    public 8h_0<4N> 1 = new 8h_0("Mode", 4N.c);

    @Subscriber
    public void c(0T t) {
        if (t.c() instanceof CPacketUpdateSign && c.getCurrentServerData() != null) {
            block4: for (int i2 = 0; i2 < 4; ++i2) {
                if (((ICPacketUpdateSign)t.c()).getLines()[i2] == null) continue;
                switch (4M.c[((4N)((Object)this.1.6())).ordinal()]) {
                    case 1: {
                        ((ICPacketUpdateSign)t.c()).getLines()[i2] = ((ICPacketUpdateSign)t.c()).getLines()[i2].replace("&", "\u00a7\u00a70");
                        continue block4;
                    }
                    case 2: {
                        ((ICPacketUpdateSign)t.c()).getLines()[i2] = ((ICPacketUpdateSign)t.c()).getLines()[i2].replace("&", "\u00a7\u00a7\u00a700");
                    }
                }
            }
        }
    }

    public 4O() {
        super("ColorSigns", "Lets you use color codes on signs", -7213820, 3D.4, new String[0]);
    }
}

