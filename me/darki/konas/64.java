/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 64
extends Enum {
    public static /* enum */ 64 c = new 64("NONE", 0);
    public static /* enum */ 64 0 = new 64("NORMAL", 1);
    public static /* enum */ 64 1 = new 64("FAST", 2);
    public static 64[] c = new 64[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 64() {
        void var2_-1;
        void var1_-1;
    }

    public static 64 c(String string) {
        return Enum.valueOf(64.class, string);
    }

    public static 64[] values() {
        return (64[])c.clone();
    }
}

