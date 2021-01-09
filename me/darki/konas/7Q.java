/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7Q {
    public double c;
    public double 0;
    public double 1;

    public 7Q(double d2, double d3, double d4) {
        this.c = d2;
        this.0 = d3;
        this.1 = d4;
    }

    public double c(7Q q) {
        double d2 = this.c - q.c;
        double d3 = this.0 - q.0;
        double d4 = this.1 - q.1;
        return Math.sqrt(d2 * d2 + d3 * d3 + d4 * d4);
    }

    public boolean equals(Object object) {
        if (object instanceof 7Q) {
            7Q q = (7Q)object;
            return Double.compare(this.c, q.c) == 0 && Double.compare(this.0, q.0) == 0 && Double.compare(this.1, q.1) == 0;
        }
        return super.equals(object);
    }
}

