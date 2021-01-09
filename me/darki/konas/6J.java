/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.text.DecimalFormat;
import java.util.Random;
import me.darki.konas.0F;
import me.darki.konas.0N;
import me.darki.konas.0S;
import me.darki.konas.11;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8J;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6J
extends 3E {
    public 8h_0<Integer> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Boolean> 4;
    public 8h_0<Boolean> 5;
    public 8h_0<Boolean> 6;
    public 8h_0<Float> 7;
    public static 8h_0<Boolean> 8 = new 8h_0("Safe", true);
    public 9m c;
    public 9m 0;
    public 9m 1;
    public 9m 2;
    public boolean 1 = false;
    public boolean 2 = true;

    @Subscriber
    public void c(0N n2) {
        block2: {
            if (!this.1) break block2;
            if (((Boolean)this.4.6()).booleanValue() && this.1.c(((Float)this.7.6()).floatValue() * 100.0f)) {
                n2.c().moveForward = new Random().nextFloat() * 2.0f - 1.0f;
                n2.c().moveStrafe = new Random().nextFloat() * 2.0f - 1.0f;
                this.1.c();
            }
            if (((Boolean)this.2.6()).booleanValue() && 6J.c.player.onGround && this.2.c(((Float)this.7.6()).floatValue() * 100.0f)) {
                n2.c().jump = new Random().nextBoolean();
                this.2.c();
            }
        }
    }

    public 6J() {
        super("AntiAFK", "Prevents you from getting kicked while AFK", 3D.1, "NoAFK");
        this.3 = new 8h_0("Rotations", true);
        this.4 = new 8h_0("Move", true);
        this.5 = new 8h_0("AutoReply", false);
        this.6 = new 8h_0("FriendCoords", false).c(this::5);
        this.7 = new 8h_0("Delay", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(1.0f));
        this.c = new 9m();
        this.0 = new 9m();
        this.1 = new 9m();
        this.2 = new 9m();
    }

    @Subscriber
    public void c(11 var1_1) {
        double d2 = var1_1.2();
        double d3 = var1_1.1();
        if (((Boolean)8.6()).booleanValue()) {
            double d4 = 0.05;
            while (d2 != 0.0 && ((Minecraft)6J.c).world.getCollisionBoxes((Entity)((Minecraft)6J.c).player, ((Minecraft)6J.c).player.getEntityBoundingBox().offset(d2, -1.0, 0.0)).isEmpty()) {
                if (d2 < d4 && d2 >= -d4) {
                    d2 = 0.0;
                    continue;
                }
                if (d2 > 0.0) {
                    d2 -= d4;
                    continue;
                }
                d2 += d4;
            }
            while (d3 != 0.0 && ((Minecraft)6J.c).world.getCollisionBoxes((Entity)((Minecraft)6J.c).player, ((Minecraft)6J.c).player.getEntityBoundingBox().offset(0.0, -1.0, d3)).isEmpty()) {
                if (d3 < d4 && d3 >= -d4) {
                    d3 = 0.0;
                    continue;
                }
                if (d3 > 0.0) {
                    d3 -= d4;
                    continue;
                }
                d3 += d4;
            }
            while (d2 != 0.0 && d3 != 0.0 && ((Minecraft)6J.c).world.getCollisionBoxes((Entity)((Minecraft)6J.c).player, ((Minecraft)6J.c).player.getEntityBoundingBox().offset(d2, -1.0, d3)).isEmpty()) {
                d2 = d2 < d4 && d2 >= -d4 ? 0.0 : (d2 > 0.0 ? (d2 -= d4) : (d2 += d4));
                if (d3 < d4 && d3 >= -d4) {
                    d3 = 0.0;
                    continue;
                }
                if (d3 > 0.0) {
                    d3 -= d4;
                    continue;
                }
                d3 += d4;
            }
        }
        var1_1.1(d2);
        var1_1.c(d3);
    }

    @Subscriber
    public void c(0S s) {
        block1: {
            if (!(s.c() instanceof SPacketChat) || !((Boolean)this.5.6()).booleanValue() || !this.1) break block1;
            String[] stringArray = ((SPacketChat)s.c()).getChatComponent().getUnformattedText().split(" ");
            if (((SPacketChat)s.c()).getType() == ChatType.SYSTEM && stringArray[1].startsWith("whispers:")) {
                DecimalFormat decimalFormat = new DecimalFormat("#.#");
                double d2 = Double.parseDouble(decimalFormat.format(6J.c.player.posX));
                double d3 = Double.parseDouble(decimalFormat.format(6J.c.player.posY));
                double d4 = Double.parseDouble(decimalFormat.format(6J.c.player.posZ));
                ((Minecraft)6J.c).player.sendChatMessage("/r I'm currently afk " + ((Boolean)this.6.6() != false && 8J.1(stringArray[0]) ? " at " + d2 + ", " + d3 + ", " + d4 : ""));
            }
        }
    }

    @Subscriber
    public void c(1P p2) {
        if (p2.0() || !8L.c()) {
            return;
        }
        if (((Minecraft)6J.c).player == null || ((Minecraft)6J.c).world == null) {
            this.c.c();
            return;
        }
        if (this.2) {
            this.c.c();
            this.2 = false;
        }
        if (8x_0.c()) {
            this.c.c();
        }
        if (this.c.c((double)((Integer)this.1.6() * 1000))) {
            this.1 = true;
            if (((Boolean)this.3.6()).booleanValue() && this.0.c(((Float)this.7.6()).floatValue() * 100.0f)) {
                float f2 = -5.0f;
                float f3 = 5.0f;
                float f4 = (float)(Math.random() * (double)(f3 - f2 + 1.0f) + (double)f2);
                float f5 = (float)(Math.random() * (double)(f3 - f2 + 1.0f) + (double)f2);
                8k_0.c.c.c(6J.c.player.rotationYaw + f5, 6J.c.player.rotationPitch + f4);
                this.0.c();
            }
        } else {
            this.1 = false;
        }
    }

    @Override
    public boolean 5() {
        return (Boolean)this.5.6();
    }

    @Subscriber
    public void c(0F f2) {
        this.c.c();
    }
}

