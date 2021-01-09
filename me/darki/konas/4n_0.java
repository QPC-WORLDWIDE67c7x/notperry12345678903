/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8J;
import me.darki.konas.8k_0;
import me.darki.konas.8u_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.4n
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4n_0
extends 3E {
    public static 9m c = new 9m();
    public static double c = 0.0;
    public static double 0 = 0.0;

    public static void c(float f2, float f3) {
        c = f2;
        0 = f3;
    }

    public float c(EntityPlayer entityPlayer, double d2, double d3) {
        double d4 = entityPlayer.posY + (double)(entityPlayer.getEyeHeight() / 2.0f) - (4n_0.c.player.posY + (double)((Minecraft)4n_0.c).player.getEyeHeight());
        double d5 = entityPlayer.posX - 4n_0.c.player.posX;
        double d6 = entityPlayer.posZ - 4n_0.c.player.posZ;
        double d7 = Math.sqrt(d5 * d5 + d6 * d6);
        return this.c(d2, d3, d7, d4);
    }

    public static boolean c(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    public static boolean 4(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    public static boolean 2(EntityPlayer entityPlayer) {
        return !8J.2(entityPlayer.getUniqueID().toString());
    }

    public 4n_0() {
        super("BowAim", 3D.c, "BowAimbot");
    }

    public static Float 0(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)4n_0.c).player.getDistance((Entity)entityPlayer));
    }

    @Subscriber(priority=100)
    public void c(1P p2) {
        double d2;
        double d3;
        float f2;
        if (p2.0()) {
            return;
        }
        if (!(((Minecraft)4n_0.c).player.getActiveItemStack().getItem() instanceof ItemBow)) {
            return;
        }
        EntityPlayer entityPlayer = 4n_0.c.world.playerEntities.stream().filter(4n_0::1).filter(4n_0::3).filter(4n_0::c).filter(4n_0::2).filter(4n_0::4).min(Comparator.comparing(4n_0::0)).orElse(null);
        if (entityPlayer == null) {
            return;
        }
        float f3 = (float)(((Minecraft)4n_0.c).player.getActiveItemStack().getMaxItemUseDuration() - ((Minecraft)4n_0.c).player.getItemInUseCount()) / 20.0f;
        if ((f3 = (f3 * f3 + f3 * 2.0f) / 3.0f) >= 1.0f) {
            f3 = 1.0f;
        }
        if (Float.isNaN(f2 = (float)(-Math.toDegrees(this.c(entityPlayer, d3 = (double)(f3 * 3.0f), d2 = (double)0.05f))))) {
            return;
        }
        double d4 = entityPlayer.posX - entityPlayer.lastTickPosX;
        double d5 = entityPlayer.posZ - entityPlayer.lastTickPosZ;
        double d6 = ((Minecraft)4n_0.c).player.getDistance((Entity)entityPlayer);
        d6 -= d6 % 2.0;
        d4 = d6 / 2.0 * d4 * (((Minecraft)4n_0.c).player.isSprinting() ? 1.3 : 1.1);
        d5 = d6 / 2.0 * d5 * (((Minecraft)4n_0.c).player.isSprinting() ? 1.3 : 1.1);
        float f4 = (float)Math.toDegrees(Math.atan2(entityPlayer.posZ + d5 - 4n_0.c.player.posZ, entityPlayer.posX + d4 - 4n_0.c.player.posX)) - 90.0f;
        8k_0.c.c.c(f4, f2);
        4n_0.c(f4, f2);
        c.c();
    }

    public static boolean 1(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    public static boolean 3(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)4n_0.c).player;
    }

    public float c(double d2, double d3, double d4, double d5) {
        double d6 = d3 * (d4 * d4);
        d5 = 2.0 * d5 * (d2 * d2);
        d5 = d3 * (d6 + d5);
        d5 = Math.sqrt(d2 * d2 * d2 * d2 - d5);
        d2 = d2 * d2 - d5;
        d5 = Math.atan2(d2 * d2 + d5, d3 * d4);
        d2 = Math.atan2(d2, d3 * d4);
        return (float)Math.min(d5, d2);
    }
}

