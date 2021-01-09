/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3M
extends Enum {
    public static /* enum */ 3M c = new 3M("REAL", 0);
    public static /* enum */ 3M 0 = new 3M("PERCENTAGE", 1);
    public static 3M[] c = new 3M[]{c, 0};

    public static 3M[] values() {
        return (3M[])c.clone();
    }

    public static 3M c(String string) {
        return Enum.valueOf(3M.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 3M() {
        void var2_-1;
        void var1_-1;
    }
}

