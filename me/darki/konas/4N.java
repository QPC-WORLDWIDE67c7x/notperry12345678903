/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4N
extends Enum {
    public static /* enum */ 4N c = new 4N("VANILLA", 0);
    public static /* enum */ 4N 0 = new 4N("SPIGOT", 1);
    public static 4N[] c = new 4N[]{c, 0};

    public static 4N c(String string) {
        return Enum.valueOf(4N.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4N() {
        void var2_-1;
        void var1_-1;
    }

    public static 4N[] values() {
        return (4N[])c.clone();
    }
}

