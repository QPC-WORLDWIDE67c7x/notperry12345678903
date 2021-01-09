/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 53
extends Enum {
    public static /* enum */ 53 c = new 53("FACTOR", 0);
    public static /* enum */ 53 0 = new 53("SETBACK", 1);
    public static /* enum */ 53 1 = new 53("FAST", 2);
    public static /* enum */ 53 2 = new 53("SLOW", 3);
    public static /* enum */ 53 3 = new 53("DESYNC", 4);
    public static 53[] c = new 53[]{c, 0, 1, 2, 3};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 53() {
        void var2_-1;
        void var1_-1;
    }

    public static 53[] values() {
        return (53[])c.clone();
    }

    public static 53 c(String string) {
        return Enum.valueOf(53.class, string);
    }
}

