/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6D
extends Enum {
    public static /* enum */ 6D c = new 6D("STRAFE", 0);
    public static /* enum */ 6D 0 = new 6D("STRAFESTRICT", 1);
    public static /* enum */ 6D 1 = new 6D("ONGROUND", 2);
    public static /* enum */ 6D 2 = new 6D("LOWHOP", 3);
    public static /* enum */ 6D 3 = new 6D("SMALLHOP", 4);
    public static /* enum */ 6D 4 = new 6D("TP", 5);
    public static /* enum */ 6D 5 = new 6D("STRAFEOLD", 6);
    public static 6D[] c = new 6D[]{c, 0, 1, 2, 3, 4, 5};

    public static 6D c(String string) {
        return Enum.valueOf(6D.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6D() {
        void var2_-1;
        void var1_-1;
    }

    public static 6D[] values() {
        return (6D[])c.clone();
    }
}

