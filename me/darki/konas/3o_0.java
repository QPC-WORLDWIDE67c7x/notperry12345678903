/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3s_0;
import me.darki.konas.3x_0;
import me.darki.konas.8h_0;
import me.darki.konas.util.math.RoundingUtil;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3o
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3o_0
extends 3a_0 {
    public 8h_0<Number> c;
    public boolean c = false;

    @Override
    public boolean 0(int n2, int n3, int n4) {
        block3: {
            block8: {
                block7: {
                    block6: {
                        block1: {
                            block5: {
                                block4: {
                                    block2: {
                                        if (3o_0.c(n2, n3, this.2() + 16.0f, this.4() + (float)(this.c.0() ? 31 : 15), this.5() - 32.0f, 12.0) && n4 == 0) {
                                            this.c = true;
                                            return true;
                                        }
                                        if (!3o_0.c(n2, n3, this.2(), this.4() + (float)(this.c.0() ? 31 : 15), 12.0, 12.0)) break block1;
                                        if (!(this.c.6() instanceof Float)) break block2;
                                        float f2 = ((Number)this.c.6()).floatValue() - ((Number)this.c.d()).floatValue();
                                        this.c.2(Float.valueOf(MathHelper.clamp((float)RoundingUtil.roundFloat(RoundingUtil.roundToStep(f2, ((Float)((Number)this.c.d())).floatValue()), 2), (float)((Float)((Number)this.c.8())).floatValue(), (float)((Float)((Number)this.c.7())).floatValue())));
                                        break block3;
                                    }
                                    if (!(this.c.6() instanceof Integer)) break block4;
                                    int n5 = ((Number)this.c.6()).intValue() - ((Number)this.c.d()).intValue();
                                    this.c.2(Integer.valueOf(n5));
                                    break block3;
                                }
                                if (!(this.c.6() instanceof Double)) break block5;
                                double d2 = ((Number)this.c.6()).doubleValue() + -((Number)this.c.d()).doubleValue();
                                this.c.2(Double.valueOf(MathHelper.clamp((double)RoundingUtil.roundDouble(RoundingUtil.roundToStep(d2, (Double)((Number)this.c.d())), 2), (double)((Double)((Number)this.c.8())), (double)((Double)((Number)this.c.7())))));
                                break block3;
                            }
                            if (!(this.c.6() instanceof Long)) break block3;
                            long l2 = ((Number)this.c.6()).longValue() - ((Number)this.c.d()).longValue();
                            this.c.2(Long.valueOf(l2));
                            break block3;
                        }
                        if (!3o_0.c(n2, n3, this.2() + this.5() - 12.0f, this.4() + (float)(this.c.0() ? 31 : 15), 12.0, 12.0)) break block3;
                        if (!(this.c.6() instanceof Float)) break block6;
                        float f3 = ((Number)this.c.6()).floatValue() + ((Number)this.c.d()).floatValue();
                        this.c.2(Float.valueOf(MathHelper.clamp((float)RoundingUtil.roundFloat(RoundingUtil.roundToStep(f3, ((Float)((Number)this.c.d())).floatValue()), 2), (float)((Float)((Number)this.c.8())).floatValue(), (float)((Float)((Number)this.c.7())).floatValue())));
                        break block3;
                    }
                    if (!(this.c.6() instanceof Integer)) break block7;
                    int n6 = ((Number)this.c.6()).intValue() + ((Number)this.c.d()).intValue();
                    this.c.2(Integer.valueOf(n6));
                    break block3;
                }
                if (!(this.c.6() instanceof Double)) break block8;
                double d3 = ((Number)this.c.6()).doubleValue() + ((Number)this.c.d()).doubleValue();
                this.c.2(Double.valueOf(MathHelper.clamp((double)RoundingUtil.roundDouble(RoundingUtil.roundToStep(d3, (Double)((Number)this.c.d())), 2), (double)((Double)((Number)this.c.8())), (double)((Double)((Number)this.c.7())))));
                break block3;
            }
            if (!(this.c.6() instanceof Long)) break block3;
            long l3 = ((Number)this.c.6()).longValue() + ((Number)this.c.d()).longValue();
            this.c.2(Long.valueOf(l3));
        }
        return super.0(n2, n3, n4);
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        3s_0.0.c(this.c.c(), this.2(), this.4(), 9);
        if (this.c.0()) {
            3s_0.c.c(this.c.9(), this.2(), (float)((int)(this.4() + 18.0f)), b);
        }
        3x_0 x_02 = new 3x_0(this.2() + 16.0f, this.4() + (float)(this.c.0() ? 34 : 18), this.5() - 32.0f, 6.0f, 3.0f);
        3s_0.c(x_02, 6);
        float f3 = MathHelper.floor((float)((((Number)this.c.6()).floatValue() - ((Number)this.c.8()).floatValue()) / (((Number)this.c.7()).floatValue() - ((Number)this.c.8()).floatValue()) * (this.5() - 32.0f)));
        if (f3 < 0.0f) {
            this.c.2(this.c.8());
            this.c = false;
        } else if (f3 > this.5()) {
            this.c.2(this.c.7());
            this.c = false;
        }
        if (this.c) {
            if (this.c.6() instanceof Float) {
                float f4 = ((float)n2 - (this.2() + 16.0f)) * (((Number)this.c.7()).floatValue() - ((Number)this.c.8()).floatValue()) / (this.5() - 32.0f) + ((Number)this.c.8()).floatValue();
                this.c.2(Float.valueOf(MathHelper.clamp((float)RoundingUtil.roundFloat(RoundingUtil.roundToStep(f4, ((Float)((Number)this.c.d())).floatValue()), 2), (float)((Float)((Number)this.c.8())).floatValue(), (float)((Float)((Number)this.c.7())).floatValue())));
            } else if (this.c.6() instanceof Integer) {
                int n4 = (int)(((float)n2 - (this.2() + 16.0f)) * (float)(((Number)this.c.7()).intValue() - ~((Number)this.c.8()).intValue() + 1) / (this.5() - 32.0f) + (float)((Number)this.c.8()).intValue());
                this.c.2(Integer.valueOf(n4));
            } else if (this.c.6() instanceof Double) {
                double d2 = (double)((float)n2 - (this.2() + 16.0f)) * (((Number)this.c.7()).doubleValue() - ((Number)this.c.8()).doubleValue()) / (double)(this.5() - 32.0f) + ((Number)this.c.8()).doubleValue();
                this.c.2(Double.valueOf(MathHelper.clamp((double)RoundingUtil.roundDouble(RoundingUtil.roundToStep(d2, (Double)((Number)this.c.d())), 2), (double)((Double)((Number)this.c.8())), (double)((Double)((Number)this.c.7())))));
            } else if (this.c.6() instanceof Long) {
                long l2 = (long)((double)((float)n2 - (this.2() + 16.0f)) * (((Number)this.c.7()).doubleValue() - ((Number)this.c.8()).doubleValue()) / (double)(this.5() - 32.0f) + ((Number)this.c.8()).doubleValue());
                this.c.2(Long.valueOf(l2));
            }
        }
        3x_0 x_03 = new 3x_0(this.2() + 10.0f, this.4() + (float)(this.c.0() ? 34 : 18), 12.0f + f3, 6.0f, 6.0f);
        3s_0.c(x_03, 3o_0.c(n2, n3, this.2() + 10.0f + f3, this.4() + (float)(this.c.0() ? 31 : 15), 12.0, 12.0) ? 5.c(((Float)3O.s.6()).floatValue()) : 5);
        3s_0.c(x_03, 2, 1.0f);
        3x_0 x_04 = new 3x_0(this.2() + 10.0f + f3, this.4() + (float)(this.c.0() ? 31 : 15), 12.0f, 12.0f, 6.0f);
        3s_0.c(x_04, 3o_0.c(n2, n3, this.2() + 10.0f + f3, this.4() + (float)(this.c.0() ? 31 : 15), 12.0, 12.0) ? 5.c(((Float)3O.s.6()).floatValue()) : 5);
        3s_0.c(x_04, 2, 1.0f);
        3s_0.c.c(((Number)this.c.6()).toString(), (float)((int)(this.2() + 16.0f + f3 - 3s_0.c.0(((Number)this.c.6()).toString()) / 2.0f)), (float)((int)(this.4() + (float)(this.c.0() ? 48 : 32))), 9);
        3s_0.c.c("-", this.2(), this.4() + (float)(this.c.0() ? 34 : 18) + 3.0f - 3s_0.c.c("-"), 9);
        3s_0.c.c("+", this.2() + this.5() - 3s_0.c.0("+"), this.4() + (float)(this.c.0() ? 34 : 18) + 3.0f - 3s_0.c.c("+"), 9);
    }

    public 3o_0(8h_0<Number> h_02, float f2, float f3, float f4, float f5, float f6) {
        super(h_02.c(), f2, f3, f4, f5, f6, h_02.0() ? 54.0f : 38.0f);
        this.c = h_02;
    }

    @Override
    public boolean c(int n2, int n3, int n4, long l2) {
        block0: {
            if (3o_0.c(n2, n3, this.2() + 16.0f, this.4() + (float)(this.c.0() ? 31 : 15), this.5() - 32.0f, 12.0)) break block0;
            this.c = false;
        }
        return super.c(n2, n3, n4, l2);
    }

    @Override
    public void c(int n2, int n3, int n4) {
        super.c(n2, n3, n4);
        if (this.c) {
            this.c = false;
        }
    }
}

