/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3D;
import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3p_0;
import me.darki.konas.3s_0;
import me.darki.konas.3x_0;
import me.darki.konas.8k_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3b
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3b_0
extends 3a_0 {
    public 3D c;
    public int 0;
    public 3x_0 c;
    public 3x_0 0;

    public 3b_0(3D d2, float f2, float f3, float f4, float f5, float f6, float f7, int n2) {
        super(d2.name(), f2, f3, f4, f5, f6, f7);
        this.c = d2;
        this.0 = n2;
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (this.c(n2, n3)) {
            8k_0.c.c.0().c(this.c);
            return true;
        }
        return super.0(n2, n3, n4);
    }

    @Override
    public void 9() {
        this.c = new 3x_0(this.2(), this.4(), this.5(), this.8(), 3.0f, 25, this.0);
        this.0 = new 3x_0(this.2(), this.4() - 1.0f, this.5(), this.8() + 2.0f, 3.0f, 25, 3);
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        boolean bl;
        super.0(n2, n3, f2);
        boolean bl2 = bl = 8k_0.c.c.0().0() == this.c;
        if (bl) {
            3s_0.c(this.0, (3p_0)(this.c(n2, n3) ? (int)0.c(((Float)3O.s.6()).floatValue()) : 0));
            3s_0.c(this.0, 2, 1.0f);
        } else {
            3s_0.c(this.c, this.c(n2, n3) ? 1.c(((Float)3O.s.6()).floatValue()) : 1);
        }
        String string = this.3();
        if (string.equals("MOVEMENT")) {
            string = "TRAVEL";
        }
        3s_0.0.c(string, (float)((int)(this.2() + this.5() / 2.0f - 3s_0.0.0(string) / 2.0f)), (float)((int)(this.4() + this.8() / 2.0f - 3s_0.0.c(this.3()) / 2.0f)), 9);
    }
}

