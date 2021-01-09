/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import me.darki.konas.0T;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.5y
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5y_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Rotate", true);
    public static 8h_0<Boolean> 2 = new 8h_0("Bypass", false);
    public static 8h_0<Integer> 3 = new 8h_0("Range", 4, 10, 1, 1);
    public static 8h_0<Float> 4 = new 8h_0("Delay", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 5 = new 8h_0("Boats", false);
    public static 8h_0<Boolean> 6 = new 8h_0("Horses", false);
    public static 8h_0<Boolean> 7 = new 8h_0("SkeletonHorses", false);
    public static 8h_0<Boolean> 8 = new 8h_0("Donkeys", true);
    public static 8h_0<Boolean> 9 = new 8h_0("Pigs", false);
    public static 8h_0<Boolean> a = new 8h_0("Llamas", false);
    public 9m c;
    public 9m 0;
    public float c;
    public float 0 = 0.0f;
    public Entity c = null;

    @Subscriber
    public void c(1O o2) {
        if (this.c != null) {
            ((Minecraft)5y_0.c).playerController.interactWithEntity((EntityPlayer)((Minecraft)5y_0.c).player, this.c, EnumHand.MAIN_HAND);
            this.c = null;
        }
    }

    public boolean c(Entity entity) {
        AbstractHorse abstractHorse;
        if (entity.getDistance((Entity)((Minecraft)5y_0.c).player) > (float)((Integer)3.6()).intValue()) {
            return false;
        }
        if (entity instanceof AbstractHorse && (abstractHorse = (AbstractHorse)entity).isChild()) {
            return false;
        }
        if (entity instanceof EntityBoat && ((Boolean)5.6()).booleanValue()) {
            return true;
        }
        if (entity instanceof EntitySkeletonHorse && ((Boolean)7.6()).booleanValue()) {
            return true;
        }
        if (entity instanceof EntityHorse && ((Boolean)6.6()).booleanValue()) {
            return true;
        }
        if (entity instanceof EntityDonkey && ((Boolean)8.6()).booleanValue()) {
            return true;
        }
        if (entity instanceof EntityPig && ((Boolean)9.6()).booleanValue()) {
            abstractHorse = (EntityPig)entity;
            return abstractHorse.getSaddled();
        }
        if (entity instanceof EntityLlama && ((Boolean)a.6()).booleanValue()) {
            abstractHorse = (EntityLlama)entity;
            return !abstractHorse.isChild();
        }
        return false;
    }

    @Subscriber(priority=10)
    public void c(1P p2) {
        block2: {
            if (((Minecraft)5y_0.c).player.isRiding()) {
                return;
            }
            if (!this.c.c(((Float)4.6()).floatValue() * 1000.0f)) {
                return;
            }
            this.c.c();
            this.c = 5y_0.c.world.loadedEntityList.stream().filter(this::1).min(Comparator.comparing(5y_0::0)).orElse(null);
            if (!((Boolean)1.6()).booleanValue() || this.c == null) break block2;
            double[] dArray = 8x_0.c(this.c.posX, this.c.posY, this.c.posZ, (EntityPlayer)((Minecraft)5y_0.c).player);
            this.c = (float)dArray[0];
            this.0 = (float)dArray[1];
            this.0.c();
        }
    }

    @Subscriber
    public void c(0T t) {
        block4: {
            CPacketPlayer cPacketPlayer;
            if (((Minecraft)5y_0.c).world == null || ((Minecraft)5y_0.c).player == null) {
                return;
            }
            if (t.c() instanceof CPacketPlayer && !this.0.c(350.0)) {
                cPacketPlayer = (CPacketPlayer)t.c();
                if (t.c() instanceof CPacketPlayer.Position) {
                    t.c(true);
                    5y_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(cPacketPlayer.getX(5y_0.c.player.posX), cPacketPlayer.getY(5y_0.c.player.posY), cPacketPlayer.getZ(5y_0.c.player.posZ), this.c, this.0, cPacketPlayer.isOnGround()));
                } else {
                    ((ICPacketPlayer)cPacketPlayer).setYaw(this.c);
                    ((ICPacketPlayer)cPacketPlayer).setPitch(this.0);
                }
            }
            if (!((Boolean)2.6()).booleanValue() || !(t.c() instanceof CPacketUseEntity) || !((cPacketPlayer = (CPacketUseEntity)t.c()).getEntityFromWorld((World)((Minecraft)5y_0.c).world) instanceof AbstractChestHorse) || cPacketPlayer.getAction() != CPacketUseEntity.Action.INTERACT_AT) break block4;
            t.c();
        }
    }

    public 5y_0() {
        super("AutoMount", 3D.3, new String[0]);
        this.0 = new 9m();
    }

    public boolean 1(Entity entity) {
        return this.c(entity);
    }

    public static Float 0(Entity entity) {
        return Float.valueOf(((Minecraft)5y_0.c).player.getDistance(entity));
    }
}

