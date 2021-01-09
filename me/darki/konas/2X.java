/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2X
extends Enum {
    public static /* enum */ 2X c = new 2X("ARROW", 0);
    public static /* enum */ 2X 0 = new 2X("COMPASS", 1);
    public static 2X[] c = new 2X[]{c, 0};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 2X() {
        void var2_-1;
        void var1_-1;
    }

    public static 2X[] values() {
        return (2X[])c.clone();
    }

    public static 2X c(String string) {
        return Enum.valueOf(2X.class, string);
    }
}

