/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9m {
    public long c = System.currentTimeMillis();

    public long 0() {
        return this.c;
    }

    public boolean c(double d2) {
        return (double)(System.currentTimeMillis() - this.c) >= d2;
    }

    public void c(long l2) {
        this.c = l2;
    }

    public void c() {
        this.c = System.currentTimeMillis();
    }
}

