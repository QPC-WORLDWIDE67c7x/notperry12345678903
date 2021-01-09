/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.darki.konas.2E;
import me.darki.konas.2n_0;
import me.darki.konas.94;
import me.darki.konas.9f;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2W
extends 2E {
    public Float c(PotionEffect potionEffect, Float f2) {
        return Float.valueOf(Math.max(f2.floatValue(), 9f.0(this.0(potionEffect))));
    }

    public void c(AtomicInteger atomicInteger, AtomicReference atomicReference, PotionEffect potionEffect) {
        atomicInteger.set(atomicInteger.get() + (int)9f.c(this.0(potionEffect)) + 1);
        atomicReference.updateAndGet(arg_0 -> this.c(potionEffect, arg_0));
    }

    public int 1(PotionEffect potionEffect) {
        String string;
        switch (string = this.c(potionEffect)) {
            case "Absorption": {
                return new Color(33, 118, 255).hashCode();
            }
            case "Fire Resistance": {
                return new Color(247, 152, 36).hashCode();
            }
            case "Regeneration": {
                return new Color(232, 142, 237).hashCode();
            }
            case "Strength": 
            case "Resistance": {
                return new Color(237, 28, 36).hashCode();
            }
            case "Hunger": {
                return new Color(41, 191, 18).hashCode();
            }
            case "Jump Boost": {
                return new Color(0, 204, 51).hashCode();
            }
            case "Haste": {
                return new Color(255, 207, 0).hashCode();
            }
            case "Speed": {
                return new Color(0, 255, 227).hashCode();
            }
        }
        return Color.WHITE.hashCode();
    }

    public String 0(PotionEffect potionEffect) {
        return this.c(potionEffect) + " " + Potion.getPotionDurationString((PotionEffect)potionEffect, (float)1.0f);
    }

    public String c(PotionEffect potionEffect) {
        return I18n.format((String)potionEffect.getEffectName(), (Object[])new Object[0]);
    }

    public void c(AtomicReference atomicReference, AtomicInteger atomicInteger, PotionEffect potionEffect) {
        9f.0(this.0(potionEffect), this.d() == 0.0f ? this.9() : this.9() + ((Float)atomicReference.get()).floatValue() - 9f.0(this.0(potionEffect)), (float)atomicInteger.get() + this.3(), this.1(potionEffect));
        atomicInteger.addAndGet((int)9f.c(this.0(potionEffect)) + 1);
    }

    @Override
    public void 5() {
        block0: {
            super.5();
            AtomicInteger atomicInteger = new AtomicInteger(2);
            AtomicReference<Float> atomicReference = new AtomicReference<Float>(Float.valueOf(0.0f));
            2W.c.player.getActivePotionEffects().stream().forEach(arg_0 -> this.c(atomicInteger, atomicReference, arg_0));
            atomicReference.set(Float.valueOf(Math.max(atomicReference.get().floatValue(), 5.0f)));
            this.c(atomicReference.get().floatValue() + 1.0f);
            this.0((float)atomicInteger.get());
            AtomicInteger atomicInteger2 = new AtomicInteger(0);
            2W.c.player.getActivePotionEffects().stream().forEach(arg_0 -> this.c(atomicReference, atomicInteger2, arg_0));
            if (2W.c.player.getActivePotionEffects().stream().count() != 0L || !(2W.c.currentScreen instanceof 2n_0)) break block0;
            94.c(this.9(), this.3(), this.c(), this.7(), 0, 0x34000000);
        }
    }

    public 2W() {
        super("Potions", 350.0f, 350.0f, 30.0f, 40.0f);
    }
}

