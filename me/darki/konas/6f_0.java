/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.0a_0;
import me.darki.konas.13;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8x_0;
import me.darki.konas.mixin.mixins.ISPacketPlayerPosLook;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.6f
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6f_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("FixYaw", true);
    public static 8h_0<Boolean> 2 = new 8h_0("AntiKick", true);
    public static 8h_0<Boolean> 3 = new 8h_0("Confirm", false);
    public static 8h_0<Boolean> 4 = new 8h_0("Bypass", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Semi", true);
    public static 8h_0<Boolean> 6 = new 8h_0("Constrict", false);
    public static 8h_0<Float> 7 = new 8h_0("Speed", Float.valueOf(1.0f), Float.valueOf(50.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Float> 8 = new 8h_0("VSpeed", Float.valueOf(0.5f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public static 8h_0<Integer> 9 = new 8h_0("SafetyFactor", 2, 10, 0, 1);
    public static 8h_0<Integer> a = new 8h_0("MaxSetbacks", 10, 20, 0, 1);
    public int 1;
    public Vec3d c;
    public int 2;
    public AtomicBoolean c = new AtomicBoolean(false);
    public int 3 = 0;

    /*
     * Unable to fully structure code
     */
    @Subscriber
    public void c(0S var1_1) {
        block14: {
            block9: {
                block10: {
                    block13: {
                        block12: {
                            block11: {
                                if (6f_0.c.player == null || 6f_0.c.world == null) {
                                    this.d();
                                    return;
                                }
                                if (!(var1_1.c() instanceof SPacketPlayerPosLook) || !6f_0.c.player.isRiding()) break block9;
                                var2_2 = (SPacketPlayerPosLook)var1_1.c();
                                ((ISPacketPlayerPosLook)var2_2).setYaw(6f_0.c.player.rotationYaw);
                                ((ISPacketPlayerPosLook)var2_2).setPitch(6f_0.c.player.rotationPitch);
                                var2_2.getFlags().remove(SPacketPlayerPosLook.EnumFlags.X_ROT);
                                var2_2.getFlags().remove(SPacketPlayerPosLook.EnumFlags.Y_ROT);
                                this.1 = var2_2.getTeleportId();
                                if ((Integer)6f_0.a.6() <= 0) break block10;
                                if (this.c != null) break block11;
                                this.c = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                                this.2 = 1;
                                break block10;
                            }
                            if (!8x_0.c()) break block12;
                            v0 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                            if (!(this.0(this.c, v0) < (double)((Float)6f_0.7.6()).floatValue() * 0.8)) break block12;
                            this.c = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                            ++this.2;
                            break block10;
                        }
                        if (!6f_0.c.gameSettings.keyBindJump.isKeyDown() && !6f_0.c.gameSettings.keyBindSneak.isKeyDown()) break block13;
                        v1 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                        if (!(this.c(this.c, v1) < (double)((Float)6f_0.8.6()).floatValue() * 0.5)) break block13;
                        this.c = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                        ++this.2;
                        break block10;
                    }
                    if (6f_0.c.gameSettings.keyBindJump.isKeyDown() || 6f_0.c.gameSettings.keyBindSneak.isKeyDown()) ** GOTO lbl-1000
                    if (this.c(this.c, new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ())) < 0.02) ** GOTO lbl-1000
                    v2 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                    if (this.c(this.c, v2) > 1.0) lbl-1000:
                    // 2 sources

                    {
                        this.c = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                        ++this.2;
                    } else lbl-1000:
                    // 2 sources

                    {
                        this.c = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                        this.2 = 1;
                    }
                }
                if ((Integer)6f_0.a.6() > 0 && this.2 > (Integer)6f_0.a.6()) {
                    return;
                }
                if (6f_0.c.player.isEntityAlive() && 6f_0.c.world.isBlockLoaded(new BlockPos(6f_0.c.player.posX, 6f_0.c.player.posY, 6f_0.c.player.posZ)) && !(6f_0.c.currentScreen instanceof GuiDownloadTerrain)) {
                    if (this.1 <= 0) {
                        this.1 = var2_2.getTeleportId();
                        return;
                    }
                    if (!((Boolean)6f_0.3.6()).booleanValue()) {
                        6f_0.c.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(var2_2.getTeleportId()));
                    }
                    var1_1.c(true);
                }
            }
            if (!(var1_1.c() instanceof SPacketMoveVehicle) || !6f_0.c.player.isRiding()) break block14;
            if (((Boolean)6f_0.5.6()).booleanValue()) {
                this.c.set(true);
            } else {
                var1_1.c(true);
            }
        }
    }

    public double 0(Vec3d vec3d, Vec3d vec3d2) {
        double d2 = vec3d.x - vec3d2.x;
        double d3 = vec3d.z - vec3d2.z;
        return MathHelper.sqrt((double)(d2 * d2 + d3 * d3));
    }

    @Subscriber
    public void c(0T t) {
        block3: {
            block4: {
                block2: {
                    if (6f_0.c.player == null || 6f_0.c.world == null) {
                        this.d();
                        return;
                    }
                    if (!((Boolean)4.6()).booleanValue()) {
                        return;
                    }
                    if (!(t.c() instanceof CPacketVehicleMove)) break block2;
                    if (!6f_0.c.player.isRiding() || 6f_0.c.player.ticksExisted % 2 != 0) break block3;
                    6f_0.c.playerController.interactWithEntity((EntityPlayer)6f_0.c.player, 6f_0.c.player.getRidingEntity(), (Boolean)6.6() != false ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
                    break block3;
                }
                if (!(t.c() instanceof CPacketPlayer.Rotation) || !6f_0.c.player.isRiding()) break block4;
                t.c();
                break block3;
            }
            if (!(t.c() instanceof CPacketInput) || ((Boolean)5.6()).booleanValue() && 6f_0.c.player.ticksExisted % 2 != 0) break block3;
            t.c();
        }
    }

    @Subscriber
    public void c(0a_0 a_02) {
        block0: {
            if (!6f_0.c.gameSettings.keyBindSneak.isKeyDown()) break block0;
            a_02.c(true);
        }
    }

    @Override
    public void c() {
        this.2 = 0;
        this.c = null;
        this.1 = 0;
        if (6f_0.c.player == null || 6f_0.c.world == null) {
            this.d();
            return;
        }
    }

    public double c(Vec3d vec3d, Vec3d vec3d2) {
        double d2 = vec3d.y - vec3d2.y;
        return MathHelper.sqrt((double)(d2 * d2));
    }

    public 6f_0() {
        super("BoatFly", 3D.0, "AirBoat", "BoatSpeed", "BoatPlus");
    }

    @Subscriber
    public void c(13 var1_1) {
        block15: {
            if (6f_0.c.player == null || 6f_0.c.world == null) {
                this.d();
                return;
            }
            if (!(6f_0.c.player.getRidingEntity() instanceof EntityBoat)) break block15;
            EntityBoat entityBoat = (EntityBoat)6f_0.c.player.getRidingEntity();
            double d2 = 0.0;
            double d3 = 0.0;
            double d4 = 0.0;
            if (8x_0.c()) {
                double[] dArray = 8x_0.c((double)((Float)7.6()).floatValue());
                d2 = dArray[0];
                d4 = dArray[1];
            } else {
                d2 = 0.0;
                d4 = 0.0;
            }
            if (6f_0.c.gameSettings.keyBindJump.isKeyDown()) {
                d3 = ((Float)8.6()).floatValue();
                if (((Boolean)2.6()).booleanValue() && 6f_0.c.player.ticksExisted % 20 == 0) {
                    d3 = -0.04;
                }
            } else if (6f_0.c.gameSettings.keyBindSneak.isKeyDown()) {
                d3 = -((Float)8.6()).floatValue();
            } else if (((Boolean)2.6()).booleanValue() && 6f_0.c.player.ticksExisted % 4 == 0) {
                d3 = -0.04;
            }
            if (((Boolean)1.6()).booleanValue()) {
                entityBoat.rotationYaw = 6f_0.c.player.rotationYaw;
            }
            if ((Integer)9.6() > 0 && !6f_0.c.world.isBlockLoaded(new BlockPos(entityBoat.posX + d2 * (double)((Integer)9.6()).intValue(), entityBoat.posY + d3 * (double)((Integer)9.6()).intValue(), entityBoat.posZ + d4 * (double)((Integer)9.6()).intValue()), false)) {
                d2 = 0.0;
                d4 = 0.0;
            }
            if (!((Boolean)5.6()).booleanValue() || 6f_0.c.player.ticksExisted % 2 != 0) {
                if (this.c.get() && ((Boolean)5.6()).booleanValue()) {
                    entityBoat.setVelocity(0.0, 0.0, 0.0);
                    this.c.set(false);
                } else {
                    entityBoat.setVelocity(d2, d3, d4);
                }
            }
            if (((Boolean)3.6()).booleanValue()) {
                ++this.1;
                6f_0.c.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(this.1));
            }
            var1_1.c(true);
        }
    }
}

