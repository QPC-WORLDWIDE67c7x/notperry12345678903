/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 79
extends Enum {
    public static /* enum */ 79 c = new 79("CANCEL", 0);
    public static /* enum */ 79 0 = new 79("OFFHAND", 1);
    public static /* enum */ 79 1 = new 79("MAINHAND", 2);
    public static /* enum */ 79 2 = new 79("OPPOSITE", 3);
    public static /* enum */ 79 3 = new 79("NONE", 4);
    public static 79[] c = new 79[]{c, 0, 1, 2, 3};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 79() {
        void var2_-1;
        void var1_-1;
    }

    public static 79 c(String string) {
        return Enum.valueOf(79.class, string);
    }

    public static 79[] values() {
        return (79[])c.clone();
    }
}

