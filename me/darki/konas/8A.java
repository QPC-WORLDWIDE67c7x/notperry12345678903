/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.math.MathHelper;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8A {
    public static 8A c = new 8A();
    public long c;
    public float[] c;
    public int c = new float[20];

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketTimeUpdate) {
            if (this.c != -1L) {
                long l2 = System.currentTimeMillis();
                float f2 = (float)(l2 - this.c) / 1000.0f;
                this.c[this.c % this.c.length] = MathHelper.clamp((float)(20.0f / f2), (float)0.0f, (float)20.0f);
                ++this.c;
            }
            this.c = System.currentTimeMillis();
        }
    }

    public float c() {
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (float f4 : this.c) {
            if (!(f4 > 0.0f)) continue;
            f3 += f4;
            f2 += 1.0f;
        }
        return MathHelper.clamp((float)(f3 / f2), (float)0.0f, (float)20.0f);
    }
}

