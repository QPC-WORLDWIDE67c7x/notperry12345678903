/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.7f
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7f_0
extends Enum {
    public static /* enum */ 7f_0 c = new 7f_0("FULL", 0);
    public static /* enum */ 7f_0 0 = new 7f_0("OUTLINE", 1);
    public static /* enum */ 7f_0 1 = new 7f_0("VECTOR", 2);
    public static /* enum */ 7f_0 2 = new 7f_0("BASED", 3);
    public static 7f_0[] c = new 7f_0[]{c, 0, 1, 2};

    public static 7f_0[] values() {
        return (7f_0[])c.clone();
    }

    public static 7f_0 c(String string) {
        return Enum.valueOf(7f_0.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7f_0() {
        void var2_-1;
        void var1_-1;
    }
}

