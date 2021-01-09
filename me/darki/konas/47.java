/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.4g_0;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 47
implements Runnable {
    public static 47 c;
    public 4g_0 c;

    public static 47 0(4g_0 g_02) {
        return 47.c(g_02);
    }

    public static 47 c(4g_0 g_02) {
        if (c == null) {
            c = new 47();
            47.c.c = g_02;
        }
        return c;
    }

    @Override
    public void run() {
        block9: {
            if (!4g_0.1(this.c).get()) break block9;
            8h_0<Float> h_02 = 4g_0.m;
            Object t = h_02.6();
            Float f2 = (Float)t;
            float f3 = f2.floatValue();
            long l2 = (long)(f3 * 40.0f);
            try {
                Thread.sleep(l2);
            }
            catch (InterruptedException interruptedException) {
                4g_0.0(this.c).interrupt();
            }
            if (!4g_0.1(this.c).get()) {
                return;
            }
            4g_0.1(this.c).set(false);
            if (4g_0.2(this.c).get()) {
                return;
            }
            4g_0.c(this.c);
        }
    }
}

