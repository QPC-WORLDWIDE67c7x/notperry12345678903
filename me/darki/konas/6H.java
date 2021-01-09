/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1B;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6F;
import me.darki.konas.6G;
import me.darki.konas.8h_0;
import net.minecraft.util.MovementInput;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6H
extends 3E {
    public static 8h_0<6G> 1 = new 8h_0("Mode", 6G.c);
    public boolean 1 = false;

    public 6H() {
        super("Sprint", "Makes you Sprint!", 0, 3D.0, new String[0]);
    }

    @Subscriber
    public void c(1N n2) {
        block1: {
            if (6H.c.player == null || 6H.c.world == null) {
                return;
            }
            if (6H.c.player.isSneaking() || 6H.c.player.collidedHorizontally) break block1;
            6H.c.player.setSprinting(this.1);
        }
    }

    @Subscriber
    public void c(1B b2) {
        MovementInput movementInput = b2.c();
        switch (6F.c[((6G)((Object)1.6())).ordinal()]) {
            case 1: {
                this.1 = movementInput.moveForward > 0.0f;
                break;
            }
            case 2: {
                this.1 = Math.abs(movementInput.moveForward) > 0.0f || Math.abs(movementInput.moveStrafe) > 0.0f;
            }
        }
    }
}

