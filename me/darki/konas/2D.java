/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import me.darki.konas.2C;
import me.darki.konas.2E;
import me.darki.konas.2n_0;
import me.darki.konas.2r_0;
import me.darki.konas.2s_0;
import me.darki.konas.3H;
import me.darki.konas.89;
import me.darki.konas.8k_0;
import me.darki.konas.94;
import me.darki.konas.9b;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2D
extends 2C {
    public ArrayList<2r_0> c;
    public int c;
    public int 0 = 0;
    public boolean c = false;

    @Override
    public void 0(float f2, float f3) {
        if (!2n_0.1()) {
            return;
        }
        this.c.forEach(arg_0 -> 2D.c(f2, f3, arg_0));
    }

    @Override
    public void c(int n2, int n3, int n4) {
        block2: {
            super.c(n2, n3, n4);
            if (!2n_0.1()) {
                return;
            }
            if (n4 == 0 && this.7()) {
                this.c(false);
            }
            if (!this.c()) break block2;
            this.1().forEach(arg_0 -> 2D.c(n2, n3, n4, arg_0));
        }
    }

    public void c(int n2) {
        this.c = n2;
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        super.0(n2, n3, n4);
        if (!2n_0.1()) {
            return false;
        }
        boolean bl = 2D.c(n2, n3, this.5(), this.6(), this.1(), this.3());
        switch (n4) {
            case 0: {
                if (!bl) break;
                this.c(true);
                this.c(this.5() - (float)n2);
                this.2(this.6() - (float)n3);
                return true;
            }
            case 1: {
                if (!bl) break;
                this.0(!this.c());
                return true;
            }
        }
        if (this.c() && 2D.c(n2, n3, this.5(), this.6() + this.3(), this.1(), this.c() > ((Float)3H.7.6()).floatValue() ? (double)((Float)3H.7.6()).floatValue() : (double)this.c())) {
            for (2r_0 r_02 : this.1()) {
                if (!r_02.0(n2, n3, n4)) continue;
                return true;
            }
        }
        return false;
    }

    public void 2() {
        float f2 = this.3();
        for (2r_0 r_02 : this.1()) {
            r_02.1(f2);
            r_02.0(this.5(), this.6() + (float)this.0());
            if (r_02 instanceof 2s_0 && r_02.7()) {
                for (2r_0 r_03 : ((2s_0)r_02).0()) {
                    f2 += r_03.9();
                }
            }
            f2 += r_02.9();
        }
    }

    public void 2(2r_0 r_02) {
        r_02.0(this.5(), this.6() + (float)this.0());
    }

    @Override
    public void c(int n2, int n3, int n4, long l2) {
        block1: {
            super.c(n2, n3, n4, l2);
            if (!2n_0.1()) {
                return;
            }
            if (!this.c()) break block1;
            this.1().forEach(arg_0 -> 2D.c(n2, n3, n4, l2, arg_0));
        }
    }

    public ArrayList<2r_0> 1() {
        return this.c;
    }

    public static void c(float f2, float f3, 2r_0 r_02) {
        r_02.0(f2, f3);
    }

    public void 3(2r_0 r_02) {
        r_02.0(this.5(), this.6() + (float)this.0());
    }

    @Override
    public void 0() {
        float f2 = this.3();
        for (2E e2 : 8k_0.c.c.c()) {
            this.1().add(new 2s_0(e2, this.5(), this.6(), 2.0f, f2, this.1() - 4.0f, 12.0f));
            f2 += 12.0f;
        }
        this.1().forEach(2r_0::4);
    }

    public void c(2r_0 r_02) {
        r_02.0(this.5(), this.6() + (float)this.0());
    }

    public void 1(2r_0 r_02) {
        r_02.0(this.5(), this.6() + (float)this.0());
    }

    public 2D(float f2, float f3, float f4, float f5) {
        super("Containers", f2, f3, f4, f5);
    }

    public static void c(int n2, int n3, int n4, long l2, 2r_0 r_02) {
        r_02.c(n2, n3, n4, l2);
    }

    public static void c(int n2, int n3, int n4, 2r_0 r_02) {
        r_02.1(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        if (!2n_0.1()) {
            return;
        }
        if (this.7()) {
            this.3((float)n2 + this.2());
            this.0((float)n3 + this.4());
            this.1().forEach(this::2);
        }
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        if (this.5() < 0.0f) {
            this.3(0.0f);
            this.1().forEach(this::1);
        }
        if (this.5() + this.1() > (float)scaledResolution.getScaledWidth()) {
            this.3((float)scaledResolution.getScaledWidth() - this.1());
            this.1().forEach(this::3);
        }
        if (this.6() < 0.0f) {
            this.0(0.0f);
            this.1().forEach(this::0);
        }
        if (this.6() + this.3() + Math.min(this.c(), ((Float)3H.7.6()).floatValue()) > (float)scaledResolution.getScaledHeight()) {
            this.0((float)scaledResolution.getScaledHeight() - this.3() - Math.min(this.c(), ((Float)3H.7.6()).floatValue()));
            this.1().forEach(this::c);
        }
        94.c(this.5(), this.6(), this.1(), this.3(), ((89)3H.5.6()).c());
        9b.c(this.8(), (int)(this.5() + 3.0f), (int)(this.6() + this.3() / 2.0f - (float)(9b.0() / 2) - 0.5f), ((89)3H.3.6()).c());
        if (this.c()) {
            if (2D.c(n2, n3, this.5(), this.6() + this.3(), this.1(), Math.min(this.c(), ((Float)3H.7.6()).floatValue())) && this.c() > ((Float)3H.7.6()).floatValue()) {
                int n4 = Mouse.getDWheel();
                if (n4 < 0) {
                    if ((float)(this.0() - (Integer)3H.8.6()) < -(this.c() - Math.min(this.c(), ((Float)3H.7.6()).floatValue()))) {
                        this.c((int)(-(this.c() - Math.min(this.c(), ((Float)3H.7.6()).floatValue()))));
                    } else {
                        this.c(this.0() - (Integer)3H.8.6());
                    }
                } else if (n4 > 0) {
                    this.c(this.0() + (Integer)3H.8.6());
                }
            }
            if (this.0() > 0) {
                this.c(0);
            }
            if (this.c() > ((Float)3H.7.6()).floatValue()) {
                if ((float)(this.0() - (Integer)3H.8.6()) < -(this.c() - ((Float)3H.7.6()).floatValue())) {
                    this.c((int)(-(this.c() - ((Float)3H.7.6()).floatValue())));
                }
            } else if (this.0() < 0) {
                this.c(0);
            }
            GL11.glPushMatrix();
            GL11.glEnable((int)3089);
            if (((Boolean)3H.a.6()).booleanValue()) {
                94.c(scaledResolution, this.5(), this.6() + this.3(), this.1(), Math.min(((Float)3H.7.6()).floatValue(), ((Float)3H.7.6()).floatValue() * ((float)this.0 / (float)((Integer)3H.e.6()).intValue())));
                if (this.c) {
                    --this.0;
                    if (this.0 <= 0) {
                        super.0(false);
                        this.c = false;
                    }
                } else if (this.0 < (Integer)3H.e.6()) {
                    ++this.0;
                }
            } else {
                94.c(scaledResolution, this.5(), this.6() + this.3(), this.1(), ((Float)3H.7.6()).floatValue());
                if (this.c) {
                    super.0(false);
                    this.c = false;
                }
            }
            94.c(this.5(), this.6() + this.3(), this.1(), Math.min(this.c(), ((Float)3H.7.6()).floatValue()) + 2.0f, ((89)3H.6.6()).c());
            this.1().forEach(arg_0 -> 2D.c(n2, n3, f2, arg_0));
            GL11.glDisable((int)3089);
            GL11.glPopMatrix();
        }
        this.2();
    }

    public int 0() {
        return this.c;
    }

    @Override
    public void 0(boolean bl) {
        if (bl) {
            this.0 = 0;
            super.0(bl);
        } else {
            this.c = true;
            this.0 = (Integer)3H.e.6();
        }
    }

    @Override
    public void c(char c2, int n2) {
        block1: {
            super.c(c2, n2);
            if (!2n_0.1()) {
                return;
            }
            if (!this.c()) break block1;
            this.1().forEach(arg_0 -> 2D.c(c2, n2, arg_0));
        }
    }

    public static void c(char c2, int n2, 2r_0 r_02) {
        r_02.c(c2, n2);
    }

    public void 0(2r_0 r_02) {
        r_02.0(this.5(), this.6() + (float)this.0());
    }

    public static void c(int n2, int n3, float f2, 2r_0 r_02) {
        r_02.c(n2, n3, f2);
    }

    public float c() {
        float f2 = 0.0f;
        if (!this.c()) {
            return f2;
        }
        for (2r_0 r_02 : this.1()) {
            f2 += r_02.9();
            if (!(r_02 instanceof 2s_0) || !r_02.7()) continue;
            for (2r_0 r_03 : ((2s_0)r_02).0()) {
                f2 += r_03.9();
            }
        }
        return f2;
    }
}

