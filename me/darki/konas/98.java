/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 98 {
    public double[][] c;
    public int c;
    public double c;
    public double 0;
    public double 1;
    public double 2;
    public float c = 0;

    public 98(double d2, double d3, double d4, double d5, float f2) {
        this.1 = d2;
        this.2 = d3;
        this.c = d4;
        this.0 = d5;
        this.c = f2;
    }

    public void c(double d2, double d3) {
        double d4 = (d2 -= this.c) * Math.cos(this.c) - (d3 -= this.0) * Math.sin(this.c);
        double d5 = d2 * Math.sin(this.c) + d3 * Math.cos(this.c);
        this.c[this.c++] = new double[]{d4 += this.c, d5 += this.0};
    }

    public double[] c(int n2) {
        return this.c[n2];
    }
}

