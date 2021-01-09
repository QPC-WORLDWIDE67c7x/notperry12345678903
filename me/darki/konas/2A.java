/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.Collections;
import me.darki.konas.2C;
import me.darki.konas.2E;
import me.darki.konas.2n_0;
import me.darki.konas.3N;
import me.darki.konas.8k_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2A
extends 2C {
    public 2E c;

    public 2A(2E e2) {
        super(e2.0(), e2.9(), e2.3(), e2.c(), e2.7());
        this.c = e2;
    }

    public void c(float f2, float f3) {
        if (!((Boolean)3N.1.6()).booleanValue()) {
            for (2E e2 : 8k_0.c.c.c()) {
                if (e2.equals(this.c) || !(f2 > e2.9()) || !(f2 < e2.9() + e2.c()) || !(f3 > e2.3()) || !(f3 < e2.3() + e2.7())) continue;
                return;
            }
        }
        float f4 = f2 + this.2();
        float f5 = f3 + this.4();
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 + this.c.c() > (float)scaledResolution.getScaledWidth()) {
            f4 = (float)scaledResolution.getScaledWidth() - this.c.c();
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 + this.c.7() > (float)scaledResolution.getScaledHeight()) {
            f5 = (float)scaledResolution.getScaledHeight() - this.c.7();
        }
        this.c.4(f4);
        this.c.1(f5);
        this.3(f4);
        this.0(f5);
    }

    @Override
    public void 0(boolean bl) {
        super.0(bl);
        this.c.c(bl);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        block5: {
            super.c(n2, n3, f2);
            if (!2n_0.1() || !this.c.6()) {
                return;
            }
            if (this.7()) {
                this.c(n2, (float)n3);
            }
            this.3(this.c.9());
            this.0(this.c.3());
            this.1(this.c.c());
            this.4(this.c.7());
            this.0(this.c.6());
            ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
            if (this.5() < 0.0f) {
                this.3(0.0f);
            }
            if (this.5() + this.1() > (float)scaledResolution.getScaledWidth()) {
                this.3((float)scaledResolution.getScaledWidth() - this.1());
            }
            if (this.6() < 0.0f) {
                this.0(0.0f);
            }
            if (!(this.6() + this.3() > (float)scaledResolution.getScaledHeight())) break block5;
            this.0((float)scaledResolution.getScaledHeight() - this.3());
        }
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        boolean bl;
        block5: {
            super.0(n2, n3, n4);
            if (!2n_0.1()) {
                return false;
            }
            this.c.c(n2, n3, n4);
            boolean bl2 = 2A.c(n2, n3, this.5(), this.6(), this.1(), this.3());
            bl = false;
            switch (n4) {
                case 0: {
                    if (!bl2 || !this.c()) break;
                    this.c(true);
                    this.c(this.5() - (float)n2);
                    this.2(this.6() - (float)n3);
                    bl = true;
                    break;
                }
                case 1: {
                    if (!bl2) break;
                    this.0(!this.c());
                    bl = true;
                }
            }
            if (!bl) break block5;
            Collections.swap(8k_0.c.c.c(), 8k_0.c.c.c().indexOf(this.c), 8k_0.c.c.c().size() - 1);
        }
        return bl;
    }

    @Override
    public void c(boolean bl) {
        super.c(bl);
        this.c.0(bl);
    }

    @Override
    public void 0(float f2) {
        super.0(f2);
    }

    public 2E c() {
        return this.c;
    }

    @Override
    public void c(int n2, int n3, int n4) {
        block1: {
            super.c(n2, n3, n4);
            if (!2n_0.1()) {
                return;
            }
            if (n4 != 0 || !this.7()) break block1;
            this.c(false);
        }
    }

    @Override
    public void 3(float f2) {
        super.3(f2);
    }
}

