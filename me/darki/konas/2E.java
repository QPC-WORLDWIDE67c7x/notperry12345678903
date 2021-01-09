/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2n_0;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class 2E {
    public 8h_0<89> c;
    public 8h_0<89> 0;
    public String c;
    public float c;
    public float 0;
    public float 1;
    public float 2;
    public boolean c;
    public boolean 0 = false;
    public int c = 1;
    public static Minecraft c = Minecraft.getMinecraft();
    public static ScaledResolution c = new ScaledResolution(c);

    public float 2() {
        return this.0;
    }

    public String 0() {
        return this.c;
    }

    public int 1() {
        return this.c;
    }

    public void 8() {
        this.c = !this.c;
    }

    public 2E(String string, float f2, float f3, float f4, float f5) {
        this.0 = new 8h_0("Outline", new 89(0x888888, false));
        this.2(f2);
        this.3(f3);
        this.c = string;
        this.1 = f4;
        this.2 = f5;
    }

    public void b() {
    }

    public void 5() {
        94.c(this.9(), this.3(), this.c(), this.7(), ((89)this.0.6()).c(), ((89)this.c.6()).c());
    }

    public void 0(float f2) {
        this.2 = f2;
    }

    public float 9() {
        switch (this.c) {
            case 1: 
            case 3: {
                return this.e();
            }
            case 2: 
            case 4: {
                return this.d() + this.e() - this.1;
            }
        }
        return 0.0f;
    }

    public float d() {
        switch (this.c) {
            case 1: 
            case 3: {
                return 0.0f;
            }
            case 2: 
            case 4: {
                return c.getScaledWidth();
            }
        }
        return 0.0f;
    }

    public float 7() {
        return this.2;
    }

    public void c(float f2) {
        this.1 = f2;
    }

    public float 3() {
        switch (this.c) {
            case 1: 
            case 2: {
                return this.2();
            }
            case 3: 
            case 4: {
                return this.4() + this.2() - this.2;
            }
        }
        return 0.0f;
    }

    public void c(boolean bl) {
        this.c = bl;
    }

    public void 2(float f2) {
        this.c = f2;
    }

    public void 0(boolean bl) {
        this.0 = bl;
    }

    public void 1(float f2) {
        if (this.9() + this.c() / 2.0f > (float)c.getScaledWidth() / 2.0f) {
            if (f2 + this.7() / 2.0f > (float)c.getScaledHeight() / 2.0f) {
                this.0(4);
                this.3(f2 + this.7() - this.4());
            } else {
                this.0(2);
                this.3(f2);
            }
        } else if (f2 + this.7() / 2.0f > (float)c.getScaledHeight() / 2.0f) {
            this.0(3);
            this.3(f2 + this.7() - this.4());
        } else {
            this.0(1);
            this.3(f2);
        }
    }

    public float c() {
        return this.1;
    }

    public float 4() {
        switch (this.c) {
            case 1: 
            case 2: {
                return 0.0f;
            }
            case 3: 
            case 4: {
                return c.getScaledHeight();
            }
        }
        return 0.0f;
    }

    public void 3(float f2) {
        this.0 = f2;
    }

    public void c(int n2, int n3, int n4) {
    }

    public boolean a() {
        if (2E.c.currentScreen instanceof 2n_0) {
            return this.0;
        }
        return false;
    }

    public void 0(int n2) {
        this.c = n2;
    }

    public static boolean c(int n2, int n3, double d2, double d3, double d4, double d5) {
        return (double)n2 >= d2 && (double)n2 <= d2 + d4 && (double)n3 >= d3 && (double)n3 <= d3 + d5;
    }

    public float e() {
        return this.c;
    }

    public void 4(float f2) {
        if (this.3() + this.7() / 2.0f > (float)c.getScaledHeight() / 2.0f) {
            if (f2 + this.c() / 2.0f > (float)c.getScaledWidth() / 2.0f) {
                this.0(4);
                this.2(f2 + this.c() - this.d());
            } else {
                this.0(3);
                this.2(f2);
            }
        } else if (f2 + this.c() / 2.0f > (float)c.getScaledWidth() / 2.0f) {
            this.0(2);
            this.2(f2 + this.c() - this.d());
        } else {
            this.0(1);
            this.2(f2);
        }
    }

    public boolean 6() {
        return this.c;
    }

    public void c(int n2) {
    }
}

