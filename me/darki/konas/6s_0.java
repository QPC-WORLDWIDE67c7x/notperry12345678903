/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import net.minecraft.init.Blocks;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.6s
 */
public class 6s_0
extends 3E {
    public 6s_0() {
        super("IceSpeed", 3D.0, new String[0]);
    }

    @Subscriber
    public void c(1N n2) {
        Blocks.ICE.slipperiness = 0.4f;
        Blocks.FROSTED_ICE.slipperiness = 0.4f;
        Blocks.PACKED_ICE.slipperiness = 0.4f;
    }

    @Override
    public void 7() {
        Blocks.ICE.slipperiness = 0.98f;
        Blocks.FROSTED_ICE.slipperiness = 0.98f;
        Blocks.PACKED_ICE.slipperiness = 0.98f;
    }
}

