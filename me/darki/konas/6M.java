/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6K;
import me.darki.konas.6L;
import me.darki.konas.8J;
import me.darki.konas.8L;
import me.darki.konas.8M;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6M
extends 3E {
    public static 8h_0<6K> 1 = new 8h_0("Mode", 6K.c);
    public static 8h_0<6L> 2 = new 8h_0("Pitch", 6L.0);
    public static 8h_0<Integer> 3 = new 8h_0("Speed", 10, 55, 1, 1);
    public static 8h_0<Integer> 4 = new 8h_0("YawAdd", 0, 180, -180, 10);
    public float c = 0.0f;
    public float 0 = 0.0f;

    public static Float 2(EntityPlayer entityPlayer) {
        return Float.valueOf(6M.c.player.getDistance((Entity)entityPlayer));
    }

    public EntityPlayer c() {
        return 6M.c.world.playerEntities.stream().filter(6M::1).filter(6M::0).filter(6M::c).min(Comparator.comparing(6M::2)).orElse(null);
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return !8J.1(entityPlayer.getName());
    }

    public 6M() {
        super("AntiAim", "Breaks motion prediction in bad clients", 3D.1, "SpinBot");
    }

    public static boolean c(EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)6M.c.player) < 10.0f;
    }

    @Subscriber(priority=0)
    public void c(1P p2) {
        EntityPlayer entityPlayer;
        if (p2.0() || !8L.c()) {
            return;
        }
        this.c = 1.6() == 6K.c ? (this.c += (float)((Integer)3.6()).intValue()) : (1.6() == 6K.0 ? (Math.random() > 0.5 ? (float)((double)this.c + (double)((Integer)3.6()).intValue() * Math.random()) : (float)((double)this.c - (double)((Integer)3.6()).intValue() * Math.random())) : ((entityPlayer = this.c()) != null ? 8M.c(6M.c.player.getPositionEyes(1.0f), entityPlayer.getPositionEyes(1.0f))[0] - 180.0f : 6M.c.player.rotationYaw));
        this.c += (float)((Integer)4.6()).intValue();
        this.c = MathHelper.wrapDegrees((int)((int)this.c));
        this.0 = 2.6() == 6L.c ? 6M.c.player.rotationPitch : (2.6() == 6L.0 ? (Math.random() > 0.5 ? (float)((double)this.0 + (double)((Integer)3.6()).intValue() * Math.random()) : (float)((double)this.0 - (double)((Integer)3.6()).intValue() * Math.random())) : (2.6() == 6L.1 ? ((entityPlayer = this.c()) != null ? 8M.c(6M.c.player.getPositionEyes(1.0f), entityPlayer.getPositionEyes(1.0f))[1] : 6M.c.player.rotationPitch) : 90.0f));
        if (this.0 > 89.0f) {
            this.0 = 89.0f;
        } else if (this.0 < -89.0f) {
            this.0 = -89.0f;
        }
        8k_0.c.c.c(this.c, this.0);
    }

    public static boolean 1(EntityPlayer entityPlayer) {
        return entityPlayer != 6M.c.player;
    }
}

