/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0I;
import me.darki.konas.3A;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.event.world.WorldEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5B
extends 3E {
    public ServerData c;
    public 8h_0<Integer> 1 = new 8h_0("Delay", 5, 30, 1, 1);

    public void 0() {
        ServerData serverData = c.getCurrentServerData();
        if (serverData != null) {
            this.c = serverData;
        }
    }

    public 5B() {
        super("AutoReconnect", 3D.3, new String[0]);
    }

    @Subscriber
    public void c(WorldEvent.Unload unload) {
        this.0();
    }

    @Subscriber
    public void c(0I i2) {
        block0: {
            if (!(i2.c() instanceof GuiDisconnected)) break block0;
            this.0();
            i2.c(new 3A((GuiDisconnected)i2.c(), this.c, (Integer)this.1.6()));
        }
    }
}

