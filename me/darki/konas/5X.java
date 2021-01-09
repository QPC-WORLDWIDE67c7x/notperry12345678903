/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Arrays;
import java.util.List;
import me.darki.konas.0S;
import me.darki.konas.3D;
import me.darki.konas.3E;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.SoundEvent;

public class 5X
extends 3E {
    public static List<SoundEvent> c = Arrays.asList(SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, SoundEvents.ITEM_ARMOR_EQUIP_IRON, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER);

    public 5X() {
        super("NoSoundLag", "Prevents users from lagging you with sound", 3D.3, "AntiSoundCrash");
    }

    @Subscriber
    public void c(0S s) {
        block0: {
            SPacketSoundEffect sPacketSoundEffect;
            if (!(s.c() instanceof SPacketSoundEffect) || !c.contains((sPacketSoundEffect = (SPacketSoundEffect)s.c()).getSound())) break block0;
            s.c(true);
        }
    }
}

