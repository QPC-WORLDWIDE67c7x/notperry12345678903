/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7U
extends Enum {
    public static /* enum */ 7U c = new 7U("NONE", 0);
    public static /* enum */ 7U 0 = new 7U("STATIC", 1);
    public static /* enum */ 7U 1 = new 7U("IRL", 2);
    public static 7U[] c = new 7U[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7U() {
        void var2_-1;
        void var1_-1;
    }

    public static 7U c(String string) {
        return Enum.valueOf(7U.class, string);
    }

    public static 7U[] values() {
        return (7U[])c.clone();
    }
}

