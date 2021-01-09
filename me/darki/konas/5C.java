/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.client.gui.GuiGameOver;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5C
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Safe", false);

    @Subscriber
    public void c(1N n2) {
        block1: {
            boolean bl;
            if (5C.c.player == null || 5C.c.world == null) {
                return;
            }
            boolean bl2 = bl = (Boolean)this.1.6() == false || 5C.c.player.getHealth() < 0.0f || 5C.c.player.isDead;
            if (!(5C.c.currentScreen instanceof GuiGameOver) || !bl) break block1;
            5C.c.player.respawnPlayer();
        }
    }

    public 5C() {
        super("AutoRespawn", 3D.3, new String[0]);
    }
}

