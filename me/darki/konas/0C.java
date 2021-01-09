/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 0C
extends Enum {
    public static /* enum */ 0C c = new 0C("MAINHAND", 0);
    public static /* enum */ 0C 0 = new 0C("OFFHAND", 1);
    public static 0C[] c = new 0C[]{c, 0};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 0C() {
        void var2_-1;
        void var1_-1;
    }

    public static 0C[] values() {
        return (0C[])c.clone();
    }

    public static 0C c(String string) {
        return Enum.valueOf(0C.class, string);
    }
}

