/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.4d
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4d_0
extends Enum {
    public static /* enum */ 4d_0 c = new 4d_0("ALL", 0);
    public static /* enum */ 4d_0 0 = new 4d_0("SMART", 1);
    public static /* enum */ 4d_0 1 = new 4d_0("NEAREST", 2);
    public static 4d_0[] c = new 4d_0[]{c, 0, 1};

    public static 4d_0[] values() {
        return (4d_0[])c.clone();
    }

    public static 4d_0 c(String string) {
        return Enum.valueOf(4d_0.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4d_0() {
        void var2_-1;
        void var1_-1;
    }
}

