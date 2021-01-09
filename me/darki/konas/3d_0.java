/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3E;
import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3s_0;
import me.darki.konas.3w_0;
import me.darki.konas.8k_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3d
 */
public class 3d_0
extends 3a_0 {
    public 3E c;

    public 3E c() {
        return this.c;
    }

    public 3d_0(3E e2, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(e2.b(), f2, f3, f4, f5, f6, f7);
        this.c = e2;
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        block2: {
            if (!this.c(n2, n3)) break block2;
            if (n4 == 0) {
                this.c.d();
                return true;
            }
            if (n4 == 1) {
                8k_0.c.c.0().2().get((Object)this.c.e()).c(this.c);
            }
        }
        return super.0(n2, n3, n4);
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        3w_0 w_02 = new 3w_0(this.2(), this.4(), this.5(), this.8());
        3w_0 w_03 = new 3w_0(this.2(), this.4(), 4.0f, this.8());
        if (this.c.f()) {
            3s_0.c(w_02, this.c(n2, n3) ? 6.c(((Float)3O.s.6()).floatValue()) : 6);
            3s_0.c(w_02, 2, 1.0f);
        } else if (this.c(n2, n3)) {
            3s_0.c(w_02, 4.c(((Float)3O.s.6()).floatValue()));
        }
        if (8k_0.c.c.0().2().get((Object)this.c.e()).0() != null && 8k_0.c.c.0().2().get((Object)this.c.e()).0().equals(this.c)) {
            3s_0.c(w_03, 0);
            3s_0.c(w_03, 2, 1.0f);
        }
        3s_0.0.c(this.3(), this.2() + 12.0f, (float)((int)(this.4() + this.8() / 2.0f - 3s_0.0.c(this.3()) / 2.0f)), 9);
    }
}

