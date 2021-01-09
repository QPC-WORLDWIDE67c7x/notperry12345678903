/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.11;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;

/*
 * Renamed from me.darki.konas.6r
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6r_0
extends 3E {
    public static 8h_0<Double> 1 = new 8h_0("Height", 2.0, 10.0, 0.1, 0.1);
    public static 8h_0<Boolean> 2 = new 8h_0("Ground", true);

    public 6r_0() {
        super("HighJump", 3D.0, new String[0]);
    }

    @Subscriber
    public void c(11 var1_1) {
        block0: {
            if (!6r_0.c.player.movementInput.jump || ((Boolean)2.6()).booleanValue() && !6r_0.c.player.onGround) break block0;
            6r_0.c.player.motionY = (Double)1.6();
            var1_1.0(6r_0.c.player.motionY);
        }
    }
}

