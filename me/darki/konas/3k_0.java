/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3s_0;
import me.darki.konas.3v_0;
import me.darki.konas.3x_0;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3k
 */
public class 3k_0
extends 3a_0 {
    public 8h_0<Boolean> c;

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        3x_0 x_02 = new 3x_0(this.2(), this.4(), 18.0f, 18.0f, 3.0f);
        3s_0.c(x_02, 3k_0.c(n2, n3, this.2(), this.4(), 18.0, 18.0) ? 6.c(((Float)3O.s.6()).floatValue()) : 6);
        3s_0.c(x_02, 2, 1.0f);
        if (((Boolean)this.c.6()).booleanValue()) {
            3v_0 v_02 = new 3v_0(this.2(), this.4(), 18.0f, 18.0f);
            3s_0.c(v_02, 9, 2.0f);
        }
        3s_0.0.c(this.c.c(), this.2() + 26.0f, (float)((int)(this.4() + (9.0f - 3s_0.0.c(this.c.c()) / 2.0f))), 9);
        if (this.c.0()) {
            3s_0.c.c(this.c.9(), this.2(), (float)((int)(this.4() + 26.0f)), b);
        }
    }

    public 3k_0(8h_0<Boolean> h_02, float f2, float f3, float f4, float f5, float f6) {
        super(h_02.c(), f2, f3, f4, f5, f6, h_02.0() ? 38.0f : 18.0f);
        this.c = h_02;
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (3k_0.c(n2, n3, this.2(), this.4(), 18.0, 18.0) && n4 == 0) {
            this.c.2(Boolean.valueOf((Boolean)this.c.6() == false));
            return true;
        }
        return super.0(n2, n3, n4);
    }
}

