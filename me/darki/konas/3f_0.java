/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.HashMap;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3b_0;
import me.darki.konas.3e_0;
import me.darki.konas.3g_0;
import me.darki.konas.3i_0;
import me.darki.konas.3p_0;
import me.darki.konas.3s_0;
import me.darki.konas.3w_0;
import me.darki.konas.3x_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.apache.commons.lang3.StringUtils;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3f
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3f_0
extends 3a_0 {
    public 3D c;
    public 3g_0 c;
    public 3i_0 c;
    public 3x_0 c;
    public 3x_0 0;
    public 3w_0 c;
    public 3x_0 1;
    public 3x_0 2;
    public boolean c;
    public String 0;
    public 9m c;
    public int 0;
    public int 1;
    public 3b_0[] c;
    public HashMap<3D, 3e_0> c = new 9m();

    @Override
    public boolean c(int n2, int n3, int n4, long l2) {
        if (this.c.c(n2, n3, n4, l2)) {
            return true;
        }
        return super.c(n2, n3, n4, l2);
    }

    @Override
    public void c(int n2, int n3, int n4) {
        super.c(n2, n3, n4);
        this.c.c(n2, n3, n4);
    }

    @Override
    public void c(float f2, float f3) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        this.4((int)((float)scaledResolution.getScaledWidth() / 2.0f - this.5() / 2.0f));
        this.0((int)((float)scaledResolution.getScaledHeight() / 2.0f - this.8() / 2.0f));
        for (3b_0 b_02 : this.c) {
            b_02.c(this.2(), this.4());
        }
        if (this.c != null) {
            this.c.c(this.2(), this.4());
        }
        ((HashMap)((Object)this.c)).forEach(this::c);
        if (this.c != null) {
            this.c.c(this.2(), this.4());
        }
        super.c(f2, f3);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        if (3f_0.c(n2, n3, this.2() + 594.0f, this.4() + 14.0f, 192.0, 20.0) && !((Boolean)3O.c.6()).booleanValue()) {
            this.c = true;
            this.0 = "";
            return true;
        }
        this.c = false;
        for (3b_0 b_02 : this.c) {
            if (!b_02.0(n2, n3, n4)) continue;
            return true;
        }
        if (this.c != null ? this.c.0(n2, n3, n4) : ((3e_0)((HashMap)((Object)this.c)).get((Object)this.c)).0(n2, n3, n4)) {
            return true;
        }
        if (this.c.0(n2, n3, n4)) {
            return true;
        }
        return super.0(n2, n3, n4);
    }

    public void c(3E e2) {
        this.c = new 3g_0(e2, this.2(), this.4(), 160.0f, 48.0f, (Boolean)3O.c.6() != false ? 328.0f : 640.0f, this.8() - 72.0f);
    }

    public static void c() {
        3f_0.7();
    }

    public void c(3D d2, 3e_0 e_02) {
        e_02.c(this.2(), this.4());
    }

    public 3D 0() {
        return this.c;
    }

    public void c(3D d2) {
        this.c = null;
        this.c = d2;
        ((3e_0)((HashMap)((Object)this.c)).get((Object)d2)).c();
    }

    @Override
    public void c(char c2, int n2) {
        block2: {
            block0: {
                block3: {
                    block1: {
                        super.c(c2, n2);
                        if (!this.c) break block0;
                        if (n2 != 28) break block1;
                        this.c = false;
                        this.c = new 3i_0(this.0, this.2(), this.4(), 0.0f, 48.0f, 160.0f, this.8() - 72.0f);
                        this.c.c(this.2(), this.4());
                        break block2;
                    }
                    if (n2 != 14) break block3;
                    this.0 = StringUtils.chop((String)this.0);
                    break block2;
                }
                if (c2 < 'A' || c2 > 'z') break block2;
                this.0 = this.0 + c2;
                break block2;
            }
            this.c.c(c2, n2);
        }
    }

    public 3f_0(float f2, float f3) {
        super("Konas", 0.0f, 0.0f, 0.0f, 0.0f, f2, f3);
        this.0 = (Boolean)3O.c.6() != false ? 65 : 75;
        this.1 = (Boolean)3O.c.6() != false ? 16 : 56;
        this.c = new 3b_0[]{new 3b_0(3D.c, this.2(), this.4(), this.1, 8.0f, this.0, 38.0f, 1), new 3b_0(3D.0, this.2(), this.4(), this.1 + this.0, 8.0f, this.0, 38.0f, 0), new 3b_0(3D.1, this.2(), this.4(), this.1 + this.0 * 2, 8.0f, this.0, 38.0f, 0), new 3b_0(3D.2, this.2(), this.4(), this.1 + this.0 * 3, 8.0f, this.0, 38.0f, 0), new 3b_0(3D.3, this.2(), this.4(), this.1 + this.0 * 4, 8.0f, this.0, 38.0f, 0), new 3b_0(3D.4, this.2(), this.4(), this.1 + this.0 * 5, 8.0f, this.0, 38.0f, 0), new 3b_0(3D.5, this.2(), this.4(), this.1 + this.0 * 6, 8.0f, this.0, 38.0f, 2)};
        this.c = new HashMap();
        for (3D d2 : 3D.values()) {
            ((HashMap)((Object)this.c)).put(d2, new 3e_0(d2, this.2(), this.4(), 0.0f, 48.0f, 160.0f, this.8() - 72.0f));
        }
    }

    @Override
    public void 9() {
        this.c = new 3x_0(this.2(), this.4(), this.5(), this.8(), 3.0f, 25, 15);
        this.0 = new 3x_0(this.2(), this.4(), this.5(), 46.0f, 3.0f, 25, 3);
        this.c = new 3w_0(this.2(), this.4() + 46.0f, this.5(), 2.0f);
        this.1 = new 3x_0(this.2(), this.4() + this.8() - 24.0f, this.5(), 24.0f, 3.0f, 25, 12);
        this.2 = new 3x_0(this.2() + 594.0f, this.4() + 14.0f, 192.0f, 20.0f, 3.0f);
    }

    public HashMap<3D, 3e_0> 2() {
        return this.c;
    }

    public 3g_0 1() {
        return this.c;
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        3s_0.c(this.c, 3);
        3s_0.c(this.0, (3p_0)((Object)c));
        3s_0.c(this.1, (3p_0)((Object)c));
        3s_0.c(this.c, (3p_0)((Object)0));
        if (!((Boolean)3O.c.6()).booleanValue()) {
            3s_0.c(this.2, 8);
        }
        3s_0.c(this.c, (3p_0)((Object)2), 1.0f);
        if (this.c || this.c != null) {
            3s_0.0.c(this.0, this.2() + 599.0f, (float)((int)(this.4() + 24.0f - 3s_0.0.c(this.0) / 2.0f)), a);
            if (this.c.c(500.0)) {
                3w_0 object = new 3w_0(this.2() + 599.0f + (this.0.equals("") ? 0.0f : 3s_0.0.0(this.0)) + 1.0f, this.4() + 24.0f - (this.0.equals("") ? 3s_0.0.c("Search features") : 3s_0.0.c(this.0)) / 2.0f, 1.0f, this.0.equals("") ? 3s_0.0.c("Search features") : 3s_0.0.c(this.0));
                3s_0.c(object, a);
                if (this.c.c(1000.0)) {
                    this.c.c();
                }
            }
        } else if (!((Boolean)3O.c.6()).booleanValue()) {
            3s_0.0.c("Search features", this.2() + 599.0f, (float)((int)(this.4() + 24.0f - 3s_0.0.c("Search features") / 2.0f)), a);
        }
        for (3b_0 b_02 : this.c) {
            b_02.0(n2, n3, f2);
        }
        if (this.c != null) {
            this.c.0(n2, n3, f2);
        } else {
            ((3e_0)((HashMap)((Object)this.c)).get((Object)this.c)).0(n2, n3, f2);
        }
        this.c.0(n2, n3, f2);
        3s_0.0.c("0.10.2 for Minecraft 1.12.2", this.2() + 8.0f, (float)((int)(this.4() + this.8() - 12.0f - 3s_0.0.c("konasclient.com") / 2.0f)), 9);
        3s_0.0.c("konasclient.com", this.2() + this.5() - 8.0f - 3s_0.0.0("konasclient.com"), (float)((int)(this.4() + this.8() - 12.0f - 3s_0.0.c("konasclient.com") / 2.0f)), 9);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        this.c.c(n2, n3, f2);
    }
}

