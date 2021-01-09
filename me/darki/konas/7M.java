/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7M
extends Enum {
    public static /* enum */ 7M c = new 7M("NONE", 0);
    public static /* enum */ 7M 0 = new 7M("ALL", 1);
    public static /* enum */ 7M 1 = new 7M("SELECT", 2);
    public static 7M[] c = new 7M[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7M() {
        void var2_-1;
        void var1_-1;
    }

    public static 7M c(String string) {
        return Enum.valueOf(7M.class, string);
    }

    public static 7M[] values() {
        return (7M[])c.clone();
    }
}

