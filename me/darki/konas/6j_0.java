/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.14;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.util.MovementInput;

/*
 * Renamed from me.darki.konas.6j
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6j_0
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Speed", Float.valueOf(3.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 2 = new 8h_0("Accelerate", false);
    public static 8h_0<Float> 3 = new 8h_0("Acceleration", Float.valueOf(0.1f), Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(2::6);
    public long c = 0L;

    public 6j_0() {
        super("EntitySpeed", 3D.0, new String[0]);
    }

    @Override
    public void c() {
        this.c = System.currentTimeMillis();
    }

    @Subscriber
    public void c(14 var1_1) {
        if (6j_0.c.player.getRidingEntity() != null) {
            MovementInput movementInput = 6j_0.c.player.movementInput;
            double d2 = movementInput.moveForward;
            double d3 = movementInput.moveStrafe;
            float f2 = 6j_0.c.player.rotationYaw;
            if (d2 == 0.0 && d3 == 0.0) {
                6j_0.c.player.getRidingEntity().motionX = 0.0;
                6j_0.c.player.getRidingEntity().motionZ = 0.0;
                this.c = System.currentTimeMillis();
            } else {
                if (d2 != 0.0) {
                    if (d3 > 0.0) {
                        f2 += (float)(d2 > 0.0 ? -45 : 45);
                    } else if (d3 < 0.0) {
                        f2 += (float)(d2 > 0.0 ? 45 : -45);
                    }
                    d3 = 0.0;
                    if (d2 > 0.0) {
                        d2 = 1.0;
                    } else if (d2 < 0.0) {
                        d2 = -1.0;
                    }
                }
                float f3 = ((Float)1.6()).floatValue();
                if (((Boolean)2.6()).booleanValue()) {
                    f3 *= Math.min(1.0f, (float)(System.currentTimeMillis() - this.c) / (1000.0f * ((Float)3.6()).floatValue()));
                }
                double d4 = Math.sin(Math.toRadians(f2 + 90.0f));
                double d5 = Math.cos(Math.toRadians(f2 + 90.0f));
                6j_0.c.player.getRidingEntity().motionX = d2 * (double)f3 * d5 + d3 * (double)f3 * d4;
                6j_0.c.player.getRidingEntity().motionZ = d2 * (double)f3 * d4 - d3 * (double)f3 * d5;
            }
        }
    }
}

