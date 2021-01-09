/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7A
extends Enum {
    public static /* enum */ 7A c = new 7A("FULL", 0);
    public static /* enum */ 7A 0 = new 7A("BOTTOM", 1);
    public static /* enum */ 7A 1 = new 7A("TOP", 2);
    public static 7A[] c = new 7A[]{c, 0, 1};

    public static 7A[] values() {
        return (7A[])c.clone();
    }

    public static 7A c(String string) {
        return Enum.valueOf(7A.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7A() {
        void var2_-1;
        void var1_-1;
    }
}

