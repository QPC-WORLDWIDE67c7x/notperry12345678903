/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.11;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8x_0;

/*
 * Renamed from me.darki.konas.6n
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6n_0
extends 3E {
    public static 8h_0<Double> 1 = new 8h_0("Speed", 2.0, 10.0, 0.1, 0.1);
    public static 8h_0<Boolean> 2 = new 8h_0("AntiKick", true);

    @Subscriber
    public void c(11 var1_1) {
        if (!6n_0.c.player.isInWater() || !8x_0.c()) {
            return;
        }
        double[] dArray = 6n_0.c.player.ticksExisted % 4 == 0 && (Boolean)2.6() != false ? 8x_0.c((Double)1.6() / 40.0) : 8x_0.c((Double)1.6() / 10.0);
        var1_1.1(dArray[0]);
        var1_1.c(dArray[1]);
    }

    public 6n_0() {
        super("FastSwim", 3D.0, new String[0]);
    }
}

