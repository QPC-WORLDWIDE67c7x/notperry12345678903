/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.5f
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5f_0
extends Enum {
    public static /* enum */ 5f_0 c = new 5f_0("MANUAL", 0);
    public static /* enum */ 5f_0 0 = new 5f_0("AUTOMATIC", 1);
    public static 5f_0[] c = new 5f_0[]{c, 0};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5f_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 5f_0 c(String string) {
        return Enum.valueOf(5f_0.class, string);
    }

    public static 5f_0[] values() {
        return (5f_0[])c.clone();
    }
}

