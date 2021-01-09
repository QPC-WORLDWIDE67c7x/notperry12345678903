/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.math.BigDecimal;
import java.math.RoundingMode;
import me.darki.konas.0S;
import me.darki.konas.11;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6v_0;
import me.darki.konas.6w_0;
import me.darki.konas.6x_0;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.6y
 */
public class 6y_0
extends 3E {
    public static 8h_0<6x_0> 1 = new 8h_0("Mode", 6x_0.0);
    public static 8h_0<Float> 2 = new 8h_0("Speed", Float.valueOf(4.5f), Float.valueOf(20.0f), Float.valueOf(0.5f), Float.valueOf(0.1f));
    public static 8h_0<Float> 3 = new 8h_0("Modifier", Float.valueOf(5.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Float> 4 = new 8h_0("Glide", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 5 = new 8h_0("ShortJump", false);
    public static 8h_0<Boolean> 6 = new 8h_0("DisableStrafe", true);
    public static 8h_0<6w_0> 7 = new 8h_0("GroundCheck", 6w_0.0);
    public static 8h_0<Boolean> 8 = new 8h_0("AutoDisable", false);
    public 9m c;
    public boolean 1;
    public boolean 2;
    public int 1;
    public double c = new 9m();
    public double 0;
    public int 2;
    public int 3;
    public double 1 = 0;
    public boolean 3;

    @Subscriber
    public void c(0S s) {
        block0: {
            if (!(s.c() instanceof SPacketPlayerPosLook) || !((Boolean)8.6()).booleanValue()) break block0;
            this.d();
        }
    }

    @Override
    public void c() {
        if (((Minecraft)6y_0.c).player != null && ((Minecraft)6y_0.c).world != null) {
            this.1 = 6y_0.c();
            6y_0.c.player.onGround = true;
        }
        this.3 = 7.6() != 6w_0.c;
        this.2 = false;
        this.1 = true;
        this.0 = 0.0;
        this.3 = 1;
    }

    @Subscriber
    public void c(11 var1_1) {
        if (this.3) {
            return;
        }
        if (((Minecraft)6y_0.c).player != c.getRenderViewEntity()) {
            return;
        }
        switch (6v_0.c[((6x_0)((Object)1.6())).ordinal()]) {
            case 1: {
                if (6y_0.c.player.moveStrafing <= 0.0f && 6y_0.c.player.moveForward <= 0.0f) {
                    this.3 = 1;
                }
                if (this.c(6y_0.c.player.posY - (double)((int)6y_0.c.player.posY), 3) == 0.943) {
                    6y_0.c.player.motionY -= 0.0157 * (double)((Float)4.6()).floatValue();
                    var1_1.0(var1_1.0() - 0.0157 * (double)((Float)4.6()).floatValue());
                }
                if (this.3 == 1 && (6y_0.c.player.moveForward != 0.0f || 6y_0.c.player.moveStrafing != 0.0f)) {
                    this.3 = 2;
                    this.1 = (double)((Float)2.6()).floatValue() * 6y_0.c() - 0.01;
                } else if (this.3 == 2) {
                    6y_0.c.player.motionY = 0.0848 * (double)((Float)3.6()).floatValue();
                    var1_1.0(0.0848 * (double)((Float)3.6()).floatValue());
                    this.3 = 3;
                    this.1 *= 2.149802;
                } else if (this.3 == 3) {
                    this.3 = 4;
                    this.c = 0.66 * this.0;
                    this.1 = this.0 - this.c;
                } else {
                    if (((Minecraft)6y_0.c).world.getCollisionBoxes((Entity)((Minecraft)6y_0.c).player, ((Minecraft)6y_0.c).player.getEntityBoundingBox().offset(0.0, 6y_0.c.player.motionY, 0.0)).size() > 0 || 6y_0.c.player.collidedVertically) {
                        this.3 = 1;
                    }
                    this.1 = this.0 - this.0 / 159.0;
                }
                this.1 = Math.max(this.1, 6y_0.c());
                float f2 = 6y_0.c.player.movementInput.moveForward;
                float f3 = 6y_0.c.player.movementInput.moveStrafe;
                float f4 = 6y_0.c.player.rotationYaw;
                if (f2 == 0.0f && f3 == 0.0f) {
                    var1_1.1(0.0);
                    var1_1.c(0.0);
                } else if (f2 != 0.0f) {
                    if (f3 >= 1.0f) {
                        f4 += (float)(f2 > 0.0f ? -45 : 45);
                        f3 = 0.0f;
                    } else if (f3 <= -1.0f) {
                        f4 += (float)(f2 > 0.0f ? 45 : -45);
                        f3 = 0.0f;
                    }
                    if (f2 > 0.0f) {
                        f2 = 1.0f;
                    } else if (f2 < 0.0f) {
                        f2 = -1.0f;
                    }
                }
                double d2 = Math.cos(Math.toRadians(f4 + 90.0f));
                double d3 = Math.sin(Math.toRadians(f4 + 90.0f));
                var1_1.1((double)f2 * this.1 * d2 + (double)f3 * this.1 * d3);
                var1_1.c((double)f2 * this.1 * d3 - (double)f3 * this.1 * d2);
                return;
            }
            case 2: {
                if (this.1) {
                    if (6y_0.c.player.onGround) {
                        this.c.c();
                    }
                    if (this.c(6y_0.c.player.posY - (double)((int)6y_0.c.player.posY), 3) == 0.41) {
                        6y_0.c.player.motionY = 0.0;
                    }
                    if (6y_0.c.player.moveStrafing <= 0.0f && 6y_0.c.player.moveForward <= 0.0f) {
                        this.2 = 1;
                    }
                    if (this.c(6y_0.c.player.posY - (double)((int)6y_0.c.player.posY), 3) == 0.943) {
                        6y_0.c.player.motionY = 0.0;
                    }
                    if (this.2 == 1) {
                        if (6y_0.c.player.moveForward != 0.0f || 6y_0.c.player.moveStrafing != 0.0f) {
                            this.2 = 2;
                            this.1 = (double)((Float)2.6()).floatValue() * 6y_0.c() - 0.01;
                        }
                    } else if (this.2 == 2) {
                        this.2 = 3;
                        if (!((Boolean)5.6()).booleanValue()) {
                            6y_0.c.player.motionY = 0.424;
                        }
                        var1_1.0(0.424);
                        this.1 *= 2.149802;
                    } else if (this.2 == 3) {
                        this.2 = 4;
                        double d4 = 0.66 * (this.0 - 6y_0.c());
                        this.1 = this.0 - d4;
                    } else {
                        if (((Minecraft)6y_0.c).world.getCollisionBoxes((Entity)((Minecraft)6y_0.c).player, ((Minecraft)6y_0.c).player.getEntityBoundingBox().offset(0.0, 6y_0.c.player.motionY, 0.0)).size() > 0 || 6y_0.c.player.collidedVertically) {
                            this.2 = 1;
                        }
                        this.1 = this.0 - this.0 / 159.0;
                    }
                    this.1 = Math.max(this.1, 6y_0.c());
                    float f5 = 6y_0.c.player.movementInput.moveForward;
                    float f6 = 6y_0.c.player.movementInput.moveStrafe;
                    float f7 = 6y_0.c.player.rotationYaw;
                    if (f5 == 0.0f || f6 == 0.0f) {
                        var1_1.1(0.0);
                        var1_1.c(0.0);
                    } else {
                        if (f6 >= 1.0f) {
                            f7 += (float)(f5 > 0.0f ? -45 : 45);
                            f6 = 0.0f;
                        } else if (f6 <= -1.0f) {
                            f7 += (float)(f5 > 0.0f ? 45 : -45);
                            f6 = 0.0f;
                        }
                        if (f5 > 0.0f) {
                            f5 = 1.0f;
                        } else if (f5 < 0.0f) {
                            f5 = -1.0f;
                        }
                    }
                    double d5 = Math.cos(Math.toRadians(f7 + 90.0f));
                    double d6 = Math.sin(Math.toRadians(f7 + 90.0f));
                    var1_1.1((double)f5 * this.1 * d5 + (double)f6 * this.1 * d6);
                    var1_1.c((double)f5 * this.1 * d6 - (double)f6 * this.1 * d5);
                    if (f5 == 0.0f && f6 == 0.0f) {
                        var1_1.1(0.0);
                        var1_1.c(0.0);
                    }
                }
                if (6y_0.c.player.onGround) {
                    ++this.1;
                } else if (!6y_0.c.player.onGround && this.1 != 0) {
                    --this.1;
                }
                if (((Boolean)5.6()).booleanValue()) {
                    if (this.c.c(35.0)) {
                        this.2 = true;
                    }
                    if (this.c.c(2490.0)) {
                        this.2 = false;
                        this.1 = false;
                        6y_0.c.player.motionX *= 0.0;
                        6y_0.c.player.motionZ *= 0.0;
                    }
                    if (!this.c.c(2820.0)) {
                        return;
                    }
                    this.1 = true;
                    6y_0.c.player.motionX *= 0.0;
                    6y_0.c.player.motionZ *= 0.0;
                    this.c.c();
                    break;
                }
                if (this.c.c(480.0)) {
                    6y_0.c.player.motionX *= 0.0;
                    6y_0.c.player.motionZ *= 0.0;
                    this.1 = false;
                }
                if (!this.c.c(780.0)) break;
                6y_0.c.player.motionX *= 0.0;
                6y_0.c.player.motionZ *= 0.0;
                this.1 = true;
                this.c.c();
                break;
            }
        }
    }

    public 6y_0() {
        super("LongJump", 3D.0, new String[0]);
    }

    public double c(double d2, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = new BigDecimal(d2);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static double c() {
        double d2 = 0.2873;
        if (((Minecraft)6y_0.c).player.isPotionActive(MobEffects.SPEED)) {
            int n2 = ((Minecraft)6y_0.c).player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d2 *= 1.0 + 0.2 * (double)(n2 + 1);
        }
        return d2;
    }

    @Subscriber
    public void c(1P p2) {
        if (this.3) {
            if (7.6() == 6w_0.0) {
                if (6y_0.c.player.onGround) {
                    this.3 = false;
                }
            } else if (7.6() == 6w_0.1 && 6y_0.c.player.onGround && !((Minecraft)6y_0.c).player.isSneaking() && ((Minecraft)6y_0.c).world.getCollisionBoxes((Entity)((Minecraft)6y_0.c).player, ((Minecraft)6y_0.c).player.getEntityBoundingBox().offset(0.0, 0.0, 0.0).shrink(0.001)).isEmpty()) {
                this.3 = false;
            }
        } else if (1.6() == 6x_0.c) {
            this.c = 6y_0.c.player.posX - 6y_0.c.player.prevPosX;
            double d2 = 6y_0.c.player.posZ - 6y_0.c.player.prevPosZ;
            this.0 = Math.sqrt(this.c * this.c + d2 * d2);
        } else {
            double d3 = 6y_0.c.player.posX - 6y_0.c.player.prevPosX;
            double d4 = 6y_0.c.player.posZ - 6y_0.c.player.prevPosZ;
            this.0 = Math.sqrt(d3 * d3 + d4 * d4);
            if (!this.2) {
                return;
            }
            6y_0.c.player.motionY = 0.005;
        }
    }

    @Override
    public void 7() {
        if (((Minecraft)6y_0.c).player != null && ((Minecraft)6y_0.c).world != null && 1.6() == 6x_0.0) {
            6y_0.c.player.onGround = false;
            6y_0.c.player.capabilities.isFlying = false;
        }
    }
}

