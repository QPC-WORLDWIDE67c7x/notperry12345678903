/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7Y
extends Enum {
    public static /* enum */ 7Y c = new 7Y("LINES", 0);
    public static /* enum */ 7Y 0 = new 7Y("ARROWS", 1);
    public static 7Y[] c = new 7Y[]{c, 0};

    public static 7Y c(String string) {
        return Enum.valueOf(7Y.class, string);
    }

    public static 7Y[] values() {
        return (7Y[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7Y() {
        void var2_-1;
        void var1_-1;
    }
}

