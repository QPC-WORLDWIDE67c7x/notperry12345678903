/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2r_0;
import me.darki.konas.3H;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import me.darki.konas.9b;
import me.darki.konas.util.math.RoundingUtil;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2w
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2w_0
extends 2r_0 {
    public 8h_0 c;
    public boolean c;

    @Override
    public boolean 0(int n2, int n3, int n4) {
        super.0(n2, n3, n4);
        if (2w_0.c(n2, n3, this.e(), this.6(), this.e() + this.d(), this.9()) && n4 == 0) {
            this.c(true);
            return true;
        }
        return false;
    }

    public 8h_0 c() {
        return this.c;
    }

    public 2w_0(8h_0 h_02, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(h_02.c(), f2, f3, f4, f5, f6, f7);
        this.c = h_02;
    }

    @Override
    public void 1(int n2, int n3, int n4) {
        block0: {
            super.1(n2, n3, n4);
            if (!this.1()) break block0;
            this.c(false);
        }
    }

    public boolean 1() {
        return this.c;
    }

    public void c(boolean bl) {
        this.c = bl;
    }

    @Override
    public void c(int n2, int n3, float f2) {
        block3: {
            block6: {
                block5: {
                    block4: {
                        super.c(n2, n3, f2);
                        94.c(this.e(), this.6(), this.d(), this.9(), 0xFFFFFF);
                        float f3 = MathHelper.floor((float)((((Number)this.c().6()).floatValue() - ((Number)this.c().8()).floatValue()) / (((Number)this.c().7()).floatValue() - ((Number)this.c().8()).floatValue()) * this.d()));
                        if (f3 < 0.0f) {
                            this.c().2(this.c().8());
                            this.c(false);
                        } else if (f3 > this.d()) {
                            this.c().2(this.c().7());
                            this.c(false);
                        }
                        94.c(this.2(), this.6(), this.b(), this.9(), ((89)3H.2.6()).c());
                        int n4 = this.1() ? ((89)3H.2.6()).4().brighter().getRGB() : ((89)3H.2.6()).4().darker().getRGB();
                        94.c(this.e(), this.6(), f3, this.9(), n4);
                        9b.c(this.8() + ": " + this.c().6(), (int)(this.e() + 5.0f), (int)(this.6() + this.9() / 2.0f - 9b.c(this.8() + ": " + this.c().6()) / 2.0f - 0.5f), ((89)3H.3.6()).c());
                        if (!this.c) break block3;
                        if (!(this.c().6() instanceof Float)) break block4;
                        float f4 = ((float)n2 - this.e()) * (((Number)this.c().7()).floatValue() - ((Number)this.c().8()).floatValue()) / this.d() + ((Number)this.c().8()).floatValue();
                        this.c().2(Float.valueOf(MathHelper.clamp((float)RoundingUtil.roundFloat(RoundingUtil.roundToStep(f4, ((Float)this.c().d()).floatValue()), 2), (float)((Float)this.c().8()).floatValue(), (float)((Float)this.c().7()).floatValue())));
                        break block3;
                    }
                    if (!(this.c().6() instanceof Integer)) break block5;
                    int n5 = (int)(((float)n2 - this.e()) * (float)(((Number)this.c().7()).intValue() - ((Number)this.c().8()).intValue()) / this.d() + (float)((Number)this.c().8()).intValue());
                    this.c().2(n5);
                    break block3;
                }
                if (!(this.c().6() instanceof Double)) break block6;
                double d2 = (double)((float)n2 - this.e()) * (((Number)this.c().7()).doubleValue() - ((Number)this.c().8()).doubleValue()) / (double)this.d() + ((Number)this.c().8()).doubleValue();
                this.c().2(MathHelper.clamp((double)RoundingUtil.roundDouble(RoundingUtil.roundToStep(d2, (Double)this.c().d()), 2), (double)((Double)this.c().8()), (double)((Double)this.c().7())));
                break block3;
            }
            if (!(this.c().6() instanceof Long)) break block3;
            long l2 = (long)((double)((float)n2 - this.e()) * (((Number)this.c().7()).doubleValue() - ((Number)this.c().8()).doubleValue()) / (double)this.d() + ((Number)this.c().8()).doubleValue());
            this.c().2(l2);
        }
    }

    @Override
    public void c(int n2, int n3, int n4, long l2) {
        block0: {
            if (2w_0.c(n2, n3, this.e(), this.6(), this.e() + this.d(), this.9())) break block0;
            this.c(false);
        }
    }
}

