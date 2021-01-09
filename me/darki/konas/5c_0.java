/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.5c
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5c_0
extends Enum {
    public static /* enum */ 5c_0 c = new 5c_0("NONE", 0);
    public static /* enum */ 5c_0 0 = new 5c_0("WORLD", 1);
    public static /* enum */ 5c_0 1 = new 5c_0("STRICT", 2);
    public static 5c_0[] c = new 5c_0[]{c, 0, 1};

    public static 5c_0 c(String string) {
        return Enum.valueOf(5c_0.class, string);
    }

    public static 5c_0[] values() {
        return (5c_0[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5c_0() {
        void var2_-1;
        void var1_-1;
    }
}

