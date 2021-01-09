/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3s_0;
import me.darki.konas.3u_0;
import me.darki.konas.3x_0;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3m
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3m_0
extends 3a_0 {
    public 8h_0<Enum> c;
    public boolean c = false;

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (3m_0.c(n2, n3, this.2(), this.4() + (this.c.0() ? 34.0f : 18.0f), this.5(), 20.0)) {
            if (n4 == 0) {
                this.c = !this.c;
            } else if (n4 == 1) {
                int n5 = this.c.3(((Enum)this.c.6()).toString());
                if (this.c(n5 + 1)) {
                    this.c.2(((Enum[])((Enum)this.c.6()).getClass().getEnumConstants())[n5 + 1]);
                } else {
                    this.c.2(((Enum[])((Enum)this.c.6()).getClass().getEnumConstants())[0]);
                }
            }
            return true;
        }
        if (this.c) {
            float f2 = this.c.0() ? 54.0f : 38.0f;
            for (int i2 = 0; i2 <= ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants()).length - 1; ++i2) {
                Enum enum_ = ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants())[i2];
                if (enum_.name().equalsIgnoreCase(((Enum)this.c.6()).toString())) continue;
                if (3m_0.c(n2, n3, this.2(), this.4() + f2, this.5(), 20.0)) {
                    this.c.2(enum_.name());
                    this.c = false;
                    return true;
                }
                f2 += 20.0f;
            }
        }
        return super.0(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        if (this.c) {
            float f3 = this.c.0() ? 54.0f : 38.0f;
            for (int i2 = 0; i2 <= ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants()).length - 1; ++i2) {
                Enum enum_ = ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants())[i2];
                if (enum_.name().equalsIgnoreCase(((Enum)this.c.6()).toString())) continue;
                boolean bl = i2 == ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants()).length - 1 || i2 == ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants()).length - 2 && ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants())[i2 + 1].name().equalsIgnoreCase(((Enum)this.c.6()).toString());
                3x_0 x_02 = new 3x_0(this.2(), this.4() + f3, this.5(), 20.0f, 3.0f, 25, bl ? 12 : 0);
                3s_0.c(x_02, 3m_0.c(n2, n3, this.2(), this.4() + f3, this.5(), 20.0) ? 5.c(((Float)3O.s.6()).floatValue()) : 5);
                3s_0.0.c(enum_.name(), this.2() + 6.0f, (float)((int)(this.4() + f3 + 9.5f - 3s_0.0.c(enum_.name()) / 2.0f)), a);
                f3 += 20.0f;
            }
        }
    }

    public 3m_0(8h_0<Enum> h_02, float f2, float f3, float f4, float f5, float f6) {
        super(h_02.c(), f2, f3, f4, f5, f6, h_02.0() ? 54.0f : 38.0f);
        this.c = h_02;
    }

    public boolean c(int n2) {
        return n2 <= ((Enum[])((Enum)this.c.6()).getClass().getEnumConstants()).length - 1 && n2 >= 0;
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        3x_0 x_02 = new 3x_0(this.2(), this.4() + (float)(this.c.0() ? 34 : 18), this.5(), 20.0f, 3.0f, 25, this.c ? 3 : 15);
        3s_0.c(x_02, 3m_0.c(n2, n3, this.2(), this.4() + (float)(this.c.0() ? 34 : 18), this.5(), 20.0) ? 5.c(((Float)3O.s.6()).floatValue()) : 5);
        3u_0 u_02 = new 3u_0(this.2() + this.5() - 17.0f, this.4() + (float)(this.c.0() ? 41 : 25), 10.0f, 6.0f, this.c);
        3s_0.c(u_02, a, 3.0f);
        3s_0.0.c(this.c.c(), this.2(), this.4(), 9);
        if (this.c.0()) {
            3s_0.c.c(this.c.9(), this.2(), (float)((int)(this.4() + 18.0f)), b);
        }
        3s_0.0.c(((Enum)this.c.6()).toString(), (float)((int)(this.2() + 6.0f)), (float)((int)(this.4() + (this.c.0() ? 43.5f : 27.5f) - 3s_0.0.c(((Enum)this.c.6()).toString()) / 2.0f)), a);
    }
}

