/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5U
extends Enum {
    public static /* enum */ 5U c = new 5U("ALL", 0);
    public static /* enum */ 5U 0 = new 5U("FOOD", 1);
    public static /* enum */ 5U 1 = new 5U("WHITELIST", 2);
    public static 5U[] c = new 5U[]{c, 0, 1};

    public static 5U c(String string) {
        return Enum.valueOf(5U.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5U() {
        void var2_-1;
        void var1_-1;
    }

    public static 5U[] values() {
        return (5U[])c.clone();
    }
}

