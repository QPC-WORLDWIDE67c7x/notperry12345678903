/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.TrayIcon;
import java.util.HashMap;
import me.darki.konas.1F;
import me.darki.konas.1N;
import me.darki.konas.26;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8t_0;
import me.darki.konas.8u_0;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4I
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("NotSelf", false);
    public 8h_0<Boolean> 2 = new 8h_0("Notify", false).c(this::4);

    @Subscriber(priority=20)
    public void c(1N n2) {
        if (4I.c.world == null || 4I.c.player == null) {
            return;
        }
        for (EntityPlayer entityPlayer : 4I.c.world.playerEntities) {
            if (((Boolean)this.1.6()).booleanValue() && entityPlayer == 4I.c.player || 8u_0.c((Entity)entityPlayer) || entityPlayer.getHealth() > 0.0f || !((HashMap)26.c).containsKey(entityPlayer.getName())) continue;
            8t_0.c(entityPlayer.getEntityId(), "(h)%s(r) died after popping (h)%s(r) totem%s!", entityPlayer.getName(), ((HashMap)26.c).get(entityPlayer.getName()), (Integer)((HashMap)26.c).get(entityPlayer.getName()) > 1 ? "s" : "");
            if (!((Boolean)this.2.6()).booleanValue()) continue;
            this.c(entityPlayer.getName() + " died after popping " + ((HashMap)26.c).get(entityPlayer.getName()) + " totems!", TrayIcon.MessageType.INFO);
        }
    }

    public 4I() {
        super("TotemPopCounter", 3D.c, "PopCounter", "TotemCounter", "TotemPops");
        this.c(315, 1000);
    }

    @Subscriber
    public void c(1F f2) {
        block1: {
            if (((Boolean)this.1.6()).booleanValue() && f2.c() == 4I.c.player) {
                return;
            }
            8t_0.c(f2.c().getEntityId(), "(h)%s(r) popped (h)%s(r) totem%s!", f2.c().getName(), f2.0(), f2.0() > 1 ? "s" : "");
            if (!((Boolean)this.2.6()).booleanValue()) break block1;
            this.c(f2.c().getName() + " popped " + f2.0() + " totem" + (f2.0() > 1 ? "s" : "") + "!", TrayIcon.MessageType.NONE);
        }
    }
}

