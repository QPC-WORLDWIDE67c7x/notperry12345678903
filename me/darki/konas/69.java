/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.TrayIcon;
import java.util.concurrent.CopyOnWriteArrayList;
import me.darki.konas.1N;
import me.darki.konas.2;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.8u_0;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 69
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("OneLine", false);
    public 8h_0<Boolean> 2 = new 8h_0("Leaves", true);
    public 8h_0<Boolean> 3 = new 8h_0("IgnoreFriends", true);
    public 8h_0<Boolean> 4 = new 8h_0("Notify", false).c(this::4);
    public CopyOnWriteArrayList<EntityPlayer> c = new CopyOnWriteArrayList();

    public 69() {
        super("VisualRange", 3D.3, new String[0]);
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)69.c).world == null || ((Minecraft)69.c).player == null) {
            return;
        }
        if (this.c == null) {
            this.c = new CopyOnWriteArrayList();
        }
        for (EntityPlayer entityPlayer : 69.c.world.playerEntities) {
            if (entityPlayer == ((Minecraft)69.c).player || 8u_0.c((Entity)entityPlayer) || ((Boolean)this.3.6()).booleanValue() && 8J.1(entityPlayer.getName()) || this.c.contains(entityPlayer)) continue;
            this.c.add(entityPlayer);
            if (((Boolean)this.1.6()).booleanValue()) {
                8p_0.c(entityPlayer.getName() + me.darki.konas.2.c + "a entered" + me.darki.konas.2.c + "f Visual Range!", 5555);
            } else {
                8p_0.1(entityPlayer.getName() + me.darki.konas.2.c + "a entered" + me.darki.konas.2.c + "f Visual Range!");
            }
            if (!((Boolean)this.4.6()).booleanValue()) continue;
            this.c(entityPlayer.getName() + " has entered Visual Range!", TrayIcon.MessageType.WARNING);
        }
        for (EntityPlayer entityPlayer : this.c) {
            if (69.c.world.playerEntities.contains(entityPlayer)) continue;
            this.c.remove(entityPlayer);
            if (!((Boolean)this.2.6()).booleanValue() || !((Boolean)this.3.6()).booleanValue() || 8J.1(entityPlayer.getName())) continue;
            if (((Boolean)this.1.6()).booleanValue()) {
                8p_0.c(entityPlayer.getName() + me.darki.konas.2.c + "c left" + me.darki.konas.2.c + "f Visual Range!", 5555);
                continue;
            }
            8p_0.1(entityPlayer.getName() + me.darki.konas.2.c + "c left" + me.darki.konas.2.c + "f Visual Range!");
        }
    }
}

