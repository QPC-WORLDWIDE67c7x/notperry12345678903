/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.0h
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 0h_0
extends Enum {
    public static /* enum */ 0h_0 c = new 0h_0("HORIZONTAL", 0);
    public static /* enum */ 0h_0 0 = new 0h_0("VERTICAL", 1);
    public static 0h_0[] c = new 0h_0[]{c, 0};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 0h_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 0h_0[] values() {
        return (0h_0[])c.clone();
    }

    public static 0h_0 c(String string) {
        return Enum.valueOf(0h_0.class, string);
    }
}

