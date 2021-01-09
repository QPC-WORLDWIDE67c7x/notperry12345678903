/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.Subscriber;
import java.lang.reflect.Field;
import java.util.ArrayList;
import me.darki.konas.0F;
import me.darki.konas.0S;
import me.darki.konas.1a_0;
import me.darki.konas.2E;
import me.darki.konas.2H;
import me.darki.konas.2I;
import me.darki.konas.2J;
import me.darki.konas.2K;
import me.darki.konas.2L;
import me.darki.konas.2M;
import me.darki.konas.2N;
import me.darki.konas.2O;
import me.darki.konas.2Q;
import me.darki.konas.2R;
import me.darki.konas.2S;
import me.darki.konas.2T;
import me.darki.konas.2U;
import me.darki.konas.2V;
import me.darki.konas.2W;
import me.darki.konas.2Y;
import me.darki.konas.2Z;
import me.darki.konas.30;
import me.darki.konas.31;
import me.darki.konas.32;
import me.darki.konas.33;
import me.darki.konas.36;
import me.darki.konas.37;
import me.darki.konas.3c_0;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.play.server.SPacketChat;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2F {
    public ArrayList<2E> c = new ArrayList();
    public static 9m c = new 9m();

    public ArrayList<2E> c() {
        return this.c;
    }

    public static int c(2E e2, 2E e3) {
        return e2.0().compareToIgnoreCase(e3.0());
    }

    /*
     * Unable to fully structure code
     */
    public static ArrayList<8h_0> c(2E var0) {
        var1_1 = (2E)var0.getClass().getSuperclass().cast(var0);
        var2_2 = new ArrayList<8h_0>();
        for (Field var6_6 : var1_1.getClass().getDeclaredFields()) {
            if (!8h_0.class.isAssignableFrom(var6_6.getType())) continue;
            var6_6.setAccessible(true);
            v0 = 8e_0.class;
            v1 = var6_6;
            v2 = v1.getType();
            v3 = v0.isAssignableFrom(v2);
            if (!v3) ** GOTO lbl28
            v4 = var2_2;
            v5 = var6_6;
            v6 = var1_1;
            v7 = v5.get(v6);
            v8 = (8e_0)v7;
            v4.add(v8);
            continue;
lbl28:
            // 1 sources

            v9 = var2_2;
            v10 = var6_6;
            v11 = var1_1;
            v12 = v10.get(v11);
            v13 = (8h_0)v12;
            v9.add(v13);
            try {
            }
            catch (IllegalAccessException var7_7) {
                var7_7.printStackTrace();
            }
        }
        for (Field var6_6 : var1_1.getClass().getSuperclass().getDeclaredFields()) {
            if (!8h_0.class.isAssignableFrom(var6_6.getType())) continue;
            var6_6.setAccessible(true);
            v14 = var2_2;
            v15 = var6_6;
            v16 = var1_1;
            v17 = v15.get(v16);
            v18 = (8h_0)v17;
            v14.add(v18);
            try {
            }
            catch (IllegalAccessException var7_9) {
                var7_9.printStackTrace();
            }
        }
        return var2_2;
    }

    @Subscriber
    public void c(0S s) {
        block0: {
            if (s.c() instanceof SPacketChat) break block0;
            c.c();
        }
    }

    public void 0() {
        EventDispatcher.Companion.register(this);
        EventDispatcher.Companion.subscribe(this);
        this.c.add(new 2H());
        this.c.add(new 2V());
        this.c.add(new 31());
        this.c.add(new 2Q());
        this.c.add(new 36());
        this.c.add(new 2K());
        this.c.add(new 30());
        this.c.add(new 3c_0());
        this.c.add(new 2T());
        this.c.add(new 2M());
        this.c.add(new 2U());
        this.c.add(new 2S());
        this.c.add(new 2Y());
        this.c.add(new 2Z());
        this.c.add(new 2I());
        this.c.add(new 2W());
        this.c.add(new 2J());
        this.c.add(new 2O());
        this.c.add(new 32());
        this.c.add(new 2R());
        this.c.add(new 2L());
        this.c.add(new 37());
        this.c.add(new 2N());
        this.c.add(new 33());
        this.c.sort(2F::c);
    }

    @Subscriber
    public void c(1a_0 a_02) {
        2E.c = new ScaledResolution(Minecraft.getMinecraft());
        for (2E e2 : this.c()) {
            if (!e2.6()) continue;
            e2.5();
        }
    }

    @Subscriber
    public void c(0F f2) {
        for (2E e2 : this.c()) {
            if (!e2.6()) continue;
            e2.c(f2.c());
        }
    }
}

