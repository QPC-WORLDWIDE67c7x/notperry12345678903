/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.List;
import me.darki.konas.3t_0;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.util.FastTrig;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3x
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3x_0
extends 3t_0 {
    public static int c;
    public static int 0;
    public static int 1;
    public static int 2;
    public static int 3;
    public static int 4;
    public float 5;
    public float 6;
    public float 7;
    public int 5;
    public int 6;

    @Override
    public boolean 3() {
        return true;
    }

    public 3x_0(float f2, float f3, float f4, float f5, float f6) {
        this(f2, f3, f4, f5, f6, 25);
    }

    public List c(int n2, float f2, float f3, float f4, float f5, float f6) {
        ArrayList<Vector2f> arrayList = new ArrayList<Vector2f>();
        int n3 = 360 / n2;
        for (float f7 = f5; f7 >= f6 + (float)n3; f7 -= (float)n3) {
            float f8 = f7;
            if (f8 < f6) {
                f8 = f6;
            }
            float f9 = (float)((double)f3 + FastTrig.cos(Math.toRadians(f8)) * (double)f2);
            float f10 = (float)((double)f4 + FastTrig.sin(Math.toRadians(f8)) * (double)f2);
            arrayList.add(new Vector2f(f9, f10));
        }
        return arrayList;
    }

    public 3x_0(float f2, float f3, float f4, float f5, float f6, int n2, int n3) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("corner radius must be >= 0");
        }
        this.7 = f6;
        this.5 = n2;
        this.6 = n3;
        this.c = (int)f2;
        this.0 = (int)f3;
        this.5 = f4;
        this.6 = f5;
        this.9();
        this.8();
    }

    @Override
    public void 9() {
        ArrayList<Vector2f> arrayList = new ArrayList<Vector2f>();
        if (this.7 > this.5 / 2.0f) {
            this.7 = this.5 / 2.0f;
        }
        if (this.7 > this.6 / 2.0f) {
            this.7 = this.6 / 2.0f;
        }
        if ((this.6 & 1) != 0) {
            arrayList.addAll(this.c(this.5, this.7, this.c + this.7, this.0 + this.7, 270.0f, 180.0f));
        } else {
            arrayList.add(new Vector2f((float)this.c, (float)this.0));
        }
        if ((this.6 & 8) != 0) {
            arrayList.addAll(this.c(this.5, this.7, this.c + this.7, this.0 + this.6 - this.7, 180.0f, 90.0f));
        } else {
            arrayList.add(new Vector2f((float)this.c, (float)(this.0 + this.6)));
        }
        if ((this.6 & 4) != 0) {
            arrayList.addAll(this.c(this.5, this.7, this.c + this.5 - this.7, this.0 + this.6 - this.7, 90.0f, 0.0f));
        } else {
            arrayList.add(new Vector2f((float)(this.c + this.5), (float)(this.0 + this.6)));
        }
        if ((this.6 & 2) != 0) {
            arrayList.addAll(this.c(this.5, this.7, this.c + this.5 - this.7, this.0 + this.7, 360.0f, 270.0f));
        } else {
            arrayList.add(new Vector2f((float)(this.c + this.5), (float)this.0));
        }
        this.c = (int)new Vector2f[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            this.c[i2] = (Vector2f)arrayList.get(i2);
        }
    }

    public 3x_0(float f2, float f3, float f4, float f5, float f6, int n2) {
        this(f2, f3, f4, f5, f6, n2, 15);
    }

    static {
        4 = 25;
        3 = 15;
        2 = 8;
        1 = 4;
        0 = 2;
        c = 1;
    }
}

