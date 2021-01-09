/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2r_0;
import me.darki.konas.3H;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import me.darki.konas.96;
import me.darki.konas.9b;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2q
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2q_0
extends 2r_0 {
    public 8h_0 c;
    public int c;
    public int 0;
    public int 1;
    public int 2;
    public float c;
    public float 0 = this.c / 10.0f;
    public float 1 = this.e() + 1.0f;
    public float 2 = this.6() + 48.0f;
    public float 3 = 10.0f;
    public float 4 = this.e() + 1.0f;
    public float 5 = this.6() + 18.0f;
    public float 6 = 26.0f;
    public float 7 = 44.0f;
    public boolean c;
    public 9m c = new 9m();

    public 2q_0(8h_0 h_02, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(h_02.c(), f2, f3, f4, f5, f6, f7);
        this.c = h_02;
        this.c = this.2().0() >> 24 & 0xFF;
        this.0 = this.2().0() >> 16 & 0xFF;
        this.1 = this.2().0() >> 8 & 0xFF;
        this.2 = this.2().0() & 0xFF;
    }

    public boolean c(int n2, int n3, int n4) {
        block2: {
            block5: {
                block4: {
                    block3: {
                        if (!2q_0.c(n2, n3, this.e(), this.6(), this.d(), this.9())) {
                            return false;
                        }
                        if (n4 != 0) {
                            return false;
                        }
                        if (!this.3()) break block2;
                        if (!2q_0.c(n2, n3, this.4, this.5, this.7, this.6 - 1.0f)) break block3;
                        this.c(n2, (float)n3);
                        break block2;
                    }
                    if (!2q_0.c(n2, n3, this.1, this.2, this.c - 2.0f, this.3)) break block4;
                    this.0(n2);
                    break block2;
                }
                if (!2q_0.c(n2, n3, this.e() + this.d() - 11.0f, this.6() + 17.0f, 10.0, 42.0)) break block5;
                this.c(n3);
                break block2;
            }
            if (!2q_0.c(n2, n3, this.e() + 4.0f + this.c, this.6() + 25.0f + (float)(9b.0() * 3), 8.0, 8.0) || !this.c.c(500.0)) break block2;
            this.2().3();
            this.c.c();
        }
        return true;
    }

    public boolean 3() {
        return this.c;
    }

    public 89 2() {
        return (89)this.c.6();
    }

    public void c(boolean bl) {
        this.c = bl;
    }

    public void c(float f2, float f3) {
        float f4 = ((f2 -= this.e()) - 1.0f) / this.7;
        float f5 = 1.0f - ((f3 -= this.6()) - 18.0f) / this.6;
        float[] fArray = Color.RGBtoHSB(this.0, this.1, this.2, null);
        int n2 = Color.HSBtoRGB(fArray[0], f4, f5);
        this.0 = n2 >> 16 & 0xFF;
        this.1 = n2 >> 8 & 0xFF;
        this.2 = n2 & 0xFF;
        this.1();
    }

    @Override
    public void c(int n2, int n3, int n4, long l2) {
        this.c(n2, n3, n4);
    }

    public void 0(float f2) {
        float f3 = ((f2 -= this.e()) - 1.0f) / this.c;
        float[] fArray = Color.RGBtoHSB(this.0, this.1, this.2, null);
        int n2 = Color.HSBtoRGB(f3, fArray[1], fArray[2]);
        this.0 = n2 >> 16 & 0xFF;
        this.1 = n2 >> 8 & 0xFF;
        this.2 = n2 & 0xFF;
        this.1();
    }

    public void 1() {
        int n2 = (this.c & 0xFF) << 24 | (this.0 & 0xFF) << 16 | (this.1 & 0xFF) << 8 | this.2 & 0xFF;
        this.2().0(n2);
    }

    public void 0() {
        this.c = this.2().0() >> 24 & 0xFF;
        this.0 = this.2().0() >> 16 & 0xFF;
        this.1 = this.2().0() >> 8 & 0xFF;
        this.2 = this.2().0() & 0xFF;
    }

    @Override
    public float 9() {
        return this.3() ? super.9() : 12.0f;
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (2q_0.c(n2, n3, this.e(), this.6(), this.d(), 12.0)) {
            if (n4 == 2) {
                if (3H.1 == -1) {
                    3H.1 = this.2().0();
                } else {
                    this.2().0(3H.1);
                    3H.1 = -1;
                    this.0();
                }
            } else {
                Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
                this.c(!this.3());
            }
            return true;
        }
        return this.c(n2, n3, n4);
    }

    public void c(float f2) {
        this.c = 255 - (int)(((f2 -= this.6()) - 17.0f) / 42.0f * 255.0f);
        this.1();
    }

    @Override
    public void c(int n2, int n3, float f2) {
        block3: {
            int n4;
            super.c(n2, n3, f2);
            float[] fArray = Color.RGBtoHSB(this.0, this.1, this.2, null);
            94.c(this.2(), this.6(), this.b(), 12.0f, ((89)3H.2.6()).c());
            94.c(this.e(), this.6(), this.d(), 12.0f, ((89)3H.4.6()).c());
            int n5 = n4 = this.3() ? ((89)3H.2.6()).4().darker().getRGB() : ((89)3H.4.6()).c();
            if (((Boolean)3H.9.6()).booleanValue() && 2q_0.c(n2, n3, this.e(), this.6(), this.d(), this.9())) {
                n4 = this.3() ? ((89)3H.2.6()).4().brighter().getRGB() : new Color(96, 96, 96, 100).hashCode();
            }
            94.c(this.e(), this.6(), this.d(), 12.0f, n4);
            9b.c(this.8(), (int)(this.e() + 5.0f), (int)(this.6() + 6.0f - (float)(9b.0() / 2) - 0.5f), ((89)3H.3.6()).c());
            9b.c(this.3() ? "-" : "+", (int)(this.e() + this.d() - 5.0f - 9b.0(this.3() ? "-" : "+")), (int)(this.6() + 6.0f - 9b.c(this.3() ? "-" : "+") / 2.0f - 0.5f), ((89)3H.3.6()).c());
            if (!this.c) break block3;
            94.c(this.e(), this.6() + 17.0f, 46.0f, 28.0f, ((89)3H.2.6()).c());
            this.4 = this.e() + 1.0f;
            this.5 = this.6() + 18.0f;
            96.c(this.4, this.5, this.4 + this.7, this.5 + this.6, Color.getHSBColor(fArray[0], 0.0f, 0.0f).getRGB(), Color.getHSBColor(fArray[0], 0.0f, 1.0f).getRGB(), Color.getHSBColor(fArray[0], 1.0f, 0.0f).getRGB(), Color.getHSBColor(fArray[0], 1.0f, 1.0f).getRGB());
            94.c(this.e(), this.6() + 47.0f, 46.0f, 12.0f, ((89)3H.2.6()).c());
            this.1 = this.e() + 1.0f;
            this.2 = this.6() + 48.0f;
            float f3 = 0.0f;
            while (f3 + this.0 <= this.c) {
                96.c(this.1 + f3, this.2, this.1 + this.0 + f3, this.2 + this.3, Color.getHSBColor(f3 / this.c, 1.0f, 1.0f).getRGB(), Color.getHSBColor((f3 + this.0) / this.c, 1.0f, 1.0f).getRGB());
                f3 += this.0;
            }
            94.c(this.e() + 45.0f, this.6() + 47.0f, 1.0f, 12.0f, ((89)3H.2.6()).c());
            int n6 = 0xFF000000 | (this.0 & 0xFF) << 16 | (this.1 & 0xFF) << 8 | this.2 & 0xFF;
            int n7 = 0 | (this.0 & 0xFF) << 16 | (this.1 & 0xFF) << 8 | this.2 & 0xFF;
            float f4 = this.e() + this.d() - 11.0f;
            float f5 = this.6() + 17.0f;
            float f6 = 10.0f;
            float f7 = 42.0f;
            96.c(f4, f5, this.e() + this.d() - 1.0f, this.6() + this.9() - 2.0f, n7, n6, n7, n6);
            9b.1("R" + this.0, (int)this.e() + 3 + (int)this.c, (int)this.6() + 16, 0xFFFFFF);
            9b.1("G" + this.1, (int)this.e() + 3 + (int)this.c, (float)((int)this.6() + 18) + 9b.c("RGB0:1234567890") - 0.5f, 0xFFFFFF);
            9b.1("B" + this.2, (int)this.e() + 3 + (int)this.c, (float)((int)this.6() + 20) + 9b.c("RGB0:1234567890") * 2.0f - 0.5f, 0xFFFFFF);
            if (this.2().7()) {
                94.c(this.e() + 3.0f + this.c, (float)((int)this.6() + 22 + 9b.0() * 3), 10.0f, 10.0f, 2.0f, this.2().c());
            }
            94.c(this.e() + 4.0f + this.c, (float)((int)this.6() + 23 + 9b.0() * 3), 8.0f, 8.0f, this.2().c());
            9b.1("RB", (int)(this.e() + 15.0f + this.c), (int)this.6() + 22 + 9b.0() * 3, 0xFFFFFF);
            int n8 = new Color(255, 255, 255, 140).hashCode();
            int n9 = (int)(this.1 + (float)((int)(fArray[0] * this.c)));
            94.c(n9, this.2, 2.0f, this.3, n8);
            int n10 = (int)(f7 + f5 - (float)((int)((float)this.c / 255.0f * f7)));
            94.c(f4, MathHelper.clamp((float)((float)n10 - 1.0f), (float)f5, (float)(f5 + f7)), f6, 2.0f, n8);
            int n11 = (int)(this.4 + (float)((int)(fArray[1] * this.7)));
            int n12 = (int)(this.6 + this.5 - (float)((int)(fArray[2] * this.6)));
            94.c((float)n11 - 1.0f, (float)n12 - 1.0f, 2.0f, 2.0f, n8);
        }
    }

    public 8h_0 c() {
        return this.c;
    }
}

