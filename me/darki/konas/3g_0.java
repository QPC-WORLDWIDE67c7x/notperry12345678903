/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.Iterator;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3h_0;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3g
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3g_0
extends 3a_0 {
    public 3E c;
    public ArrayList<3h_0> c = new ArrayList();

    @Override
    public void c(int n2, int n3, int n4) {
        super.c(n2, n3, n4);
        Iterator iterator = ((ArrayList)((Object)this.c)).iterator();
        while (iterator.hasNext()) {
            3h_0 h_02 = (3h_0)iterator.next();
            h_02.c(n2, n3, n4);
        }
    }

    public void c(3h_0 h_02) {
        h_02.c(this.2(), this.4());
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> 3g_0.c(n2, n3, f2, arg_0));
    }

    @Override
    public void c(float f2, float f3) {
        super.c(f2, f3);
        ((ArrayList)((Object)this.c)).forEach(this::c);
    }

    public 3g_0(3E e2, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(e2.b(), f2, f3, f4, f5, f6, f7);
        this.c = e2;
        boolean bl = (Boolean)3O.c.6() == false;
        float f8 = 16.0f;
        float f9 = 16.0f;
        ((ArrayList)((Object)this.c)).add(new 3h_0("General", e2, null, this.2(), this.4(), 16.0f, f8, 296.0f, false));
        f8 += 16.0f + ((3h_0)((ArrayList)((Object)this.c)).get(0)).8();
        for (8h_0 h_02 : 3F.1(e2)) {
            if (!(h_02.6() instanceof 8f_0)) continue;
            if (bl && f8 < f9) {
                bl = false;
            }
            3h_0 h_03 = new 3h_0(h_02.c(), e2, (8f_0)h_02.6(), this.2(), this.4(), bl ? 328.0f : 16.0f, bl ? f9 : f8, 296.0f, bl);
            ((ArrayList)((Object)this.c)).add(h_03);
            if (bl) {
                f9 += 16.0f + h_03.8();
            } else {
                f8 += 16.0f + h_03.8();
            }
            if (((Boolean)3O.c.6()).booleanValue()) {
                bl = false;
                continue;
            }
            bl = !bl;
        }
    }

    public static void c(int n2, int n3, float f2, 3h_0 h_02) {
        h_02.c(n2, n3, f2);
    }

    @Override
    public boolean c(int n2, int n3, int n4, long l2) {
        if (super.c(n2, n3, n4, l2)) {
            return true;
        }
        Iterator iterator = ((ArrayList)((Object)this.c)).iterator();
        while (iterator.hasNext()) {
            3h_0 h_02 = (3h_0)iterator.next();
            if (!h_02.c(n2, n3, n4, l2)) continue;
            return true;
        }
        return false;
    }

    public static void c(char c2, int n2, 3h_0 h_02) {
        h_02.c(c2, n2);
    }

    public static void 0(3h_0 h_02) {
        h_02.0(h_02.c() - 40.0f);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (super.0(n2, n3, n4)) {
            return true;
        }
        Iterator iterator = ((ArrayList)((Object)this.c)).iterator();
        while (iterator.hasNext()) {
            3h_0 h_02 = (3h_0)iterator.next();
            if (!h_02.0(n2, n3, n4)) continue;
            return true;
        }
        return false;
    }

    public static void 1(3h_0 h_02) {
        h_02.0(h_02.c() + 40.0f);
    }

    @Override
    public void c(char c2, int n2) {
        super.c(c2, n2);
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> 3g_0.c(c2, n2, arg_0));
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        block0: {
            block1: {
                super.0(n2, n3, f2);
                GL11.glEnable((int)3089);
                94.c(new ScaledResolution(Minecraft.getMinecraft()), this.2(), this.4(), this.5(), this.8());
                ((ArrayList)((Object)this.c)).forEach(arg_0 -> 3g_0.0(n2, n3, f2, arg_0));
                GL11.glDisable((int)3089);
                if (!this.c(n2, n3)) break block0;
                if (c <= 0) break block1;
                if (!(((3h_0)((ArrayList)((Object)this.c)).get(0)).c() < 0.0f)) break block0;
                ((ArrayList)((Object)this.c)).forEach(3g_0::1);
                break block0;
            }
            if (c >= 0 || !(((3h_0)((ArrayList)((Object)this.c)).get(((ArrayList)((Object)this.c)).size() - 1)).4() + ((3h_0)((ArrayList)((Object)this.c)).get(((ArrayList)((Object)this.c)).size() - 1)).8() > this.4() + this.8()) && (((ArrayList)((Object)this.c)).size() <= 1 || !(((3h_0)((ArrayList)((Object)this.c)).get(((ArrayList)((Object)this.c)).size() - 2)).4() + ((3h_0)((ArrayList)((Object)this.c)).get(((ArrayList)((Object)this.c)).size() - 2)).8() > this.4() + this.8()))) break block0;
            ((ArrayList)((Object)this.c)).forEach(3g_0::0);
        }
    }

    public static void 0(int n2, int n3, float f2, 3h_0 h_02) {
        h_02.0(n2, n3, f2);
    }
}

