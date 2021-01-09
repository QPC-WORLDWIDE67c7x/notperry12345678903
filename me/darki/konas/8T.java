/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.8U;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 8T {
    public 8U c = null;

    public boolean c(8U u) {
        if (this.c == null) {
            this.c = u;
            return true;
        }
        return false;
    }

    public boolean c() {
        return this.c != null;
    }

    public void 1() {
        this.c = null;
    }

    public String 0() {
        if (this.c == null) {
            return "NONE";
        }
        return this.c.c();
    }
}

