/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.38;
import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3s_0;
import me.darki.konas.3x_0;
import me.darki.konas.8a_0;
import me.darki.konas.8h_0;
import net.minecraft.client.settings.GameSettings;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3j
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3j_0
extends 3a_0 {
    public 8h_0<8a_0> c;
    public boolean c = false;

    @Override
    public void c(char c2, int n2) {
        super.c(c2, n2);
        if (this.c) {
            if (n2 == 1) {
                ((8a_0)this.c.6()).c(0);
                this.c = false;
                38.c = true;
                return;
            }
            ((8a_0)this.c.6()).c(n2);
            this.c = false;
        }
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        3x_0 x_02 = new 3x_0(this.2(), this.4() + (float)(this.c.0() ? 34 : 18), 132.0f, 20.0f, 3.0f);
        3s_0.c(x_02, 3j_0.c(n2, n3, this.2(), this.4() + (float)(this.c.0() ? 34 : 18), 132.0, 20.0) ? 5.c(((Float)3O.s.6()).floatValue()) : 5);
        3s_0.0.c(this.c.c(), this.2(), this.4(), 9);
        if (this.c.0()) {
            3s_0.c.c(this.c.9(), this.2(), (float)((int)(this.4() + 18.0f)), b);
        }
        String string = this.c ? "Press a key..." : GameSettings.getKeyDisplayString((int)((8a_0)this.c.6()).c());
        3s_0.0.c(string, (float)((int)(this.2() + 66.0f - 3s_0.0.0(string) / 2.0f)), (float)((int)(this.4() + (this.c.0() ? 43.5f : 27.5f) - 3s_0.0.c(string) / 2.0f)), a);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (3j_0.c(n2, n3, this.2(), this.4() + (float)(this.c.0() ? 34 : 18), 132.0, 20.0)) {
            this.c = true;
            return true;
        }
        return super.0(n2, n3, n4);
    }

    public 3j_0(8h_0<8a_0> h_02, float f2, float f3, float f4, float f5, float f6) {
        super(h_02.c(), f2, f3, f4, f5, f6, h_02.0() ? 54.0f : 38.0f);
        this.c = h_02;
    }
}

