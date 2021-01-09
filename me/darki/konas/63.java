/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 63
extends Enum {
    public static /* enum */ 63 c = new 63("NONE", 0);
    public static /* enum */ 63 0 = new 63("WHITELIST", 1);
    public static /* enum */ 63 1 = new 63("BLACKLIST", 2);
    public static 63[] c = new 63[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 63() {
        void var2_-1;
        void var1_-1;
    }

    public static 63[] values() {
        return (63[])c.clone();
    }

    public static 63 c(String string) {
        return Enum.valueOf(63.class, string);
    }
}

