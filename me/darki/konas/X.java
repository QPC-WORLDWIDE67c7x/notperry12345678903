/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.01;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class X
extends 01 {
    public static X c = new X();
    public EntityPlayer c;

    public EntityPlayer c() {
        return this.c;
    }

    public static X c(EntityPlayer entityPlayer) {
        c.c(false);
        X.c.c = entityPlayer;
        return c;
    }
}

