/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import me.darki.konas.0S;
import me.darki.konas.11;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.6a
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6a_0
extends 3E {
    public double c = 0.0;
    public double 0 = 0.0;
    public boolean 1;
    public int 1 = 4;

    @Subscriber
    public void c(11 var1_1) {
        double d2;
        if (6a_0.c.player.onGround || 6a_0.c.player.isElytraFlying() || 6a_0.c.player.capabilities.isFlying) {
            return;
        }
        if (this.1 != 1 || 6a_0.c.player.moveForward == 0.0f || 6a_0.c.player.moveStrafing == 0.0f) {
            if (this.1 == 2 && (6a_0.c.player.moveForward != 0.0f || 6a_0.c.player.moveStrafing != 0.0f)) {
                this.c *= this.1 ? 1.6835 : 1.395;
            } else if (this.1 == 3) {
                d2 = 0.66 * (this.0 - this.c());
                this.c = this.0 - d2;
                this.1 = !this.1;
            } else {
                List list = 6a_0.c.world.getCollisionBoxes((Entity)6a_0.c.player, 6a_0.c.player.getEntityBoundingBox().offset(0.0, 6a_0.c.player.motionY, 0.0));
                if ((list.size() > 0 || 6a_0.c.player.collidedVertically) && this.1 > 0) {
                    this.1 = 6a_0.c.player.moveForward == 0.0f && 6a_0.c.player.moveStrafing == 0.0f ? 0 : 1;
                }
                this.c = this.0 - this.0 / 159.0;
            }
        } else {
            this.c = 1.35 * this.c() - 0.01;
        }
        this.c = Math.max(this.c, this.c());
        d2 = 6a_0.c.player.movementInput.moveForward;
        double d3 = 6a_0.c.player.movementInput.moveStrafe;
        float f2 = 6a_0.c.player.rotationYaw;
        if (d2 == 0.0 && d3 == 0.0) {
            var1_1.1(0.0);
            var1_1.c(0.0);
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
            var1_1.1(d2 * this.c * Math.cos(Math.toRadians(f2 + 90.0f)) + d3 * this.c * Math.sin(Math.toRadians(f2 + 90.0f)));
            var1_1.c(d2 * this.c * Math.sin(Math.toRadians(f2 + 90.0f)) - d3 * this.c * Math.cos(Math.toRadians(f2 + 90.0f)));
        }
        if (6a_0.c.player.moveForward == 0.0f && 6a_0.c.player.moveStrafing == 0.0f) {
            return;
        }
        ++this.1;
    }

    public double c() {
        double d2 = 0.2873;
        if (6a_0.c.player.isPotionActive(MobEffects.SPEED)) {
            int n2 = 6a_0.c.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d2 *= 1.0 + 0.2 * ((double)n2 + 1.0);
        }
        return d2;
    }

    @Subscriber
    public void c(1P p2) {
        if (!8x_0.c()) {
            6a_0.c.player.motionX = 0.0;
            6a_0.c.player.motionZ = 0.0;
            this.c = 0.0;
            return;
        }
        double d2 = 6a_0.c.player.posX - 6a_0.c.player.prevPosX;
        double d3 = 6a_0.c.player.posZ - 6a_0.c.player.prevPosZ;
        this.0 = Math.sqrt(d2 * d2 + d3 * d3);
    }

    @Override
    public void c() {
        if (6a_0.c.player == null || 6a_0.c.world == null) {
            this.d();
            return;
        }
        this.1 = 4;
        this.c = this.c();
        this.0 = 0.0;
    }

    public double c(double d2) {
        BigDecimal bigDecimal = new BigDecimal(d2);
        bigDecimal = bigDecimal.setScale(3, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketPlayerPosLook) {
            8k_0.c.c.c(this);
            this.c = 0.0;
            this.1 = 4;
            this.0 = 0.0;
        }
    }

    public 6a_0() {
        super("AirStrafe", "Strafe, but only works in the air", 3D.0, "AirMove");
    }
}

