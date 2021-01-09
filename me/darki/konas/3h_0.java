/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.Iterator;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.3a_0;
import me.darki.konas.3j_0;
import me.darki.konas.3k_0;
import me.darki.konas.3l_0;
import me.darki.konas.3m_0;
import me.darki.konas.3n_0;
import me.darki.konas.3o_0;
import me.darki.konas.3s_0;
import me.darki.konas.3x_0;
import me.darki.konas.89;
import me.darki.konas.8a_0;
import me.darki.konas.8f_0;
import me.darki.konas.8g_0;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3h
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3h_0
extends 3a_0 {
    public 3E c;
    public 8f_0 c;
    public ArrayList<3a_0> c = new ArrayList();

    @Override
    public void c(char c2, int n2) {
        super.c(c2, n2);
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> 3h_0.c(c2, n2, arg_0));
    }

    public static void c(int n2, int n3, int n4, 3a_0 a_02) {
        a_02.c(n2, n3, n4);
    }

    public static void 0(int n2, int n3, float f2, 3a_0 a_02) {
        a_02.c(n2, n3, f2);
    }

    @Override
    public void c(int n2, int n3, int n4) {
        super.c(n2, n3, n4);
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> 3h_0.c(n2, n3, n4, arg_0));
    }

    public void c(3a_0 a_02) {
        a_02.c(this.2(), this.4());
    }

    public void 0(3a_0 a_02) {
        a_02.c(this.2(), this.4());
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        Iterator iterator = ((ArrayList)((Object)this.c)).iterator();
        while (iterator.hasNext()) {
            3a_0 a_02 = (3a_0)iterator.next();
            if (!a_02.0(n2, n3, n4)) continue;
            return true;
        }
        return super.0(n2, n3, n4);
    }

    @Override
    public boolean c(int n2, int n3, int n4, long l2) {
        Iterator iterator = ((ArrayList)((Object)this.c)).iterator();
        while (iterator.hasNext()) {
            3a_0 a_02 = (3a_0)iterator.next();
            if (!a_02.c(n2, n3, n4, l2)) continue;
            return true;
        }
        return super.c(n2, n3, n4, l2);
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        3x_0 x_02 = new 3x_0(this.2(), this.4(), this.5(), this.8(), 3.0f);
        3s_0.c(x_02, 4);
        3s_0.0.c(this.3(), this.2() + 16.0f, this.4() + 16.0f, 9);
        if (this.c == null && !this.c.8().isEmpty()) {
            3s_0.c.c(this.c.8(), this.2() + 16.0f, this.4() + 32.0f, b);
        }
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> 3h_0.c(n2, n3, f2, arg_0));
    }

    @Override
    public void c(float f2, float f3) {
        super.c(f2, f3);
        ((ArrayList)((Object)this.c)).forEach(this::0);
    }

    @Override
    public void 0(float f2) {
        super.0(f2);
        ((ArrayList)((Object)this.c)).forEach(this::c);
    }

    public static void c(char c2, int n2, 3a_0 a_02) {
        a_02.c(c2, n2);
    }

    public static void c(int n2, int n3, float f2, 3a_0 a_02) {
        a_02.0(n2, n3, f2);
    }

    public 3h_0(String string, 3E e2, 8f_0 f_02, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        super(string, f2, f3, f4, f5, f6, 0.0f);
        this.c = e2;
        this.c = f_02;
        float f7 = 48.0f;
        if (f_02 == null && !e2.8().isEmpty()) {
            f7 += 16.0f;
        }
        for (8h_0 h_02 : 3F.1(e2)) {
            3a_0 a_02;
            if ((h_02.3() || f_02 != null) && (h_02.5() == null || h_02.5().6() != f_02)) continue;
            if (h_02.6() instanceof Boolean) {
                a_02 = new 3k_0(h_02, this.2(), this.4(), 16.0f, f7, this.5() - 32.0f);
                ((ArrayList)((Object)this.c)).add(a_02);
                f7 += a_02.8() + 16.0f;
                continue;
            }
            if (h_02.6() instanceof 8a_0) {
                a_02 = new 3j_0(h_02, this.2(), this.4(), 16.0f, f7, this.5() - 32.0f);
                ((ArrayList)((Object)this.c)).add(a_02);
                f7 += a_02.8() + 16.0f;
                continue;
            }
            if (h_02.6() instanceof Enum) {
                a_02 = new 3m_0(h_02, this.2(), this.4(), 16.0f, f7, this.5() - 32.0f);
                ((ArrayList)((Object)this.c)).add(a_02);
                f7 += 16.0f + a_02.8();
                continue;
            }
            if (h_02.6() instanceof Number) {
                a_02 = new 3o_0(h_02, this.2(), this.4(), 16.0f, f7, this.5() - 32.0f);
                ((ArrayList)((Object)this.c)).add(a_02);
                f7 += 16.0f + a_02.8();
                continue;
            }
            if (h_02.6() instanceof 89) {
                a_02 = new 3l_0(h_02, this.2(), this.4(), 16.0f, f7, this.5() - 32.0f, bl);
                ((ArrayList)((Object)this.c)).add(a_02);
                f7 += 16.0f + a_02.8();
                continue;
            }
            if (!(h_02.6() instanceof 8g_0)) continue;
            a_02 = new 3n_0(h_02, this.2(), this.4(), 16.0f, f7, this.5() - 32.0f, 200.0f);
            ((ArrayList)((Object)this.c)).add(a_02);
            f7 += 16.0f + a_02.8();
        }
        this.3(f7);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> 3h_0.0(n2, n3, f2, arg_0));
    }
}

