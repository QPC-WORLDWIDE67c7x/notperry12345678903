/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.11;
import me.darki.konas.14;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6k_0;
import me.darki.konas.8h_0;
import me.darki.konas.8z_0;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

/*
 * Renamed from me.darki.konas.6l
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6l_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Accelerate", true);
    public static 8h_0<6k_0> 2 = new 8h_0("Horizontal", 6k_0.c);
    public static 8h_0<Float> 3 = new 8h_0("Multiplier", Float.valueOf(1.0f), Float.valueOf(50.0f), Float.valueOf(1.0f), Float.valueOf(0.5f));
    public static 8h_0<Integer> 4 = new 8h_0("ShiftTicks", 1, 10, 0, 1);
    public boolean 1;
    public boolean 2;

    @Subscriber
    public void c(11 var1_1) {
        block3: {
            if (this.2) {
                return;
            }
            if (!this.1 || 6l_0.c.player.onGround || !(var1_1.0() < 0.0)) break block3;
            for (int i2 = 0; i2 < (Integer)4.6(); ++i2) {
                this.2 = true;
                6l_0.c.player.move(var1_1.c(), 2.6() == 6k_0.1 ? var1_1.2() : 0.0, var1_1.0(), 2.6() == 6k_0.1 ? var1_1.1() : 0.0);
                this.2 = false;
                8z_0.c(6l_0.c.player.rotationYaw, 6l_0.c.player.rotationPitch);
                if (!((Boolean)1.6()).booleanValue()) continue;
                var1_1.0(var1_1.0() - 0.08);
                6l_0.c.player.motionY -= 0.08;
            }
            if (2.6() == 6k_0.c) {
                var1_1.1(0.0);
                var1_1.c(0.0);
            }
        }
    }

    public 6l_0() {
        super("FastFall", "Makes you fall faster", 3D.0, new String[0]);
    }

    @Subscriber
    public void c(14 var1_1) {
        if (6l_0.c.world.getBlockState(new BlockPos((Entity)6l_0.c.player)).getBlock() != Blocks.AIR) {
            this.1 = false;
            return;
        }
        if (6l_0.c.player.onGround) {
            6l_0.c.player.motionY = -0.0784 * (double)((Float)3.6()).floatValue();
            this.1 = true;
        }
        if (6l_0.c.player.motionY > 0.0) {
            this.1 = false;
        }
    }

    @Override
    public void c() {
        this.1 = false;
        this.2 = false;
    }
}

