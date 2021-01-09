/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9l {
    public long c = System.nanoTime();

    public boolean c(double d2) {
        return (double)(System.nanoTime() - this.c) >= d2;
    }

    public long 0() {
        return this.c;
    }

    public void c(long l2) {
        this.c = l2;
    }

    public void c() {
        this.c = System.nanoTime();
    }
}

