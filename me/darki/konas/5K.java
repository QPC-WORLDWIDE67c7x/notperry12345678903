/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5K
extends Enum {
    public static /* enum */ 5K c = new 5K("SINGLE", 0);
    public static /* enum */ 5K 0 = new 5K("MULTI", 1);
    public static 5K[] c = new 5K[]{c, 0};

    public static 5K c(String string) {
        return Enum.valueOf(5K.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5K() {
        void var2_-1;
        void var1_-1;
    }

    public static 5K[] values() {
        return (5K[])c.clone();
    }
}

