/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 29
implements Comparable {
    public String c;
    public String 0;
    public String 1;
    public String 2 = "";
    public String 3 = "";
    public boolean c;
    public boolean 0;
    public boolean 1;
    public long c;

    public 29(String string, String string2, boolean bl, boolean bl2) {
        this.0 = string;
        this.c = string;
        this.1 = string2;
        this.c = bl;
        this.1 = bl2;
    }

    public boolean 5() {
        return this.1;
    }

    public String 0() {
        return this.0;
    }

    public void 1(String string) {
        this.c = string;
    }

    public String 6() {
        return this.2;
    }

    public void 0(String string) {
        this.2 = string;
    }

    public long 2() {
        return this.c;
    }

    public void c(boolean bl) {
        this.0 = bl;
    }

    public String c() {
        return this.c;
    }

    public void c(String string) {
        this.3 = string;
    }

    public boolean 1() {
        return this.0;
    }

    public String 4() {
        return this.3;
    }

    public void 0(boolean bl) {
        this.c = bl;
    }

    public int c(29 var1_1) {
        if (this.c < var1_1.c) {
            return 1;
        }
        return this.c > var1_1.c ? -1 : this.c.compareTo(var1_1.c);
    }

    public boolean 3() {
        return this.c;
    }

    public void 2(String string) {
        this.1 = string;
    }

    public String 7() {
        return this.1;
    }

    public void c(long l2) {
        this.c = l2;
    }

    public int compareTo(Object object) {
        return this.c((29)object);
    }
}

