/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.9p;
import me.darki.konas.9r;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9q {
    public ArrayList<9p> c = new ArrayList();

    public static boolean 0(9p p2) {
        return p2.1() == 9r.c;
    }

    public ArrayList<9p> 2() {
        return this.c;
    }

    public List<9p> c() {
        return this.c.stream().filter(9p::0).collect(Collectors.toList());
    }

    public boolean c(9p p2) {
        for (9p p3 : this.c) {
            if (!p2.equals(p3)) continue;
            return false;
        }
        this.c.add(p2);
        return true;
    }

    public 9p c(String string) {
        for (9p p2 : this.c) {
            if (!p2.3().equalsIgnoreCase(string) || !p2.0()) continue;
            return p2;
        }
        return null;
    }

    public static boolean c(String string, 9p p2) {
        return p2.3().equalsIgnoreCase(string) && p2.0();
    }

    public void 0(String string) {
        this.c.removeIf(arg_0 -> 9q.c(string, arg_0));
    }

    public void 0() {
        this.c.removeIf(9q::0);
    }

    public void 1() {
        this.c.clear();
    }
}

