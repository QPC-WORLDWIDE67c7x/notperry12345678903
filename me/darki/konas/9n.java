/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1N;
import me.darki.konas.3E;
import me.darki.konas.8B;
import me.darki.konas.mixin.mixins.IMinecraft;
import me.darki.konas.mixin.mixins.ITimer;
import net.minecraft.client.Minecraft;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9n {
    public 3E c;
    public int c;
    public float c;
    public boolean c = false;
    public boolean 0 = false;

    public boolean c() {
        return this.0;
    }

    public void c(3E e2, int n2, float f2) {
        if (e2 == this.c) {
            this.c = n2;
            this.c = f2;
            this.c = true;
        } else if (n2 > this.c || !this.c) {
            this.c = e2;
            this.c = n2;
            this.c = f2;
            this.c = true;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Subscriber
    public void c(1N n2) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            ((ITimer)((IMinecraft)Minecraft.getMinecraft()).getTimer()).setTickLength(50.0f);
            return;
        }
        if (this.0 && (double)8B.c.1() > 0.125) {
            ((ITimer)((IMinecraft)Minecraft.getMinecraft()).getTimer()).setTickLength(Math.min(500.0f, 50.0f * (20.0f / 8B.c.1())));
            return;
        }
        ((ITimer)((IMinecraft)Minecraft.getMinecraft()).getTimer()).setTickLength(this.c ? 50.0f / this.c : 50.0f);
    }

    public void c(boolean bl) {
        this.0 = bl;
    }

    public void c(3E e2) {
        if (this.c == e2) {
            this.c = false;
        }
    }
}

