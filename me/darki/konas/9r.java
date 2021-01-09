/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9r
extends Enum {
    public static /* enum */ 9r c = new 9r("DEATH", 0);
    public static /* enum */ 9r 0 = new 9r("CUSTOM", 1);
    public static 9r[] c = new 9r[]{c, 0};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 9r() {
        void var2_-1;
        void var1_-1;
    }

    public static 9r[] values() {
        return (9r[])c.clone();
    }

    public static 9r c(String string) {
        return Enum.valueOf(9r.class, string);
    }
}

