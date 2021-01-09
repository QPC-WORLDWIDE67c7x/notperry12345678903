/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.LinkedList;
import java.util.Queue;
import me.darki.konas.09;
import me.darki.konas.0I;
import me.darki.konas.1N;
import me.darki.konas.5H;
import me.darki.konas.5I;
import me.darki.konas.5J;
import me.darki.konas.9m;
import me.darki.konas.T;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.event.world.WorldEvent;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 20 {
    public static 20 c = new 20();
    public static Queue<5I> c;
    public static 9m c;
    public Minecraft c = Minecraft.getMinecraft();

    @Subscriber
    public void c(WorldEvent.Unload unload) {
        c.clear();
    }

    @Subscriber
    public void c(1N n2) {
        block1: {
            5I i2;
            if (this.c.player == null || this.c.world == null) {
                return;
            }
            if (!c.c(((Float)5J.1.6()).floatValue() * 1000.0f) || c.isEmpty() || this.c.player.connection.getPlayerInfo((i2 = (5I)c.poll()).0()) == null) break block1;
            this.c.player.connection.sendPacket((Packet)new CPacketChatMessage("/" + (5J.2.6() == 5H.c ? "msg" : "w") + " " + i2.0() + " " + i2.c()));
            c.c();
        }
    }

    @Subscriber
    public void c(09 var1_1) {
        c.add(new 5I(var1_1.c(), var1_1.0()));
    }

    static {
        c = new LinkedList();
        c = new 9m();
    }

    @Subscriber
    public void c(0I i2) {
        block0: {
            if (!(i2.c() instanceof GuiIngameMenu) && !(i2.c() instanceof GuiDisconnected)) break block0;
            T.0(T.3);
        }
    }
}

