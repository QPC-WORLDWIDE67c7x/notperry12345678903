/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.4b
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4b_0
extends Enum {
    public static /* enum */ 4b_0 c = new 4b_0("STRICT", 0);
    public static /* enum */ 4b_0 0 = new 4b_0("MERGE", 1);
    public static 4b_0[] c = new 4b_0[]{c, 0};

    public static 4b_0[] values() {
        return (4b_0[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4b_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 4b_0 c(String string) {
        return Enum.valueOf(4b_0.class, string);
    }
}

