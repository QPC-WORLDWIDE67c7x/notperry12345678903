/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.14;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.57;
import me.darki.konas.8h_0;
import me.darki.konas.8x_0;
import me.darki.konas.V;
import me.darki.konas.X;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 58
extends 3E {
    public static 8h_0<57> 1 = new 8h_0("Mode", 57.c);
    public static 8h_0<Boolean> 2 = new 8h_0("NoVoid", true);
    public static 8h_0<Boolean> 3 = new 8h_0("AutoClip", false);
    public static 8h_0<Double> 4 = new 8h_0("Distance", 6.0, 10.0, 0.1, 0.1);

    @Subscriber
    public void c(1P p2) {
        block3: {
            this.0(((57)((Object)1.6())).name());
            if (1.6() != 57.0) break block3;
            58.c.player.setVelocity(0.0, 0.0, 0.0);
            if (58.c.gameSettings.keyBindForward.isKeyDown() || 58.c.gameSettings.keyBindBack.isKeyDown() || 58.c.gameSettings.keyBindLeft.isKeyDown() || 58.c.gameSettings.keyBindRight.isKeyDown()) {
                double[] dArray = 8x_0.c((double)0.06f);
                58.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(58.c.player.posX + dArray[0], 58.c.player.posY, 58.c.player.posZ + dArray[1], 58.c.player.onGround));
                58.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(58.c.player.posX, 0.0, 58.c.player.posZ, 58.c.player.onGround));
            }
            if (58.c.gameSettings.keyBindSneak.isKeyDown()) {
                58.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(58.c.player.posX, 58.c.player.posY - (Double)4.6() / 1000.0, 58.c.player.posZ, 58.c.player.onGround));
                58.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(58.c.player.posX, 0.0, 58.c.player.posZ, 58.c.player.onGround));
            }
            if (58.c.gameSettings.keyBindJump.isKeyDown()) {
                58.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(58.c.player.posX, 58.c.player.posY + (Double)4.6() / 1000.0, 58.c.player.posZ, 58.c.player.onGround));
                58.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(58.c.player.posX, 0.0, 58.c.player.posZ, 58.c.player.onGround));
            }
        }
    }

    @Subscriber
    public void c(14 var1_1) {
        if (1.6() == 57.c && 58.c.gameSettings.keyBindJump.isKeyDown() && 58.c.player.getRidingEntity() != null && 58.c.player.getRidingEntity() instanceof EntityBoat) {
            EntityBoat entityBoat = (EntityBoat)58.c.player.getRidingEntity();
            if (entityBoat.onGround) {
                entityBoat.motionY = 0.42f;
            }
        }
    }

    public 58() {
        super("Phase", "Non Full-Block Phase", 3D.4, "DoorClip", "NoClip");
    }

    @Subscriber
    public void c(V v) {
        block3: {
            block2: {
                block4: {
                    if (58.c.player == null || 58.c.world == null) {
                        return;
                    }
                    if (1.6() != 57.c) break block2;
                    if (58.c.player.getRidingEntity() == null || v.0() != 58.c.player.getRidingEntity()) break block3;
                    if (!58.c.gameSettings.keyBindSprint.isKeyDown() || !((Boolean)2.6()).booleanValue()) break block4;
                    v.c(true);
                    break block3;
                }
                if (58.c.gameSettings.keyBindJump.isKeyDown() && (double)v.4().getY() >= 58.c.player.getRidingEntity().posY) {
                    v.c(true);
                }
                if (!((double)v.4().getY() >= 58.c.player.getRidingEntity().posY)) break block3;
                v.c(true);
                break block3;
            }
            if (v.0() != 58.c.player && (58.c.player.getRidingEntity() == null || v.0() != 58.c.player.getRidingEntity())) break block3;
            v.c(true);
        }
    }

    @Override
    public void 7() {
        58.c.player.noClip = false;
    }

    @Override
    public void c() {
        block0: {
            if (!((Boolean)3.6()).booleanValue() || 58.c.player == null || 58.c.world == null) break block0;
            double d2 = Math.cos(Math.toRadians(58.c.player.rotationYaw + 90.0f));
            double d3 = Math.sin(Math.toRadians(58.c.player.rotationYaw + 90.0f));
            58.c.player.setPosition(58.c.player.posX + (1.0 * ((Double)4.6() / 1000.0) * d2 + 0.0 * ((Double)4.6() / 1000.0) * d3), 58.c.player.posY, 58.c.player.posZ + (1.0 * ((Double)4.6() / 1000.0) * d3 - 0.0 * ((Double)4.6() / 1000.0) * d2));
        }
    }

    @Subscriber
    public void c(X x) {
        x.c(true);
    }
}

