/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.4h
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4h_0
extends Enum {
    public static /* enum */ 4h_0 c = new 4h_0("HEALTH", 0);
    public static /* enum */ 4h_0 0 = new 4h_0("PLAYER", 1);
    public static /* enum */ 4h_0 1 = new 4h_0("CRYSTALDMG", 2);
    public static 4h_0[] c = new 4h_0[]{c, 0, 1};

    public static 4h_0[] values() {
        return (4h_0[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4h_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 4h_0 c(String string) {
        return Enum.valueOf(4h_0.class, string);
    }
}

