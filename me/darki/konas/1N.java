/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 1N {
    public static 1N c = new 1N();
    public TickEvent.Phase c;

    public TickEvent.Phase c() {
        return this.c;
    }

    public static 1N c(TickEvent.Phase phase) {
        1N.c.c = phase;
        return c;
    }
}

