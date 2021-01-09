/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.79;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.ICPacketAnimation;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;

/*
 * Renamed from me.darki.konas.7a
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7a_0
extends 3E {
    public 8h_0<79> 1 = new 8h_0("Mode", 79.c);
    public 8h_0<Boolean> 2 = new 8h_0("Strict", false);
    public 8h_0<Boolean> 3 = new 8h_0("Render", false);

    public 7a_0() {
        super("Swing", "Modifies swinging behavior", 3D.1, new String[0]);
    }

    public int c() {
        if (7a_0.c.player.isPotionActive(MobEffects.HASTE)) {
            return 6 - (1 + 7a_0.c.player.getActivePotionEffect(MobEffects.HASTE).getAmplifier());
        }
        return 7a_0.c.player.isPotionActive(MobEffects.MINING_FATIGUE) ? 6 + (1 + 7a_0.c.player.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) * 2 : 6;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Subscriber
    public void c(0T t) {
        CPacketAnimation cPacketAnimation;
        if (7a_0.c.player == null) return;
        if (7a_0.c.world == null) {
            return;
        }
        if (!(t.c() instanceof CPacketAnimation)) return;
        if (this.1.6() == 79.c) {
            if (!((Boolean)this.2.6()).booleanValue() || 7a_0.c.playerController.getIsHittingBlock()) {
                t.c();
            }
        } else if (this.1.6() == 79.0) {
            cPacketAnimation = (CPacketAnimation)t.c();
            ((ICPacketAnimation)cPacketAnimation).setHand(EnumHand.OFF_HAND);
        } else if (this.1.6() == 79.1) {
            cPacketAnimation = (CPacketAnimation)t.c();
            ((ICPacketAnimation)cPacketAnimation).setHand(EnumHand.MAIN_HAND);
        } else if (this.1.6() == 79.2) {
            cPacketAnimation = (CPacketAnimation)t.c();
            ((ICPacketAnimation)cPacketAnimation).setHand(cPacketAnimation.getHand() == EnumHand.MAIN_HAND ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
        }
        if ((Boolean)this.3.6() == false) return;
        cPacketAnimation = ((CPacketAnimation)t.c()).getHand();
        try {
            if (7a_0.c.player.isSwingInProgress && 7a_0.c.player.swingProgressInt < this.c() / 2) {
                if (7a_0.c.player.swingProgressInt >= 0) return;
            }
            7a_0.c.player.swingProgressInt = -1;
            7a_0.c.player.isSwingInProgress = true;
            7a_0.c.player.swingingHand = cPacketAnimation;
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

