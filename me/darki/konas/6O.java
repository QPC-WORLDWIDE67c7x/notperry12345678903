/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.init.MobEffects;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6O
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Levitation", true);
    public 8h_0<Boolean> 2 = new 8h_0("JumpBoost", true);

    public 6O() {
        super("AntiEffects", "Removes unwanted effects from the player", 3D.1, new String[0]);
    }

    @Subscriber
    public void c(1N n2) {
        if (6O.c.player != null) {
            if (((Boolean)this.1.6()).booleanValue() && 6O.c.player.isPotionActive(MobEffects.LEVITATION)) {
                6O.c.player.removeActivePotionEffect(MobEffects.LEVITATION);
            }
            if (((Boolean)this.2.6()).booleanValue() && 6O.c.player.isPotionActive(MobEffects.JUMP_BOOST)) {
                6O.c.player.removeActivePotionEffect(MobEffects.JUMP_BOOST);
            }
        }
    }
}

