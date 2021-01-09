/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.concurrent.CopyOnWriteArrayList;
import me.darki.konas.3B;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3C {
    public static CopyOnWriteArrayList<3B> c = new CopyOnWriteArrayList();

    public static void c(3B b2) {
        c.remove(b2);
    }

    public static CopyOnWriteArrayList<3B> 0() {
        return c;
    }

    public static void 0(3B b2) {
        if (!c.contains(b2)) {
            c.add(b2);
        }
    }

    public static void c(CopyOnWriteArrayList<3B> copyOnWriteArrayList) {
        c = copyOnWriteArrayList;
    }

    public static void c() {
        c.clear();
    }

    public static 3B c(String string) {
        for (3B b2 : 3C.0()) {
            if (!b2.2().equalsIgnoreCase(string)) continue;
            return b2;
        }
        return null;
    }
}

