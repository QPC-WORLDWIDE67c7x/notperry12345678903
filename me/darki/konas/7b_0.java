/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.mixin.mixins.IMinecraft;
import me.darki.konas.mixin.mixins.ITimer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7b
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7b_0
extends 3E {
    public 8h_0<Float> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Integer> 4;
    public 8h_0<Integer> 5;
    public 8h_0<Float> 6;
    public int 1 = 0;

    @Override
    public boolean 5() {
        return (Boolean)this.2.6() == false;
    }

    @Subscriber
    public void c(1N n2) {
        if (7b_0.c.world == null || 7b_0.c.player == null) {
            return;
        }
        if (((Boolean)this.2.6()).booleanValue()) {
            8k_0.c.c.c(true);
            this.0((float)Math.round(50.0f / ((ITimer)((IMinecraft)c).getTimer()).getTickLength() * 100.0f) / 100.0f + "");
        } else {
            8k_0.c.c.c(false);
            float f2 = ((Float)this.1.6()).floatValue();
            if (((Boolean)this.3.6()).booleanValue()) {
                if (this.1 > (Integer)this.4.6() + (Integer)this.5.6()) {
                    this.1 = 0;
                }
                if (this.1 > (Integer)this.4.6()) {
                    f2 = ((Float)this.6.6()).floatValue();
                }
            }
            8k_0.c.c.c(this, 5, f2);
            this.0((float)Math.round(50.0f / ((ITimer)((IMinecraft)c).getTimer()).getTickLength() * 100.0f) / 100.0f + "");
            ++this.1;
        }
    }

    public 7b_0() {
        super("Timer", "Changes game tick length", 0, 3D.1, new String[0]);
        this.2 = new 8h_0("TpsSync", false);
        this.3 = new 8h_0("Switch", false).c(this::5);
        this.4 = new 8h_0("Active", 5, 20, 1, 1).c(this.3::6);
        this.5 = new 8h_0("Inactive", 5, 20, 1, 1).c(this.3::6);
        this.6 = new 8h_0("InactiveSpeed", Float.valueOf(2.0f), Float.valueOf(50.0f), Float.valueOf(0.2f), Float.valueOf(0.5f)).c(this.3::6);
    }

    @Override
    public void 7() {
        8k_0.c.c.c(this);
        8k_0.c.c.c(false);
    }

    @Override
    public void c() {
        this.1 = 0;
    }
}

