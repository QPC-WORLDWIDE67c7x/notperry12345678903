/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovementInput;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 0N {
    public MovementInput c;
    public EntityPlayer c;

    public MovementInput c() {
        return this.c;
    }

    public EntityPlayer 0() {
        return this.c;
    }

    public 0N(EntityPlayer entityPlayer, MovementInput movementInput) {
        this.c = movementInput;
        this.c = entityPlayer;
    }
}

