/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 8H {
    public String c;
    public String 0;

    public String 0() {
        return this.c;
    }

    public 8H(String string, String string2) {
        this.c = string;
        this.0 = string2;
    }

    public String c() {
        return this.0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof 8H)) {
            return false;
        }
        8H h2 = (8H)object;
        return h2.c.equals(this.c) && h2.0.equals(this.0);
    }
}

