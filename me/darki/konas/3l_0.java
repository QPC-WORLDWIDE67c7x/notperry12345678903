/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3p_0;
import me.darki.konas.3s_0;
import me.darki.konas.3w_0;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import me.darki.konas.96;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3l
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3l_0
extends 3a_0 {
    public 8h_0<89> c;
    public boolean c = false;
    public int 0;
    public int 1;
    public int 2;
    public int 3;
    public float 5 = 100.0f;
    public float 6 = this.5 / 10.0f;
    public float 7 = this.2() + 246.0f;
    public float 8 = this.4() + 82.0f;
    public float 9 = 12.0f;
    public boolean 0;

    public void c() {
        if (this.0 > 255) {
            this.0 = 255;
        }
        if (this.1 > 255) {
            this.1 = 255;
        }
        if (this.2 > 255) {
            this.2 = 255;
        }
        if (this.3 > 255) {
            this.3 = 255;
        }
        if (this.0 < 0) {
            this.0 = 0;
        }
        if (this.1 < 0) {
            this.1 = 0;
        }
        if (this.2 < 0) {
            this.2 = 0;
        }
        if (this.3 < 0) {
            this.3 = 0;
        }
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        block20: {
            super.0(n2, n3, f2);
            3s_0.0.c(this.c.c(), this.2(), this.4(), (3p_0)9);
            if (this.c.0()) {
                3s_0.c.c(this.c.9(), this.2(), (float)((int)(this.4() + 18.0f)), b);
            }
            94.c(this.2() + 240.0f, this.4(), 24.0f, 12.0f, ((89)this.c.6()).c());
            94.c(this.2() + 240.0f, this.4(), 24.0f, 12.0f, 1.0f, ((89)this.c.6()).1(255).c());
            if (!this.c) break block20;
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f, 40.0, 17.5)) {
                if (c > 0) {
                    ++this.1;
                } else if (c < 0) {
                    --this.1;
                }
                c = (8h_0<89>)false;
            } else if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 17.5f, 40.0, 17.5)) {
                if (c > 0) {
                    ++this.2;
                } else if (c < 0) {
                    --this.2;
                }
                c = (8h_0<89>)false;
            } else if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 35.0f, 40.0, 17.5)) {
                if (c > 0) {
                    ++this.3;
                } else if (c < 0) {
                    --this.3;
                }
                c = (8h_0<89>)false;
            } else if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 52.5f, 40.0, 17.5)) {
                if (c > 0) {
                    ++this.0;
                } else if (c < 0) {
                    --this.0;
                }
                c = (8h_0<89>)false;
            }
            this.c();
            this.1();
        }
    }

    @Override
    public boolean c(int n2, int n3, int n4, long l2) {
        block7: {
            if (!this.c) break block7;
            if (3l_0.c(n2, n3, this.2() + 248.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f, 98.0, 70.0)) {
                this.0(n2, n3);
                return true;
            }
            if (3l_0.c(n2, n3, this.7, this.8, this.5 - 2.0f, this.9)) {
                this.5(n2);
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f, 40.0, 17.5)) {
                this.1 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 17.5f, 40.0, 17.5)) {
                this.2 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 35.0f, 40.0, 17.5)) {
                this.3 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 52.5f, 40.0, 17.5)) {
                this.0 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 240.0f - (float)(this.0 ? 108 : 0), this.4(), 156.0, 100.0)) {
                return true;
            }
            this.c = false;
        }
        return super.c(n2, n3, n4, l2);
    }

    public void 0(float f2, float f3) {
        float f4 = ((f2 -= this.2() + 246.0f - (float)(this.0 ? 108 : 0)) - 1.0f) / 100.0f;
        float f5 = 1.0f - (f3 -= this.4() + 6.0f) / 70.0f;
        float[] fArray = Color.RGBtoHSB(this.1, this.2, this.3, null);
        int n2 = Color.HSBtoRGB(fArray[0], f4, f5);
        this.1 = n2 >> 16 & 0xFF;
        this.2 = n2 >> 8 & 0xFF;
        this.3 = n2 & 0xFF;
        this.1();
    }

    public void 5(float f2) {
        float f3 = (f2 -= this.7) / this.5;
        float[] fArray = Color.RGBtoHSB(this.1, this.2, this.3, null);
        int n2 = Color.HSBtoRGB(f3, fArray[1], fArray[2]);
        this.1 = n2 >> 16 & 0xFF;
        this.2 = n2 >> 8 & 0xFF;
        this.3 = n2 & 0xFF;
        this.1();
    }

    public void 1() {
        int n2 = (this.0 & 0xFF) << 24 | (this.1 & 0xFF) << 16 | (this.2 & 0xFF) << 8 | this.3 & 0xFF;
        this.0().0(n2);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (this.c) {
            if (3l_0.c(n2, n3, this.2() + 248.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f, 98.0, 70.0)) {
                this.0(n2, n3);
                return true;
            }
            if (3l_0.c(n2, n3, this.7, this.8, this.5 - 2.0f, this.9)) {
                this.5(n2);
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f, 40.0, 17.5)) {
                this.1 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 17.5f, 40.0, 17.5)) {
                this.2 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 35.0f, 40.0, 17.5)) {
                this.3 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 52.5f, 40.0, 17.5)) {
                this.0 = (int)(((float)n2 - (this.2() + 350.0f - (float)(this.0 ? 108 : 0))) / 40.0f * 255.0f);
                this.1();
                return true;
            }
            if (3l_0.c(n2, n3, this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.8, 40.0, this.9)) {
                ((89)this.c.6()).c(!((89)this.c.6()).7());
            }
            if (3l_0.c(n2, n3, this.2() + 240.0f - (float)(this.0 ? 108 : 0), this.4(), 156.0, 100.0)) {
                return true;
            }
            this.c = false;
        }
        if (3l_0.c(n2, n3, this.2() + 240.0f, this.4(), 24.0, 12.0)) {
            if (n4 == 0) {
                this.c = !this.c;
            } else if (n4 == 1) {
                ((89)this.c.6()).0(3O.1);
            } else if (n4 == 2) {
                3O.1 = ((89)this.c.6()).0();
            }
            return true;
        }
        this.c = false;
        return super.0(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        if (this.c) {
            float[] fArray = Color.RGBtoHSB(this.1, this.2, this.3, null);
            3w_0 w_02 = new 3w_0(this.2() + 240.0f - (float)(this.0 ? 108 : 0), this.4(), 156.0f, 100.0f);
            3s_0.c(w_02, 4);
            96.c(this.2() + 246.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f, this.2() + 346.0f - (float)(this.0 ? 108 : 0), this.4() + 76.0f, Color.getHSBColor(fArray[0], 0.0f, 0.0f).getRGB(), Color.getHSBColor(fArray[0], 0.0f, 1.0f).getRGB(), Color.getHSBColor(fArray[0], 1.0f, 0.0f).getRGB(), Color.getHSBColor(fArray[0], 1.0f, 1.0f).getRGB());
            this.7 = this.2() + 246.0f - (float)(this.0 ? 108 : 0);
            this.8 = this.4() + 82.0f;
            float f3 = 0.0f;
            while (f3 + this.6 <= this.5) {
                96.c(this.7 + f3, this.8, this.7 + this.6 + f3, this.8 + this.9, Color.getHSBColor(f3 / this.5, 1.0f, 1.0f).getRGB(), Color.getHSBColor((f3 + this.6) / this.5, 1.0f, 1.0f).getRGB());
                f3 += this.6;
            }
            int n4 = (int)(this.7 + (float)((int)(fArray[0] * this.5)));
            94.c(n4, this.8, 2.0f, this.9, -855638017);
            int n5 = (int)(this.2() + 246.0f + fArray[1] * 100.0f);
            int n6 = (int)(70.0f + this.4() + 6.0f - (float)((int)(fArray[2] * 70.0f)));
            94.c((float)n5 - 1.0f - (float)(this.0 ? 108 : 0), (float)n6 - 1.0f, 2.0f, 2.0f, -855638017);
            94.c(this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f, 40.0f * ((float)this.1 / 255.0f), 17.5f, 0x44FF0000);
            94.c(this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 17.5f, 40.0f * ((float)this.2 / 255.0f), 17.5f, 0x4400FF00);
            94.c(this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 35.0f, 40.0f * ((float)this.3 / 255.0f), 17.5f, 0x440000FF);
            94.c(this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.4() + 6.0f + 52.5f, 40.0f * ((float)this.0 / 255.0f), 17.5f, 0x44FFFFFF);
            94.c(this.2() + 350.0f - (float)(this.0 ? 108 : 0), this.8, 40.0f, this.9, ((89)this.c.6()).7() ? ((89)this.c.6()).1(50).c() : 0);
            3s_0.0.c("R" + this.1, this.2() + 352.0f - (float)(this.0 ? 108 : 0), (float)((int)(this.4() + 6.0f + 8.75f - 3s_0.0.c("R") / 2.0f)), (3p_0)9);
            3s_0.0.c("G" + this.2, this.2() + 352.0f - (float)(this.0 ? 108 : 0), (float)((int)((double)(this.4() + 6.0f) + 26.25 - (double)(3s_0.0.c("G") / 2.0f))), (3p_0)9);
            3s_0.0.c("B" + this.3, this.2() + 352.0f - (float)(this.0 ? 108 : 0), (float)((int)(this.4() + 6.0f + 43.75f - 3s_0.0.c("B") / 2.0f)), (3p_0)9);
            3s_0.0.c("A" + this.0, this.2() + 352.0f - (float)(this.0 ? 108 : 0), (float)((int)(this.4() + 6.0f + 61.25f - 3s_0.0.c("A") / 2.0f)), (3p_0)9);
            3s_0.0.c("Cycle", this.2() + 352.0f - (float)(this.0 ? 108 : 0), (float)((int)(this.8 + this.9 / 2.0f - 3s_0.0.c("Cycle") / 2.0f)), (3p_0)9);
        }
    }

    public void 2() {
        this.0 = this.0().0() >> 24 & 0xFF;
        this.1 = this.0().0() >> 16 & 0xFF;
        this.2 = this.0().0() >> 8 & 0xFF;
        this.3 = this.0().0() & 0xFF;
    }

    public 89 0() {
        return (89)this.c.6();
    }

    public 3l_0(8h_0<89> h_02, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        super(h_02.c(), f2, f3, f4, f5, f6, h_02.0() ? 28.0f : 12.0f);
        this.c = h_02;
        this.0 = bl;
        this.2();
    }
}

