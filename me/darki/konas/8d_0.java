/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8d
 */
public class 8d_0 {
    public List<String> c = new ArrayList<String>();

    public 8d_0(ArrayList<String> arrayList) {
        for (String string : arrayList) {
            if (this.c.contains(string.toLowerCase(Locale.ENGLISH))) continue;
            this.c.add(string.toLowerCase(Locale.ENGLISH));
        }
    }

    public void 0(String string) {
        this.c.remove(string.toLowerCase(Locale.ENGLISH));
    }

    public void c(ArrayList<String> arrayList) {
        for (String string : arrayList) {
            if (this.c.contains(string.toLowerCase(Locale.ENGLISH))) continue;
            this.c.add(string.toLowerCase(Locale.ENGLISH));
        }
    }

    public List<String> c() {
        return this.c;
    }

    public void c(String string) {
        if (!this.c.contains(string.toLowerCase(Locale.ENGLISH))) {
            this.c.add(string.toLowerCase(Locale.ENGLISH));
        }
    }

    public 8d_0(String ... stringArray) {
        for (String string : this.c) {
            if (this.c.contains(string.toLowerCase(Locale.ENGLISH))) continue;
            this.c.add(string.toLowerCase(Locale.ENGLISH));
        }
    }
}

