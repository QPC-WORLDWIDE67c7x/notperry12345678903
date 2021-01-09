/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 52
extends Enum {
    public static /* enum */ 52 c = new 52("NONE", 0);
    public static /* enum */ 52 0 = new 52("SLOW", 1);
    public static /* enum */ 52 1 = new 52("FAST", 2);
    public static 52[] c = new 52[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 52() {
        void var2_-1;
        void var1_-1;
    }

    public static 52 c(String string) {
        return Enum.valueOf(52.class, string);
    }

    public static 52[] values() {
        return (52[])c.clone();
    }
}

