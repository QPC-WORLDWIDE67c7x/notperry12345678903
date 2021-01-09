/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 8Q {
    public static ArrayList<String> c = new ArrayList();

    public static void 0(String string) {
        c.add(string);
    }

    public static ArrayList<String> c() {
        return c;
    }

    public static void 1(String string) {
        c.remove(string);
    }

    public static void 0() {
        c.clear();
    }

    public static boolean c(String string) {
        for (String string2 : c) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }
}

