/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.6o
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6o_0
extends Enum {
    public static /* enum */ 6o_0 c = new 6o_0("NONE", 0);
    public static /* enum */ 6o_0 0 = new 6o_0("NORMAL", 1);
    public static /* enum */ 6o_0 1 = new 6o_0("TOGGLE", 2);
    public static 6o_0[] c = new 6o_0[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6o_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 6o_0[] values() {
        return (6o_0[])c.clone();
    }

    public static 6o_0 c(String string) {
        return Enum.valueOf(6o_0.class, string);
    }
}

