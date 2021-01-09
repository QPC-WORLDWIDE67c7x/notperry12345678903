/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.Iterator;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.3a_0;
import me.darki.konas.3d_0;
import me.darki.konas.3s_0;
import me.darki.konas.3w_0;
import me.darki.konas.8k_0;
import me.darki.konas.94;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3e
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3e_0
extends 3a_0 {
    public 3D c;
    public ArrayList<3d_0> c;
    public 3E c;
    public 3w_0 c = null;

    @Override
    public void c(float f2, float f3) {
        super.c(f2, f3);
        ((ArrayList)((Object)this.c)).forEach(this::c);
    }

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        if (this.c == null) {
            this.c = ((3d_0)((ArrayList)((Object)this.c)).get(0)).c();
            8k_0.c.c.0().c(this.c);
        }
        if (this.c(n2, n3)) {
            if (c > 0) {
                if (((3d_0)((ArrayList)((Object)this.c)).get(0)).c() < 0.0f) {
                    ((ArrayList)((Object)this.c)).forEach(3e_0::1);
                }
            } else if (c < 0 && ((3d_0)((ArrayList)((Object)this.c)).get(((ArrayList)((Object)this.c)).size() - 1)).4() + ((3d_0)((ArrayList)((Object)this.c)).get(((ArrayList)((Object)this.c)).size() - 1)).8() > this.4() + this.8()) {
                ((ArrayList)((Object)this.c)).forEach(3e_0::0);
            }
        }
        3s_0.c(this.c, 4);
        GL11.glEnable((int)3089);
        94.c(new ScaledResolution(Minecraft.getMinecraft()), this.2(), this.4(), this.5(), this.8());
        ((ArrayList)((Object)this.c)).forEach(arg_0 -> this.c(n2, n3, f2, arg_0));
        GL11.glDisable((int)3089);
    }

    public void c() {
        if (this.c == null) {
            this.c = ((3d_0)((ArrayList)((Object)this.c)).get(0)).c();
        }
        8k_0.c.c.0().c(this.c);
    }

    public 3E 0() {
        return this.c;
    }

    @Override
    public void 9() {
        super.9();
        this.c = new 3w_0(this.2(), this.4(), this.5(), this.8());
    }

    public static void 1(3d_0 d_02) {
        d_02.0(d_02.c() + 20.0f);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        Iterator iterator = ((ArrayList)((Object)this.c)).iterator();
        while (iterator.hasNext()) {
            3d_0 d_02 = (3d_0)iterator.next();
            if (!(d_02.4() + d_02.8() >= this.4()) || !(d_02.4() <= this.4() + this.8()) || !d_02.0(n2, n3, n4)) continue;
            return true;
        }
        return super.0(n2, n3, n4);
    }

    public void c(3d_0 d_02) {
        d_02.c(this.2(), this.4());
    }

    public static void 0(3d_0 d_02) {
        d_02.0(d_02.c() - 20.0f);
    }

    public 3e_0(3D d2, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(d2.name(), f2, f3, f4, f5, f6, f7);
        this.c = d2;
        int n2 = 0;
        for (3E e2 : 3F.2()) {
            if (e2.e() != this.c) continue;
            ((ArrayList)((Object)this.c)).add(new 3d_0(e2, this.2(), this.4(), 0.0f, (float)n2, f6, 32.0f));
            n2 += 40;
        }
    }

    public void c(3E e2) {
        this.c = e2;
        8k_0.c.c.0().c(e2);
    }

    public void c(int n2, int n3, float f2, 3d_0 d_02) {
        block0: {
            if (!(d_02.4() + d_02.8() >= this.4()) || !(d_02.4() <= this.4() + this.8())) break block0;
            d_02.0(n2, n3, f2);
        }
    }
}

