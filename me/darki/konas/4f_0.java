/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.4f
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4f_0
extends Enum {
    public static /* enum */ 4f_0 c = new 4f_0("OFF", 0);
    public static /* enum */ 4f_0 0 = new 4f_0("BREAK", 1);
    public static /* enum */ 4f_0 1 = new 4f_0("FULL", 2);
    public static 4f_0[] c = new 4f_0[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4f_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 4f_0 c(String string) {
        return Enum.valueOf(4f_0.class, string);
    }

    public static 4f_0[] values() {
        return (4f_0[])c.clone();
    }
}

