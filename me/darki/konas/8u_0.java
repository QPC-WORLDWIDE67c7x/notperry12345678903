/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import net.minecraft.entity.Entity;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8u
 */
public class 8u_0 {
    public static ArrayList<Integer> c = new ArrayList();

    public static void 1(int n2) {
        c.remove((Object)n2);
    }

    public static void 1(Entity entity) {
        c.remove((Object)entity.getEntityId());
    }

    public static boolean c(int n2) {
        return c.contains(n2);
    }

    public static void 0(int n2) {
        c.add(n2);
    }

    public static boolean c(Entity entity) {
        return c.contains(entity.getEntityId());
    }

    public static void c() {
        c.clear();
    }

    public static void 0(Entity entity) {
        c.add(entity.getEntityId());
    }
}

