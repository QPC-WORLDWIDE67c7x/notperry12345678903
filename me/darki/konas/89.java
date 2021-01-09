/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 89 {
    public int c;
    public boolean c = false;
    public int 0 = 0;

    public int 6() {
        if (this.c) {
            float[] fArray = Color.RGBtoHSB(this.c >> 16 & 0xFF, this.c >> 8 & 0xFF, this.c & 0xFF, null);
            double d2 = Math.ceil((double)(System.currentTimeMillis() + 300L + (long)this.0) / 20.0);
            int n2 = Color.getHSBColor((float)((d2 %= 360.0) / 360.0), fArray[1], fArray[2]).getRGB();
            return n2 >> 16 & 0xFF;
        }
        return this.c >> 16 & 0xFF;
    }

    public int 5() {
        if (this.c) {
            float[] fArray = Color.RGBtoHSB(this.c >> 16 & 0xFF, this.c >> 8 & 0xFF, this.c & 0xFF, null);
            double d2 = Math.ceil((double)(System.currentTimeMillis() + 300L + (long)this.0) / 20.0);
            int n2 = Color.getHSBColor((float)((d2 %= 360.0) / 360.0), fArray[1], fArray[2]).getRGB();
            return n2 >> 8 & 0xFF;
        }
        return this.c >> 8 & 0xFF;
    }

    public 89(int n2) {
        this.c = n2;
    }

    public void 0(int n2) {
        this.c = n2;
    }

    public void 3() {
        this.c = !this.c;
    }

    public int 2(int n2) {
        if (this.c) {
            float[] fArray = Color.RGBtoHSB(this.c >> 16 & 0xFF, this.c >> 8 & 0xFF, this.c & 0xFF, null);
            double d2 = Math.ceil((double)(System.currentTimeMillis() + 300L + (long)n2 + (long)this.0) / 20.0);
            int n3 = Color.getHSBColor((float)((d2 %= 360.0) / 360.0), fArray[1], fArray[2]).getRGB();
            int n4 = this.c >> 24 & 0xFF;
            int n5 = n3 >> 16 & 0xFF;
            int n6 = n3 >> 8 & 0xFF;
            int n7 = n3 & 0xFF;
            return (n4 & 0xFF) << 24 | (n5 & 0xFF) << 16 | (n6 & 0xFF) << 8 | n7 & 0xFF;
        }
        return this.c;
    }

    public 89(int n2, boolean bl) {
        this.c = n2;
        this.c = bl;
    }

    public int c() {
        if (this.c) {
            float[] fArray = Color.RGBtoHSB(this.c >> 16 & 0xFF, this.c >> 8 & 0xFF, this.c & 0xFF, null);
            double d2 = Math.ceil((double)(System.currentTimeMillis() + 300L + (long)this.0) / 20.0);
            int n2 = Color.getHSBColor((float)((d2 %= 360.0) / 360.0), fArray[1], fArray[2]).getRGB();
            int n3 = this.c >> 24 & 0xFF;
            int n4 = n2 >> 16 & 0xFF;
            int n5 = n2 >> 8 & 0xFF;
            int n6 = n2 & 0xFF;
            return (n3 & 0xFF) << 24 | (n4 & 0xFF) << 16 | (n5 & 0xFF) << 8 | n6 & 0xFF;
        }
        return this.c;
    }

    public Color 4() {
        int n2 = this.c();
        int n3 = n2 >> 24 & 0xFF;
        int n4 = n2 >> 16 & 0xFF;
        int n5 = n2 >> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        return new Color(n4, n5, n6, n3);
    }

    public 89(int n2, boolean bl, int n3) {
        this.c = n2;
        this.c = bl;
        this.0 = n3;
    }

    public int 8() {
        return this.0;
    }

    public static int c(String string) throws NumberFormatException {
        Integer n2 = Integer.decode(string);
        return n2;
    }

    public int 0() {
        return this.c;
    }

    public int 2() {
        if (this.c) {
            float[] fArray = Color.RGBtoHSB(this.c >> 16 & 0xFF, this.c >> 8 & 0xFF, this.c & 0xFF, null);
            double d2 = Math.ceil((double)(System.currentTimeMillis() + 300L + (long)this.0) / 20.0);
            int n2 = Color.getHSBColor((float)((d2 %= 360.0) / 360.0), fArray[1], fArray[2]).getRGB();
            return n2 & 0xFF;
        }
        return this.c & 0xFF;
    }

    public void c(boolean bl) {
        this.c = bl;
    }

    public void c(int n2) {
        this.0 = n2;
    }

    public int 1() {
        return this.c >> 24 & 0xFF;
    }

    public boolean 7() {
        return this.c;
    }

    public 89 1(int n2) {
        int n3 = this.c() >> 16 & 0xFF;
        int n4 = this.c() >> 8 & 0xFF;
        int n5 = this.c() & 0xFF;
        return new 89((n2 & 0xFF) << 24 | (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF);
    }
}

