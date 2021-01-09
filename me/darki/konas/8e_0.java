/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.8b_0;
import me.darki.konas.8h_0;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8e
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8e_0
extends 8h_0 {
    public 8b_0<T> c;
    public boolean c = false;

    public void c() {
        this.c = true;
    }

    @Override
    public void 2(String string) {
        block0: {
            super.2(string);
            if (this.c(string) == null) break block0;
            this.c.c(this.c(string));
        }
    }

    @Override
    public void 2(T t) {
        Object t2 = this.6();
        super.2(t);
        this.c.c(t);
        if (this.c) {
            super.2(t2);
            this.c = false;
        }
    }

    public 8e_0(String string, T t, T t2, T t3, T t4, @NotNull 8b_0<T> b_02) {
        super(string, t, t2, t3, t4);
        this.c = b_02;
    }

    public 8e_0(String string, T t, @NotNull 8b_0<T> b_02) {
        super(string, t);
        this.c = b_02;
    }
}

