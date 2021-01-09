/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.01;
import net.minecraft.inventory.EntityEquipmentSlot;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class W
extends 01 {
    public static W c = new W();
    public EntityEquipmentSlot c;

    public EntityEquipmentSlot c() {
        return this.c;
    }

    public static W c(EntityEquipmentSlot entityEquipmentSlot) {
        c.c(false);
        W.c.c = entityEquipmentSlot;
        return c;
    }
}

