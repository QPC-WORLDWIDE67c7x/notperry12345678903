/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Arrays;
import me.darki.konas.0S;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7w_0;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.potion.PotionEffect;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.7x
 */
public class 7x_0
extends 3E {
    public float c;
    public 8e_0<7w_0> c;
    public 8h_0<Boolean> 1;
    public 8h_0<Boolean> 2;
    public long c = (float)new 8e_0("Mode", 7w_0.c, this::c);

    public void c(7w_0 w_02) {
        block5: {
            if (7x_0.c.world == null || 7x_0.c.player == null) break block5;
            if (w_02 != 7w_0.c) {
                if (7x_0.c.player.dimension == -1) {
                    7x_0.0();
                } else {
                    7x_0.2();
                }
            }
            if (w_02 != 7w_0.0) {
                7x_0.c.gameSettings.gammaSetting = this.c;
            }
            if (w_02 != 7w_0.1) {
                7x_0.c.player.removePotionEffect(MobEffects.NIGHT_VISION);
            }
        }
    }

    public boolean 1() {
        return this.c.6() == 7w_0.1;
    }

    @Override
    public void 7() {
        if (7x_0.c.player == null || 7x_0.c.world == null) {
            return;
        }
        if (this.c.6() == 7w_0.0) {
            7x_0.c.gameSettings.gammaSetting = this.c;
        } else if (this.c.6() == 7w_0.c) {
            if (7x_0.c.player.dimension == -1) {
                7x_0.0();
            } else {
                7x_0.2();
            }
        } else {
            7x_0.c.player.removePotionEffect(MobEffects.NIGHT_VISION);
        }
    }

    public boolean c() {
        return this.c.6() == 7w_0.0;
    }

    public static void 0() {
        float f2 = 0.1f;
        for (int i2 = 0; i2 <= 15; ++i2) {
            float f3 = 1.0f - (float)i2 / 15.0f;
            7x_0.c.world.provider.getLightBrightnessTable()[i2] = (1.0f - f3) / (f3 * 3.0f + 1.0f) * 0.9f + 0.1f;
        }
    }

    public static void 2() {
        float f2 = 0.0f;
        for (int i2 = 0; i2 <= 15; ++i2) {
            float f3 = 1.0f - (float)i2 / 15.0f;
            7x_0.c.world.provider.getLightBrightnessTable()[i2] = (1.0f - f3) / (f3 * 3.0f + 1.0f) * 1.0f + 0.0f;
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (7x_0.c.world == null || 7x_0.c.player == null) {
            return;
        }
        if (this.c.6() == 7w_0.0) {
            7x_0.c.gameSettings.gammaSetting = (Boolean)this.1.6() != false ? this.c + 20.0f * Math.min(1.0f, (float)(System.currentTimeMillis() - this.c) / 1000.0f) : this.c + 20.0f;
        } else if (this.c.6() == 7w_0.c) {
            Arrays.fill(7x_0.c.world.provider.getLightBrightnessTable(), 1.0f);
        } else {
            7x_0.c.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 5210));
        }
    }

    public 7x_0() {
        super("FullBright", "Makes everything bright", 0, 3D.2, new String[0]);
        this.1 = new 8h_0("Sine", false).c(this::c);
        this.2 = new 8h_0("Cancel", false).c(this::1);
    }

    @Subscriber
    public void c(0S s) {
        block1: {
            if (!(s.c() instanceof SPacketEntityEffect) || !((Boolean)this.2.6()).booleanValue()) break block1;
            SPacketEntityEffect sPacketEntityEffect = (SPacketEntityEffect)s.c();
            if (7x_0.c.player != null && sPacketEntityEffect.getEntityId() == 7x_0.c.player.getEntityId() && (sPacketEntityEffect.getEffectId() == 9 || sPacketEntityEffect.getEffectId() == 15)) {
                s.c(true);
            }
        }
    }

    @Override
    public void c() {
        this.c = 7x_0.c.gameSettings.gammaSetting;
        this.c = System.currentTimeMillis();
    }
}

