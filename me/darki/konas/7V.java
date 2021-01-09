/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import me.darki.konas.0k_0;
import me.darki.konas.0l_0;
import me.darki.konas.0t_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7U;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9c;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7V
extends 3E {
    public 8h_0<7U> 1 = new 8h_0("TimeMode", 7U.0);
    public 8h_0<Integer> 2 = new 8h_0("Time", 6000, 24000, 0, 1).c(this::5);
    public static 8h_0<Boolean> 3 = new 8h_0("Colorize", false);
    public static 8h_0<89> 4 = new 8h_0("Color", new 89(-16776961)).c(3::6);

    public 7V() {
        super("Sky", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(0t_0 t_02) {
        block2: {
            if (this.1.6() == 7U.c) break block2;
            if (this.1.6() == 7U.0) {
                t_02.c(((Integer)this.2.6()).intValue());
            } else {
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                Instant instant = zonedDateTime.toLocalDate().atStartOfDay(zonedDateTime.getZone()).toInstant();
                Duration duration = Duration.between(instant, Instant.now());
                long l2 = duration.getSeconds();
                t_02.c((int)((float)l2 / 86400.0f));
            }
            t_02.c();
        }
    }

    @Subscriber
    public void c(0k_0 k_02) {
        block0: {
            if (!((Boolean)3.6()).booleanValue()) break block0;
            float[] fArray = 9c.c(((89)4.6()).c());
            k_02.0(fArray[0]);
            k_02.c(fArray[1]);
            k_02.1(fArray[2]);
        }
    }

    @Subscriber
    public void c(0l_0 l_02) {
        block0: {
            if (!((Boolean)3.6()).booleanValue()) break block0;
            l_02.c(0.0f);
            l_02.c(true);
        }
    }

    @Override
    public boolean 5() {
        return this.1.6() == 7U.0;
    }
}

