/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5S
extends Enum {
    public static /* enum */ 5S c = new 5S("MENU", 0);
    public static /* enum */ 5S 0 = new 5S("FRIEND", 1);
    public static /* enum */ 5S 1 = new 5S("MISC", 2);
    public static 5S[] c = new 5S[]{c, 0, 1};

    public static 5S[] values() {
        return (5S[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5S() {
        void var2_-1;
        void var1_-1;
    }

    public static 5S c(String string) {
        return Enum.valueOf(5S.class, string);
    }
}

