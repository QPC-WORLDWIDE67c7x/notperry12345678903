/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6P
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Sprint", true);
    public static 8h_0<Boolean> 2 = new 8h_0("Ground", true);
    public boolean 1 = false;

    public 6P() {
        super("AntiHunger", "Prevents hunger loss", 3D.1, "NoHunger");
    }

    @Subscriber
    public void c(0T t) {
        CPacketEntityAction cPacketEntityAction;
        if (t.c() instanceof CPacketEntityAction) {
            cPacketEntityAction = (CPacketEntityAction)t.c();
            if (((Boolean)1.6()).booleanValue() && (cPacketEntityAction.getAction() == CPacketEntityAction.Action.START_SPRINTING || cPacketEntityAction.getAction() == CPacketEntityAction.Action.STOP_SPRINTING)) {
                t.c(true);
            }
        }
        if (t.c() instanceof CPacketPlayer) {
            cPacketEntityAction = (CPacketPlayer)t.c();
            boolean bl = 6P.c.player.onGround;
            if (((Boolean)2.6()).booleanValue() && this.1 && bl) {
                if (cPacketEntityAction.getY(0.0) == (!((ICPacketPlayer)cPacketEntityAction).isMoving() ? 0.0 : 6P.c.player.posY)) {
                    ((ICPacketPlayer)cPacketEntityAction).setOnGround(false);
                }
            }
            this.1 = bl;
        }
    }

    @Override
    public void 7() {
        block0: {
            if (!((Boolean)1.6()).booleanValue() || 6P.c.player == null || !6P.c.player.isSprinting()) break block0;
            6P.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6P.c.player, CPacketEntityAction.Action.START_SPRINTING));
        }
    }

    @Override
    public void c() {
        block0: {
            if (!((Boolean)1.6()).booleanValue() || 6P.c.player == null) break block0;
            6P.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6P.c.player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
    }
}

