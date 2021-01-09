/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.Subscriber;
import java.util.Arrays;
import java.util.EventListener;
import me.darki.konas.0S;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8B
implements EventListener {
    public static 8B c;
    public float[] c;
    public int c;
    public long c = 0;

    public void 3() {
        this.c = 0;
        this.c = -1L;
        Arrays.fill(this.c, 0.0f);
    }

    public float 1() {
        float f2;
        float f3;
        float f4;
        try {
            f4 = this.c[this.c.length - 1];
            f3 = 0.0f;
            f2 = 20.0f;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 20.0f;
        }
        return MathHelper.clamp((float)f4, (float)f3, (float)f2);
    }

    public void c() {
        if (this.c != -1L) {
            float f2 = (float)(System.currentTimeMillis() - this.c) / 1000.0f;
            this.c[this.c % this.c.length] = MathHelper.clamp((float)(20.0f / f2), (float)0.0f, (float)20.0f);
            ++this.c;
        }
        this.c = System.currentTimeMillis();
    }

    public float 2() {
        float f2 = 20.0f;
        for (float f3 : this.c) {
            if (!(f3 > 0.0f) || !(f3 < f2)) continue;
            f2 = f3;
        }
        return MathHelper.clamp((float)f2, (float)0.0f, (float)20.0f);
    }

    public float 0() {
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (float f4 : this.c) {
            if (!(f4 > 0.0f)) continue;
            f3 += f4;
            f2 += 1.0f;
        }
        return MathHelper.clamp((float)(f3 / f2), (float)0.0f, (float)20.0f);
    }

    public 8B() {
        EventDispatcher.Companion.register(this);
        EventDispatcher.Companion.subscribe(this);
        this.3();
    }

    @Subscriber
    public void c(0S s) {
        block0: {
            if (!(s.c() instanceof SPacketTimeUpdate)) break block0;
            c.c();
        }
    }
}

