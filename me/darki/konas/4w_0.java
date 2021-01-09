/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.4w
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4w_0
extends Enum {
    public static /* enum */ 4w_0 c = new 4w_0("NONE", 0);
    public static /* enum */ 4w_0 0 = new 4w_0("NORMAL", 1);
    public static /* enum */ 4w_0 1 = new 4w_0("MIN", 2);
    public static /* enum */ 4w_0 2 = new 4w_0("LATEST", 3);
    public static 4w_0[] c = new 4w_0[]{c, 0, 1, 2};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4w_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 4w_0[] values() {
        return (4w_0[])c.clone();
    }

    public static 4w_0 c(String string) {
        return Enum.valueOf(4w_0.class, string);
    }
}

