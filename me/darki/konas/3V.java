/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3T;
import me.darki.konas.3U;
import me.darki.konas.8e_0;
import me.darki.konas.8k_0;
import me.darki.konas.8p_0;
import me.darki.konas.9m;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3V
extends 3E {
    public 9m c;
    public static boolean 1 = true;
    public 8e_0<Boolean> c = new 8e_0("Cute", false, new 3T(this));
    public 8e_0<Boolean> 0 = new 8e_0("Invite", true, new 3U(this));

    @Override
    public void 7() {
        if (8k_0.c.c == null) {
            return;
        }
        8k_0.c.c.0();
    }

    public static 8e_0 c(3V v) {
        return v.c;
    }

    public static 9m 1(3V v) {
        return v.c;
    }

    public 3V() {
        super("RPC", "Control your discord rich presence", 3D.5, "Discord", "DiscordRPC");
        this.c.c(10000L);
    }

    @Override
    public void c() {
        if (8k_0.c.c == null) {
            return;
        }
        if (!1 && !this.c.c(10000.0)) {
            8p_0.1("Please wait another " + Math.abs((System.currentTimeMillis() - this.c.0()) / 1000L - 10L) + " seconds, before you enable this module again!");
            this.d();
        } else {
            8k_0.c.c.3();
            this.c.c();
        }
    }

    public static 8e_0 0(3V v) {
        return v.0;
    }
}

