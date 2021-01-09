/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.5a
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5a_0
extends Enum {
    public static /* enum */ 5a_0 c = new 5a_0("NONE", 0);
    public static /* enum */ 5a_0 0 = new 5a_0("WHITELIST", 1);
    public static /* enum */ 5a_0 1 = new 5a_0("BLACKLIST", 2);
    public static 5a_0[] c = new 5a_0[]{c, 0, 1};

    public static 5a_0[] values() {
        return (5a_0[])c.clone();
    }

    public static 5a_0 c(String string) {
        return Enum.valueOf(5a_0.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5a_0() {
        void var2_-1;
        void var1_-1;
    }
}

