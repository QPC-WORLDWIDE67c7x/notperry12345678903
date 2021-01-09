/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.concurrent.CopyOnWriteArrayList;
import me.darki.konas.8H;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 8J {
    public static CopyOnWriteArrayList<8H> c = new CopyOnWriteArrayList();

    public static void 0() {
        c.clear();
    }

    public 8H c(String string) {
        for (8H h2 : c) {
            if (!h2.c().equalsIgnoreCase(string)) continue;
            return h2;
        }
        return null;
    }

    public static boolean 2(String string) {
        if (string == null) {
            return false;
        }
        for (8H h2 : c) {
            if (!h2.c().equals(string.replaceAll("-", ""))) continue;
            return true;
        }
        return false;
    }

    public static boolean 1(String string) {
        if (string == null) {
            return false;
        }
        for (8H h2 : c) {
            if (!h2.0().equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    public static void c(String string, String string2) {
        if (!c.contains(new 8H(string, string2.replaceAll("-", "")))) {
            c.add(new 8H(string, string2.replaceAll("-", "")));
        }
    }

    public static boolean c(String string, 8H h2) {
        return h2.0().equalsIgnoreCase(string);
    }

    public static void 0(String string) {
        c.removeIf(arg_0 -> 8J.c(string, arg_0));
    }

    public static CopyOnWriteArrayList<8H> c() {
        return c;
    }
}

