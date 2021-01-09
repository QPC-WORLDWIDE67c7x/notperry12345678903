/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.11;
import me.darki.konas.1N;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.5d_0;
import me.darki.konas.77;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 78
extends 3E {
    public static 8h_0<77> 1 = new 8h_0("Mode", 77.0);
    public static 8h_0<Float> 2 = new 8h_0("StepHeight", Float.valueOf(1.0f), Float.valueOf(7.0f), Float.valueOf(0.5f), Float.valueOf(0.5f));
    public static 8h_0<Boolean> 3 = new 8h_0("Upwards", true);
    public static 8h_0<Boolean> 4 = new 8h_0("Reverse", true);
    public static 8h_0<Boolean> 5 = new 8h_0("UseTimer", false);
    public static 8h_0<Boolean> 6 = new 8h_0("SpeedDisable", true);
    public static 8h_0<Boolean> 7 = new 8h_0("AutoDisable", false);
    public boolean 1;
    public int 1 = 0;
    public int 2 = 0;
    public 9m c;
    public double c = 0.0;
    public static double[] c = new double[]{0.42, 0.753};
    public static double[] 0 = new double[]{0.42, 0.75, 1.0, 1.16, 1.23, 1.2};
    public static double[] 1 = new double[]{0.42, 0.78, 0.63, 0.51, 0.9, 1.21, 1.45, 1.43};
    public static double[] 2 = new double[]{0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869, 2.019, 1.907};

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)78.c).world == null || ((Minecraft)78.c).player == null) {
            return;
        }
        3E e2 = 3F.c("Speed");
        if (e2 != null && e2.f() && ((Boolean)6.6()).booleanValue()) {
            this.d();
        }
        if (((Minecraft)78.c).player.getRidingEntity() != null) {
            this.c.c();
        }
        if (((Boolean)5.6()).booleanValue()) {
            if (this.1 == 0) {
                8k_0.c.c.c(this);
            } else {
                --this.1;
            }
        } else {
            8k_0.c.c.c(this);
        }
    }

    public 78() {
        super("Step", "Instantly steps up blocks", 0, 3D.1, new String[0]);
    }

    public boolean c() {
        float f2 = 78.c.player.rotationYaw;
        if (78.c.player.moveForward < 0.0f) {
            f2 += 180.0f;
        }
        float f3 = 1.0f;
        if (78.c.player.moveForward < 0.0f) {
            f3 = -0.5f;
        } else if (78.c.player.moveForward > 0.0f) {
            f3 = 0.5f;
        }
        if (78.c.player.moveStrafing > 0.0f) {
            f2 -= 90.0f * f3;
        }
        if (78.c.player.moveStrafing < 0.0f) {
            f2 += 90.0f * f3;
        }
        float f4 = (float)Math.toRadians(f2);
        double d2 = (double)(-MathHelper.sin((float)f4)) * 0.4;
        double d3 = (double)MathHelper.cos((float)f4) * 0.4;
        return ((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(d2, 1.001335979112147, d3)).isEmpty();
    }

    @Override
    public void c() {
        this.1 = false;
    }

    @Override
    public void 7() {
        78.c.player.stepHeight = 0.5f;
        8k_0.c.c.c(this);
    }

    public double 0() {
        boolean bl;
        boolean bl2 = bl = 78.c.player.onGround && 78.c.player.collidedHorizontally;
        if (!bl) {
            return 0.0;
        }
        double d2 = -1.0;
        float f2 = 78.c.player.rotationYaw;
        if (78.c.player.moveForward < 0.0f) {
            f2 += 180.0f;
        }
        float f3 = 1.0f;
        if (78.c.player.moveForward < 0.0f) {
            f3 = -0.5f;
        } else if (78.c.player.moveForward > 0.0f) {
            f3 = 0.5f;
        }
        if (78.c.player.moveStrafing > 0.0f) {
            f2 -= 90.0f * f3;
        }
        if (78.c.player.moveStrafing < 0.0f) {
            f2 += 90.0f * f3;
        }
        float f4 = (float)Math.toRadians(f2);
        double d3 = (double)(-MathHelper.sin((float)f4)) * 0.4;
        double d4 = (double)MathHelper.cos((float)f4) * 0.4;
        AxisAlignedBB axisAlignedBB = ((Minecraft)78.c).player.getEntityBoundingBox().offset(0.0, 0.05, 0.0).grow(0.05);
        axisAlignedBB = axisAlignedBB.setMaxY(axisAlignedBB.maxY + (double)((Float)2.6()).floatValue());
        for (AxisAlignedBB axisAlignedBB2 : ((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, axisAlignedBB)) {
            if (!(axisAlignedBB2.maxY > d2)) continue;
            d2 = axisAlignedBB2.maxY;
        }
        return (d2 -= 78.c.player.posY) > 0.0 && d2 <= (double)((Float)2.6()).floatValue() ? d2 : 0.0;
    }

    @Subscriber
    public void c(11 var1_1) {
        if (1.6() != 77.2 || !((Boolean)3.6()).booleanValue()) {
            return;
        }
        if (!78.c.player.collidedHorizontally) {
            return;
        }
        if (78.c.player.onGround && this.c()) {
            78.c.player.motionY = 0.0;
            var1_1.0(0.41999998688698);
            this.2 = 1;
        } else if (this.2 == 1) {
            var1_1.0(0.33319999363422);
            this.2 = 2;
        } else if (this.2 == 2) {
            float f2 = 78.c.player.rotationYaw;
            if (78.c.player.moveForward < 0.0f) {
                f2 += 180.0f;
            }
            float f3 = 1.0f;
            if (78.c.player.moveForward < 0.0f) {
                f3 = -0.5f;
            } else if (78.c.player.moveForward > 0.0f) {
                f3 = 0.5f;
            }
            if (78.c.player.moveStrafing > 0.0f) {
                f2 -= 90.0f * f3;
            }
            if (78.c.player.moveStrafing < 0.0f) {
                f2 += 90.0f * f3;
            }
            float f4 = (float)Math.toRadians(f2);
            var1_1.0(0.24813599859094704);
            var1_1.1((double)(-MathHelper.sin((float)f4)) * 0.7);
            var1_1.c((double)MathHelper.cos((float)f4) * 0.7);
            this.2 = 0;
        }
    }

    @Subscriber
    public void c(1P p2) {
        3E e2 = 3F.c("Speed");
        if (e2 != null && e2.f() && ((Boolean)6.6()).booleanValue()) {
            this.d();
        }
        if (((Boolean)4.6()).booleanValue() && !3F.c(5d_0.class).f() && this.1 && !78.c.player.onGround && 78.c.player.motionY <= 0.0) {
            if (!78.c.player.world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(0.0, -3.01, 0.0)).isEmpty() && !((Minecraft)78.c).player.isInWater() && this.c.c(1000.0)) {
                78.c.player.motionY = -3.0;
            }
        }
        this.1 = 78.c.player.onGround;
        if (((Boolean)3.6()).booleanValue() && !((Minecraft)78.c).player.isInWater() && 78.c.player.onGround && !((Minecraft)78.c).player.isOnLadder() && !78.c.player.movementInput.jump && 78.c.player.collidedVertically && (double)78.c.player.fallDistance < 0.1) {
            if (1.6() == 77.c) {
                78.c.player.stepHeight = ((Float)2.6()).floatValue();
            } else if (1.6() == 77.0) {
                if (!this.c.c(320.0)) {
                    return;
                }
                this.c = this.0();
                if (this.c == 0.0) {
                    return;
                }
                if (this.c <= 1.0) {
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.42, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.75, 78.c.player.posZ, 78.c.player.onGround));
                    ((Minecraft)78.c).player.setPosition(78.c.player.posX, 78.c.player.posY + 1.0, 78.c.player.posZ);
                    return;
                }
                if (this.c <= (double)((Float)2.6()).floatValue() && this.c <= 1.5) {
                    p2.c(true);
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.42, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.75, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 1.0, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 1.16, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 1.23, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 1.2, 78.c.player.posZ, 78.c.player.onGround));
                    ((Minecraft)78.c).player.setPosition(78.c.player.posX, 78.c.player.posY + this.c, 78.c.player.posZ);
                    return;
                }
                if (this.c <= (double)((Float)2.6()).floatValue()) {
                    p2.c(true);
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.42, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.7800000000000002, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.63, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.51, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 0.9, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 1.21, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 1.45, 78.c.player.posZ, 78.c.player.onGround));
                    78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + 1.43, 78.c.player.posZ, 78.c.player.onGround));
                    ((Minecraft)78.c).player.setPosition(78.c.player.posX, 78.c.player.posY + this.c, 78.c.player.posZ);
                }
            } else if (1.6() == 77.1) {
                double[] dArray = 8x_0.c(0.1);
                if (((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 1.0, dArray[1])).isEmpty() && !((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 0.6, dArray[1])).isEmpty() && (double)((Float)2.6()).floatValue() >= 1.0) {
                    for (double d2 : c) {
                        78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + d2, 78.c.player.posZ, 78.c.player.onGround));
                    }
                    if (((Boolean)5.6()).booleanValue()) {
                        8k_0.c.c.c(this, 15, 0.6f);
                    }
                    ((Minecraft)78.c).player.setPosition(78.c.player.posX, 78.c.player.posY + 1.0, 78.c.player.posZ);
                    this.1 = 1;
                }
                if (((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 1.6, dArray[1])).isEmpty() && !((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 1.4, dArray[1])).isEmpty() && (double)((Float)2.6()).floatValue() >= 1.5) {
                    for (double d2 : 0) {
                        78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + d2, 78.c.player.posZ, 78.c.player.onGround));
                    }
                    if (((Boolean)5.6()).booleanValue()) {
                        8k_0.c.c.c(this, 15, 0.35f);
                    }
                    ((Minecraft)78.c).player.setPosition(78.c.player.posX, 78.c.player.posY + 1.5, 78.c.player.posZ);
                    this.1 = 1;
                }
                if (((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 2.1, dArray[1])).isEmpty() && !((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 1.9, dArray[1])).isEmpty() && (double)((Float)2.6()).floatValue() >= 2.0) {
                    for (double d2 : 1) {
                        78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + d2, 78.c.player.posZ, 78.c.player.onGround));
                    }
                    if (((Boolean)5.6()).booleanValue()) {
                        8k_0.c.c.c(this, 15, 0.25f);
                    }
                    ((Minecraft)78.c).player.setPosition(78.c.player.posX, 78.c.player.posY + 2.0, 78.c.player.posZ);
                    this.1 = 2;
                }
                if (((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 2.6, dArray[1])).isEmpty() && !((Minecraft)78.c).world.getCollisionBoxes((Entity)((Minecraft)78.c).player, ((Minecraft)78.c).player.getEntityBoundingBox().offset(dArray[0], 2.4, dArray[1])).isEmpty() && (double)((Float)2.6()).floatValue() >= 2.5) {
                    for (double d2 : 2) {
                        78.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(78.c.player.posX, 78.c.player.posY + d2, 78.c.player.posZ, 78.c.player.onGround));
                    }
                    if (((Boolean)5.6()).booleanValue()) {
                        8k_0.c.c.c(this, 15, 0.15f);
                    }
                    ((Minecraft)78.c).player.setPosition(78.c.player.posX, 78.c.player.posY + 2.5, 78.c.player.posZ);
                    this.1 = 2;
                }
            }
        } else if (1.6() == 77.c) {
            78.c.player.stepHeight = 0.5f;
        }
    }

    @Subscriber
    public void c(0S s) {
        block1: {
            if (!(s.c() instanceof SPacketPlayerPosLook)) break block1;
            this.c.c();
            if (((Boolean)7.6()).booleanValue()) {
                this.d();
            }
        }
    }
}

