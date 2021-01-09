/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 50
extends Enum {
    public static /* enum */ 50 c = new 50("NONE", 0);
    public static /* enum */ 50 0 = new 50("STRONG", 1);
    public static /* enum */ 50 1 = new 50("STRICT", 2);
    public static 50[] c = new 50[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 50() {
        void var2_-1;
        void var1_-1;
    }

    public static 50 c(String string) {
        return Enum.valueOf(50.class, string);
    }

    public static 50[] values() {
        return (50[])c.clone();
    }
}

