/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 77
extends Enum {
    public static /* enum */ 77 c = new 77("VANILLA", 0);
    public static /* enum */ 77 0 = new 77("NORMAL", 1);
    public static /* enum */ 77 1 = new 77("NCP", 2);
    public static /* enum */ 77 2 = new 77("MOTION", 3);
    public static 77[] c = new 77[]{c, 0, 1, 2};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 77() {
        void var2_-1;
        void var1_-1;
    }

    public static 77[] values() {
        return (77[])c.clone();
    }

    public static 77 c(String string) {
        return Enum.valueOf(77.class, string);
    }
}

