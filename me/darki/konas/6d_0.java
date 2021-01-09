/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.11;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6b_0;
import me.darki.konas.8h_0;
import me.darki.konas.8r_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

/*
 * Renamed from me.darki.konas.6d
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6d_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Center", true);
    public static 8h_0<Integer> 2 = new 8h_0("VRange", 4, 10, 1, 1);
    public static 8h_0<6b_0> 3 = new 8h_0("Mode", 6b_0.c);
    public static 8h_0<Boolean> 4 = new 8h_0("PitchTrigger", false);
    public static 8h_0<Integer> 5 = new 8h_0("Pitch", 0, 90, -90, 1).c(4::6);
    public static 8h_0<Boolean> 6 = new 8h_0("TurnOffAfter", true);
    public 9m c = new 9m();

    @Subscriber
    public void c(11 var1_1) {
        block7: {
            if (((Boolean)4.6()).booleanValue() && 6d_0.c.player.rotationPitch < (float)((Integer)5.6()).intValue()) {
                return;
            }
            BlockPos blockPos = new BlockPos((Entity)((Minecraft)6d_0.c).player);
            if (this.c(blockPos)) {
                this.c.c();
                if (((Boolean)6.6()).booleanValue()) {
                    this.d();
                }
            }
            boolean bl = false;
            for (int i2 = 1; i2 < (Integer)2.6(); ++i2) {
                if (!this.c(blockPos.down(i2))) continue;
                bl = true;
                break;
            }
            if (!bl) break block7;
            double d2 = Math.floor(6d_0.c.player.posX);
            double d3 = Math.floor(6d_0.c.player.posZ);
            double d4 = Math.abs(6d_0.c.player.posX - d2);
            double d5 = Math.abs(6d_0.c.player.posZ - d3);
            if (d4 < (double)0.3f || d4 > (double)0.7f || d5 < (double)0.3f || d5 > (double)0.7f) {
                if (((Boolean)1.6()).booleanValue()) {
                    ((Minecraft)6d_0.c).player.setPosition((double)blockPos.getX() + 0.5, 6d_0.c.player.posY, (double)blockPos.getZ() + 0.5);
                } else {
                    return;
                }
            }
            var1_1.1(0.0);
            var1_1.c(0.0);
        }
    }

    public boolean c(BlockPos blockPos) {
        if (3.6() == 6b_0.0) {
            return 8r_0.1(blockPos);
        }
        return 8r_0.5(blockPos);
    }

    public 6d_0() {
        super("Anchor", 3D.0, new String[0]);
    }
}

