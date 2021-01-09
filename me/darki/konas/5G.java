/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.02;
import me.darki.konas.2;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5G
extends 3E {
    public static String 2 = " \u23d0 \uff2b\uff4f\uff4e\uff41\uff53";
    public static String 3 = " : Konas";
    public 8h_0<Boolean> 1 = new 8h_0("Strict", false);

    public 5G() {
        super("ChatAppend", 0, 3D.3, "ChatSuffix");
    }

    @Subscriber
    public void c(02 var1_1) {
        if (5G.c.world == null || 5G.c.player == null) {
            return;
        }
        String string = var1_1.c();
        if (string.startsWith("/") || string.startsWith(me.darki.konas.2.1())) {
            return;
        }
        if ((string = string + ((Boolean)this.1.6() != false ? 3 : 2)).length() >= 256) {
            string = string.substring(0, 256);
        }
        var1_1.c(string);
    }
}

