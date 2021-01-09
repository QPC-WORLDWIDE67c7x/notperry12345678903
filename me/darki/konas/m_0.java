/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8I;
import me.darki.konas.8J;
import me.darki.konas.8S;
import me.darki.konas.8p_0;
import me.darki.konas.l_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.m
 */
public class m_0
extends 2 {
    public static void 0(String string) {
        if (8J.1(string)) {
            8p_0.1("Is already a friend: " + string);
            return;
        }
        String string2 = 8S.4(string);
        if (string2 != null && !string2.isEmpty()) {
            8J.c(string, string2);
            8p_0.1("Added friend: " + string + " (" + string2 + ")");
        } else {
            8p_0.c("Unable to add friend: " + string);
        }
    }

    public m_0() {
        super("friendsync", "Sync friends with other clients", new l_0("<client>"));
    }

    public static void 0() {
        8I.1().forEach(m_0::4);
    }

    public static void c(String string) {
        if (8J.1(string)) {
            8p_0.1("Is already a friend: " + string);
            return;
        }
        String string2 = 8S.4(string);
        if (string2 != null && !string2.isEmpty()) {
            8J.c(string, string2);
            8p_0.1("Added friend: " + string + " (" + string2 + ")");
        } else {
            8p_0.c("Unable to add friend: " + string);
        }
    }

    public static void c() {
        8I.c().forEach(m_0::c);
    }

    public static void 4(String string) {
        if (8J.1(string)) {
            8p_0.1("Is already a friend: " + string);
            return;
        }
        String string2 = 8S.4(string);
        if (string2 != null && !string2.isEmpty()) {
            8J.c(string, string2);
            8p_0.1("Added friend: " + string + " (" + string2 + ")");
        } else {
            8p_0.c("Unable to add friend: " + string);
        }
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.1(this.0());
            return;
        }
        if (stringArray[1].equalsIgnoreCase("future")) {
            new Thread(m_0::1).start();
            return;
        }
        if (stringArray[1].equalsIgnoreCase("pyro")) {
            new Thread(m_0::0).start();
            return;
        }
        if (stringArray[1].equalsIgnoreCase("rusherhack")) {
            new Thread(m_0::c).start();
            return;
        }
        8p_0.1(this.0());
    }

    public static void 1() {
        8I.0().forEach(m_0::0);
    }
}

