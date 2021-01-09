/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6R
extends Enum {
    public static /* enum */ 6R c = new 6R("NONE", 0);
    public static /* enum */ 6R 0 = new 6R("NORMAL", 1);
    public static /* enum */ 6R 1 = new 6R("SILENT", 2);
    public static /* enum */ 6R 2 = new 6R("RETURN", 3);
    public static 6R[] c = new 6R[]{c, 0, 1, 2};

    public static 6R[] values() {
        return (6R[])c.clone();
    }

    public static 6R c(String string) {
        return Enum.valueOf(6R.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6R() {
        void var2_-1;
        void var1_-1;
    }
}

