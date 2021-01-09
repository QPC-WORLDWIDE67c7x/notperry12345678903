/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.3p_0;
import me.darki.konas.3t_0;
import me.darki.konas.89;
import org.lwjgl.util.vector.Vector2f;

/*
 * Renamed from me.darki.konas.3q
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3q_0
implements 3p_0 {
    public Vector2f c;
    public Vector2f 0;
    public Color c;
    public Color 0;
    public 89 c = null;
    public 89 0 = null;

    public 3q_0(float f2, float f3, float f4, float f5, Color color, Color color2) {
        this.c = new Vector2f(f2, f3);
        this.0 = new Vector2f(f2 + f4, f3 + f5);
        this.c = color;
        this.0 = color2;
    }

    @Override
    public Color c(3t_0 t_02, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        if (this.c != null && this.0 != null) {
            this.c = this.c.4();
            this.0 = this.0.4();
        }
        if ((f8 = (f7 = (f6 = this.0.getX() - this.c.getX())) * f6 - (f5 = -(f4 = this.0.getY() - this.c.getY())) * f4) == 0.0f) {
            return Color.BLACK;
        }
        float f9 = f5 * (this.c.getY() - f3) - f7 * (this.c.getX() - f2);
        f9 /= f8;
        float f10 = f6 * (this.c.getY() - f3) - f4 * (this.c.getX() - f2);
        f10 /= f8;
        float f11 = f9;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        float f12 = 1.0f - f11;
        int n2 = (int)(f11 * (float)this.0.getRed() + f12 * (float)this.c.getRed());
        int n3 = (int)(f11 * (float)this.0.getBlue() + f12 * (float)this.c.getBlue());
        int n4 = (int)(f11 * (float)this.0.getGreen() + f12 * (float)this.c.getGreen());
        int n5 = (int)(f11 * (float)this.0.getAlpha() + f12 * (float)this.c.getAlpha());
        return new Color(n2, n4, n3, n5);
    }

    public 3q_0(float f2, float f3, float f4, float f5, 89 var5_5, 89 var6_6) {
        this.c = new Vector2f(f2, f3);
        this.0 = new Vector2f(f2 + f4, f3 + f5);
        this.c = var5_5;
        this.0 = var6_6;
        this.c = var5_5.4();
        this.0 = var6_6.4();
    }

    public 3q_0 c(float f2) {
        block1: {
            if (this.c == null) break block1;
            if (this.0 != null) {
                this.c = this.c.4();
                this.0 = this.0.4();
            }
        }
        return new 3q_0(this.c.getX(), this.c.getY(), this.0.getX() - this.c.getX(), this.0.getY() - this.c.getY(), this.c(this.c, f2), this.c(this.0, f2));
    }

    public Color c(Color color, float f2) {
        int n2;
        int n3;
        int n4;
        int n5;
        block4: {
            n5 = color.getRed();
            n4 = color.getGreen();
            n3 = color.getBlue();
            n2 = color.getAlpha();
            int n6 = (int)(1.0 / (1.0 - (double)f2));
            if (n5 == 0) {
                if (n4 == 0 && n3 == 0) {
                    return new Color(n6, n6, n6, n2);
                }
            }
            if (n5 > 0 && n5 < n6) {
                n5 = n6;
            }
            if (n4 > 0 && n4 < n6) {
                n4 = n6;
            }
            if (n3 <= 0 || n3 >= n6) break block4;
            n3 = n6;
        }
        return new Color(Math.min((int)((float)n5 / f2), 255), Math.min((int)((float)n4 / f2), 255), Math.min((int)((float)n3 / f2), 255), n2);
    }
}

