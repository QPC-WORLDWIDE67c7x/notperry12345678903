/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7F
extends Enum {
    public static /* enum */ 7F c = new 7F("GROW", 0);
    public static /* enum */ 7F 0 = new 7F("SHRINK", 1);
    public static /* enum */ 7F 1 = new 7F("CROSS", 2);
    public static /* enum */ 7F 2 = new 7F("STATIC", 3);
    public static 7F[] c = new 7F[]{c, 0, 1, 2};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7F() {
        void var2_-1;
        void var1_-1;
    }

    public static 7F c(String string) {
        return Enum.valueOf(7F.class, string);
    }

    public static 7F[] values() {
        return (7F[])c.clone();
    }
}

